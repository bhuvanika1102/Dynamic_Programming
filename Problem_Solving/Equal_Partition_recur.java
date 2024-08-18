public class Equal_Partition_recur {
    private static boolean solve(int[] arr, int target, int idx) {
        if (target == 0)
            return true;
        if (idx == 0)
            return arr[0] == target;
        boolean nottake = solve(arr, target, idx - 1);
        boolean take = false;
        if (target >= arr[idx]) {
            take = solve(arr, target - arr[idx], idx - 1);
        }
        return take || nottake;
    }

    private static boolean total(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 == 1)
            return false;
        int target = sum / 2;
        return solve(arr, target, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 6, 7, 3 };
        System.out.println(total(arr));

    }

}
