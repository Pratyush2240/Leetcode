import java.util.HashMap;
import java.util.Map;

class Solution {
    public int specialTriplets(int[] nums) {
        long MOD = 1_000_000_007;
        int n = nums.length;

        Map<Integer, Long> leftCount = new HashMap<>();
        Map<Integer, Long> rightCount = new HashMap<>();

        // Initialize rightCount with all frequencies
        for (int x : nums) {
            rightCount.put(x, rightCount.getOrDefault(x, 0L) + 1);
        }

        long result = 0;

        // Iterate with j as middle
        for (int j = 0; j < n; j++) {
            int val = nums[j];

            // Decrement frequency in rightCount
            rightCount.put(val, rightCount.get(val) - 1);

            int target = val * 2;

            long iCount = leftCount.getOrDefault(target, 0L);
            long kCount = rightCount.getOrDefault(target, 0L);

            result = (result + (iCount * kCount) % MOD) % MOD;

            // Add current value to leftCount
            leftCount.put(val, leftCount.getOrDefault(val, 0L) + 1);
        }

        return (int) result;
    }
}
