import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int X = sc.nextInt();
			
			if(X == 1 || X == 2 * N - 1) System.out.println("#" + test_case + " 0");
			else System.out.println("#" + test_case + " 1");
		}
	}
}