class Solution {
    public int maxProduct(int[] nums) {
        

int firstmax=Integer.MIN_VALUE;
int secmax=Integer.MIN_VALUE;

for(int i =0;i<nums.length;i++){
    if(nums[i]>=firstmax){
        secmax=firstmax;
        firstmax=nums[i];
    }else if(secmax<=nums[i] && nums[i]<firstmax){
      
  secmax=nums[i];
    }
}





return (firstmax-1)*(secmax-1);

    }
}