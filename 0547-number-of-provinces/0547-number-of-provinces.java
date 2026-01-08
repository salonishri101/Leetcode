class Solution {

 
 public void dfs(int[][] isConnected,boolean vis[],int city){
    
      
     vis[city]=true;//->visited
for(int j =0;j<isConnected.length;j++){
    if(!vis[j] && isConnected[city][j]==1){
        dfs(isConnected,vis,j);
    }
}

 }




    public int findCircleNum(int[][] isConnected) {
         int count=0; 
         boolean vis[] = new boolean[isConnected.length];
for(int i =0;i<isConnected.length;i++){
    if(!vis[i]){
        dfs(isConnected,vis,i);
        count++;
    }

    }

return count;
    }
}