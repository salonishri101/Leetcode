class Solution {
    public int longestSubsequence(int[] nums) {
        

int total =0;

for(int i =0;i<nums.length;i++){
    total^=nums[i];
}


if(total!=0){
    return nums.length;
}


// if(total==0){
    for(int i =0;i<nums.length;i++){
        if(nums[i]==0){
            continue;
        }else{
            return nums.length-1;
        }

    }
    return 0;

// }


// if(total==0){
//     return nums.length-1;
// }





// return -1;



    }
}