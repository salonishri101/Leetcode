class Solution {


    public int bfs(int[][] grid,Queue<int[]> q){
        int countTime=0;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
       while(!q.isEmpty()){

        int size=q.size();
        boolean rottedThisRound = false;

        for(int s =0;s<size;s++){
        int [] curr=q.remove();
        int r =curr[0];
        int c= curr[1];

        for(int i =0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length ){
                if(grid[nr][nc]==1){
                 grid[nr][nc]=2;
                 q.add(new int[]{nr,nc});
                 rottedThisRound = true;

                }
            }
        }
       }
      if (rottedThisRound) countTime++; 
       }
        for(int i =0;i<grid.length;i++){
        for(int j =0;j<grid[0].length;j++){
            if(grid[i][j]==1){
               return -1;
            }
        }
        
       }

 return countTime;

    }




    public int orangesRotting(int[][] grid) {
        Queue<int[]> q =new LinkedList<>();

       for(int i =0;i<grid.length;i++){
        for(int j =0;j<grid[0].length;j++){
            if(grid[i][j]==2){
                q.add(new int[]{i,j});
            }
        }
        
       }


return bfs(grid,q);
        
    }
}