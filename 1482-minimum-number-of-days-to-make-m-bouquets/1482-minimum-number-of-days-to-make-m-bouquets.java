class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
             if ((long) m * k > bloomDay.length) return -1;
        int low=Arrays.stream(bloomDay).min().getAsInt();
        int high=Arrays.stream(bloomDay).max().getAsInt();
        int ans=0;
         while(low<=high){
             int mid=low+(high-low)/2;
            int bouquets=0,count=0; 
          for(int i =0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                count++;
                if(count==k){
                   bouquets++;
                   count=0; 
                }
            }else{
                count=0;
            }
          }

         if(bouquets>=m){
            ans=mid;
            high=mid-1;
         }else{
            low=mid+1;
         }

         }



return ans;
    }
}