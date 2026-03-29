class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
     int cand1=0,cand2=0,count1=0,count2=0;

    for(int i =0;i<nums.length;i++){
        if(cand1==nums[i]){
            count1++;
        } else if(cand2==nums[i]){
            count2++;
        } else if(count1==0){
            cand1=nums[i];
            count1++;
        } else if(count2==0){
            cand2=nums[i];
            count2++;
        } else{
            count1--;
            count2--;
        }
    } 
count1=0;
count2=0;
 for(int i =0;i<nums.length;i++){
if(nums[i]==cand1){
    count1++;
}else if(nums[i]==cand2){
count2++;
}

 }
ArrayList<Integer> ans = new ArrayList<>();

if(count1>nums.length/3) ans.add(cand1);
if(count2>nums.length/3) ans.add(cand2);


return ans;

    }
}