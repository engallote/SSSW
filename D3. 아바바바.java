import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			long N = sc.nextLong();
			long res = (N / 2) * (N - 1) / 2;
			
			System.out.println("#" + test_case + " " + res);
		}
	}
}