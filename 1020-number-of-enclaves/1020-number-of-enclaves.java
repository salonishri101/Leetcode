class Solution {


public void dfs(int[][] grid,int r,int c){

       if(r<0 || c<0 || r>=grid.length || c>=grid[0].length ){
        return;
       }


       
        if(grid[r][c]==1){
            grid[r][c]=0;
            dfs(grid,r+1,c);
            dfs(grid,r-1,c);
            dfs(grid,r,c+1);
            dfs(grid,r,c-1);
        }
    


}

    public int numEnclaves(int[][] grid) {
        

        // boolean [][] vis= new boolean[grid.length][grid[0].length];

        int n = grid.length;
         int m = grid[0].length;
     for(int i =0;i<n;i++){
        if(grid[i][0]==1){
            dfs(grid,i,0);
        }
     }

       for(int j=1;j<m;j++){
        if(grid[n-1][j]==1){
            dfs(grid,n-1,j);
        }
     }

       for(int i =n-2;i>=0;i--){
        if(grid[i][m-1]==1){
           dfs(grid,i,m-1);
        }
     }

       for(int j =m-1;j>=1;j--){
        if(grid[0][j]==1){
            dfs(grid,0,j);
        }
     }

       
      int count =0;
       for(int i =0;i<n;i++){
        for(int j =0;j<m;j++){
            if(grid[i][j]==1){
                count++;
            }
        }
       }



return count;

    }
}