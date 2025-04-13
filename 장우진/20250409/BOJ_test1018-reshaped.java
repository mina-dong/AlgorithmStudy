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
        char[][] AW = generatePattern('W'); // 시작점이 흰색으로 시작
        char[][] AB = generatePattern('B'); // 시작점이 검은색으로 시작

        // char[][] AW = {
        //     {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
        //     {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
        //     {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
        //     {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
        //     {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
        //     {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
        //     {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
        //     {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        // };

        // char[][] AB = {
        //     {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
        //     {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
        //     {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
        //     {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
        //     {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
        //     {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
        //     {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
        //     {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        // }; // 직접 작성하지 않고, 함수로 정답 패턴을 생성
        
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
                // C.add(countW);
                // C.add(countB);
                C.add(Math.min(countW, countB)); // C에 넣을 변수를 줄임으로써 메모리 절약
            }
        }
        Collections.sort(C); // 따라서 count를 정렬하고, 0번째 값을 꺼내면 최솟값.
        System.out.println(C.get(0));
    }
}
public static char[][] generatePattern(char start) {
    char[][] pattern = new char[8][8];
    char alt;

    if (start == 'W') {
        alt = 'B'; // 시작이 흰색이면, 검은색과 번갈아 나와야함.
    } else {
        alt = 'W'; // 시작이 검은색이면, 흰색과 번갈아 나와야함.
    }

    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if ((i + j) % 2 == 0) {
              /* WBWBWBWB
                 BWBWBWBW
                순으로 작성되어야함. (0,0),(1,0),(2,0)의 값이 계속 교차되어야 하므로 i나 j가 아닌 i+j를 2로 나눈 나머지가 0이여야 함.*/
                pattern[i][j] = start; // 시작이 W이면 짝수번째는 계속 W가 들어가야함.
            } else {
                pattern[i][j] = alt;  // 짝수번째가 아닌 곳에는 B가 들어가야함.
            }
        }
    }

    return pattern;
}
