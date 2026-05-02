class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s= new Stack<>();
        int ans[]= new int[nums.length];
        Arrays.fill(ans,-1);
        for(int i =(2*nums.length)-1;i>=0;i--){
            int k =i%nums.length;
            int val=nums[k];
            while(!s.isEmpty() && val>=s.peek()){
                s.pop();
            }

        //   ans[k]=s.isEmpty()?-1:s.peek();
         if (!s.isEmpty()) {
                ans[k] = s.peek();
            }
          
          s.push(val);
            
        }
            
            return ans;
    }
}