class Solution {

class Pair{
    int first;
    int second;
       Pair(int first,int second){
        this.first=first;
         this.second=second;
       }
        

}

class PairOfPair{
    Pair pos;
    int time;
      PairOfPair(Pair pos,int time){
        this.pos=pos;
         this.time=time;
       }
        

}




    public int orangesRotting(int[][] grid) {
      boolean vis[][]= new boolean[grid.length][grid[0].length];

      Queue<PairOfPair> q = new LinkedList<>();
       


        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
          if(grid[i][j]==2){
            q.add(new PairOfPair(new Pair(i,j),0));
            vis[i][j]=true;
          }

            }
        }
        
int ans =0;
while(q.size()>0){


   PairOfPair curr=q.poll();
int i =curr.pos.first;
int j =curr.pos.second;
int time=curr.time;
ans =Math.max(ans,time);




if( i-1>=0 && grid[i-1][j]==1 && !vis[i-1][j]){
    vis[i-1][j]=true;
    q.add(new PairOfPair(new Pair(i-1,j),time+1));

}


if( j-1>=0 && grid[i][j-1]==1 && !vis[i][j-1]){
    vis[i][j-1]=true;
    q.add(new PairOfPair(new Pair(i,j-1),time+1));

}

if( i+1<grid.length && grid[i+1][j]==1 && !vis[i+1][j]){
    vis[i+1][j]=true;
    q.add(new PairOfPair(new Pair(i+1,j),time+1));

}

if( j+1<grid[0].length && grid[i][j+1]==1 && !vis[i][j+1]){
    vis[i][j+1]=true;
   q.add(new PairOfPair(new Pair(i,j+1),time+1));

}


}


        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
          if(grid[i][j]==1 && !vis[i][j]){
           return -1;
          }

            }
        }

        return ans;
        
    }
}