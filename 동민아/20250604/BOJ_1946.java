import java.io.*;
import java.util.*;

public class BOJ_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int t = 0; t<testCase; t++){
            int N = Integer.parseInt(br.readLine()); // 지원자 숫자

            int [][] people = new int[N][2];

            for(int i = 0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                people[i][0] = Integer.parseInt(st.nextToken());
                people[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(people, (a, b) -> a[0] - b[0]); // 서류 성적 기준 오름차순 정렬

            //선발할 수 있는 최대 인원수?
            // 1차적으로 서류 점수를 정렬했기 때문에,
            // 1번째의 면접점수 < i번째의 면접점수 => 탈락 처리

            int minCnt = Integer.MAX_VALUE;
            int result =0;
            for(int i=0; i<N; i++){
//                작은 경우 변경
                if( people[i][1] < minCnt){
                    minCnt = people[i][1];
                    result ++;
                }
            }

            System.out.println(result);
        }

        }
    }

//                1 4
//                    2 5 ->  탈락
//                        3 1 -> 합격
//                   4 2 -> 합격


//Arrays.sort(people, (a, b) -> a[0] - b[0]); // 서류 성적 기준 오름차순 정렬
// -> 그냥 정렬하면 런타임 에러가 발생되는데
// int[][] 객체 배열이 아니라, 기본형 배열의 배열이라서 명확히 해주는게 런타임 에러가 발생되지 않는다.
// 컴파일에러 : 코드 실행전 문법이 틀려서 발생
// 런타임에러: 코드는 컴파일이 잘 됐지만, 실행시 문제 발생.