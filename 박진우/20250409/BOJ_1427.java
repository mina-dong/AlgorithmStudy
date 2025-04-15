//1427. 소트인사이드
//https://www.acmicpc.net/problem/1427

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String li = sc.nextLine();
        char[]arr=li.toCharArray();

        Arrays.sort(arr);

        for(int i =arr.length-1; i>=0;i--){
            System.out.print(arr[i]);
        }

    }
}