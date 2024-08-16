/*Problem Statement: Given a number of stairs. Starting from the 0th stair we need to climb to the “Nth” stair.
 At a time we can climb either one or two steps. 
We need to return the total number of distinct ways to reach from 0th to Nth stair. */
public class ClimbStairs_recur {
    private static int climb_stairs(int num) {
        if (num == 0)
            return 1;
        if (num == 1)
            return 1;
        int left = climb_stairs(num - 1);
        int right = climb_stairs(num - 2);
        return left + right;
    }

    public static void main(String[] args) {
        int num = 4;
        System.out.println(climb_stairs(num));
    }
}
