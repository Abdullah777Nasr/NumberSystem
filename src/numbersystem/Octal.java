package numbersystem;

public class Octal extends Decimal {

    // convert octalNumber to decimalNumber
    public String decimalNumberOct(long d) {
        m = "";
        c = 0;
        while (d != 0) {
            //31 --------- 25
            c += ((d % 10) * (Math.pow(8, i)));
            d /= 10;
            i++;
        }
        m += c;
        return m;
    }

    @Override
    public String binaryNumber(long d) {
        m = "";
        m = decimalNumberOct(d);
        a = Long.parseLong(m);
        m = super.binaryNumber(a);
        return m;
    }

    @Override
    public String hexadecimalNumber(long d) {
        m = "";
        m += d;
        m = decimalNumberOct(d);
        a = Long.parseLong(m);
        m = super.hexadecimalNumber(a);
        return m;
    }
}
