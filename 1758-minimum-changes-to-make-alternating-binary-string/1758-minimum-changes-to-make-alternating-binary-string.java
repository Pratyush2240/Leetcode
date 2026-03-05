class Solution {
    public int minOperations(String s) {
        int changeStart0 = 0;
        int changeStart1 = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Pattern starting with 0: 010101...
            if (c != (i % 2 == 0 ? '0' : '1')) {
                changeStart0++;
            }

            // Pattern starting with 1: 101010...
            if (c != (i % 2 == 0 ? '1' : '0')) {
                changeStart1++;
            }
        }

        return Math.min(changeStart0, changeStart1);
    }
}