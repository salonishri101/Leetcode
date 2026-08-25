class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
         Queue<Integer> q = new LinkedList<>();

        for(int i =0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
         int indegree[]= new int[numCourses];

        for(int[] i:prerequisites){
            int a =i[0];
            int b =i[1];
            graph.get(b).add(a);
            indegree[a]+=1;
        }
     

     for(int i =0;i<numCourses;i++){
           if(indegree[i]==0){
            q.add(i);
           }
     }
       
       
       int count=0;
    while(!q.isEmpty()){
        int curr= q.poll();
         count++;

         for(int neigh:graph.get(curr)){
           indegree[neigh]--;
           if(indegree[neigh]==0){
            q.add(neigh);
           }
         }


    }

    return count==numCourses;

    }
}