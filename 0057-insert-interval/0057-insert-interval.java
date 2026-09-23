class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        


//  if(intervals.length<=1){
//            return intervals;
//         }

     Arrays.sort(intervals,(st,end)->Integer.compare(st[0],end[0]));

     ArrayList<int[]> merged=new ArrayList<>();




boolean added=false;
     for(int [] interval :intervals){
        if(interval[1]<newInterval[0]){
            merged.add(interval);
        }else if(interval[0]<=newInterval[1]){
           newInterval[0]=Math.min(interval[0],newInterval[0]);
           newInterval[1]=Math.max(interval[1],newInterval[1]);
        }else{

            if(!added){
            merged.add(newInterval);
            added=true;
            }

            merged.add(interval);
           


        }
     }


      if (!added) {
            merged.add(newInterval);
        }


 return merged.toArray(new int[merged.size()][]);
    }
}











// [1,2]       [3,5]       [6,7]       [8,10]       [12,16]
//    LEFT       OVERLAP      OVERLAP       OVERLAP       RIGHT
//               \____________ [4,8] ____________/


// LEFT    → directly add
// OVERLAP → merge
// RIGHT   → newInterval add, then remaining directly add