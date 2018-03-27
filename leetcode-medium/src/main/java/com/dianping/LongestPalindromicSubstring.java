package com.dianping;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        System.out.println(getResult(s1));
        System.out.println(getResult(s2));
    }

    private String getResult(String s) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > high - low + 1) {
                low = i - (len - 1) / 2;
                high = i + len / 2;
            }
        }
        return s.substring(low, high + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // O(n*n*n) complexity
    // private static String getResult(String s) {
    // int low = 0;
    // int high = 0;
    // int maxLength = 0;
    // for (int i = 0; i < s.length();i++) {
    // for (int j = i; j < s.length(); j++) {
    // if (isPalidromic(s.substring(i, j + 1))) {
    // if ((j - i + 1) > maxLength) {
    // low = i;
    // high = j;
    // maxLength = j - i + 1;
    // }
    // }
    // }
    // }
    // return s.substring(low, high + 1);
    // }
    //
    // private static boolean isPalidromic(String s) {
    // int length = s.length();
    // int mid = length / 2;
    // for (int i = 0; i < mid; i++) {
    // if (s.charAt(i) != s.charAt(length - 1 - i)) {
    // return false;
    // }
    // }
    // return true;
    // }
}
