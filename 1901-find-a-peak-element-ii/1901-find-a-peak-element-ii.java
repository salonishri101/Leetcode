class Solution {
    public int[] findPeakGrid(int[][] mat) {
        

        int i =0,j =mat[0].length-1;
        while(i<=j){

            int mid=i+(j-i)/2;

               int rowIdx = 0;
            for (int k = 0; k < mat.length; k++) {
                if (mat[k][mid] > mat[rowIdx][mid]) {
                    rowIdx = k;
                }
            }
boolean leftIsSmaller = (mid == 0 || mat[rowIdx][mid] > mat[rowIdx][mid - 1]);
            boolean rightIsSmaller = (mid == mat[0].length - 1 || mat[rowIdx][mid] > mat[rowIdx][mid + 1]);

            if (leftIsSmaller && rightIsSmaller) {
                return new int[]{rowIdx, mid};
            } else if (mid > 0 && mat[rowIdx][mid - 1] > mat[rowIdx][mid]) {
            j= mid - 1;
            }else{
              i=mid+1;
            }
        }

  return new int[]{-1, -1};
    }
}