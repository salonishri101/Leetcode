class Solution {



public int AtMostK(int[] nums, int goal){

if(goal < 0) return 0;

int i =0;
int count=0;
int oddCount=0;
for(int j =0;j<nums.length;j++){

   if(nums[j]%2!=0){
    oddCount++;
   }

    while(oddCount>goal){
       
        if(nums[i]%2!=0){
            oddCount--;
            }
     
        i++;
    }


   
        count+=(j-i+1);
    
    
}


return count;
}





    public int numberOfSubarrays(int[] nums, int k) {
        
        return AtMostK(nums,k)-AtMostK(nums,k-1);
    }
}