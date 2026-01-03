class Solution {


class Pair{
    int node;
    int wt;
    Pair(int node,int wt){
        this.node = node;
        this.wt=wt;
    }
}




    public int minCostConnectPoints(int[][] points) {
        
     PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
     pq.add(new Pair(0,0));
    boolean  vis[]= new boolean[points.length];
    int finalCost=0;
int count=0;
    while(!pq.isEmpty()&& count < points.length){
        Pair curr= pq.remove();
        int currNode=curr.node;
        int currWt=curr.wt;
          

            if(vis[currNode]){
            continue;
           }

           
            vis[currNode]=true;
            finalCost+=currWt;
            count++;
           
        for(int i =0;i<points.length;i++){
            if(!vis[i]){
         int wt=Math.abs(points[currNode][0]-points[i][0])+Math.abs(points[currNode][1]-points[i][1]);
         pq.add(new Pair(i,wt));

            }
        }
    }

return finalCost;


    }
} 