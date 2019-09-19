import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long mod = 1000000007;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] c = sc.next().toCharArray();
			HashSet<Character> hs = new HashSet<>();
			long sum = 1;
			for(int i = 1; i < c.length - 1; i++)
			{
				hs.clear();
				hs.add(c[i-1]);
				hs.add(c[i]);
				hs.add(c[i+1]);
				
				sum *= hs.size();
				sum %= mod;
			}
			
			if(c[0] != c[1])
			{
				sum *= 2;
				sum %= mod;
			}
			if(c[c.length - 1] != c[c.length - 2])
			{
				sum *= 2;
				sum %= mod;
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
}