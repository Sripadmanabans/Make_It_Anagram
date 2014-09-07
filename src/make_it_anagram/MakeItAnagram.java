package make_it_anagram;

import java.util.HashMap;
import java.util.Scanner;

public class MakeItAnagram 
{
	public static int anagram(String a, String b) 
	{
		int count = 0;
		char arrayA[] = a.toCharArray();
		char arrayB[] = b.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < arrayA.length; i++)
		{
			if(map.containsKey(arrayA[i]))
			{
				int value = map.get(arrayA[i]);
				value += 1;
				map.put(arrayA[i], value);
			}
			else
			{
				map.put(arrayA[i], 1);
			}
		}
		for(int i = 0; i < arrayB.length; i++)
		{
			if(map.containsKey(arrayB[i]))
			{
				int value = map.get(arrayB[i]);
				value -= 1;
				map.put(arrayB[i], value);
			}
			else
			{
				map.put(arrayB[i], -1);
			}
		}
		System.out.println(map.entrySet());
		for(char c : map.keySet())
		{
			count += Math.abs(map.get(c));
		}
		return count;
	}
	
	public static void main(String args[]) 
	{
		Scanner sr = new Scanner(System.in);
		String a = sr.nextLine();
		String b = sr.nextLine();
		System.out.println(anagram(a, b));
		sr.close();
	}
}
