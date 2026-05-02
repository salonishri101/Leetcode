class Solution {


public long sumSubnumsayMins(int[] nums) {
        int n =nums.length;
    Stack<Integer> s= new Stack<>();
        int nse[]= new int[nums.length];
        int pse[]= new int[nums.length];
        for(int i =nums.length-1;i>=0;i--){
            while(!s.isEmpty() && nums[i]<=nums[s.peek()]){
                s.pop();
            }
          nse[i]=s.isEmpty()?n-i:s.peek()-i;
          
          s.push(i);
            
        }

s.clear();

     for(int i =0;i<nums.length;i++){
            while(!s.isEmpty() && nums[i]<nums[s.peek()]){
                s.pop();
            }
          pse[i]=s.isEmpty()?i+1:i-s.peek();
          
          s.push(i);
            
        }


            
long sum = 0;


for (int i = 0; i < nums.length; i++) {
    long curr = (long) nums[i] * pse[i]  * nse[i] ;
    sum+=curr;
}

return sum;

}



public long sumSubnumsayMaxs(int[] nums) {
        int n =nums.length;
    Stack<Integer> s= new Stack<>();
        int nge[]= new int[nums.length];
        int pge[]= new int[nums.length];
        for(int i =nums.length-1;i>=0;i--){
            while(!s.isEmpty() && nums[i]>=nums[s.peek()]){
                s.pop();
            }
          nge[i]=s.isEmpty()?n-i:s.peek()-i;
          
          s.push(i);
            
        }

s.clear();

     for(int i =0;i<nums.length;i++){
            while(!s.isEmpty() && nums[i]>nums[s.peek()]){
                s.pop();
            }
          pge[i]=s.isEmpty()?i+1:i-s.peek();
          
          s.push(i);
            
        }


long sum = 0;
            



for (int i = 0; i < nums.length; i++) {
    long curr = (long) nums[i] * pge[i]  * nge[i] ;
    sum+=curr;
}

return sum;

}






    public long subArrayRanges(int[] nums) {
        return sumSubnumsayMaxs(nums)-sumSubnumsayMins(nums);
 
       

    }
}