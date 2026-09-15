class Solution {
    public int longestOnes(int[] nums, int k) {
        
int i =0;
int Zcount=0;
int maxLen =0;
for(int j =0;j<nums.length;j++){

if(nums[j]==0){
    Zcount++;
}

while(Zcount>k){
    if(nums[i]==0){
        Zcount--;
    }
    i++;
}

maxLen=Math.max(maxLen,j-i+1);

}

return maxLen;

    }
}