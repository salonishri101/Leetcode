class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid ) {
        int n= grid.length;
      HashMap<Integer,Integer> map =new HashMap<>();

      int repeating=-1,missing=-1;
      for(int i=0;i<grid.length; i++){

        for(int j=0;j<grid[i].length;j++){
        if(map.containsKey(grid[i][j])){   
 repeating=grid[i][j];
        }else{
            map.put(grid[i][j],1);

        }

      
      }
      }

       for(int i=1;i<=n*n; i++){
           if(!map.containsKey(i)){ 
             missing=i;
             break;
  }
      }

    
        
    

    int ans[]=new int[]{repeating,missing};
    return ans;

}
    }