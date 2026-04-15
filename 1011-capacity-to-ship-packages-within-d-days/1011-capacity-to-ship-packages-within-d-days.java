class Solution {
    public int shipWithinDays(int[] weights, int days) {
        


int low=Arrays.stream(weights).max().getAsInt();
          int high=Arrays.stream(weights).sum();
        int ans=0;
         while(low<=high){
             int mid=low+(high-low)/2;
               


               int currLoad=0,d=1;
             for(int i =0;i<weights.length;i++){
              
              if(currLoad+weights[i]<=mid){
                    currLoad+=weights[i];
             }else{
                d++;
                currLoad=weights[i];
             }

             }
             if(d<=days){
                ans=mid;
                high=mid-1;
             }else{
                low=mid+1;
             }
         
         }

         

return ans;



    }
}