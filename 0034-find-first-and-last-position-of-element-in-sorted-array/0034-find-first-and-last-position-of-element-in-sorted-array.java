class Solution {
    public int[] searchRange(int[] nums, int target) {
        
 int i =0,j=nums.length-1;
    int fOcur=-1,lOcur=-1;

while(i<=j){
    int mid=i+(j-i)/2;
if(nums[mid]==target){
    fOcur=mid;
     j=mid-1;
}else if(nums[mid]>target){
  j=mid-1;
}else{
    i=mid+1;
}
}

i =0;j=nums.length-1;
while(i<=j){
    int mid=i+(j-i)/2;
if(nums[mid]==target){
    lOcur=mid;
     i=mid+1;
}else if(nums[mid]>target){
  j=mid-1;
}else{
    i=mid+1;
}
}

return new int[]{fOcur,lOcur};


    }
}