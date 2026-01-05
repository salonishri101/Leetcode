class Solution {

   class Info{
    int node;
    int cost;
    int stops;
    Info(int node,int cost,int stops){
        this.node = node;
        this.cost=cost;
        this.stops=stops;
    }
   }






    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {



        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

       for(int[] flight:flights){
        int u =flight[0];
        int v =flight[1];
        int cost=flight[2];
        adj.get(u).add(new int[]{v,cost});

       }

        
     PriorityQueue<Info> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
     int dist[][]= new int[k+2][n];
      for(int i =0;i<=k+1;i++){
        Arrays.fill(dist[i],Integer.MAX_VALUE);
      }
      dist[0][src]=0;

     pq.add(new Info(src,0,0));
     while(!pq.isEmpty()){
        Info curr=pq.remove();
        int currNode=curr.node;
        int currCost=curr.cost;
        int currStop=curr.stops;
        if(currStop>k){
          continue;
        }

        for(int i =0;i<adj.get(currNode).size();i++){
            int[] neigh=adj.get(currNode).get(i);
        int neighNode=neigh[0];
        int neighCost=neigh[1];
          if(currCost+neighCost<dist[currStop+1][neighNode]){
              dist[currStop+1][neighNode]=currCost+neighCost;
              pq.add(new Info(neighNode,dist[currStop+1][neighNode],currStop+1));
            }


        }
     }

 int ans=Integer.MAX_VALUE;
    for(int i=0;i<=k+1;i++){
        ans=Math.min(ans,dist[i][dst]);
    }
    return ans==Integer.MAX_VALUE?-1:ans;

    }
}