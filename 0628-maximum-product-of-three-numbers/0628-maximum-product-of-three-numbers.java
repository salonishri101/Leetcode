class Solution {
    public int maximumProduct(int[] nums) {


int product1=-1;
int product2=-1;


    int firstmax=Integer.MIN_VALUE;
    int secmax=Integer.MIN_VALUE;
    int thirdmax=Integer.MIN_VALUE;

    int firstmin=Integer.MAX_VALUE;
    int secmin=Integer.MAX_VALUE;

for(int i =0;i<nums.length;i++){

if(nums[i]>=firstmax){
    thirdmax=secmax;
secmax=firstmax;

firstmax=nums[i];
}else if(secmax<=nums[i]   && nums[i]<firstmax){
    thirdmax=secmax;
    secmax=nums[i];
}else if(thirdmax<=nums[i] && nums[i]<secmax){
    thirdmax=nums[i];
}


if(nums[i]<=firstmin){
secmin=firstmin;
firstmin=nums[i];
}else if(secmin>=nums[i] &&  nums[i]>firstmin){
    secmin=nums[i];
}

product1=firstmax*secmax*thirdmax;
product2=firstmin*secmin*firstmax;


}


return Math.max(product1,product2);

// return firstmax*secmax*thirdmax;

    }
}