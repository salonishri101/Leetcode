class Solution {
    public boolean search(int[] nums, int target) {


int i =0,j = nums.length-1;

  while(i<=j){
        int mid=i+(j-i)/2;
        if(target==nums[mid]){
            return true;
        }
        
              if (nums[i] == nums[mid] && nums[mid] == nums[j]) {
                i++;
                j--;
            }
        
        
        else if(nums[mid]>=nums[i]){//left half sorted
         
       if(nums[i]<=target && nums[mid]>=target ){
        j=mid-1;
       }else{
        i=mid+1;
       }

        }else{//right hald sorted
        
 if(nums[mid]<=target && nums[j]>=target){
       
         i=mid+1;
       }else{
         j=mid-1;
       }


        }
     }

return false;





    }
}