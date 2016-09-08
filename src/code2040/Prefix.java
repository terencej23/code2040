package code2040;

import java.io.*;
import java.net.*;

import org.json.*;

public class Prefix extends Connect
{
	public static void main(String[] args) throws Exception 
	{
			URL url = new URL("http://challenge.code2040.org/api/prefix");
			String token = "{\"token\":\"90cbb362df71c877e4dd238ef8a63e6f\"";
			String string = token + "}";
			
			BufferedReader in = connect(url, string);
			JSONObject dict = new JSONObject(in.readLine());
			in.close();		
			
			JSONArray array = dict.getJSONArray("array");
			String prefix = dict.getString("prefix");
			
			JSONArray noPrefix = new JSONArray();
			
			for(int i = 0; i < array.length(); i++)
				if(!array.getString(i).startsWith(prefix))
					noPrefix.put(array.getString(i));
			
			String stringV = token + ",\"array\":" + noPrefix + "}";	
			URL validate = new URL("http://challenge.code2040.org/api/prefix/validate");
			
			getResult(validate, stringV);
	}

}