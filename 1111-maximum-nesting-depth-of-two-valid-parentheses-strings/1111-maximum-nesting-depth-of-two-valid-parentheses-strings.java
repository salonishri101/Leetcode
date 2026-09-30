class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        
int ans[]=new int[seq.length()];
int p =0;
int depth =0;

for(int i =0;i<seq.length();i++){
    char ch =seq.charAt(i);

    if(ch=='('){ 
        depth++;  
      if(depth%2==0){
        ans[p]=1;
      
      }else{
        ans[p]=0;
      }
        p++;

    }

    if(ch==')') {
          

if(depth%2==0){
        ans[p]=1;
      
      }else{
        ans[p]=0;
      }
        p++;

        depth--;
         
    }


    
}


return ans;

    }
}