import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int B = sc.nextInt();
			int E = sc.nextInt();
			
			int min = B - E, max = B + E, res = 0;
			
			for(int i = 0; i < N; i++)
			{
				int num = sc.nextInt();
				
				for(int j = 1;; j++)
				{
					if(num * j > max) break;
					else if(num * j >= min && num * j<= max)
					{
						res++;
						break;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + res);
		}
	}
}