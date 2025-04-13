import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] A = new int[9]; // 난쟁이 9명 입력받고, A에 저장
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            A[i] = scanner.nextInt();
            sum += A[i]; // 난쟁이 9명의 키 합
        }

        int diff = sum - 100; 
        boolean F = false; // 가짜 난쟁이를 찾으면 True로 바꾸고 break를 하기 위해.

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (A[i] + A[j] == diff) {
                    A[i] = 0;
                    A[j] = 0; // 문제에서 오름차순으로 출력하라고 했으므로, 0으로 지정하면 오름차순 정렬시 맨 앞에 두명으로 가게됨.
                    F = true;
                    break; // A[i]와 A[j]의 합이 diff와 같으면 A[i]와 A[j]를 0으로 지정하고, F를 true로 바꾸고 for문 종료.
                }
            }
            if (F) break; // F가 true이면 for문 종료.
        }

        Arrays.sort(A);

        for (int i = 2; i < 9; i++) {
            System.out.println(A[i]); // A = [0, 0, ~ ]으로 나오므로 index=2부터 끝까지 출력하면 가짜인 0을 제외하고 7명이 출력.
        }
    }
}
