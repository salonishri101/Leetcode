class Solution {
    public int longestConsecutive(int[] nums) {

    HashSet<Integer> set = new HashSet<>();


     for(int i =0;i<nums.length;i++){
     set.add(nums[i]);
     }
    
     int maxLen =0;
    
     for(int key:set){
     
     if(!set.contains(key-1)){
        int val=key;
        int len =0;
       while(set.contains(val)){
        len+=1;
        val+=1;
       }

       maxLen=Math.max(len,maxLen); 
      }
       
     }


return maxLen;

    }
}