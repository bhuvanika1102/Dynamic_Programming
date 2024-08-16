/*Given an array of ‘N’  positive integers, 
we need to return the maximum sum of the subsequence 
such that no two elements of the subsequence are adjacent elements in the array.
*/
public class Max_Sum_NonAdjacent_recur {
    private static int solve(int[] arr, int idx) {
        if (idx == 0)
            return arr[idx];
        if (idx < 0)
            return 0;
        int pick = arr[idx] + solve(arr, idx - 2);
        int notpick = 0 + solve(arr, idx - 1);
        return Math.max(pick, notpick);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 9 };
        int num = arr.length;
        System.out.println(solve(arr, num - 1));
    }
}
