package com.omniwyse.server;

import java.io.IOException;

public class OpenServer {

    public static void main(String[] args) throws IOException {
	new OpenServer().getOpenServer();
    }

    public void getOpenServer() throws IOException {
	String path = "C:/Program Files (x86)/Appium/Appium.exe";
	Runtime.getRuntime().exec(path + " /c start");
	// Files.createDirectories(Paths.get(""));
	// Desktop.getDesktop().open(new File(path));
	// Runtime.getRuntime().exec(path);

    }
}
