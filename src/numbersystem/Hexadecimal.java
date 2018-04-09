package numbersystem;

public class Hexadecimal extends Decimal {

    // convert hexadecimalNumber to decimalNumber
    public String decimalNumberHex(String num) {
        m = "";
        c = 0;
        int j = num.length() - 1;
        for (i = 0; i < num.length(); i++, j--) {
            switch (num.charAt(i)) {
                case 'A':
                    c += (10 * (Math.pow(16, j)));
                    break;
                case 'B':
                    c += (11 * (Math.pow(16, j)));
                    break;
                case 'C':
                    c += (12 * (Math.pow(16, j)));
                    break;
                case 'D':
                    c += (13 * (Math.pow(16, j)));
                    break;
                case 'E':
                    c += (14 * (Math.pow(16, j)));
                    break;
                case 'F':
                    c += (15 * (Math.pow(16, j)));
                    break;
                default: {
                    int s;
                    s = num.charAt(i) - 48;
                    c += (s * (Math.pow(16, j)));
                }
            }
        }
        m += c;
        return m;
    }

    public String binaryNumber(String num) {
        m = "";
        m = decimalNumberHex(num);
        a = Long.parseLong(m);
        m = super.binaryNumber(a);
        return m;
    }

    public String octalNumber(String num) {
        m = "";
        m = decimalNumberHex(num);
        a = Long.parseLong(m);
        m = super.octalNumber(a);
        return m;
    }
}
