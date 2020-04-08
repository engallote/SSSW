import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int sum = 0;
			int[] arr = new int[12];
			Arrays.fill(arr, 4);
			arr[10] = 16;
			
			for(int i = 0; i < N; i++){
				int num = sc.nextInt();
				sum += num;
				arr[num] -= 1;
			}
			
			if(sum >= 21){
				System.out.println("#" + test_case + " STOP");
				continue;
			}
			
			int a = 0, b = 0;
			
			for(int i = 2; i <= 11; i++){
				if(sum + i <= 21) a += arr[i];
				else b += arr[i];
			}
			
//			System.out.println(a + " " + b);
			if(a <= b) System.out.println("#" + test_case + " STOP");
			else System.out.println("#" + test_case + " GAZUA");
		}
	}
}