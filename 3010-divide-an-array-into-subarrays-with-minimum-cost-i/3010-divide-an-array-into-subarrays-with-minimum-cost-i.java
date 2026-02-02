class Solution {
    public int minimumCost(int[] nums) {
        

        int firstmin=Integer.MAX_VALUE;
        int secmin=Integer.MAX_VALUE;
for(int i =1;i<nums.length;i++){
      if(nums[i]<firstmin ){
        
        secmin=firstmin;
        firstmin=nums[i];
      }else if(nums[i]<secmin){
        secmin=nums[i];
      }

}
return nums[0]+firstmin+secmin;
    }
}