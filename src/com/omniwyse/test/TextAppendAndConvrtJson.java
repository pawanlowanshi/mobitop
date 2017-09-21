package com.omniwyse.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONObject;

public class TextAppendAndConvrtJson {
    
    public static void main(String[] args) throws Exception {
	getJsonMap();
    }

    public static HashMap<String, JSONObject> getJsonMap() throws IOException{
	HashMap<String, JSONObject> map=new HashMap<String, JSONObject>();
        int[] a={22,23};
         for(int x:a)     
         {
             System.out.println("grade id is:"   +x);
            String url=String.format("https://staging.tllms.com/elearn/api/v4/cohorts/%s?json_version=3", x);

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("Accept", "application/json");

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        
            in.close();
        
            //print result
           // System.out.println(response.toString());
            PrintStream console = System.out;
            new File("C:/Users/pawanl/Desktop/out.txt").delete();
            File file = new File("C:/Users/pawanl/Desktop/out.txt");
            FileOutputStream fos = new FileOutputStream(file,true);
            PrintStream ps = new PrintStream(fos);
            JSONObject json=new JSONObject(response.toString());
            
            map.put(x+"pawan", json);
            System.setOut(ps);
            
           
         
            System.out.println(response.toString());
          
            System.setOut(console);
          
            System.out.println("This also goes to the console");
        }
         System.out.println("my map : "+map);
         
         return map;
    }
}
