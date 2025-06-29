import java.io.*;
import java.util.*;

public class aivle_28 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int k = 0;
        while (true) {
            if (k * (k + 1) / 2 + 1 >= N) {
                System.out.println(k);
                break;
            }
            k++;
        }
    }