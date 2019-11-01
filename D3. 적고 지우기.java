import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] ch = sc.next().toCharArray();
			HashSet<Character> hs = new HashSet<>();
			
			for(char c : ch)
			{
				if(hs.contains(c))
					hs.remove(c);
				else hs.add(c);
			}
			
			System.out.println("#" + test_case + " " + hs.size());
		}
	}
}