class Solution {

       public void reverse(int[] nums, int i,int j) {


while(i<j){
    int temp=nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
    i++;
    j--;
    
}
    }




    public void rotate(int[] nums, int k) {
     k=k%nums.length;

    reverse(nums,0,nums.length-1);
    reverse(nums,0,k-1);
    reverse(nums,k,nums.length-1);

// for(int i =0;i<(nums.length)/2;i++){
//     int temp=nums[i];
//      nums[i]=nums[nums.length-1-i];
//      nums[nums.length-1-i]=temp;
// }

// for(int i =0;i<k/2;i++){
//     int temp=nums[i];
//      nums[i]=nums[k-1-i];
//      nums[k-1-i]=temp;
// }

// for(int i =nums.length-k;i<(nums.length)/2;i++){
//     int temp=nums[i];
//      nums[i]=nums[nums.length-1-i];
//      nums[nums.length-1-i]=temp;
// }





    }
}