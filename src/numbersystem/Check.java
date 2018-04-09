package numbersystem;

public class Check {

    static boolean checkBinaryNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0' && str.charAt(i) != '1'&& str.charAt(i) != '.') {
                return true;
            }
        }
        return false;
    }

    static boolean checkNumber(String str) {
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'F') {
                return true;
            }
        }
        return false;
    }
}
