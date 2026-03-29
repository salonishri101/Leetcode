class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
       HashMap<Integer,Integer>map=new HashMap<>();


       for(int i=0;i<nums.length;i++){
        if(map.containsKey(nums[i])){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }else{
        map.put(nums[i],1);
        }
       }

ArrayList<Integer> ans = new ArrayList<>();
for(Integer k :map.keySet()){
    if(map.get(k)>nums.length/3){
        ans.add(k);
    }
}



return ans;
    }
}