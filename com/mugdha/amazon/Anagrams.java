package com.mugdha.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Anagrams {
	
	public static void main(String args[]) {
		findAnagrams("baa","aa");
		String[] annagram = {"eat","tea","tan","ate","nat","bat"};
		groupAnagrams(annagram);
		
		
	}

	public static List<Integer> findAnagrams(String s, String p) {
		HashMap<String, Integer> pMap = new HashMap<String, Integer>();
		HashMap<String, Integer> sMap = new HashMap<String, Integer>();
		
		char[] c = p.toCharArray();
		LinkedList<Integer> ret = new LinkedList<Integer>();
		
		for(int i = 0; i< p.length(); i++) {
			int count = 0;
			if(pMap.containsKey(Character.toString(c[i])))
				count = pMap.get(Character.toString(c[i]));
			pMap.put(Character.toString(c[i]), ++count);
		}
		
		System.out.println("p map is: "+ pMap);
		char[] c1 = s.toCharArray();
		for(int i = 0; i<= s.length()-(p.length()); i++) {
			int end = i+p.length();
			for(int j = i; j< end; j++) {
				int count = 0;
				
				if(sMap.containsKey(Character.toString(c1[j])))
					count = sMap.get(Character.toString(c1[j]));
				
				sMap.put(Character.toString(c1[j]), ++count);
			}
			System.out.println("New map is: "+ sMap);
			if(pMap.equals(sMap)) {
				ret.add(i);
			}
			sMap = new HashMap<String, Integer>();
			/*
			 * int count = sMap.get(Character.toString(c1[i]));
			 * if(sMap.get(Character.toString(c1[i])) > 1) {
			 * sMap.put(Character.toString(c1[i]), --count); }else
			 * sMap.remove(Character.toString(c1[i]));
			 */
			
		}
		System.out.println(ret);
        return ret;
    }
	
	public static List<Integer> findAnagrams1(String s, String p) {
		HashMap<String, Integer> pMap = new HashMap<String, Integer>();
		HashMap<String, Integer> sMap = new HashMap<String, Integer>();
		
		char[] c = p.toCharArray();
		LinkedList<Integer> ret = new LinkedList<Integer>();
		
		for(int i = 0; i< p.length(); i++) {
			int count = 0;
			if(pMap.containsKey(Character.toString(c[i])))
				count = pMap.get(Character.toString(c[i]));
			pMap.put(Character.toString(c[i]), ++count);
		}
		
		System.out.println("p map is: "+ pMap);
		
		char[] c1 = s.toCharArray();
		for(int i=0; i< s.length(); i++) {
			int count = 0;
			if(sMap.containsKey(Character.toString(c1[i])))
				count = sMap.get(Character.toString(c1[i]));
			sMap.put(Character.toString(c1[i]), count++);
			
		}
		System.out.println(ret);
        return ret;
    }
	
	/*
	 * This code is accepted by leetcode :)
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {
		
		// create mapAnagram - stores the key as the sorted anagram , linked list as the anagrams from the input string
		HashMap<String, LinkedList<String>> mapAnagram = new HashMap<String, LinkedList<String>>();
		
		// loop through the input string array
		
		for(String currentstr : strs){
			// sort each value and check if the map has the key if yes then add to the linked list
			char[] currentCharArr = currentstr.toCharArray();
			Arrays.sort(currentCharArr);
			
			//if map contains then add it as value
			LinkedList<String> list = new LinkedList<String>();
			String sortedCurrentstr = new String(currentCharArr);
			if(mapAnagram.containsKey(sortedCurrentstr)) {
				list = mapAnagram.get(sortedCurrentstr);
			}
			list.add(currentstr);
			mapAnagram.put(sortedCurrentstr, list);
		}
		
		List<List<String>> groupedAnagram = new ArrayList<>();
		groupedAnagram.addAll(mapAnagram.values());
        return groupedAnagram;
    }
	
}
