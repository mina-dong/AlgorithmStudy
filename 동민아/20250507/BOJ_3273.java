import java.io.*;
import java.util.*;

public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        int answer = getSolution(X,arr);

        System.out.println(answer);

    }

    public static int getSolution(int target, int[] nums){
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;

        int cnt =0;
        while (left < right){
            int sum = nums[left]+nums[right];
            if (sum==target){
                cnt++;
                //중복쌍을 계산하지 않기위해 작업
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
            }

        return cnt;

    }
}


// 투포인터 알고리즘
// 이중 포문이랑 뭐가 차이점인데? -> 시간복잡도 낮추고, 한번에 비교하는 점이 다르다.
