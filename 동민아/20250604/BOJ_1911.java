import java.io.*;
import java.util.*;

public class BOJ_1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 웅덩이 개수
        int L = Integer.parseInt(st.nextToken()); // 널빤지 길이

        int[][] arr = new int[N][2];

        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken()); // 시작위치
            arr[i][1] = Integer.parseInt(st.nextToken()); // 끝위치
        }

        //목표: 모든 웅덩이를 덮기위해 필요한 널빤지들의 최소개수
        Arrays.sort(arr, (a,b)-> Integer.compare(a[0], b[0]));

        int result =0;
        int current =0; //현재 덮인 위치

        for (int i=0; i<N; i++){
            int start = arr[i][0]; //1
            int end = arr[i][1];  // 4

            if(current >= end) { continue;} // 0>=4? - current가 5이고 end=4 라면, 이미 덮었으니 다음 for문으로 넘어간다. = continue의 역할
            if (current < start){ current = start;} // 0<1 -> currnet = 1

            //필요한 널빤지 개수?
            int length = end - current; // 4 - 1 = 3
            int cnt = (int) Math.ceil((double) length / L); // 3/3  =1, 만약 길이가 5인경우 2개가 필요함으로  5/2 =1.5 이지만 올림처리.
            result += cnt;

            //현재위치 변경 = 현재 널빤지가 채워진 곳까지
            current += cnt*L;

        }

        //테스트케이스가 여러개가 아니므로 for문 밖에 출력.
        System.out.println(result);
        }
    }

//    //목표: 모든 웅덩이를 덮기위해 필요한 널빤지들의 최소개수
//
//웅덩이의 개수는 N개, 널빤지의 길이는 L,
//각 줄마다 웅덩이의 시작위치와 끝위치,
//
//답: 5
//        111222..333444555.... // 길이 3인 널빤지
//        .MMMMM..MMMM.MMMM.... // 웅덩이
//        0123456789 01234567890 // 좌표
//
//첫번째 생각:
//힌트처럼... 좌표를 두고 웅덩이처리를 하고, 길이만큼 제외할까?
//
//우선 최소개수를 추출하기전에,
//웅덩이는 겹치지 않음!
//
//연달아 웅덩이가 있는 경우도 고려를 해야하나?
//시작위치에 우선 대고(필요하니까)
//    현재 끝위치를 갱신, 널빤지의 추가를 해,
//또 끝위치 갱신, 필요시 넣고 불필요시 놓치않음
//단? 해당 위치가 웅덩이인지 아닌지를 판단을 하는게 또 필요할듯?
//
//        0. 길의 마지막 위치를 알기 위해, 최대값 MAxlength은 따로 저장한다.
//1. [0]을 기준으로 정렬를 한다 : 순서대로 입력된다는 보장이 없기때문에
//        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));
//2. 받은 값을 기준으로, 웅덩이 표현을 한다. Maxlength 까지 범위.
//
//        근데 굳이 그리디하게 가니까 maxlength를 생각하지 않고,
//시작위치부터 그때에 맞게, 그리디하게 가는걸로 목표로하면 될듯
//왜? 어차피 웅덩이 자체는 겹치지는 않으니까.



//실수나눗넴할때 전체를 포함시키지말고, 한 요소만 실수처리할것..
// a / b 이 자체가 정수나눗넴이기 때문.!


