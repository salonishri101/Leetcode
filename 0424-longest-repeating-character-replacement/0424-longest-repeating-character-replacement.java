class Solution {
    public int characterReplacement(String s, int k) {
        

HashMap<Character,Integer> map = new HashMap<>();
int i =0;
int maxLen =0;
int maxFreq =0;
for(int j =0;j<s.length();j++){
    char rightchar =s.charAt(j);
    map.put(rightchar,map.getOrDefault(rightchar,0)+1);
    maxFreq=Math.max(maxFreq,map.get(rightchar));

    while(j-i+1-maxFreq>k){
        char leftchar=s.charAt(i);
        map.put(leftchar,map.get(leftchar)-1);

        if(map.get(leftchar)==0){
            map.remove(leftchar);
        }
        i++;
    }

    maxLen =Math.max(j-i+1,maxLen);

}

return maxLen;
    }
}