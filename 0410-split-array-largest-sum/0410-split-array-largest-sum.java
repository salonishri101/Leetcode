class Solution {
    public int splitArray(int[] nums, int k) {
        


 
          int low=Arrays.stream(nums).max().getAsInt();
          int high=Arrays.stream(nums).sum();
        int ans=0;
         while(low<=high){
             int mid=low+(high-low)/2;
                
                
                
                int subarr=1,sum=0;
             for(int i =0;i<nums.length;i++){
                 
              if(nums[i]+sum<=mid){
                 sum+= nums[i];
                 
              }else{
                   subarr++;
                  sum=nums[i];
              }
             }


             if(subarr<=k){
                ans=mid;
                high=mid-1;
             }else{
                  low=mid+1;
             }
         }
        
        return ans;
        
        




    }
}