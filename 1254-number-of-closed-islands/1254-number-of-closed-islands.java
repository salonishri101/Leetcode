class Solution {


public void dfs(int[][] grid,int r,int c,boolean vis[][]){




if(r<0 || r>=grid.length || c<0 || c>=grid[0].length||vis[r][c]){
    return ;
}
if(grid[r][c]==1) return;

vis[r][c]=true;



if(grid[r][c]==0){
dfs(grid,r+1,c,vis);
dfs(grid,r-1,c,vis);
dfs(grid,r,c+1,vis);
dfs(grid,r,c-1,vis);
}




}





    public int closedIsland(int[][] grid) {
        

boolean vis[][]= new boolean[grid.length][grid[0].length];
int count=0;



int m = grid.length;
int n = grid[0].length;

for (int i = 0; i < m; i++) {
    if (grid[i][0] == 0) dfs(grid, i, 0,vis);
    if (grid[i][n - 1] == 0) dfs(grid, i, n - 1,vis);
}

for (int j = 0; j < n; j++) {
    if (grid[0][j] == 0) dfs(grid, 0, j,vis);
    if (grid[m - 1][j] == 0) dfs(grid, m - 1, j,vis);
}
for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {

        if (grid[i][j] == 0 && !vis[i][j]) {
            count++;
            dfs(grid, i, j, vis);
        }

    }
}




return count;
    }
}