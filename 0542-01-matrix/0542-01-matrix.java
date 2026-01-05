class Solution {

public void bfs(int[][] mat, int[][]dis,Queue<int[]> q){
   

     while(!q.isEmpty()){
        int[] curr=q.remove();
        int r =curr[0];
        int c = curr[1];
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        for(int i =0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nr<mat.length && nc>=0 && nc<mat[0].length){
                if(dis[nr][nc]>dis[r][c]+1){
                    dis[nr][nc]=dis[r][c]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
          
          }


}

    public int[][] updateMatrix(int[][] mat) {
       Queue<int[]> q= new LinkedList<>();
     int[][]dis= new int[mat.length][mat[0].length];
     for(int i =0;i<mat.length;i++){
        for(int j =0;j<mat[0].length;j++){
            if(mat[i][j]==0){
                dis[i][j]=0;
                q.add(new int[]{i,j});
            }else{
               dis[i][j]=Integer.MAX_VALUE; 
            }
        }
     }

     bfs(mat,dis,q);

   return dis;
    }
}