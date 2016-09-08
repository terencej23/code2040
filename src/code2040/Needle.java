package code2040;

import java.io.*;
import java.net.*;
import org.json.*;

public class Needle extends Connect
{
	public static void main(String[] args) throws Exception 
	{
			URL url = new URL("http://challenge.code2040.org/api/haystack");
			String token = "{\"token\":\"90cbb362df71c877e4dd238ef8a63e6f\"";
			String string = token + "}";
			
			BufferedReader in = connect(url, string);
			JSONObject dict = new JSONObject(in.readLine());
			in.close();
			
			JSONArray haystack = dict.getJSONArray("haystack");
			String needle = dict.getString("needle");
			
			int i;
			for(i = 0; i < haystack.length(); i++)
				if(haystack.getString(i).equals(needle))
					break;
			
			String stringV = token + ",\"needle\":\"" + i + "\"}";	
			URL validate = new URL("http://challenge.code2040.org/api/haystack/validate");
			
			getResult(validate, stringV);
	}
}
