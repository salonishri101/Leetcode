class Solution {
    public int removeDuplicates(int[] nums) {
        
        // ArrayList<Integer> ans = new ArrayList<>();
        
        //ans.add(arr[0]);
        int count=1;
        
        for(int i =1;i<nums.length;i++){
            if(nums[i]!=nums[i-1] ){
               // ans.add(arr[i]);
               
               nums[count]=nums[i];
               count++;
            }
        }
        
        
       return count; 
    }
}