package com.omniwyse.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

public class StartAndStopAppium {

    public static void main(String[] args) throws IOException {
	
	StartAndStopAppium appium=new StartAndStopAppium();
	appium.serverStart();
	
	  /*  WebDriver driver;
	    AppiumDriverLocalService appiumService;
	    String appiumServiceUrl;
	    appiumService = AppiumDriverLocalService.buildDefaultService();
		appiumService.start();
		appiumServiceUrl = appiumService.getUrl().toString();
	        System.out.println("Appium Service Address : - "+ appiumServiceUrl);*/
	
	//appium.stopServer();//giving exception
	
	
	
	/*String Appium_Node_Path="C:\\Program Files (x86)\\Appium\\node.exe";
	String Appium_JS_Path="C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
	AppiumDriverLocalService appiumService;
	appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().
                usingAnyFreePort().usingDriverExecutable(new File(Appium_Node_Path)).
                withAppiumJS(new File(Appium_JS_Path)));
	appiumService.start();*/
	
    }
	public void serverStart() {
	 String AppiumNodeFilePath = "C:/Program Files (x86)/Appium/node.exe";
	        String AppiumJavaScriptServerFile = "C:/Program Files (x86)/Appium/node_modules/appium/bin/Appium.js";
	        String AppiumServerConfigurations = "--no-reset --local-timezone";
	        executeCommand("\"" + AppiumNodeFilePath + "\" \"" + AppiumJavaScriptServerFile + "\" " + AppiumServerConfigurations);
	}
	
    
    private static void executeCommand(String command) {
        String s = null;

        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // read any errors from the attempted command
            System.out.println("Standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("exception happened: ");
            e.printStackTrace();
        }
    }
	public void startServer() {
	    
		CommandLine command = new CommandLine(
				"/Applications/Appium.app/Contents/Resources/node/bin/node");
		command.addArgument(
				"/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js",
				false);
		command.addArgument("--address", false);
		command.addArgument("127.0.0.1");
		command.addArgument("--port", false);
		command.addArgument("4723");
		command.addArgument("--full-reset", false);
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
			Thread.sleep(5000);
			System.out.println("Appium server started.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void stopServer() {
		String[] command = { "C:/Program Files (x86)/Appium", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
