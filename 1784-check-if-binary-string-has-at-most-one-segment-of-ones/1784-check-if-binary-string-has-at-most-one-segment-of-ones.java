class Solution {
    public boolean checkOnesSegment(String s) {
        boolean zeroSeen = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '0') {
                zeroSeen = true;
            } 
            else if (zeroSeen && c == '1') {
                return false;
            }
        }

        return true;
    }
}