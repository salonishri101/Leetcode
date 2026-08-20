class Solution {




    public int[] resultArray(int[] nums) {
        ArrayList<Integer> arr1= new ArrayList<>();
         ArrayList<Integer> arr2= new ArrayList<>();


         arr1.add(nums[0]);
         arr2.add(nums[1]);

        // int p =0;
        // int q =0;

        for(int i =2;i<nums.length;i++){
            if(arr1.get(arr1.size()-1)>arr2.get(arr2.size()-1)){
                  arr1.add(nums[i]);
                //   p++;
            }else{
              arr2.add(nums[i]);
                //   q++;  
            }
        }


        int[] result = new int [nums.length];

       int i=0;
       while(i<arr1.size()){
        result[i]=arr1.get(i);
        i++;
       }
       int j=0;
        while(j<arr2.size()){
        result[i]=arr2.get(j);
        j++;
        i++;
       }

return result;


    }
}