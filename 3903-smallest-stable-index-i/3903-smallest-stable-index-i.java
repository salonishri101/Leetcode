class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
 int n = nums.length;

        int[] max = new int[n];
        int[] min = new int[n];

        // Prefix Maximum
        max[0] = nums[0];

        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], nums[i]);
        }

        // Suffix Minimum
        min[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i]);
        }





for(int i =0;i<nums.length;i++){
    int curr=max[i]-min[i];

    if(curr<=k){
        
return i;

    }
}



return -1;


    }
}