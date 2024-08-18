import java.util.Arrays;

public class Ninja_Training_memo {
    private static int solve(int days, int last, int[][] arr, int[][] dp) {
        if (dp[days][last] != -1)
            return dp[days][last];
        if (days == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, arr[0][i]);
                }
            }
            return dp[days][last] = maxi; // Store and return the result

        }

        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int points = arr[days][i] + solve(days - 1, i, arr, dp);
                maxi = Math.max(maxi, points);
            }
        }

        return dp[days][last] = maxi;
    }

    private static int fill(int[][] arr, int num) {
        int[][] dp = new int[num][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(num - 1, 3, arr, dp);
    }

    public static void main(String[] args) {
        int arr[][] = { { 10, 40, 70 },
                { 20, 50, 80 },
                { 30, 60, 90 } };
        int length = arr.length;
        System.out.println(fill(arr, length));
    }
}
