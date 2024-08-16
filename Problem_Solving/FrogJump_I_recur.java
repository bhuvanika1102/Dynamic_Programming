/*
 * Problem Statement:

Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair.
 At a time the frog can climb either one or two steps. A height[N] array is also given. 
 Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]),
  where abs() means the absolute difference. 
We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1.
 */
public class FrogJump_I_recur {
    private static int min(int a, int b) {
        return a < b ? a : b;
    }

    private static int frog_jump(int[] arr, int num) {
        int first_jump = -1;
        int second_jump = Integer.MAX_VALUE; // Initialize with a large value
        if (num == 0)
            return 0;
        first_jump = frog_jump(arr, num - 1) + Math.abs(arr[num] - arr[num - 1]);

        if (num > 1) {
            second_jump = frog_jump(arr, num - 2) + Math.abs(arr[num] - arr[num - 2]);
        }

        return min(first_jump, second_jump);
    }

    public static void main(String[] args) {
        int[] heights = { 10, 20, 30, 10 };
        int num = heights.length - 1;
        System.out.println(frog_jump(heights, num));
    }

}
