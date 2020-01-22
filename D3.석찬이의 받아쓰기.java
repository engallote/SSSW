import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			char[] order = sc.next().toCharArray();
			char[] ch = sc.next().toCharArray();
			int res = 0;
			
			for(int i = 0; i < N; i++)
				if(ch[i] == order[i]) ++res;
			System.out.println("#" + test_case + " " + res);
		}
	}
}