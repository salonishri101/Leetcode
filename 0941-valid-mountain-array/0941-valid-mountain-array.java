class Solution {
    public boolean validMountainArray(int[] arr) {
int i =1;
int n = arr.length;

while(i<n && arr[i-1]<arr[i]){
    i++;
}

if(i==1 || i ==n) return false;

while(i<n && arr[i-1]>arr[i]){
    i++;
}

return i==n;
        
    }
}