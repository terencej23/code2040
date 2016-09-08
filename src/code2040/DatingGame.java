package code2040;

import java.io.*;
import java.net.*;
import java.time.Instant;

import org.joda.time.*;
import org.json.*;

public class DatingGame extends Connect
{
	public static void main(String[] args) throws Exception 
	{
		URL url = new URL("http://challenge.code2040.org/api/dating");
		String token = "{\"token\":\"90cbb362df71c877e4dd238ef8a63e6f\"";
		String string = token + "}";
		
		BufferedReader in = connect(url, string);
		JSONObject dict = new JSONObject(in.readLine());
		in.close();		
		
		DateTime date = DateTime.parse(dict.getString("datestamp"));
		date = date.plusSeconds(dict.getInt("interval"));
		String datestamp = Instant.parse(date.toString()).toString();
		
		String stringV = token + ",\"datestamp\":\"" + datestamp + "\"}";
		URL validate = new URL("http://challenge.code2040.org/api/dating/validate");
		
		getResult(validate, stringV);
	}

}
