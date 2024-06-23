package String.Question520;

public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        char first = word.charAt(0);
        // �����һ���ַ��Ǵ�д��
        if (Character.isUpperCase(first)) {
            return checkAllUpper(word) || checkAllLower(word.substring(1));
        } else {
            //��һ���ַ���ΪСд��
            return checkAllLower(word);
        }

    }


    /**
     * �ж��ַ����Ƿ�ȫ�����Ǵ�д
     *
     * @param word Ҫ�жϵ��ַ���
     * @return true ���ȫ�Ǵ�д; false, ��֮��Ϊfalse
     */
    private boolean checkAllUpper(String word) {
        return word.toUpperCase().equals(word);
    }

    /**
     * �ж��ַ����Ƿ�ȫ������Сд
     *
     * @param word Ҫ�жϵ��ַ���
     * @return true ���ȫ��Сд; false, ��֮��Ϊfalse
     */
    private boolean checkAllLower(String word) {
        return word.toLowerCase().equals(word);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().detectCapitalUse("USA"));
    }

}
