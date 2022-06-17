package com.chen.algorithm.排序;

import java.util.Arrays;

/**
 * @author chenchen
 * @date 2022-04-24 23:26
 */
public class 快排 {

    public static void main(String[] args) {
        int[] arr = {20,7,35,17,66,25,3,27};
        int pivot = arr[0]; // 20 基准元素
        int left = arr[0];
        int right = arr[arr.length-1];
        while (left < right){
            // 从右向左找到小于基准位置的元素
            while (arr[right--] < pivot){
                arr[0] = arr[right];
            }
            while (arr[left++] > pivot){
                arr[right] = arr[left];
            }
        }
    }

    public static void quickSort(int[] arr, int left, int right){
        if (left < right){
            // 把数组分块
            int pivot = partition(arr, left, right);
            System.out.println(Arrays.toString(arr));
            // 基准元素左边递归
            quickSort(arr, left, pivot-1);
            // 基准元素右边递归
            quickSort(arr, pivot+1, right);
        }
    }

    /**
     * @Description 一趟快速排序：將序列分片，基准元素左边的都是小于它的，右边的都是大于它的
     * @Param [arr, left, right]
     */
    public static int partition(int[] arr, int left, int right){
        int pivot = arr[left];        	// 选取第一个为基准元素
        while(left<right){
            /* 先从右往移动，直到遇见小于 pivot 的元素 */
            while (left<right && arr[right]>=pivot){
                right--;
            }
            arr[left] = arr[right];         // 记录小于 pivot 的值

            /* 再从左往右移动，直到遇见大于 pivot 的元素 */
            while(left<right && arr[left]<=pivot){
                left++;
            }
            arr[right] = arr[left];         // 记录大于 pivot 的值
        }
        arr[left] = pivot;            		// 记录基准元素到当前指针指向的区域
        return left;						// 返回基准元素的索引
    }



}
