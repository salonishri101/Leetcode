class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        
HashMap<Integer,Integer> map = new HashMap<>(); 
int j =0;
int maxlen=Integer.MIN_VALUE;
int len =0;
for(int i =0;i<nums.length;i++){
    if(map.containsKey(nums[i])){
       
 map.put(nums[i],map.getOrDefault(nums[i],0)+1);

    }else{
       map.put(nums[i],1);
    }

       while(map.get(nums[i])>k){
        map.put(nums[j],map.get(nums[j])-1);
        j++;
       }

       len =i-j+1;
       maxlen=Math.max(len,maxlen);

       

}


return maxlen;

    }
}