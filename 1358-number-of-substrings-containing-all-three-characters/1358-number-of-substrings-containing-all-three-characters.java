class Solution {



    public int numberOfSubstrings(String s) {
        
HashMap<Character,Integer> map = new HashMap<>();
int i =0;
int count =0;

for(int j =0;j<s.length();j++){
    char rightchar =s.charAt(j);
    map.put(rightchar,map.getOrDefault(rightchar,0)+1);
   

    // while(map.get('a')>0 && map.get('b')>0 && map.get('c')>0){->null pointer exception if not present

    while(map.containsKey('a') &&
      map.containsKey('b') &&
      map.containsKey('c')) {

        
        char leftchar=s.charAt(i);
        map.put(leftchar,map.get(leftchar)-1);

        if(map.get(leftchar)==0){
            map.remove(leftchar);
        }
        i++;
    }

    count+=(i);

   

}

return count;

    }
}