package com.omniwyse.server;

import java.io.IOException;

public class OpenAndCloseTomcat {

    public static void main(String[] args) throws IOException {
	new OpenAndCloseTomcat().serverManager();
    }

    private void serverManager() throws IOException {
	Runtime runTime = Runtime.getRuntime();
	runTime.exec("C:/Windows/System32/cmd.exe /c start");
	System.out.println("ok");
	Process start = runTime.exec("D:\\apache-tomcat-7.0.70\\bin\\startup.bat");
	System.out.println("cheking server for start..." + start);
	Process close = runTime.exec("D:\\apache-tomcat-7.0.70\\bin\\shutdown.bat");
	System.out.println("cheking server for close..." + close);
    }

}
