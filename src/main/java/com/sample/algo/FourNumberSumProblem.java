package com.sample.algo;

import java.util.*;


//http://practice.geeksforgeeks.org/problems/four-elements/0
class FourNumberSumProblem {
    private static Map<MapKey, Boolean> sumMap = new HashMap<>();

    private static boolean isFourNumberSumExist(int[] arr, int startIndex, int stopIndex, int requiredSum, int
            elementCount) {
        boolean sumExist = false;

        MapKey mapKey = new MapKey(startIndex, requiredSum, elementCount);
        if(arr.length == 0 || startIndex > stopIndex || requiredSum < 0 || elementCount==0) {
            sumExist = false;
            sumMap.put(mapKey, sumExist);
            return sumExist;
        }

        if(elementCount == 1 && arr[startIndex] ==  requiredSum) {
            sumExist = true;
            sumMap.put(mapKey, sumExist);
            return sumExist;
        }

        final Boolean existingValue = sumMap.get(mapKey);
        if(existingValue != null) {
            return existingValue;
        }

        if(arr[startIndex] > requiredSum) {
            sumExist = isFourNumberSumExist(arr, startIndex + 1, stopIndex,
                    requiredSum, elementCount);
        } else {
            sumExist = isFourNumberSumExist(arr, startIndex + 1, stopIndex, requiredSum -
                    arr[startIndex], elementCount - 1)||isFourNumberSumExist(arr, startIndex + 1, stopIndex,
                    requiredSum, elementCount);
        }
        sumMap.put(mapKey, sumExist);
        return sumExist;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numberOfTest = s.nextInt();

        for(int i = 0; i < numberOfTest; i++) {
            int arrSize = s.nextInt();
            int[] inputArr = new int[arrSize];
            for(int j = 0; j < arrSize; j++) {
                inputArr[j] = s.nextInt();
            }
            int requiredSum = s.nextInt();
            sumMap = new HashMap<>(requiredSum);
            System.out.println(isFourNumberSumExist(inputArr, 0, arrSize - 1, requiredSum, 4) ? 1 : 0);
        }
    }

    public static class MapKey {
        int elementCount;
        int requiredSum;
        int startIndex;

        public MapKey(final int startIndex, final int requiredSum, final int elementCount) {
            this.startIndex = startIndex;
            this.requiredSum = requiredSum;
            this.elementCount = elementCount;
        }

        @Override
        public String toString() {
            return "MapKey{" +
                    "elementCount=" + elementCount +
                    ", requiredSum=" + requiredSum +
                    ", startIndex=" + startIndex +
                    '}';
        }

        @Override
        public int hashCode() {
            int result = startIndex;
            result = 31 * result + requiredSum;
            result = 57 * result + elementCount;
            return result;
        }

        @Override
        public boolean equals(final Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;

            final MapKey mapKey = (MapKey) o;

            if(startIndex != mapKey.startIndex) return false;
            if(requiredSum != mapKey.requiredSum) return false;
            return elementCount == mapKey.elementCount;
        }
    }
}