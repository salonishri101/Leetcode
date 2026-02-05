class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
int l =0;
int minLen = Integer.MAX_VALUE;
int sum =0;
for(int r =0;r<nums.length;r++){
    sum+=nums[r];

while(sum>target){
    sum-=nums[l];
    l++;
}

if(sum==target){
   int len=r-l+1;
    minLen = Math.min(len,minLen);
}


}

return minLen==Integer.MAX_VALUE?0:minLen;

    }
}