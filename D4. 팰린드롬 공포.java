import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] ch = sc.next().toCharArray();
			String res = "YES";
			int a = 0, b = 0, c = 0;
			for(int i = 0; i < ch.length; i++)
			{
				if(ch[i] == 'a') ++a;
				else if(ch[i] == 'b') ++b;
				else ++c;
			}
			
			int min = Math.min(a, Math.min(b, c));
			if(a - min >= 2 || b - min >= 2 || c - min >= 2) res = "NO";
			System.out.println("#" + test_case + " " + res);
		}
	}
}