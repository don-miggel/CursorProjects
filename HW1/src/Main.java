


public class Main {
    public static void main(String[] args) {
        byte byte1, byte2;
        short short1, short2;
        int int1, int2;
        long long1, long2;
        float float1, float2;
        double double1, double2;

        System.out.println();
        System.out.println("---------OPERATIONS WITH BYTE VARIABLES----------------");
        byte1 = 10;
        byte2 = 12;
        System.out.println("byte1 = "+byte1+", byte2 = "+ byte2);
        System.out.println("byte adding: "+ (byte1+byte2));
        System.out.println("byte subtraction: "+(byte2-byte1));
        System.out.println("byte multiplication: "+ (byte1*byte2));
        System.out.println("byte division: "+ (byte2/byte1));

        System.out.println();
        System.out.println("---------OPERATIONS WITH SHORT VARIABLES----------------");
        short1 = 512;
        short2 = 48;
        System.out.println("short1 = "+short1+", short2 = "+ short2);
        System.out.println("short adding: "+ (short1+short2));
        System.out.println("short subtraction: "+ (short1-short2));
        System.out.println("short multiplication: "+ (short1*short2));
        System.out.println("short division: "+(short1/short2));

        System.out.println();
        System.out.println("---------OPERATIONS WITH INTEGER VARIABLES----------------");
        int1 = 49152;
        int2 = 512;
        System.out.println("int1 = "+int1+", int2 = "+ int2);
        System.out.println("integer adding: "+ (int1+int2));
        System.out.println("integer subtraction: "+ (int1-int2));
        System.out.println("integer multiplication: "+ (int1 * int2));
        System.out.println("integer division: "+(int1 / int2));

        System.out.println();
        System.out.println("---------OPERATIONS WITH LONG VARIABLES----------------");
        long1 = 49_152_436_758L;
        long2 = 512_456_736L;
        System.out.println("long1 = "+long1+", long2 = "+ long2);
        System.out.println("long adding: "+ (long1+long2));
        System.out.println("long subtraction: "+ (long1-long2));
        System.out.println("long multiplication: "+ (long1 * long2));
        System.out.println("long division: "+(long1 / long2));

        System.out.println();
        System.out.println("---------OPERATIONS WITH FLOAT VARIABLES----------------");
        float1 = 3.14159f;
        float2 = 2.71f;
        System.out.println("float1 = "+float1+", float2 = "+ float2);
        System.out.println("float adding: "+ (float1+float2));
        System.out.println("float subtraction: "+ (float1-float2));
        System.out.println("float multiplication: "+ (float1 * float2));
        System.out.println("float division: "+(float1 / float2));

        System.out.println();
        System.out.println("---------OPERATIONS WITH DOUBLE VARIABLES----------------");
        double1 = 9.256_728_365_826_915;
        double2 = 3.14_159_265_359;
        System.out.println("double1 = "+double1+",  double2 = "+  double2);
        System.out.println("double adding: "+ (double1+ double2));
        System.out.println("double subtraction: "+ (double1- double2));
        System.out.println("double multiplication: "+ (double1 * double2));
        System.out.println("double division: "+(double1 /  double2));
    }
}
