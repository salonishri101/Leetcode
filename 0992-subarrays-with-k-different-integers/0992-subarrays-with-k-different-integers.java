class Solution {


public int Atmostk(int[] nums,int goal){

if(goal < 0) return 0;


HashMap<Integer,Integer> map = new HashMap<>();
  



int count=0;
    int i =0;
    for(int j =0;j<nums.length;j++){
     
     map.put(nums[j],map.getOrDefault(nums[j],0)+1);

     while(map.size()>goal){
        map.put(nums[i],map.get(nums[i])-1);

        if( map.get(nums[i])==0){
            map.remove(nums[i]);
        }

        i++;
     }



     count+=(j-i+1);

    }

     return count;

    
}



    public int subarraysWithKDistinct(int[] nums, int k) {


return Atmostk(nums,k)-Atmostk(nums,k-1);
        
    }
}