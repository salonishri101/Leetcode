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


         int MOD = 1000000007;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.dist,b.dist));
        long dist[] = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        int ways[]= new int[n];
        Arrays.fill(ways,0);
        ways[0]=1;

      ArrayList<ArrayList<int[]>> adj= new ArrayList<>();
      for(int i =0;i<n;i++){
        adj.add(new ArrayList<>());
      } 
    
    for(int[] road:roads){
        int u =road[0];
        int v =road[1];
        int wt =road[2];
        adj.get(u).add(new int[]{v,wt});
        adj.get(v).add(new int[]{u,wt});
    }

   pq.add(new Pair(0,0));
   while(!pq.isEmpty()){
    Pair curr=pq.remove();
    if(curr.dist > dist[curr.node]) continue;//*
    for(int i =0;i<adj.get(curr.node).size();i++){
        int[] neigh=adj.get(curr.node).get(i);
        int neighNode=neigh[0];
        long wt = neigh[1];
        if(dist[curr.node]+wt<dist[neighNode]){
            dist[neighNode]=dist[curr.node]+wt;
            
            ways[neighNode]=ways[curr.node];//copy path
             pq.add(new Pair(neighNode, dist[neighNode]));

        }else if(dist[curr.node]+wt==dist[neighNode]){
           
       ways[neighNode] = (int)(((long)ways[neighNode] + ways[curr.node]) % MOD);
        }
    }
   }


return ways[n-1];

    }
}