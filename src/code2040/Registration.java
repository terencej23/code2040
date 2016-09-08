package code2040;

import java.net.*;

public class Registration extends Connect
{
	public static void main(String[] args) throws Exception 
	{
			URL register = new URL("http://challenge.code2040.org/api/register");
			String token = "{\"token\":\"90cbb362df71c877e4dd238ef8a63e6f\"";
			String git = "\"github\":\"https://github.com/terencej23/code2040\"}";
			String string = token + "," + git;
			
			getResult(register, string);
	}
}