
  class Solution {


public void dfs(char[][] grid,int r,int c,boolean [][] vis){

       if(r<0 || c<0 || r>=grid.length || c>=grid[0].length|| vis[r][c] || grid[r][c] =='0' ){
        return;
       }

      vis[r][c]=true;
       
        
            dfs(grid,r+1,c,vis);
            dfs(grid,r-1,c,vis);
            dfs(grid,r,c+1,vis);
            dfs(grid,r,c-1,vis);
        
    


}




    public int numIslands(char[][] grid) {
boolean [][] vis= new boolean[grid.length][grid[0].length];
         int n = grid.length;
         int m = grid[0].length;
          int count=0;


             for(int i =0;i<n;i++){
                 for(int j =0;j<m;j++){
                   if(grid[i][j]=='1' && !vis[i][j] ){
                    count++;
                     dfs(grid,i,j,vis);
                     
            }
        }
       }

       return count;

    }


}