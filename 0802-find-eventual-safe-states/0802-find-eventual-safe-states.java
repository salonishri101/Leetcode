class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
int n = graph.length;
ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
 Queue<Integer> q = new LinkedList<>();

for(int i =0;i<n;i++){
 rev.add(new ArrayList<>());
}

int outdegree[]= new int[n];
for(int i =0;i<n;i++){
outdegree[i]= graph[i].length;
   for(int neigh:graph[i]){
    rev.get(neigh).add(i);
   }


}
 

for(int i =0;i<n;i++){
if(outdegree[i]==0){
    q.add(i);
}

}

ArrayList<Integer> ans = new ArrayList<>();

       int i =0;
    while(!q.isEmpty()){
        int curr= q.poll();
         ans.add(curr);

         for(int neigh:rev.get(curr)){
           outdegree[neigh]--;
           if(outdegree[neigh]==0){
            q.add(neigh);
           }
         }


    }

Collections.sort(ans);

return ans;


    }
}