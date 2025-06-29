import java.io.*;
import java.util.*;

import java.util.Scanner;
public class aivle_29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();

        int[][] mat = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                mat[i][j] = sc.nextInt();

        boolean found = false;

        for (int row1 = 0; row1 < N; row1++) {
            for (int row2 = row1; row2 < N; row2++) {
                for (int col1 = 0; col1 < M; col1++) {
                    for (int col2 = col1; col2 < M; col2++) {
                        int sum = 0;
                        for (int i = row1; i <= row2; i++) {
                            for (int j = col1; j <= col2; j++) {
                                sum += mat[i][j];
                            }
                        }
                        if (sum == X) {
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }
                if (found) break;
            }
            if (found) break;
        }

        System.out.println(found ? "YES" : "NO");
    }
}
