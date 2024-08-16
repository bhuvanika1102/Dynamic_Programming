/*
 * In the previous question, the frog was allowed to jump either one or two steps at a time.
 *  In this question, the frog is allowed to jump up to ‘K’ steps at a time. 
 * If K=4, the frog can jump 1,2,3, or 4 steps at every index.
 */
public class FrogJump_II_recur {
    private static int solve(int idx, int[] arr, int k) {
        if (idx == 0)
            return 0;

        int minsteps = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (idx - i >= 0) {
                int jump = solve(idx - i, arr, k) + Math.abs(arr[idx] - arr[idx - i]);
                minsteps = Math.min(jump, minsteps);
            }
        }
        return minsteps;
    }

    public static void main(String[] args) {
        int[] heights = { 30, 10, 60, 10, 60, 50 };
        int num = heights.length;
        int k = 2;
        System.out.println(solve(num - 1, heights, k));
    }
}
