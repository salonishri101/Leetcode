class Solution {
    public String reverseParentheses(String s) {
        

Stack<String> st = new Stack<>();
String curr="";

for(int i =0;i<s.length();i++){

char ch = s.charAt(i);


if(ch=='('){
st.push(curr);
curr="";
}else if(ch==')'){
   String revstr = new StringBuilder(curr).reverse().toString();
    curr = st.pop() + revstr;

}else{
curr+=ch;
}




}


return curr;

    }
}




// Use a Stack of Strings and one StringBuilder curr.

// Traverse the string character by character.
// If character is a normal letter → append it to curr.
// If character is (:
// Push the current curr into the stack.
// Start a fresh curr.
// If character is ):
// Reverse curr.
// Pop the previous string from the stack.
// Append the reversed curr to that previous string.
// Make this combined string the new curr.
// At the end, curr is the answer.