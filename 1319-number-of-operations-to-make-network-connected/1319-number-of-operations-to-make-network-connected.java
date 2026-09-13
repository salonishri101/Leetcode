class Solution {

void dfs(ArrayList<ArrayList<Integer>> graph,boolean vis[],int node){
    vis[node]= true;
    for(int neigh:graph.get(node)){
        if(!vis[neigh]){
            dfs(graph,vis,neigh);
        }
    }
}





    public int makeConnected(int n, int[][] connections) {
        
      int component=0;

     ArrayList<ArrayList<Integer>> graph= new ArrayList<>();
        
        for(int i =0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        
        for(int []edge:connections){
            int u =edge[0];
            int v =edge[1];
           
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        
        
        
        
        
        
        boolean vis[]= new boolean[n];



      for(int i =0;i<n;i++){
        if(!vis[i]){
            dfs(graph,vis,i);
            component++;
        }
      }


if(connections.length<n-1) return -1;


return component-1;

    }
}