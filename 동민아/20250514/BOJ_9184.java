import java.io.*;
import java.util.*;

public class BOJ_9184 {
    static int[][][]dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b, c;

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a =Integer.parseInt(st.nextToken());
            b =Integer.parseInt(st.nextToken());
            c =Integer.parseInt(st.nextToken());

            // 입력의 마지막은 -1 -1 -1로
            if(a == -1 && b == -1 && c == -1) { break;}

            int result = solution(a,b,c);

            System.out.println("w("+ a +", "+ b +", "+ c +") = "+result);
        }
    }

    public static int solution(int x, int y, int z){
        if (x <= 0 || y <= 0 || z <= 0) return 1;
        if (x > 20 || y > 20 || z > 20) return solution(20, 20, 20);

        //dp에서 중요한 부분!
        if (dp[x][y][z] != 0) return dp[x][y][z];

        if (x < y && y < z) {
            dp[x][y][z] = solution(x, y, z - 1) + solution(x, y - 1, z - 1) - solution(x, y - 1, z);
        } else {
            dp[x][y][z] = solution(x - 1, y, z) + solution(x - 1, y - 1, z) +
                    solution(x - 1, y, z - 1) - solution(x - 1, y - 1, z - 1);
        }

        return dp[x][y][z];
    }
}


// 한줄에 하나씩 입력된다. 음.....

// 왜 dp 배열이 왜 20개일까?
// 20보다 큰 값이 들어오면 그냥 w(20, 20, 20)을 대신 계산해서 리턴함

//dp에서 중요한 부분!
//        if (dp[a][b][c] != 0) return dp[a][b][c];
//  0이 아니다 = 이전에 재귀로 계산했던 부분을 불러올 수 있다 = 중복호출을 줄인다.

//if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns: 1
//if a > 20 or b > 20 or c > 20, then w(a, b, c) returns: w(20, 20, 20) =>
//if a < b and b < c, then w(a, b, c) returns: w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
//
//otherwise it returns: w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)