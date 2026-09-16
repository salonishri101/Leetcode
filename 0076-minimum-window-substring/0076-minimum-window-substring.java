class Solution {
    public String minWindow(String s, String t) {
        
HashMap<Character,Integer> map = new HashMap<>();

for(int j =0;j<t.length();j++){
map.put(t.charAt(j),map.getOrDefault(t.charAt(j),0)+1);

}



int i =0;
int count=0;
int minLen =Integer.MAX_VALUE;
int start=0;
for(int j =0;j<s.length();j++){
    char ch =s.charAt(j);
    if(map.getOrDefault(ch,0)>0)  count++;
    map.put(ch, map.getOrDefault(ch, 0) - 1);
   

    while(count==t.length()){
       

        if(j-i+1<minLen){
            minLen=j-i+1;
            start=i;
        }
    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);


      if(map.getOrDefault(s.charAt(i),0)>0)  count--;
    

     i++;
     



    }

}

return minLen==Integer.MAX_VALUE?"":s.substring(start,start + minLen);





    }
}