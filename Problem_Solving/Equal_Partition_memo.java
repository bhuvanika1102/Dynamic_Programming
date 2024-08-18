import java.util.Arrays;

public class Equal_Partition_memo {
    private static boolean solve(int[] arr, int target, int idx, boolean[] dp) {
        if (target == 0)
            return true;
        if (idx == 0)
            return arr[0] == target;
        if (dp[idx] != false)
            return dp[idx];
        boolean nottake = solve(arr, target, idx - 1, dp);
        boolean take = false;
        if (target >= arr[idx]) {
            take = solve(arr, target - arr[idx], idx - 1, dp);
        }
        return dp[idx] = take || nottake;
    }

    private static boolean total(int[] arr, boolean[] dp) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 == 1)
            return false;
        int target = sum / 2;
        return solve(arr, target, arr.length - 1, dp);
    }

    private static boolean fill(int[] arr) {
        int n = arr.length;
        boolean[] dp = new boolean[n];
        Arrays.fill(dp, false);
        return total(arr, dp);
    }

    public static void main(String[] args) {
        int[] arr = { 6, 7, 3, 2 };
        System.out.println(fill(arr));

    }

}
