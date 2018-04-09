package numbersystem;

public class Decimal {

    protected long f, c, a;
    protected int i;
    protected String m;

    public Decimal() {
        m = "";
        f = 1;
        i = 0;
        c = 0;
    }

    // convert decimalNumber to binaryNumber
    public String binaryNumber(long d) {
        m = "";
        c = 0;
        f = 1;
        while (d != 0) {
            //25 ------- 11001
            c += ((d % 2) * f);
            f *= 10;
            d /= 2;
        }
        m += c;
        return m;
    }

    // convert decimalNumber to octalNumber
    public String octalNumber(long d) {
        m = "";
        f = 1;
        c = 0;
        while (d != 0) {
            //25 ------- 31
            c += ((d % 8) * f);
            f *= 10;
            d /= 8;
        }
        m += c;
        return m;
    }

    // convert decimalNumber to hexadecimalNumber
    public String hexadecimalNumber(long d) {
        f = 1;
        String num1 = "", num2 = "";
        while (d != 0) {
            //25 ------- 19
            switch ((int) d % 16) {
                case 10:
                    num1 += 'A';
                    break;
                case 11:
                    num1 += 'B';
                    break;
                case 12:
                    num1 += 'C';
                    break;
                case 13:
                    num1 += 'D';
                    break;
                case 14:
                    num1 += 'E';
                    break;
                case 15:
                    num1 += 'F';
                    break;
                default: {
                    num1 += (d % 16);
                    break;
                }
            }
            d /= 16;
        }
        for (i = num1.length() - 1; i >= 0; i--) {
            num2 += num1.charAt(i);
        }
        return num2;
    }
}
