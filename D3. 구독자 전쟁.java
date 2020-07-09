import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int max = Math.min(A, B);
			int min = A + B <= N ? 0 : (A + B) - N;
			
			System.out.println("#" + test_case + " " + max + " " + min);
		}
	}
}