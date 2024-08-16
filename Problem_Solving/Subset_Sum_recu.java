//1.DP ON SUBSEQUENCES
/*RECURSION
 * TC=>O(2^n)
 * SC=>O(n)
 */
public class Subset_Sum_recu {
    private static boolean subsetsum(int[] arr, int target, int idx) {
        if (target == 0)
            return true;
        if (idx == 0)
            return arr[0] == target;
        boolean not_take = subsetsum(arr, target, idx - 1);
        boolean take = false;
        if (target >= arr[idx]) {
            take = subsetsum(arr, target - arr[idx], idx - 1);
        }
        return take || not_take;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int target = 7;
        int idx = arr.length - 1;
        System.out.println(subsetsum(arr, target, idx));
    }
}
