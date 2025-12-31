class Solution {

//directed+topsort+hasCycle

public boolean hasCycle(ArrayList<ArrayList<Integer>> adj,boolean vis[],boolean stack[],int curr ){
    vis[curr]= true;
    stack[curr]=true;

    for(int i =0;i<adj.get(curr).size();i++){
        int neigh= adj.get(curr).get(i);
        if(!vis[neigh]){
            if(hasCycle(adj,vis,stack,neigh)){
                return true;
            }
        }else if(stack[neigh]){
            return true;
        }
    }

stack[curr]=false;
return false;
   
}





public void topSort(ArrayList<ArrayList<Integer>> adj,boolean vis2[],Stack<Integer> s,int curr ){
    vis2[curr]= true;

    for(int i =0;i<adj.get(curr).size();i++){
        int neigh= adj.get(curr).get(i);
        if(!vis2[neigh]){
            topSort(adj,vis2,s,neigh);
        }
    }


    s.push(curr);
}





    public int[] findOrder(int numCourses, int[][] prerequisites) {





        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean vis[] = new boolean[numCourses];
        boolean vis2[] = new boolean[numCourses];
        boolean stack[] = new boolean[numCourses];
        int ans[] = new int[numCourses];
        Stack<Integer> s = new Stack<>();


 for(int i =0;i<numCourses;i++){
     adj.add(new ArrayList<>());
 }


 for(int preq[]:prerequisites ){
    int a = preq[0];
    int b =preq[1];
    adj.get(b).add(a);
 }

 for(int i =0;i<numCourses;i++){
   if(hasCycle(adj,vis,stack,i)){
    return new int[0];
   }
 }


 for(int i =0;i<numCourses;i++){
     if(!vis2[i]){
        topSort(adj,vis2,s,i);
     }

 }


int idx=0;
 while(!s.isEmpty()){
   ans[idx++]=s.pop();
    }
return ans;


    }
}