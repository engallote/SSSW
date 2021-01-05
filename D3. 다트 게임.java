import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = {20, 40, 60, 80, 100, 120 ,140 ,160 ,180, 200};
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int res = 0;
			
			for(int i = 0; i < N; i++) {
				int x = sc.nextInt();;
				int y = sc.nextInt();
				
				double tmp = (x * x) + (y * y);
				
				for(int k = 0; k < 10; k++) {
					int num = arr[k];
					if(tmp <= num * num) {
						res += (10 - k);
						break;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + res);
		}
	}
}