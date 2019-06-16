package com.zlin.fish.leetcode.service;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author zlin
 * @ClassName ThreeSum
 * @Description  三数之和
 * @Date 2019/6/16 17:29
 * @Version 1.0
 **/
@Service
public class ThreeSumService {

    /**
     * HashSet 去重版
     * @param nums
     * @return
     */
    public ArrayList<ArrayList<Integer>> threeSum01(int[] nums) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        //hashSet 去重
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        //数组排序
        Arrays.sort(nums);
        int low;
        int high;
        int last = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            low = i + 1;
            high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    ArrayList<Integer> pre = new ArrayList<Integer>();
                    pre.add(nums[i]);
                    pre.add(nums[low]);
                    pre.add(nums[high]);
                    if (!hashSet.contains(pre)) {
                        hashSet.add(pre);
                        list.add(pre);
                    }
                    low++;
                    high--;
                } else if (sum > 0) {
                    high--;
                } else if (sum < 0) {
                    low++;
                }
            }
        }
        return list;
    }

    public ArrayList<ArrayList<Integer>> threeSum02(int[] nums) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        int sum;
        int low;
        int high;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                low = i + 1;
                high = nums.length - 1;
                while (low < high) {
                    sum = nums[i] + nums[low] + nums[high];
                    if (sum == 0) {
                        ArrayList<Integer> pre = new ArrayList<Integer>();
                        pre.add(nums[i]);
                        pre.add(nums[low]);
                        pre.add(nums[high]);
                        list.add(pre);
                        low++;
                        high--;
                        while (low < high && nums[low] == nums[low - 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high + 1]) {
                            high--;
                        }
                    } else if (sum > 0) {
                        high--;
                    } else if (sum < 0) {
                        low++;
                    }
                }
            }
        }
        return list;
    }

    /**
     * 最终提交版本
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum03(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        int sum;
        int low;
        int high;
        Arrays.sort(nums);
        //数组长度为3
        if(nums.length ==3){
            int sum1 =nums[0] + nums[1] + nums[2];
            if(sum1==0){
                List<Integer> pre = new ArrayList<Integer>();
                pre.add(nums[0]);
                pre.add(nums[1]);
                pre.add(nums[2]);
                list.add(pre);
            }
        }else{
            for (int i = 0; i < nums.length - 3; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    low = i + 1;
                    high = nums.length - 1;
                    while (low < high) {
                        sum = nums[i] + nums[low] + nums[high];
                        if (sum == 0) {
                            List<Integer> pre = new ArrayList<Integer>();
                            pre.add(nums[i]);
                            pre.add(nums[low]);
                            pre.add(nums[high]);
                            list.add(pre);
                            low++;
                            high--;
                            while (low < high && nums[low] == nums[low - 1]) {
                                low++;
                            }
                            while (low < high && nums[high] == nums[high + 1]) {
                                high--;
                            }
                        } else if (sum > 0) {
                            high--;
                        } else if (sum < 0) {
                            low++;
                        }
                    }
                }
            }
        }

        return list;
    }

    /**
     * 自己实现的版本
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumSelf(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int first;
        int second;
        int last;
        Arrays.sort(nums);
        List<Integer> innerList = null;
        for (int i = 0; i < nums.length; i++) {
            first = nums[i];
            for (int m = i + 1; m < nums.length; m++) {
                second = nums[m];
                int temp = first + second;
                for (int t = m + 1; t < nums.length; t++) {
                    last = nums[t];
                    if (temp == -last) {
                        innerList = new ArrayList<Integer>();
                        innerList.add(first);
                        innerList.add(second);
                        innerList.add(last);
                        //判断
                        Boolean yes = compareList(list, innerList);
                        if (!yes) {
                            list.add(innerList);
                        }
                        break;
                    }
                }
            }

        }
        return list;
    }

    private Boolean compareList(List<List<Integer>> list, List<Integer> pre) {
        Collections.sort(pre);
        Boolean flag = false;
        if (list.contains(pre)) {
            flag = true;
        }
        return flag;
    }
}
