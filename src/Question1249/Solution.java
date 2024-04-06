package Question1249;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    private Stack<Integer> stack=new Stack<>();
    private Set<Integer> set=new HashSet<>();


    public String minRemoveToMakeValid(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            if(s.charAt(i)==')'){
                if(stack.empty()){
                    set.add(i);
                }else {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            set.add(stack.pop());
        }

        StringBuilder stringBuilder=new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString();


    }
}
