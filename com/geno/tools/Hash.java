package com.geno.tools;

import java.security.MessageDigest;
import java.security.Security;
import java.util.Set;

public class Hash
{
	public static final String hash(String str, String algorithm)
	{
		MessageDigest hashcode = null;
		try {hashcode = MessageDigest.getInstance(algorithm); }
		catch (Exception e) {e.printStackTrace(); }
	
		char[] charArray = str.toCharArray();
		byte[] byteArray = new byte[charArray.length];
	
		for (int i=0;i < charArray.length;i++)
			byteArray[i] = (byre)charArray[i];
		byte[] hashBytes = hashcode.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i=0; i < hashBytes.length; i++)
		{
			int val = ((int)hashBytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
	
	public static final Set<String> getAlgol()
	{
		return Security.getAlgorithms("MessageDigest");
	}
}

