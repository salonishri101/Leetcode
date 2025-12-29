// class Solution {
            
//  public void merge(int[] nums ,int st, int end,int mid){

//    int temp[]=new int[end-st+1];
//    int i =st,j=mid+1;
//    int k =0;
//    while(i<=mid && j<=end){
//     if( nums[i]< nums[j]){
//         temp[k]= nums[i];
//         i++;
//     }else{
//        temp[k]= nums[j]; 
//        j++;
//     }
//     k++;
//    }

// //left part of left half
// while(i<=mid){
//     temp[k++]= nums[i++];

// }
// // left part of right part

// while(j<=end){
//     temp[k++]= nums[j++];
    
// }

// for(i =st,k=0;k<temp.length;i++,k++){
//     nums[i]=temp[k];
// }
// // for (int p = 0; p < temp.length; p++) {
// //     nums[st + p] = temp[p];
// // }



//  }


//        public void mergeSort(int[] nums ,int st, int end){

//         if(st>=end) return ;
//         int mid = st+(end-st)/2;
//           mergeSort(nums,st,mid);
//           mergeSort(nums,mid+1,end);
//           merge(nums,st,end,mid);

//        }



//     public int[] sortArray(int[] nums) {
//          mergeSort(nums,0,nums.length-1);
//          return nums;
  
//     }
// }



class Solution {
 
public void heapify(int [] nums,int i,int size){
    int max=i;
    int left=2*i+1;
    int right=2*i+2;

    if(left<size && nums[max]<nums[left]) max=left;
    if(right<size && nums[max]<nums[right]) max=right;

    if(max!=i){
    int temp=nums[max];
     nums[max]=nums[i];
     nums[i]=temp;
     heapify(nums,max,size);
    }
}


    public int[] sortArray(int[] nums) {
      int n = nums.length;
      for(int i =n/2;i>=0;i--){
        heapify(nums,i,n);
      }


        for(int i =n-1;i>=0;i--){
            int temp =nums[0];
            nums[0]=nums[i];
            nums[i]=temp;
        heapify(nums,0,i);
      }

      return nums;
  
    }
}