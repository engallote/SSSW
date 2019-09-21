import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			sc.nextLine();
			PriorityQueue<String> pq = new PriorityQueue<>();
			HashSet<Character> hs = new HashSet<>();
			int max = 0;
			for(int i = 0; i < N; i++)
			{
				hs.clear();
				char[] c = sc.nextLine().toCharArray();
				for(char ch : c)
					if(ch != ' ') 
						hs.add(ch);
				
				if(max < hs.size())
				{
					max = hs.size();
					pq.clear();
					pq.add(new String(c));
				}
				else if(max == hs.size()) pq.add(new String(c));
			}
			
			System.out.println("#" + test_case + " " + pq.poll());
		}
	}
}