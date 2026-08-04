class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
int min =Arrays.stream(nums).min().getAsInt();
int max =Arrays.stream(nums).max().getAsInt();


HashSet<Integer> set = new HashSet<>();

for(int i =0; i<nums.length;i++){
set.add(nums[i]);
}

List<Integer> ans = new ArrayList<>();


for(int i =min;i<=max;i++){
if(!set.contains(i)){
    ans.add(i);
}
}

Collections.sort(ans);

return ans;


    }
}