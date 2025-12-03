class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int i = 0;
        int j = n;
        int k = 0;
        while(i<n && j<2*n){
            ans[k++] = nums[i++];  // take xi
            ans[k++] = nums[j++];  // take yi
        }
        return ans;
    }
}