package com.sample.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nsin79 on 6/15/2017.
 */
public class PerfectSum {

    public static List<List<Integer>> getAllPerfectSumSubeset(int[] input, int start, int end, int requiredSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(start == end && input[start] != requiredSum) {
            return result;
        }
        if(start == end && input[start] == requiredSum) {
            final List<Integer> subset = new ArrayList<>();
            subset.add(requiredSum);
            result.add(subset);
            return result;
        }
        if(input[end] > requiredSum) {
            return getAllPerfectSumSubeset(input, start, end - 1, requiredSum);
        }
        final List<List<Integer>> subsetsWithLastValueIncluded = getAllPerfectSumSubeset(input, start, end - 1, requiredSum - input[end]);

        for(List<Integer> subsetWithLastValues:subsetsWithLastValueIncluded
            ) {
            subsetWithLastValues.add(input[end]);
        }

        result.addAll(subsetsWithLastValueIncluded);
        result.addAll(getAllPerfectSumSubeset(input, start, end - 1, requiredSum));
        return result;
    }

    public static void main(String[] args) {
        final List<List<Integer>> allPerfectSumSubeset = getAllPerfectSumSubeset(new int[]{2, 3, 5, 6, 8, 10}, 0,
                5, 10);
        allPerfectSumSubeset.forEach(ints -> System.out.print(ints));
    }

}
