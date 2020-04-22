import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			arr = new int[N];
			int res = -1;
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			for(int i = 0; i < N; i++)
				for(int j = i + 1; j < N; j++){
					if(isOk(arr[i] * arr[j]))
						res = Math.max(res, arr[i] * arr[j]);
				}
			
			System.out.println("#" + test_case + " " + res);
		}
	}
	private static boolean isOk(int num) {
		int pre = num % 10;
		num /= 10;
		while(num > 0){
			if(num % 10 >= pre || Math.abs(num % 10 - pre) != 1) return false;
			pre = num % 10;
			num /= 10;
		}
		return true;
	}
}