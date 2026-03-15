class Solution {
    public int[] rearrangeArray(int[] nums) {
        
int ans[]= new int[nums.length];
int p=0,n=(nums.length)/2;
for(int i =0;i<nums.length;i++){

if(nums[i]>0) {
    ans[p++]=nums[i];
}else{
    ans[n++]=nums[i];
}
}


p=0;n=(nums.length)/2;int i=0;
while(i<nums.length){
nums[i++]=ans[p++];
nums[i++]=ans[n++];
}



return nums;


    }
}