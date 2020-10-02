package DebugInterviews;

import java.util.HashMap;
import java.util.Map;

/*Top-Down approach*/
public class SubsetSumMemoization {
    public static boolean subsetSum(int[] arr, int n, int sum,
                                    Map<String, Boolean> memo) {
        // return true if given sum is 0 or sum becomes 0 eventually ie., subset found
        if (sum == 0) {
            return true;
        }

        // base case: empty array or no items left or sum becomes negative
        if (n < 0 || sum < 0) {
            return false;
        }

        // construct an unique key from dynamic elements of the input
        String key = n + "|" + sum;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!memo.containsKey(key)) {

            // Case 1: include the current element in the subset and recur
            // for remaining (n - 1) elements with remaining (sum - arr[n]) sum
            boolean include = subsetSum(arr, n - 1, sum - arr[n], memo);

            // Case 2: exclude the current element n from subset and recur
            // for remaining (n - 1) elements
            boolean exclude = subsetSum(arr, n - 1, sum, memo);

            // assign true if we get a subset by either including or excluding the current element
            memo.put(key, include || exclude);
        }

        // return solution to current sub-problem
        return memo.get(key);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 10, 1, 9 };
        int sum = 8;

        // create a memo map to store solutions of subproblems
        Map<String, Boolean> memo = new HashMap<>();

        if (subsetSum(arr, arr.length - 1, sum, memo)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
