class Solution {
    public int minimumDeletions(int[] nums) {

               
               int minidx=nums.length-1;
               int maxidx=0;
               int min=Integer.MAX_VALUE;
               int max=Integer.MIN_VALUE;

                for(int i =0;i<nums.length;i++){
                    if(nums[i]<min){
                        minidx=i;
                        min =nums[i];
                    }

                        if(nums[i]>max){
                        maxidx=i;
                        max=nums[i];
                    }
                } 


             int i =Math.min(minidx,maxidx);
             int j = Math.max(minidx,maxidx);

             int ans1 =j+1;
             int ans2=nums.length-i;
             int ans3 =i+1+nums.length-j;

             int ans = Math.min(Math.min(ans1,ans2),ans3);

             return ans;




      


    }
}