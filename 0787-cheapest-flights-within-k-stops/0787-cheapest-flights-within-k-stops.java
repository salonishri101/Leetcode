class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {


      class Pair{
        int node;
        int dist;
        int stops;
        Pair(int node,int dist,int stops){
            this.node = node;
            this.dist=dist;
            this.stops=stops;
        }
      }  


ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

for(int i =0;i<n;i++){
    graph.add(new ArrayList<>());

}

for(int edge[]:flights){
    int u =edge[0];
    int v = edge[1];
    int wt =edge[2];

    graph.get(u).add(new int[]{v,wt});
}

PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.dist-b.dist);
pq.add(new Pair(src,0,0));
int dist[][]= new int[n][k+2];

for(int i = 0; i < n; i++) {
    Arrays.fill(dist[i], Integer.MAX_VALUE);
}

dist[src][0] = 0;


while(!pq.isEmpty()){

    Pair curr=pq.poll();
    int currNode = curr.node;
    int currStops=curr.stops;
    int currDist=curr.dist;

    

if(currNode==dst) return currDist;

    // if(currStops>k) continue;
    if(currStops == k + 1) continue;

    

for(int neigh[]:graph.get(currNode)){
    int neighNode=neigh[0];
    int neighDist=neigh[1];

// pq.add(new Pair(neighNode,currDist+neighDist,currStops+1));
int newDist=currDist+neighDist;
if(newDist < dist[neighNode][currStops + 1]) {
    dist[neighNode][currStops + 1] = newDist;
    pq.add(new Pair(neighNode, newDist, currStops + 1));
}
    
}

    
    
    
    }


return -1;


    }
}