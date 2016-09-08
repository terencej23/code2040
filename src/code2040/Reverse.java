package code2040;

import java.net.*;
import java.io.*;

public class Reverse extends Connect 
{
	public static void main(String[] args) throws Exception 
	{
			URL url = new URL("http://challenge.code2040.org/api/reverse");
			String token = "{\"token\":\"90cbb362df71c877e4dd238ef8a63e6f\"";
			String string = token + "}";
			
			BufferedReader in = connect(url, string);
			
			String original;
			while((original = in.readLine()) != null)
			{
				String reversed = new StringBuilder(original).reverse().toString();
				String stringV = token + ",\"string\":\"" + reversed + "\"}";	
				URL validate = new URL("http://challenge.code2040.org/api/reverse/validate");
				
				getResult(validate, stringV);
			}
			in.close();		
	}
}
