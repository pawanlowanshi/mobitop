package com.omniwyse.server;

import java.io.IOException;

public class AppiumStartStop {

    // Set path of your node.exe file. Set your path.
    static String nodePath = "C:/Program Files (x86)/Appium/node.exe";
    // Set path of your appium.js file. Set your path.
    static String appiumJSPath = "C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js";

    static Process process;

    static String cmd = nodePath + " " + appiumJSPath;

    // This method Is responsible for starting appium server.
    public static void appiumStart() throws IOException, InterruptedException {
	
	// Execute command string to start appium server.
	process = Runtime.getRuntime().exec(cmd);
	
	// Provide wait time of 10 mins to start appium server properly.
	// If face any error(Could not start a new session...) then Increase
	// this time to 15 or 20 mins.
	Thread.sleep(10000);
	if (process != null) {
	    System.out.println("Appium server Is started now.");
	}
    }

    // This method Is responsible for stopping appium server.
    public static void appiumStop() throws IOException {
	if (process != null) {
	    process.destroy();
	}
	System.out.println("Appium server Is stopped now.");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
	appiumStart();
	appiumStop();
    }
}
