import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();    
        sc.nextLine();

        char[][] A = new char[N][M];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLine().toCharArray();
        }

        ArrayList<Integer> C = new ArrayList<>();

        char[][] AW = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        };

        char[][] AB = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        }; // 시작이 흰색, 검은색인 경우의 체스판
        int count = 0;
        
        for (int i = 0; i <= N - 8; i++) { 
            for (int j = 0; j <= M - 8; j++) { // 시작 지점으로 가능한 포인트. 8x8이므로 i,j부터 N,M까지 8칸이 존재해야하므로 N-8,M-8까지 가능함. N,M이 9라면 가능한 시작 0~8, 1~9
                int countW = 0; 
                int countB = 0;
                for (int x = i; x < i + 8; x++) { 
                    for (int y = j; y < j + 8; y++) { // 시작 지점부터 8칸. 1부터 8까지
                            if (A[x][y] != AW[x - i][y - j]) {
                                countW++; // AW와 비교하여 다르면 칠해야하니 countW를 하나 증가
                            }
                            if (A[x][y] != AB[x - i][y - j]) {
                                countB++; // AB와 비교하여 다르면 칠해야하니 countB를 하나 증가
                            }
                    }
                }
                c.add(countW);
                C.add(countB); // 시작점이 검은색일수도, 흰색일수도 있음. 이 중, 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구해야함. 
            }
        }
        Collections.sort(C); // 따라서 count를 정렬하고, 0번째 값을 꺼내면 최솟값.
        System.out.println(C.get(0));
    }
}

