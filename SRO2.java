package TZh2609;
import java.util.Scanner;
public class SRO2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("2int");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int sum1 = num1 + num2;
        System.out.println("2int = " + sum1);
        System.out.println("3int");
        int num3 = in.nextInt();
        int num4 = in.nextInt();
        int num5 = in.nextInt();
        int sum2 = num3 + num4 + num5;
        System.out.println("3int = " + sum2);
        System.out.println("4int");
        int num6 = in.nextInt();
        int num7 = in.nextInt();
        int num8 = in.nextInt();
        int num9 = in.nextInt();
        int sum3 = num6 + num7 + num8 + num9;
        System.out.println("4int = " + sum3);
    }
}
