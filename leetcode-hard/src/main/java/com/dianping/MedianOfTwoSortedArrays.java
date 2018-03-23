package com.dianping;

import java.util.LinkedList;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] input1 = { 1, 2 };
        int[] input2 = { 3, 4 };

        System.out.println(getResult(input1, input2));
    }

    private static double getResult(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        double totalLength = nums1.length + nums2.length;
        double mid = totalLength / 2;
        int count = 1;
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        while (i < nums1.length || j < nums2.length) {
            int toAdd;
            if (i >= nums1.length) {
                toAdd = nums2[j];
                j = j + 1;
            } else if (j >= nums2.length) {
                toAdd = nums1[i];
                i = i + 1;
            } else {
                if (nums1[i] > nums2[j]) {
                    toAdd = nums2[j];
                    j = j + 1;
                } else {
                    toAdd = nums1[i];
                    i = i + 1;
                }
            }
            if (Math.abs(mid - count) <= 1) {
                tmp.add(toAdd);
            }
            count++;
        }
        if (totalLength == 1) {
            return tmp.getFirst();
        } else if (totalLength == 2) {
            return (tmp.getFirst() + tmp.getLast()) / 2.0;
        } else {
            tmp.removeFirst();
            if (totalLength % 2 == 0) {
                return (tmp.getFirst() + tmp.getLast()) / 2.0;
            } else {
                return tmp.getFirst();
            }
        }
    }
}
