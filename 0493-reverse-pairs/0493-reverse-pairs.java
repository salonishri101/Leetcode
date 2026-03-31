class Solution {


     static void merge(int nums[],int st,int mid,int end){
        int temp[]=new int[end-st+1];
        
        int i =st;
        int j =mid+1;
        int k =0;
    
        while(i<=mid && j<=end){
        if(nums[i]>nums[j]){
            temp[k++]=nums[j++];
            
           
        }else{
           temp[k++]=nums[i++]; 
       
        }
        
        }
        
        while(i<=mid){
            temp[k++]=nums[i];
            i++;
        }
        
        
        
                while(j<=end){
            temp[k++]=nums[j];
            j++;
        }
        
        
        
        
          for (int p = 0; p < temp.length; p++) {
            nums[st + p] = temp[p];
        }

        
        
    }
    
    
    
    
     static int sort(int nums[],int st,int end){
        
       
        
// if (st < end) {
//             int mid = st + (end - st) / 2;
//             count =sort(nums, st, mid)+sort(nums, mid + 1, end);
//         }


        if (st >= end) return 0;
        int mid = st + (end - st) / 2;
        int count = sort(nums, st, mid) + sort(nums, mid + 1,end);


int i=st,j = mid+1;
while(i<=mid){
     while (j <= end && (long) nums[i] > 2L * nums[j]) {
        j++;
    }
    count+=(j-(mid+1));
    i++;
}


merge(nums, st, mid, end);
        return count;
        
    }
    
    






    public int reversePairs(int[] nums) {
return sort(nums,0,nums.length-1);

    }
}