import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int K = sc.nextInt();
			int res = 0;
			
			if(N < K) res = 1;
			else res = (N % K == 0 ? 0 : 1);
			System.out.println("#" + test_case + " " + res);
		}
	}
}