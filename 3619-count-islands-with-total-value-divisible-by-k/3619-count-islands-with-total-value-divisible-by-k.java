class Solution {

public long dfs(int[][] grid,boolean[][] vis,int r,int c){

if(r<0 || r>=grid.length ||c<0 || c>=grid[0].length ||vis[r][c] ||grid[r][c]==0){
    return 0L;
}


vis[r][c]=true;

  long sum = grid[r][c];


    sum+=dfs(grid,vis,r-1,c);
     sum+=dfs(grid,vis,r+1,c);
      sum+=dfs(grid,vis,r,c+1);
       sum+=dfs(grid,vis,r,c-1);



return sum;

}





    public int countIslands(int[][] grid, int k) {
        
int count=0;
int n =grid.length;
int m =grid[0].length;


boolean vis[][]= new boolean[n][m];

for(int i =0;i<n;i++){
    for(int j =0;j<m;j++){
      if(!vis[i][j] && grid[i][j]!=0){
         long sum=dfs(grid,vis,i,j);

         if(sum%k==0) count++;
      }
    }
}


return count;

    }
}