
/* A Ninja has an ‘N’ Day training schedule.
 He has to perform one of these three activities (Running, Fighting Practice, or Learning New Moves) each day. 
 There are merit points associated with performing an activity each day. 
 The same activity can’t be performed on two consecutive days.
  We need to find the maximum merit points the ninja can attain in N Days. */

public class Ninja_Training_recur {
    private static int solve(int day, int last, int[][] arr) {
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, arr[0][i]);
                }
            }
            return maxi;
        }
        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int points = arr[day][i] + solve(day - 1, i, arr);
                maxi = Math.max(maxi, points);
            }
        }
        return maxi;

    }

    public static void main(String[] args) {
        int[][] arr = { { 10, 40, 70 },
                { 20, 50, 80 },
                { 30, 60, 90 } };
        int length = arr.length;
        System.out.println(solve(length - 1, 3, arr));
    }
}
