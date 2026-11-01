class Solution {
    public int minMoves(int[] nums) {
        

int min =Integer.MAX_VALUE;

for(int i =0;i<nums.length;i++){
    if(nums[i]<min){
        min=nums[i];
    }
}


int count=0;

for(int i =0;i<nums.length;i++){
   int currDiff=nums[i]-min;
    count+=currDiff;


}

return count;


    }
}