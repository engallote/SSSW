import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int S = sc.nextInt();
			int E = sc.nextInt();
			int M = sc.nextInt();
			
			int s = 1, e = 1, m = 1, res = 1;
			while(true)
			{
				if(s == S && e == E && m == M)
					break;
				s++;
				e++;
				m++;
				if(s > 365) s = 1;
				if(e > 24) e = 1;
				if(m > 29) m = 1;
				res++;
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}