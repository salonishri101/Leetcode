class Solution {


      class Pair{
        int node;
        int dist;
       
        Pair(int node,int dist){
            this.node = node;
            this.dist=dist;
            
        }
      }  


    public int networkDelayTime(int[][] times, int n, int k) {
        


ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

for(int i =0;i<=n;i++){
    graph.add(new ArrayList<>());

}

for(int edge[]:times){
    int u =edge[0];
    int v = edge[1];
    int wt =edge[2];

    graph.get(u).add(new int[]{v,wt});
}

PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.dist-b.dist);
pq.add(new Pair(k,0));
int dist[]= new int[n+1];


    Arrays.fill(dist, Integer.MAX_VALUE);


dist[k] = 0;


while(!pq.isEmpty()){

    Pair curr=pq.poll();
    int currNode = curr.node;
   
    int currDist=curr.dist;


    if(currDist>dist[currNode]) continue;
    
for(int neigh[]:graph.get(currNode)){
    int neighNode=neigh[0];
    int neighDist=neigh[1];

// pq.add(new Pair(neighNode,currDist+neighDist,currStops+1));
int newDist=currDist+neighDist;
if(newDist < dist[neighNode]) {
    dist[neighNode] = newDist;
    pq.add(new Pair(neighNode, newDist));
}
    
}

    
    
    
    }


        int ans = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE)
                return -1;

            ans = Math.max(ans, dist[i]);
        }

        return ans;



        
    }
}