class Solution {
    public int minimumPushes(String word) {
        

char arr[]=word.toCharArray();
// Arrays.sort(arr);
HashMap<Character,Integer> m=new HashMap<>();


for(char ch:arr){
if(m.containsKey(ch)){
  m.put(ch,m.getOrDefault(ch,0)+1)  ;
}else{

m.put(ch,1);
}
}






ArrayList<Integer> list=new ArrayList(m.values());

list.sort(Collections.reverseOrder());

int sum =0;
for(int i =0;i<list.size();i++){
    int curr=(i/8)+1;
    int val=curr*list.get(i);

    sum+=val;
}




return sum;


    }
}