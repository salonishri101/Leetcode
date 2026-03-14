class Solution {
    public void sortColors(int[] nums) {
        
     int cZero=0,cOne=0,cTwo=0;
     for(int i =0;i<nums.length;i++){
        if(nums[i]==0){
            cZero++;
        }else if(nums[i]==1) {
            cOne++;
        }else{
            cTwo++;
        }
     }

for(int i =0;i<cZero;i++){
nums[i]=0;
}

for(int i =cZero;i<cZero+cOne;i++){
nums[i]=1;
}

for(int i =cZero+cOne;i<nums.length;i++){
nums[i]=2;
}





    }
}




// class Solution {
//     public void sortColors(int[] nums) {
//         int cZero = 0, cOne = 0, cTwo = 0;

//         // Step 1: Count frequencies
//         for (int num : nums) {
//             if (num == 0) cZero++;
//             else if (num == 1) cOne++;
//             else cTwo++;
//         }

//         // Step 2: Fill back into nums
//         int i = 0;
//         while (cZero-- > 0) nums[i++] = 0;
//         while (cOne-- > 0) nums[i++] = 1;
//         while (cTwo-- > 0) nums[i++] = 2;
//     }
// }
