class Solution {


public boolean hasCycle(ArrayList<ArrayList<Integer>> adj,boolean vis[],boolean stack[],int curr){
 vis[curr]=true;
 stack[curr]=true;


 for(int i =0; i<adj.get(curr).size();i++){
    int neigh=adj.get(curr).get(i);

    if(stack[neigh]){
       return true; 
    }
     if(!vis[neigh] && hasCycle(adj,vis,stack,neigh)){
return true;
    }
     
  
 }

 stack[curr]=false;

return false;

}



    public boolean canFinish(int numCourses, int[][] prerequisites) {

       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

       for(int i =0;i<numCourses;i++){
        adj.add(new ArrayList<>());
       }

       for(int pre[] : prerequisites){
        int a =pre[0];
        int b =pre[1];
        adj.get(b).add(a);

       }

       boolean vis[] = new boolean[adj.size()];
      boolean stack[] = new boolean[adj.size()];


       for (int i = 0; i < numCourses; i++) {
    if (!vis[i] && hasCycle(adj, vis, stack, i)) {
        return false;
    }
}



         return true;


    }
}