class Solution {


    public int[] shuffle(int[] nums, int n) {
        
     int ans[]= new int[2*n];
     int i =0;
     int j =n;
     int p =0;

     while(i<n && j<2*n){
        ans[p]=nums[i];
         ans[p+1]=nums[j];
         i++;
         j++;
         p+=2;
     }

return ans;
    }
}