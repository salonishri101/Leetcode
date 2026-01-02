class Solution {

public boolean bfs(int[][] graph,Queue<Integer> q,int col[],boolean vis[],int src){

col[src]=0;

    vis[src]=true;
    q.add(src);

while(!q.isEmpty()){
    int curr= q.remove();
    for(int i =0;i<graph[curr].length;i++){
        int neigh = graph[curr][i];
        if(col[neigh]==col[curr]){
            return false;
        }
         
        if(col[neigh]==-1){
            vis[neigh] = true;
            q.add(neigh);
            col[neigh]=col[curr]==0?1:0;
        }
    }

   
}

 return true;

}





    public boolean isBipartite(int[][] graph) {

Queue<Integer> q = new LinkedList<>();

int col[]=new int[graph.length];
boolean vis[]=new boolean[graph.length];

Arrays.fill(col,-1);

for(int i =0;i<graph.length;i++){
    if(!vis[i]){
        if(!bfs(graph,q,col,vis,0)){
return false;
        }
    }
}

return true;

        
    }
}