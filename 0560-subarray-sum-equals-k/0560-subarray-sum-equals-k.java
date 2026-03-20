class Solution {
    public int subarraySum(int[] nums, int k) {
        

        int ps[]=new int[nums.length];
        ps[0]=nums[0];

        for(int i =1;i<nums.length;i++){
            ps[i]=ps[i-1]+nums[i];
        }
         
HashMap<Integer,Integer> m= new HashMap<>();
         int len =0;
         int maxLen =0;
        for(int i =0;i<nums.length;i++){
         
int val =ps[i]-k;
if(val==0){
    len+=1;
    maxLen=Math.max(len,maxLen);
}

if(m.containsKey(val)){
    m.put(ps[i],m.getOrDefault(ps[i],0)+1);
    len+=m.get(ps[i]);
     maxLen=Math.max(len,maxLen);
}


m.put(ps[i],1);

        }


return maxLen;
    }
}