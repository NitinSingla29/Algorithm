package com.sample;
import java.util.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/fill-array-by-1s/0
class FillArrayWithOne {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int numberOfTest = s.nextInt();

        for(int i = 0; i < numberOfTest; i++) {
            int arrSize = s.nextInt();
            int[] inputArr = new int[arrSize];
            for(int j = 0; j < arrSize; j++) {
                inputArr[j] = s.nextInt();
            }
            System.out.println(countIterationToFillArr(inputArr));
        }
    }

    private static int countIterationToFillArr(int[] inputArr) {
        int result = 0;
        boolean arrayChanged = true;
        while(arrayChanged) {
            arrayChanged = false;
            for(int i = 0; i < inputArr.length;i++) {
                if(inputArr[i]==1 && (i-1) >= 0 && inputArr[i-1]==0) {
                    inputArr[i-1]=1;
                    arrayChanged = true;
                }
                if(inputArr[i]==1 && (i+1)<inputArr.length && inputArr[i+1]==0) {
                    inputArr[i+1]=1;
                    arrayChanged = true;
                    i++;
                }
            }
            if(arrayChanged) {
                result++;
            }
        }
        for(int i = 0; i < inputArr.length ; i++) {
            if(inputArr[i]==0) {
                return -1;
            }
        }
        return result;
    }
}