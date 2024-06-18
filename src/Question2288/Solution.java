package Question2288;

public class Solution {
    public String discountPrices(String sentence, int discount) {
        StringBuilder stringBuilder = new StringBuilder();
        sentence = sentence.trim();
        String[] all = sentence.split(" ");
        for (String s : all) {
            if (ifValid(s)) {
                stringBuilder.append(applyDiscount(s, discount)).append(" ");
            } else {
                stringBuilder.append(s).append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }

    public boolean ifValid(String s) {
        if (s.length() < 2) {
            return false;
        }
        String first = s.substring(0, 1);
        String second = s.substring(1);
        if (!"$".equals(first)) {
            return false;
        }
        for (char c : second.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public String applyDiscount(String s, int discount) {
        String digit = s.substring(1);
        double number = Double.parseDouble(digit);
        double newDigit = number * (100 - discount) / 100;
        String newValue = String.format("%.2f", newDigit);
        return "$" + newValue;
    }
}
