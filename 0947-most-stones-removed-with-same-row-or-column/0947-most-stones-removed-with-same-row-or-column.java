class Solution {

public void dfs(boolean vis[],int curr,ArrayList<ArrayList<Integer>> adj){
    vis[curr]=true;
    for(int neigh:adj.get(curr)){
        if(!vis[neigh]){
            dfs(vis,neigh,adj);
        }
    }
}

    public int removeStones(int[][] stones) {
        int n = stones.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean vis[]= new boolean[n];

        for(int i =0;i<n;i++){
            adj.add( new ArrayList<>());
        }

        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] ||stones[i][1]==stones[j][1] ){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
int count=0;
            for(int i =0;i<n;i++){
                if(!vis[i]){
                    dfs(vis,i,adj);
                    count++;
                }
                
            }

        return n-count;
    }
}