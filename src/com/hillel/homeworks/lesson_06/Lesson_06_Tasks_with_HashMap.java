package com.hillel.homeworks.lesson_06;

import com.hillel.homeworks.Utils;

import java.util.Collection;
import java.util.HashMap;

public class Lesson_06_Tasks_with_HashMap {
	private static String lessonName = "Lesson_06_Tasks_with_HashMap".replace('_', ' ').toUpperCase();
    private static final String TASK01 = "Write method which compares 2 strings and returns quantity of letters which are differs. In case stings have different lenght returns -1."
    		+ "\nFor example:\na=asdf, b=qwerty => -1\na=abb, b=bba => 0\na=abc, b=dca => 1\na=aaa, b=fga => 2\na=abc, b=dfg => 3";

    public static void run() {
        Utils utils = new Utils();
        System.out.println(Utils.wrapMessage(lessonName, true,'*','*', '*'));
        utils.execute(TASK01, Lesson_06_Tasks_with_HashMap::task01);

    }

    private static void task01() {
        String[] val1 = {"asdf", "abb", "abc", "aaa", "abc", "hjkuygjhbgfdghjhgtgyrdfchgfknhgdfh"};
        String[] val2 = {"qwerty", "bba", "dca", "fga", "dfg", "hjkuygjhbgfdghjhgtgyrdfchgfknhgzfz" };

        for (int i = 0; i < val1.length; i++) {
            System.out.println("Analyzing words with  circle  compare: " + val1[i] + " and " + val2[i] + ", answer = " + compare(val1[i], val2[i]));
            System.out.println("Analyzing words with Hashcode compare: " + val1[i] + " and " + val2[i] + ", answer = " + compareWithHashMap(val1[i], val2[i])+"\n");
        }
    }

    private static int compare(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;
        StringBuilder secondStringAsStringBuilder = new StringBuilder(s2);
        int count;
        int length2 = secondStringAsStringBuilder.length();

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < length2; j++) {
                if (s1.charAt(i) == secondStringAsStringBuilder.charAt(j)) {
                    secondStringAsStringBuilder.deleteCharAt(j);
                    length2 = secondStringAsStringBuilder.length();
                    break;
                }
            }
        }
        count = secondStringAsStringBuilder.length();
        return count;
    }
    
    private static int compareWithHashMap(String s1, String s2) {
    	if(s1.length() != s2.length()) return -1;
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	int count =0;
    	stringToMap(map, s1,1);
    	stringToMap(map, s2,-1);
    	Collection<Integer> values =  map.values();
    	for(Integer v: values) {
    		count=count + Math.abs(v);
    	}
    	return count/2;
    }
    
    private static void stringToMap(HashMap<Character, Integer> map, String str, int increment) {
    	int value;
    	Character ch;
    	for (int i=0; i<str.length(); i++) {
    		ch = str.charAt(i);
    		if(map.containsKey(ch)) {
    			value = map.get(ch)+increment;
    		} else {
    			value = increment;
    		}
    		map.put(ch, value);
    	}
    }
}