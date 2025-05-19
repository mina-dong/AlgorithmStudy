import java.io.*;
import java.util.*;

public class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int [] arr = new int[a];
        int [] dp = new int[a];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<arr.length; i++){
            arr[i] =Integer.parseInt(st.nextToken());
        }

        int result = 0;

        //dp! 그리고 동시에 최대값을 저장한다.
        for (int i=0; i<a; i++){
            dp[i] = 1;
            for (int j=0; j<i; j++){
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            //어차피 이전 값이 갱신되는 일이 없으니, i루프 돈 다음에 최대값 저장.
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}


// 한줄에 하나씩 입력된다. 음.....

// 왜 dp 배열이 왜 20개일까?
// 20보다 큰 값이 들어오면 그냥 w(20, 20, 20)을 대신 계산해서 리턴함

//dp에서 중요한 부분!
//        if (dp[a][b][c] != 0) return dp[a][b][c];
//  0이 아니다 = 이전에 재귀로 계산했던 부분을 불러올 수 있다 = 중복호출을 줄인다.


//수열 A = {10, 20, 10, 30, 20, 50} 인 경우에
//가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
//
//        가장 긴 증가하는 부분이 뭘 말하는건지...? 문제가 이해가 안됌.
//        > 증가하는 부분수열이란? 앞보다 뒤 숫자가 더 큰 부분수열임
//        > {10, 20, 30} → 증가함 (OK)
//        > {10, 30, 20} → 증가하지 않음 (X, 30 > 20 이라서 꺾임)
//
//    이게 어떻게 dp이지?  => dp[i]: i번째 원소를 마지막 원소로 하는 LIS의 길이
//
//초기화 dp = [1, 1, 1, 1, 1, 1] (자기 자신만 포함하는 경우)
//
//계산 과정(인덱스 기준)
//    i시작이  0이 아닌 이유? 증가하는 부분 수열이니까, 0번째 앞은 당연히 없기때문임
//        => 즉, 1번째부터 시작하되, 0번부터 쭉 확인한다 = j는 당연히 0이고, i 직전까지해야함!
//        -> i번째는 마지막 숫자임을 명심.
//
//        수열 A = {10, 20, 10, 30, 20, 50}
//
//i = 1 (20):
//        10 < 20 → dp[1] = max(1, dp[0]+1) = 2
//        → dp = [1, 2, 1, 1, 1, 1]
//i = 2 (10): 이전 값들보다 작거나 같아서 dp[2]는 그대로 1
//i = 3 (30)
//        dp[i] = Math.max(dp[i], dp[j] + 1);
//        10 < 30 → dp[3] = dp[0]+1 = 2
//        20 < 30 → dp[3] = max(2, dp[1]+1) = 3
//        10 < 30 → dp[3] = max(3, dp[2]+1) = 3
//        → dp = [1, 2, 1, 3, 1, 1]




