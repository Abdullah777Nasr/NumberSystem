package numbersystem;

public class Binary extends Decimal {

    // convert binaryNumber to decimalNumber
    public String decimalNumberBin(long d) {
        m = "";
        c = 0;
        while (d != 0) {
            //11001 ------- 25
            c += ((d % 10) * (Math.pow(2, i)));
            d /= 10;
            i++;
        }
        m += c;
        return m;
    }

    @Override
    public String octalNumber(long d) {
        //String n="";
        m = "";
        m = decimalNumberBin(d);
        a = Long.parseLong(m);
        m = super.octalNumber(a);
        return m;
    }

    @Override
    public String hexadecimalNumber(long d) {
        m = "";
        m += d;
        m = decimalNumberBin(d);
        a = Long.parseLong(m);
        m = super.hexadecimalNumber(a);
        return m;
    }
}
