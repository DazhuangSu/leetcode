package com.dianping;

import java.util.HashMap;

public class LongestSubstring {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        System.out.println(getResult(s1));
        System.out.println(getResult(s2));
        System.out.println(getResult(s3));
    }
    
    private static String getResult(String input) {
        StringBuilder sb = new StringBuilder();
        if (input.length() == 0) {
            return sb.toString();
        }
        HashMap<Character, Integer> charToIndex = new HashMap<Character, Integer>();
        int max = 0;
        int low = 0;
        int high = 0;
        for (int i = 0, j = 0; i < input.length(); i++) {
            if (charToIndex.containsKey(input.charAt(i))) {
                j = Math.max(j, charToIndex.get(input.charAt(i)) + 1);
            }
            charToIndex.put(input.charAt(i), i);
            int newMax = i - j + 1;
            if (newMax > max) {
                max = newMax;
                low = j;
                high = i;
            }
        }
        return input.substring(low, high + 1);
    }
}
