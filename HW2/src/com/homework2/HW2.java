package com.homework2;

import java.util.Arrays;

public class HW2 {
    public static void main(String[] args) {

        HW2 hw2 = new HW2();
        int[] arrToSort = {2,3,1,7,11};
        // checking first task
        System.out.println(hw2.reverseOrderSort(arrToSort));

        // checking second task
        int[] arrWithNegatives = {-2,3,1,-7,11};
        System.out.println(hw2.getPositiveNumSum(arrWithNegatives));

        // checking third task
        int[] avgCheck = {1,2,4,1};
        System.out.println(hw2.calcAvg(avgCheck));

        // checking fourth task
        int[] arrToReplace = {3,2,3,1,4,2,8,3};
        System.out.println(hw2.replaceDuplicates(arrToReplace));

    }

    /*
     * Create next array of Integers with values: 2,3,1,7,11. Sort them by DESC(reverseOrder).
     */
    public String reverseOrderSort(int[] arr){

        int[] output = arr.clone();
        for(int i = 1; i <= output.length; i++){
            int j = i-1;
            while (--j >= 0 && (output[j] < output[j+1])){
                int tmp = output[j+1];
                output[j+1] = output[j];
                output[j] = tmp;
            }
        }
        return Arrays.toString(output);

    }

    /*
     * You get an array of numbers(should contain both positive and negative numbers),
     * and return the sum of all the positive ones. (If there are nothing to sum, sum should be 0)
     */

    public int getPositiveNumSum(int[] arr){

        int sum = 0;
        for(int elem: arr){
            if (elem > 0)
                sum += elem;
        }
        return sum;
    }

    /*
     * You get an array of numbers, return the average of a list of numbers in this array. (Example -  array{1,2,4,1} -> avg = 2)
     */
    public int calcAvg(int[] arr){

        int total = 0;
        for(int elem: arr){
            total += elem;
        }
        return total / arr.length;
    }

    /*
     * *You have array {3,2,3,1,4,2,8,3}. Replace all duplicated values by 0. Result should be  next: {3,2,0,1,4,0,8,0}
     */
    public String replaceDuplicates(int[] arr){

        int[] output = arr.clone();

        for(int i = 0; i < output.length; i++)

            for (int j = i+1; j < output.length; j++){
                if (output[i] == output[j])
                    output[j] = 0;
            }
        return Arrays.toString(output);
    }


}
