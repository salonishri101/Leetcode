class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high= Arrays.stream(piles).max().getAsInt();
        int ans=high;
         while(low<=high){
             int mid=low+(high-low)/2;
                 long time=0;
             for(int i =0;i<piles.length;i++){
              time += (long) Math.ceil((double) piles[i] / mid);
             }


             if(time<=h){
                ans=mid;
                high=mid-1;
             }else{
                low=mid+1;
             }
         }


return ans;

    }
}