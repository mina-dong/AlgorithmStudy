import java.io.*;
import java.util.*;

public class aivle_21 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine()); // 둘레 N

        //목표: 최대 개수를 만들수 있는 둘레 P와 개수 cnt;
        int p = 12;  //n의 최소 범위가 12임.
        int cnt = 0; // 최종 개수
        int result = 0; //최대 둘레

        while (p <= N){  // p가 N이 될때까지 증가하며 직각삼각형이 될 수 있는 조합 찾기

            int currentCnt =0;

            for(int a = 1; a<p/3; a++ ){ // a<b<c
                for(int b = a+1; b<(p-a) / 2; b++){  //a<b<c 이기때문에 p-a의 남은것에 반.으로 범위 한정
                    int c = p - a - b; //나머지 변
                    if( (a*a) + (b*b) == (c*c)){
                        currentCnt++; //조건 만족시, 직각삼각형 개수 증가
                    }
                }
            }

            //직각삼각형을 **가장 많이** 만들 수 있는 둘레와 개수값 갱신
            if ( cnt < currentCnt ) { // 위 조합의 개수가 최대 개수라면,
                cnt = currentCnt;
                result = p;
            }

            p++; // 한 사이클 종료 후 1증가한 둘레.
        }

        System.out.println(result+" "+cnt);

        }
    }

    //문제1: 이렇게 했을 경우 4번 테스트케이스에서 오류남.
    // for(int b = a+1; b<(p-a) / 2 ; b++){
    // 이유 :  p = 60 이라고 가정,
//        a = 10,
//        b = 11 부터 시작해서 b< 25 까지라서 b=24 까지만 가능함,
//        그러면 25까지 포함이 안되기 때문에, 범위가 빠지는 경우가 생김!
//    // 해결: for(int b = a+1; b<=(p-a) / 2; b++)