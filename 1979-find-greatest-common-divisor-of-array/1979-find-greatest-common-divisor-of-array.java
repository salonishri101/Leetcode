class Solution {
    public int findGCD(int[] nums) {
        int min =Arrays.stream(nums).min().getAsInt();
         int max=Arrays.stream(nums).max().getAsInt();

         

        while(min!=0){
            int rem=max%min;
          max=min;
          min=rem;
        }
          return max;

    }

   
}