package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class jsonUtility {
 public String getDataFromJasonFile(String key) throws Throwable {
	 FileReader fileR=new FileReader("./configAppData/appCmnData.jason");
	 JSONParser parser =new JSONParser();
		Object obj=parser.parse((fileR));
		JSONObject map=(JSONObject)obj;
		String data=(String)map.get(key);
	 return data;
 }
}
