import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int test_case = 1; test_case <= tc; test_case++)
		{
			int N = sc.nextInt();
			int[] alp = new int[26];
			
			for(int i = 0; i < N; i++)
			{
				char c = sc.next().charAt(0);
				alp[c - 'A']++;
			}
			
			int res = 0;
			
			for(int i = 0; i < 26; i++)
			{
				if(alp[i] > 0) res++;
				else break;
			}
			
			System.out.println("#" + test_case + " " + res);
		}
	}
}