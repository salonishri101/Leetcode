class Solution {

public int AtMostK(int[] nums, int goal){

if(goal < 0) return 0;

int i =0;
int count=0;
int sum=0;
for(int j =0;j<nums.length;j++){

    sum+=nums[j];

    while(sum>goal){
        sum-=nums[i];
     
        i++;
    }


   
        count+=(j-i+1);
    
    
}


return count;
}

    public int numSubarraysWithSum(int[] nums, int goal) {
        
return AtMostK(nums,goal)-AtMostK(nums,goal-1);

    }
}