class Solution {
    public int minOperations(int[] nums, int x) {
        

int n =nums.length;

int total = 0;

for(int num : nums){
    total += num;
}
int tar=total-x;


   if (tar < 0) return -1;
    if (tar == 0) return n;


int i =0;
int sum =0;
int maxLen=0;
for(int j =0;j<n;j++){

// while(i<n && j<n){
    sum+=nums[j];

while( i<n && sum>tar){
        sum-=nums[i];
        i++;
    }


    if(sum==tar){
   maxLen =Math.max(maxLen,j-i+1);
   
    }
}


if(maxLen == 0) return -1;


return n -maxLen;



    }
}