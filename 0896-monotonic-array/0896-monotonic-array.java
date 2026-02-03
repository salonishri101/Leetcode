class Solution {
    public boolean isMonotonic(int[] nums) {

   int i =1;
   int j =1;
   int n = nums.length;

   while(i<n && nums[i]>=nums[i-1]){
    i++;
   }


       while(j<n && nums[j]<=nums[j-1]){
    j++;
          }





return i==n || j==n;

    }
}




// class Solution {
//     public boolean isMonotonic(int[] nums) {

//         int i = 1;
//         int j = 1;
//         int n = nums.length;

//         while(i < n && nums[i] >= nums[i-1]){
//             i++;
//         }

//         if(i == n) return true;

//         while(j < n && nums[j] <= nums[j-1]){
//             j++;
//         }

//         return j == n;
//     }
// }
