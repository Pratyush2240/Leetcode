class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total += x;

        int need = (int)(total % p);
        if (need == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // prefix before array starts

        long prefix = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;

            int target = (int)((prefix - need + p) % p);

            if (map.containsKey(target)) {
                int length = i - map.get(target);
                if (length < ans) ans = length;
            }

            map.put((int)prefix, i);
        }

        return ans == Integer.MAX_VALUE || ans == nums.length ? -1 : ans;
    }
}
