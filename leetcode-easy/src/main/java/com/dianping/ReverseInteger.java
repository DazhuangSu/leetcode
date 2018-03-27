package com.dianping;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();
        ReverseInteger.Solution solution = r.new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(120));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(solution.reverse(Integer.MAX_VALUE));
        System.out.println(solution.reverse(1463847412));
        System.out.println(solution.reverse(-2147483648));
    }

    private class Solution {
        private int reverse(int x) {
            int re = 0;
            while (x % 10 != 0 || x / 10 != 0) {
                if (re > Integer.MAX_VALUE / 10 || re < Integer.MIN_VALUE / 10) {
                    return 0;
                }
                if (re == Integer.MAX_VALUE / 10 || re == Integer.MIN_VALUE / 10) {
                    if (x % 10 > Integer.MAX_VALUE % 10 || x % 10 < Integer.MIN_VALUE % 10) {
                        return 0;
                    }
                }
                re = re * 10 + x % 10;
                x = x / 10;
            }
            return re;
        }
    }
}