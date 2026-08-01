class Solution {

public boolean dfs(int nums[],boolean turn,int p1score,int p2score,int left,int right){
if(left>right) return p1score>=p2score;



if(turn){
    return dfs(nums,false,p1score+nums[left],p2score,left+1,right) || dfs(nums,false,p1score+nums[right],p2score,left,right-1);
}else{
     return dfs(nums,true,p1score,p2score+nums[left],left+1,right) && dfs(nums,true,p1score,p2score+nums[right],left,right-1);
}


}



    public boolean predictTheWinner(int[] nums) {
        return dfs(nums,true,0,0,0,nums.length-1);
    }
}