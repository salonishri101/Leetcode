class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
List<Integer> ans = new ArrayList<>();
int sr=0,sc=0,er=matrix.length-1,ec=matrix[0].length-1;


while (sr <= er && sc <= ec) {
//top
for(int i =sc;i<=ec;i++){
    ans.add(matrix[sr][i]);
}
//right
for(int i =sr+1;i<=er;i++){
    ans.add(matrix[i][ec]);
}
//bottom
if(sr<er){
for(int i =ec-1;i>=sc;i--){
    ans.add(matrix[er][i]);
}
}
//left

if(sc<ec){
for(int i =er-1;i>=sr+1;i--){
    ans.add(matrix[i][sc]);
}
}
sr++;
sc++;
er--;
ec--;



}




return ans;

    }
}