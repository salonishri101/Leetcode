class Solution {
    public int reverseDegree(String s) {
        

int arr[] = new int[26];

int count =26;
for(int i =0;i<26;i++){
    arr[i]=count;
    count--;
}


int ans =0;
for(int i =0;i<s.length();i++){
    int ch=s.charAt(i)-'a';
     
     int curr=arr[ch]*(i+1);
     ans+=curr;

}


return ans;

    }
}