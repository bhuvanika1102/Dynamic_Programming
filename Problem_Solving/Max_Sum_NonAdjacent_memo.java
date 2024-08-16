
/*Given an array of ‘N’  positive integers, 
we need to return the maximum sum of the subsequence 
such that no two elements of the subsequence are adjacent elements in the array.
*/

import java.util.Arrays;

public class Max_Sum_NonAdjacent_memo {
    private static int solve(int[] arr, int idx, int[] dp) {
        if (idx == 0)
            return arr[idx];
        if (idx < 0)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int pick = arr[idx] + solve(arr, idx - 2, dp);
        int notpick = 0 + solve(arr, idx - 1, dp);
        return dp[idx] = Math.max(pick, notpick);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 9 };
        int num = arr.length;
        int[] dp = new int[num];
        Arrays.fill(dp, -1);
        System.out.println(solve(arr, num - 1, dp));
    }
}
