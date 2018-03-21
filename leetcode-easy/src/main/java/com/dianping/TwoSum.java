package com.dianping;

public class TwoSum {

    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int[] result = getResult(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
    
    private static int[] getResult(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j <nums.length; j ++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

}
