class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        long result = 0;
        int bits = 0;

        for (int i = 1; i <= n; i++) {

            // If i is power of 2 → bit length increases
            if ((i & (i - 1)) == 0) {
                bits++;
            }

            result = ((result << bits) + i) % MOD;
        }

        return (int) result;
    }
}