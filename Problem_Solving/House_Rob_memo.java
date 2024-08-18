
/*A thief needs to rob money in a street. The houses in the street are arranged in a circular manner. 
Therefore the first and the last house are adjacent to each other. 
The security system in the street is such that if adjacent houses are robbed, the police will get notified.

Given an array of integers “Arr'' which represents money at each house, 
we need to return the maximum amount of money that the thief can rob without alerting the police. */
import java.util.Arrays;

public class House_Rob_memo {
    private static int solve(int[] arr, int startIdx, int endIdx, int[] dp) {
        if (endIdx == startIdx)
            return arr[startIdx];
        if (endIdx < startIdx)
            return 0;
        if (dp[endIdx] != -1)
            return dp[endIdx];
        int pick = arr[endIdx] + solve(arr, startIdx, endIdx - 2, dp);
        int notpick = 0 + solve(arr, startIdx, endIdx - 1, dp);
        return dp[endIdx] = Math.max(pick, notpick);
    }

    public static int rob(int[] arr) {
        int num = arr.length;
        if (num == 1)
            return arr[0];
        if (num == 2)
            return Math.max(arr[0], arr[1]);

        int[] dp1 = new int[num];
        Arrays.fill(dp1, -1);
        int maxMoney1 = solve(arr, 0, num - 2, dp1); // Case 1: Include the first house, exclude the last

        int[] dp2 = new int[num];
        Arrays.fill(dp2, -1);
        int maxMoney2 = solve(arr, 1, num - 1, dp2); // Case 2: Exclude the first house, include the last

        return Math.max(maxMoney1, maxMoney2);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 9 };
        System.out.println(rob(arr)); // Output should be 11
    }
}
