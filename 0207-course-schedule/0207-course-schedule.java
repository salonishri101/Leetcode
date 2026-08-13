class Solution {

public boolean isCycle(int node,ArrayList<ArrayList<Integer>> graph,boolean vis[] ,boolean stack[] ){
    stack[node]=true;
    vis[node]=true;


    for(int neigh:graph.get(node)){
        if(stack[neigh]){
            return true;
        }

        if(!vis[neigh] && isCycle(neigh,graph,vis,stack)){
           return true;
        }
    }
stack[node]=false;
return false;


}






    public boolean canFinish(int numCourses, int[][] prerequisites) {
        

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
         boolean vis[] = new boolean[numCourses];
         boolean stack[] = new boolean[numCourses];

        for(int i =0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }


        for(int[] i:prerequisites){
            int a =i[0];
            int b =i[1];
            graph.get(b).add(a);
        }
       

       for(int i =0;i<numCourses;i++){
        if(!vis[i]){

            if(isCycle(i,graph,vis,stack)){
                return false;
            }
        }
       }
return true;

    }
}