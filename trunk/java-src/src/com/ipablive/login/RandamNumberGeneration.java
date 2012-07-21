/**
 * 
 */
package com.ipablive.login;

import java.util.Random;

/**
 * @author 
 *
 */
public class RandamNumberGeneration 
{

	/**
	 * 
	 */
	public RandamNumberGeneration() 
	{
		
	}
	
	public static Random rn=null;
	static
	{
	 rn = new Random();
	}
	public static int rand(int lo, int hi)
	{
		int n = hi - lo + 1;
		int i = rn.nextInt() % n;
		if (i < 0)
			i = -i;

		return lo + i;
	}

	public static String randomstring(int lo, int hi)
	{
		int n = rand(lo, hi);
		int m = rand(5, 9);
		int p = rand(0, 5);
		
		byte b[] = new byte[n];
		for (int i = 0; i < n; i++)
		{
			b[i] = (byte) rand('a', 'z');
			b[m] = (byte) rand('A', 'Z');
			b[p] = (byte) rand('0', '9');
		}
			
		return new String(b);
	}
	
//	public static void main(String[] args) {
//		for(int i=0; i<5;i++)
//		{
//			String num = randomstring(15, 20);
//			System.out.println(num);
//		}
//		
//	}

}
