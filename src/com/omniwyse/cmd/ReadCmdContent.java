package com.omniwyse.cmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadCmdContent {
    // open cmd
    /*
     * public static void main(String args[]) { try {
     * Runtime.getRuntime().exec("C:/Windows/System32/cmd.exe /c start");
     * System.out.println("ok"); } catch (IOException ex) {
     * ex.printStackTrace(); } }
     */

    public static List<Map<String, List<String>>> deviceDetails = new ArrayList<Map<String, List<String>>>();
    static List<String> serialNumbers = new ArrayList<String>();
    static List<String> completeDeviceData = new ArrayList<String>();
    static String completeData = "";

    public static void main(String[] args) throws Exception {
	new ReadCmdContent().getCmdData();
    }

    public void getCmdData() throws Exception {
	getindividualCmdData("adb devices");

	Map<String, List<String>> map = new HashMap<String, List<String>>();
	for (String serialno : serialNumbers) {
	    String[] adbCommands = {
		    "adb -s " + serialno + " shell getprop ro.product.brand",
		    "adb -s " + serialno + " shell getprop ro.build.version.release",
		    "adb -s " + serialno + " shell getprop ro.build.version.sdk" 
		    };

	    List<String> list = new ArrayList<String>();
	    map.put(serialno, list);
	    for (int i = 0; i < adbCommands.length; i++) {
		String result = getindividualCmdData(adbCommands[i]);
		list.add(result.trim());
		completeData = completeData + result;
	    }
	    completeDeviceData.add(completeData.trim());
	    System.out.println(completeDeviceData);
	    System.out.println(serialNumbers);
	    completeData = "";
	}
	System.out.println();
	System.out.println(completeDeviceData);
	deviceDetails.add(map);
	System.out.println();
	System.out.println("my last output:::::: " + deviceDetails);
    }

    private static String getindividualCmdData(String command) throws Exception {
	String data = " ";
	String line = "";
	Process pr = Runtime.getRuntime().exec(command);
	pr.waitFor();

	BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
	while ((line = br.readLine()) != null) {
	    if ("adb devices".equals(command)&& !"List of devices attached".equals(line.trim())&& !"".equals(line)) {
		System.out.println("line:::" + line);
		System.out.println("splited value::::::" + line.trim().split(" ")[0]);
		serialNumbers.add(line.trim().split("\t")[0]);
	    } else
		data = data + line.trim();
	}
	return data;
    }
}
