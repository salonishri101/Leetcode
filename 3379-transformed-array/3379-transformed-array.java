class Solution {
    public int[] constructTransformedArray(int[] nums) {

       int[] ans = new int[nums.length];

       for(int i =0;i<nums.length;i++){
        if(nums[i]>0){
            ans[i]=nums[((i+nums[i])%nums.length+nums.length)%nums.length];
        }else if(nums[i]<0){
             ans[i]=nums[((i+nums[i]+nums.length)%nums.length+nums.length)%nums.length];
        }else{
            ans[i]=nums[i];
        }
       }

return ans;
        
    }
}