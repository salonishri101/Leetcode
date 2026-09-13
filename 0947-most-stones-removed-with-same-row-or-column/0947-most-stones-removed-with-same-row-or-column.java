class Solution {


void dfs(int[][] stones,int i,boolean vis[]){
    vis[i]=true;
    for(int j =0;j<stones.length;j++){
        if(!vis[j] && (stones[i][0] == stones[j][0] ||
                 stones[i][1] == stones[j][1])){
            dfs(stones,j,vis);
        }
    }
}

    public int removeStones(int[][] stones) {


      int n =stones.length;
      int m =stones[0].length;  
boolean[] vis = new boolean[n];


int compo=0;
for(int i =0;i<n;i++){
    if(!vis[i]){
        dfs(stones,i,vis);
        compo++;
    }
}

return n -compo;


    }
}