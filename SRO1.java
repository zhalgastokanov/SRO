package TZh2609;
import java.util.Scanner;
public class SRO1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("X = ");
        int size = in.nextInt();
        int[] nums = new int[size];
        System.out.println("Элементы массива =");
        for (int i = 0; i < size; i++) {
            nums[i] = in.nextInt();
        }
        System.out.print("X = ");
        int X = in.nextInt();
        boolean found = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == X) {
                    System.out.println("Индексы " + i + " и " + j + " (" + nums[i] + " + " + nums[j] + ")");
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Нет сумм равных" + X);
        }
    }
}
