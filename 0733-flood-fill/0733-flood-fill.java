class Solution {

 public void help(int[][] image, int r, int c, int orgcolor,int newcolor){
      if(r<0 || c<0 || r>=image.length || c>=image[0].length  || image[r][c]!=orgcolor || image[r][c]==newcolor ){
        return ;
      }
      //vis[r][c]=true;->replace with image[r][c]=newcolor
      image[r][c]=newcolor;


          
 help(image,r,c+1,orgcolor,newcolor);
 help(image,r,c-1,orgcolor,newcolor);
 help(image,r+1,c,orgcolor,newcolor);
 help(image,r-1,c,orgcolor,newcolor);
 }






    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //int orgcolor=image[sr][sc];
       // boolean vis[][]= new boolean[image.length];
         help(image,sr,sc,image[sr][sc],color);
         return image;
    }
}