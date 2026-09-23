class Solution {
    public int minGroups(int[][] intervals) {
        
PriorityQueue<Integer> pq = new PriorityQueue<>();



int ans=0;

Arrays.sort(intervals,(a,b)->a[0]-b[0]);
for(int[] interval:intervals){

while(!pq.isEmpty() && interval[0]>pq.peek()){
    pq.poll();
}

pq.add(interval[1]);

ans=Math.max(ans,pq.size());


}


return ans;

    }
}