package hashmap;

/**
 * Takes an input string and produces a 32-character hash
 * of that input string. 
 * 
 * Change one character and the hash changes.
 * 
 * @author lorenzo
 *
 */

import java.security.*;
import java.math.*;

public class Hasher
{
	// Create instance of MD5 algorithm
	public static void getHash(String input) throws NoSuchAlgorithmException
	{
		MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
		digest.update(input.getBytes(), 0, input.length());
		System.out.println("MD5 hash: " + new BigInteger(1, digest.digest()).toString(16));
	}

	public static void main(String[] args) throws NoSuchAlgorithmException
	{
		String string1 = "Suppose he should relent and publish grace to all, on promise made of new subjection, with what eyes could we stand in his presence humble?";
		getHash(string1);
	
		String string2 = "Suppose he should relent and publish grace to all, on promise made of new subjection, with what eyes could we stand in his presence humble?";
		getHash(string2);		
		
//		String string3 = "Central garbage collection";
//		getHash(string3);		
	}
}
