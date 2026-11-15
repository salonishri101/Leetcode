class Solution {
    public int numOfSubarrays(int[] arr) {
        
   int mod = 1000000007;

   int even =1; // Empty prefix sum is even
   int odd=0;
   int ans=0;
   int sum =0;

   for(int a:arr){

    sum+=a;
    if(sum%2==0){
        ans=(ans+odd)%mod;
            even++;
    }else{
         ans=(ans+even)%mod;
            odd++;
    }




   }

return ans;

    }
}