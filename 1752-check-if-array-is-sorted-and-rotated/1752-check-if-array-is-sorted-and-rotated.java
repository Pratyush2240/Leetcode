class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        if (n <= 1) return true;

        // count drops in linear scan
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
            }
        }

        // check last to first (rotation condition)
        if (nums[n - 1] > nums[0]) {
            count++;
        }

        return count <= 1;
    }
}