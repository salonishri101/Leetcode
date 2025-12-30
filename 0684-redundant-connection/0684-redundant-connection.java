class Solution {

public boolean hasCycle( ArrayList<ArrayList<Integer>> adj,boolean vis[],int curr,int par ){
vis[curr]=true;
for(int i =0;i<adj.get(curr).size();i++){
int neigh=adj.get(curr).get(i);
if(!vis[neigh]){
    if(hasCycle(adj,vis,neigh,curr)){
return true;
    }
}else if(vis[neigh] && neigh!=par){
    return true;
}
}
return false;
}





    public int[] findRedundantConnection(int[][] edges) {
       ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
       

        for(int i =0;i<edges.length+1;i++){
            adj.add(new ArrayList<>());
        }


        for(int[] edge:edges){
            int a=edge[0];
            int b= edge[1];

            adj.get(a).add(b);
            adj.get(b).add(a);

            boolean vis[]= new boolean[edges.length+1];// nodes are 1-based, so we allocate size n+1
        if(hasCycle(adj,vis,a,-1)){
            
            return edge;
        }
        }

        return new int[0];
    }
}