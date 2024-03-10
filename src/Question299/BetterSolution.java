package Question299;

public class BetterSolution {
    public String getHint(String secret,String guess){
        //���s������1��10�Ĵ���
        int[] s=new int[10];
        //���g������1��10�ĸ���
        int[] g=new int[10];
        int len=secret.length();
        int aNumber=0;
        int bNumber=0;
        for(int i=0;i<len;i++){
            int curS=secret.charAt(i)-'0';
            int curG=guess.charAt(i)-'0';
            if(curS==curG){
                aNumber++;
            }else {
                s[curS]++;
                g[curG]++;
            }
        }
        for(int i=0;i<10;i++){
            bNumber+=Math.min(s[i],g[i]);
        }
        return aNumber+"A"+bNumber+"B";
    }

}
