class Solution {

    public int longestMountain(int[] arr) {
        
    int n =arr.length;
    // int maxLen = Integer.MIN_VALUE;
      int maxLen = 0;

    for(int i =1;i<arr.length-1;i++){
       if(arr[i-1]<arr[i] && arr[i]>arr[i+1]){
        int l = i;
          while(l>0 && arr[l]>arr[l-1]){
            l--;
          }

          int r=i;
            while(r<n-1 && arr[r]>arr[r+1]){
            r++;
          }

          int len = r-l+1;
          maxLen = Math.max(len,maxLen);
                
       }

    }

    // return maxLen<0?0:maxLen;
    return maxLen;

    }
}