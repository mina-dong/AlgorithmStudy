// 2309. 일곱 난쟁이이
// https://www.acmicpc.net/problem/2309

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[9];
        int sum = 0;
        
        //9개의 수 입력받기
        for (int i = 0; i < 9; i++) {
            heights[i] = sc.nextInt();
            sum += heights[i];
        }
        
        int target = sum - 100;

        // 두 난쟁이 찾기
        //outerLoop:
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (heights[i] + heights[j] == target) {
                    // 일곱 난쟁이 선택 및 정렬
                    ArrayList<Integer> result = new ArrayList<>();
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            result.add(heights[k]);
                        }
                    }
                    //정렬
                    Collections.sort(result);
                    
                    // 결과 출력
                    for (int num : result) {
                        System.out.println(num);
                    }
                    //outerLoopbreak outerLoop; // 종료
                }
            }
        }
    }
}
