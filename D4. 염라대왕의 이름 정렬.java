import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			PriorityQueue<Name> pq = new PriorityQueue<>();
			HashSet<String> hs = new HashSet<>();
			for(int i = 0; i < N; i++)
			{
				String name = sc.next();
				if(hs.contains(name)) continue;
				hs.add(name);
				pq.add(new Name(name));
			}
			
			System.out.println("#" + test_case);
			while(!pq.isEmpty())
				System.out.println(pq.poll().str);
		}
	}
}
class Name implements Comparable<Name>{
	String str;
	Name(String str){
		this.str = str;
	}
	@Override
	public int compareTo(Name o) {
		char[] a = o.str.toCharArray(), b = this.str.toCharArray();
		if(a.length < b.length) return 1;
		else if(a.length == b.length)
		{
			for(int i = 0; i < a.length; i++)
			{
				if(a[i] > b[i]) return -1;
				else if(a[i] < b[i]) return 1;
			}
			return 0;
		}
		else return -1;
	}
}