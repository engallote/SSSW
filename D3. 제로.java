import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Stack<Long> st = new Stack<>();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int K = sc.nextInt();
			long res = 0;
			st.clear();
			
			for(int i = 0; i < K; i++){
				long num = sc.nextLong();
				if(num == 0) res -= st.pop();
				else{
					res += num;
					st.push(num);
				}
			}
			
			System.out.println("#" + test_case + " " + res);
		}
	}
}