package com.hillel.homeworks.lesson_09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hillel.homeworks.Utils;

public class Lesson_09_TreeMap_Jenerics {
	private static String LESSON_NAME = "Lesson_09_TreeMap_Janerics".replace('_', ' ').toUpperCase();

	private static final String TASK01 = "There is a .txt file containing list of URLs. Print top10 visited domens. "
			+ "Incorrect URLs should be ignored";
//	TODO Implement task2 and task3
	private static final String TASK02 = "Implements interface Map as TreeMap<K,V>";
	private static final String TASK03 = "Implement balanced tree as red-black or AVL";

	public static void run() {
		Utils utils = new Utils();
		System.out.println(Utils.wrapMessage(LESSON_NAME, true, '*', '*', '*'));
		utils.execute(TASK01, Lesson_09_TreeMap_Jenerics::task01);
//		utils.execute(TASK02, Lesson_09_TreeMap_Janerics::task02);
//		utils.execute(TASK02, Lesson_09_TreeMap_Janerics::task03); 
	}

	private static void task01() {
		String path = "C:\\JavaProjects\\_Hillel\\com.hillel.homeworks\\src\\com\\hillel\\homeworks\\lesson_09\\urls.txt";
//		String path = "C:\\JavaProjects\\_Hillel\\com.hillel.homeworks\\src\\com\\hillel\\homeworks\\lesson_09\\short_url.txt";
		List<String> urls = readFile(path);
		Map<String, Integer> myMap = new HashMap<String, Integer>();

		for (String line : urls) {
			String domain = getDomen(line);
			if (domain.isEmpty())
				continue;
			myMap.put(domain, myMap.getOrDefault(domain, 0) + 1);
		}

		PriorityQueue<Entry<String, Integer>> topUrls = new PriorityQueue<>(
				(a, b) -> Integer.compare(a.getValue(), b.getValue()));

		for (Entry<String, Integer> entry : myMap.entrySet()) {
			topUrls.offer(entry);
			if (topUrls.size() > 10) {
				topUrls.poll();
			}
		}

		List<Entry<String, Integer>> sortedTopUrls = new ArrayList<>(topUrls);
		Collections.sort(sortedTopUrls, (a, b) -> Integer.compare(b.getValue(), a.getValue()));

		System.out.println("Top 10:");
		sortedTopUrls.stream().forEach(item -> System.out.printf("%-30s - %4d%n",item.getKey(), item.getValue()));
	}

	private static void task02() {

	}

	private static void task03() {

	}

//	task01 helper
	private static List<String> readFile(String path) {
		LinkedList<String> result = new LinkedList<String>();

		try (FileReader newReader = new FileReader(path); Scanner newScan = new Scanner(newReader);) {
			while (newScan.hasNextLine()) {
				String line = newScan.nextLine();
				if (line != null && !line.isEmpty()) {
					result.add(line);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return result;
	}

	private static String getDomen(String url) {
		if (url == null || url.isEmpty()) {
			return "";
		}

//		starts with prefix
		String[] prefixes = { "www.", "http//:", "https//:" };
		for (String prefix : prefixes) {
			if (url.startsWith(prefix)) {
				if (url.indexOf("/") < 0) {
					return url.substring(prefix.length());
				} else {
					if (url.indexOf("/") >= prefix.length()) {
						return url.substring(prefix.length(), url.indexOf("/"));
					} else {
						return "";
					}
				}
			}
		}

//		check for ip
		String ipRegex = "(\b25[0-5]|\b2[0-4][0-9]|\b[01]?[0-9][0-9]?)(\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}";
		Pattern p = Pattern.compile(ipRegex);
		Matcher m = p.matcher(url);
		if (m.find()) {
			return url.substring(m.start(), m.end());
		}
		;

//		URL without prefix	
		if (url.indexOf("/") > 0) {
			return url.substring(0, url.indexOf("/"));
		}

		return "";
	}

//	TODO
	private class MyTreeMapImpl<K, V> implements Map<K, V>{

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsKey(Object key) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsValue(Object value) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public V get(Object key) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public V put(K key, V value) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public V remove(Object key) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void putAll(Map<? extends K, ? extends V> m) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Set<K> keySet() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Collection<V> values() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Set<Entry<K, V>> entrySet() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
