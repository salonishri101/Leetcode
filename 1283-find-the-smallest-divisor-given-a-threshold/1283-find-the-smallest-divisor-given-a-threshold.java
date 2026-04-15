class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        


 int low=1,high=Arrays.stream(nums).max().getAsInt();;
        int ans=high;
         while(low<=high){
             int mid=low+(high-low)/2;
                 long sum=0;
             for(int i =0;i<nums.length;i++){
              sum += (long) Math.ceil((double) nums[i] / mid);
             }


             if(sum<=threshold){
                ans=mid;
                high=mid-1;
             }else{
                low=mid+1;
             }
         }


return ans;




    }
}