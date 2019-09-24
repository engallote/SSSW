import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			Stack<Integer> st = new Stack<>();
			StringBuilder str = new StringBuilder();
			int[] arr = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			int i = 0, idx = 0;
			for(i = 1; i <= N; i++)
			{
				while(!st.isEmpty() && st.peek() == arr[idx])
				{
					st.pop();
					idx++;
					str.append("-");
					if(idx == N) break;
				}
				if(idx >= N) break;
				if(st.isEmpty() || st.peek() != arr[idx])
				{
					st.add(i);
					str.append("+");
				}
			}
			
			while(!st.isEmpty() && st.peek() == arr[idx])
			{
				st.pop();
				idx++;
				str.append("-");
				if(idx == N) break;
			}
			System.out.print("#" + test_case + " ");
			if(idx >= N && i > N)
				System.out.println(str.toString());
			else
				System.out.println("NO");
		}
	}
}