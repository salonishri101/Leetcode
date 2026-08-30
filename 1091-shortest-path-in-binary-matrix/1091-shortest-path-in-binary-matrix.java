class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
 int n =grid.length;
 int m =grid[0].length;


 if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
    return -1;

// int dr[]={0,0,-1,1,-1,1,-1,1};
// int dc[]={-1,1,0,0,-1,1,-1,1};

int[] dr = {-1,-1,-1,0,0,1,1,1};
int[] dc = {-1,0,1,-1,1,-1,0,1};


Queue<int []> q = new LinkedList<>();
int dist=1;
q.add(new int[]{0,0});

while(!q.isEmpty()){


    int size=q.size();
    while(size-->0){
    int [] curr= q.poll();
    int r =curr[0];
    int c = curr[1];

if(r==n-1  && c == m-1) return dist;


for(int i =0;i<8;i++){
    int nr=r+dr[i];
    int nc=c+dc[i];

 if(nr >= 0 && nr < n &&
               nc >= 0 && nc < m &&
               grid[nr][nc] == 0) {

                grid[nr][nc] = 1;
                q.add(new int[]{nr, nc});
            }
}

}

dist++;

}


return -1;

    }
}