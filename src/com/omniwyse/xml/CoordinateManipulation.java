package com.omniwyse.xml;

public class CoordinateManipulation {

    public static void main(String[] args) {
	new CoordinateManipulation().doManipulation();
    }

    public String doManipulation(/* String coords */) {
	String coords = "[56,76][98,767]";
	String manipulateCoords = coords.replace("[", "").replace("]", " ").trim();
	String completeCoords = manipulateCoords.substring(0, coords.indexOf("]") - 1) + "," + manipulateCoords.substring(coords.indexOf("]"),manipulateCoords.length());
	System.out.println(completeCoords);
	System.out.println(completeCoords.split(",")[0] + " "
		+ completeCoords.split(",")[1] + " "
		+ completeCoords.split(",")[2] + " "
		+ completeCoords.split(",")[3]);
	return completeCoords;
    }

}
