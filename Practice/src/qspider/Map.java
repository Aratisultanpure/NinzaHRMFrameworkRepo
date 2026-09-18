package qspider;

import java.util.HashMap;

public class Map {

	public static void main(String[] args) {

		
		HashMap<Integer,String> hm = new HashMap<Integer, String>();
		hm.put(10, "Apple");
		hm.put(20, "Orange");
		hm.put(30, "Banana");
		hm.put(40, "Guava");
		
		
		System.out.println("Keys are:");
		for(Integer i :hm.keySet())
		{
			System.out.println(i);
		}
		System.out.println("Values are:");
		for(String s:hm.values())
		{
			System.out.println(s);
		}
	}

}
