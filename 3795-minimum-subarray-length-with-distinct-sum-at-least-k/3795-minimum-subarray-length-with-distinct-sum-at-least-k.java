class Solution {
    public int minLength(int[] nums, int k) {

        HashMap<Integer,Integer>map = new HashMap<>();
        int i =0,j =0;
        int minLen=Integer.MAX_VALUE;
        int sum=0;
        while(j<nums.length){
           map.put(nums[j],map.getOrDefault(nums[j],0)+1);
           if(map.get(nums[j])==1){
            sum+=nums[j];
           }

           while(sum>=k){
            minLen =Math.min((j-i+1),minLen);
            map.put(nums[i],map.get(nums[i])-1);
            if(map.get(nums[i])==0){
                sum-=nums[i];
            }
            i++;


           }
           j++;
            
        }

        return minLen==Integer.MAX_VALUE?-1:minLen;
    }
}