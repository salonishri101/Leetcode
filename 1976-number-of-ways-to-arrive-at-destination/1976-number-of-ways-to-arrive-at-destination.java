class Solution {

class Pair{
    int node;
    long dist;
         Pair(int node,long dist){
            this.node = node;
            this.dist=dist;
         }
    
}



    public int countPaths(int n, int[][] roads) {
        
ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

for(int i =0;i<n;i++){
    graph.add(new ArrayList<>());
}

for(int[] edge: roads){
    int u =edge[0];
    int v =edge[1];
    int wt=edge[2];

    graph.get(u).add(new int[]{v,wt});
    graph.get(v).add(new int[]{u,wt});
}

PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.dist,b.dist));


pq.add(new Pair(0,0));
long dist[] = new long[n];
long ways[]= new long[n];

long MOD=1_000_000_007;

Arrays.fill(dist, Long.MAX_VALUE);
Arrays.fill(ways,0);

dist[0]=0;
ways[0]=1;

while(!pq.isEmpty()){
    Pair curr=pq.poll();
    int currNode=curr.node;
    long currDist=curr.dist;


    if(currDist>dist[currNode]) continue;

    for(int[] neigh:graph.get(currNode)){
        int neighNode=neigh[0];
        long neighDist=neigh[1];

        long newDist=currDist+neighDist;

        if(newDist<dist[neighNode]){
            dist[neighNode]=newDist;
             ways[neighNode]=ways[currNode];
            pq.add(new Pair(neighNode,dist[neighNode]));
        }else if(newDist==dist[neighNode]){
            ways[neighNode]=(ways[neighNode]+ways[currNode])%MOD;
        }
    }
}

return (int)ways[n-1];


    }
}