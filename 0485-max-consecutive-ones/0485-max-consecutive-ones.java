class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxCount=Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                count=0;
            }else{
                count++;
            }

           maxCount = Math.max(count,maxCount);

        }

        return maxCount;
    }
}