class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        

HashMap<String,String> map = new HashMap<>();

for(int i =0;i<knowledge.size();i++){
    map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
}



StringBuilder ans = new StringBuilder();
int i=0;
while(i<s.length()){
    char ch =s.charAt(i);
   
   if(ch=='('){


    StringBuilder curr=new StringBuilder();
    i++;
    while(s.charAt(i)!=')'){
        char currchar=s.charAt(i);
        curr.append(currchar);
        i++;
    }
    i++;

   if(map.containsKey(curr.toString())){
    ans.append(map.get(curr.toString()));
   }else{
    ans.append('?');

   }



   }
   
   else if(ch==')'){
    i++;
   }else{
    ans.append(ch);
    i++;
   }


}




return ans.toString();


    }
}