class Solution {
    public int subarraySum(int[] nums, int k) {
        

        // int ps[]=new int[nums.length];
        // ps[0]=nums[0];

        // for(int i =1;i<nums.length;i++){
        //     ps[i]=ps[i-1]+nums[i];
        // }


        
         
HashMap<Integer,Integer> m= new HashMap<>();
m.put(0,1);
         int count =0;
        int sum=0;
        for(int i =0;i<nums.length;i++){
         sum+=nums[i];
int val =sum-k;
// if(val==0){
//     count+=1;
    
// }

if(m.containsKey(val)){
  
    count+=m.get(val);
    
}


m.put(sum,m.getOrDefault(sum,0)+1);

        }


return count;
    }
}