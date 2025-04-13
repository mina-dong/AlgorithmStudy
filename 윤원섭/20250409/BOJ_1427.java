import java.util.Scanner;
import java.util.Arrays;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		char[] arr = in.nextLine().toCharArray();		//입력받은 문자열을 배열로 변환
 
 
		Arrays.sort(arr);		//오름차순으로 정렬
 
		for (int i = arr.length - 1; i >= 0; i--) {		//역순으로 출력(내림차순)
			System.out.print(arr[i]);
		}
 
	}
}
