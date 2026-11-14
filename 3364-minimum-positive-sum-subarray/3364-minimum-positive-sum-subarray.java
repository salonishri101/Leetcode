class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        

int p =0,q=0;

int minSum=Integer.MAX_VALUE;
int len=0;


        for (int i = 0; i < nums.size(); i++) {

            int sum = 0;

            for (int j = i; j < nums.size(); j++) {
sum+=nums.get(j);
len=j-i+1;

if(sum>0 &&(len>=l && len<=r) ){
   minSum=Math.min(sum,minSum);
   
}

 if (len > r) {
                    break;
                }


}

        }

return minSum==Integer.MAX_VALUE?-1:minSum;

    }
}