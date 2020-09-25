package DebugInterviews;

public class SubsetSumBacktracking {
        
        public static boolean subsetSum(int[] arr, int n, int sum)
        {
            // return true if given sum is 0 or sum becomes 0 eventually ie., subset found
            if (sum == 0) {
                return true;
            }

            // base case: empty array or no items left or sum becomes negative
            if (n < 0 || sum < 0) {
                return false;
            }

            // Case 1: include the current element in the subset and recur
            // for remaining (n - 1) elements with remaining (sum - arr[n]) sum
            boolean include = subsetSum(arr, n - 1, sum - arr[n]);

            // Case 2: exclude the current element n from subset and recur
            // for remaining (n - 1) elements
            boolean exclude = subsetSum(arr, n - 1, sum);

            // return true if we get a subset by either including or excluding the current element
            return include || exclude;
        }

        public static void main(String[] args)
        {
            int[] arr = { 3, 5, 10, 1, 9 };
            int sum = 8;

            if (subsetSum(arr, arr.length - 1, sum)) {
                System.out.print("True");
            }
            else {
                System.out.print("False");
            }
        }
}
