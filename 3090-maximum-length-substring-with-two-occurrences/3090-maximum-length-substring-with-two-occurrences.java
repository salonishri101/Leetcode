class Solution {
    public int maximumLengthSubstring(String s) {
        
       HashMap<Character,Integer> map = new HashMap<>();
       int i =0;
       int maxLen=Integer.MIN_VALUE;
       for(int j =0;j<s.length();j++){
        char ch = s.charAt(j);

       if(map.containsKey(ch)){
        map.put(ch,map.getOrDefault(ch,0)+1);
       }else{
        map.put(ch,1);
       }


       while(map.get(ch)>2){
        char leftChar =s.charAt(i);
        map.put(leftChar,map.getOrDefault(leftChar,0)-1);
         i++;
       }

   int len =j-i+1;
   maxLen=Math.max(len,maxLen);

       }

 return maxLen;
    }
}