package code2040;

import java.io.*;
import java.net.*;

public class Connect 
{
	public static BufferedReader connect (URL url, String token) throws Exception
	{		
		HttpURLConnection connect;
		OutputStreamWriter out;
		BufferedReader in;
		
		connect = (HttpURLConnection) url.openConnection();
		connect.setDoOutput(true);
		connect.setRequestProperty( "Content-Type", "application/json" );
		connect.setRequestMethod("POST");
			
		out = new OutputStreamWriter(connect.getOutputStream());
		out.write(token);
		out.flush();
			
		in = new BufferedReader(new InputStreamReader(connect.getInputStream()));	
		return in;
	}
	
	public static void getResult(URL url, String token) throws Exception
	{
		BufferedReader in = connect(url, token);
		
		String result;
		while((result = in.readLine()) != null)
			System.out.println(result);
		in.close();
	}
}
