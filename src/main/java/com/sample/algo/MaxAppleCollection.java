package com.sample.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nsin79 on 6/15/2017.
 */
//https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm
// /collecting-apples-69/
public class MaxAppleCollection {

    public static Integer[][] maxAppleMap = new Integer[20][20];

    private static List<Integer> asList(Integer[] arr) {
        return Arrays.asList(arr);
    }

    public static int getMaxAppleCount(int[] appArr, int[] energyArr, int farmCount, int
            startFarmIndex, int remainingEnergy) {
        if(farmCount == 0 || remainingEnergy == 0) {
            return 0;
        }
        if(remainingEnergy > farmCount) {
            remainingEnergy = farmCount;
        }
        if(maxAppleMap[remainingEnergy][startFarmIndex]!=null) {
            return maxAppleMap[remainingEnergy][startFarmIndex];
        }

        maxAppleMap[remainingEnergy][startFarmIndex] = Math.max(appArr[startFarmIndex] +
                        getMaxAppleCount(appArr,
                energyArr,
                farmCount - 1,
                startFarmIndex + 1, (remainingEnergy - 1)),
                getMaxAppleCount(appArr, energyArr, farmCount - 1,
                        startFarmIndex + 1, remainingEnergy - 1 + energyArr[startFarmIndex]));
        return maxAppleMap[remainingEnergy][startFarmIndex];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numberOfTest = s.nextInt();

        for(int i = 0; i < numberOfTest; i++) {
            int farmCount = s.nextInt();
            int remainingEnergy = s.nextInt();

            int[] energyArr = new int[farmCount];
            int[] appleArr = new int[farmCount];
            maxAppleMap = new Integer[farmCount+1][farmCount+1];
            for(int j = 0; j < farmCount; j++) {
                energyArr[j] = s.nextInt();
            }
            for(int j = 0; j < farmCount; j++) {
                appleArr[j] = s.nextInt();
            }
            System.out.println(getMaxAppleCount(appleArr, energyArr, farmCount, 0, remainingEnergy));
        }
    }
}
