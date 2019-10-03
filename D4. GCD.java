import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int K = sc.nextInt() - 1;
			long a = 2, b = 1, tmp = 0;
			while(K > 0)
			{
				K--;
				tmp = b;
				b = a;
				a += tmp;
			}
			
			System.out.println("#" + test_case + " " + a + " " + b);
		}
	}
}