package Question299;


import java.util.HashMap;


public class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Integer,Character> s=new HashMap<>(secret.length());
        HashMap<Integer,Character> g=new HashMap<>(guess.length());
        for(int i=0;i<secret.length();i++){
            s.put(i,secret.charAt(i));
        }
        for(int i=0;i<guess.length();i++){
            g.put(i,guess.charAt(i));
        }
        //得到A前面的数字是多少
        int aNumber=0;
        for(int i=s.size()-1;i>=0;i--){
            if(s.get(i).equals(g.get(i))){
                aNumber++;
                s.put(i,'b');
                g.put(i,'a');
            }
        }
        int bNumber =0;
        //得到B前面的数字是多少
        for(int i=0;i<g.size();i++){
            if(s.values().contains(g.get(i))){
                bNumber++;
                s.values().remove(g.get(i));
            }
        }
        return aNumber+"A"+bNumber+"B";
    }


    public static void main(String[] args) {
        String scret="1807";
        String guess="7810";
        System.out.println(new Solution().getHint(scret,guess));
    }
}
