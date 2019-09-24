import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		ArrayList<Character> aly = new ArrayList<>();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			sc.nextLine();
			int len = 0, d = 0, s = 0, o = 0, sum = 0, cnt = 0;
			aly.clear();
			System.out.print("#" + test_case + " "); 
			while(cnt < N)
			{
				char[] c = sc.nextLine().toCharArray();
				len = c.length;
				for(int j = 0; j < len; j++)
				{
					if(c[j] >= 'A' && c[j] <= 'Z') aly.add('d');
					else if(c[j] >= 'a' && c[j] <= 'z') aly.add('s');
					else if(c[j] == ' ' || c[j] == '.' || c[j] == '!' || c[j] == '?')
					{
						if(!aly.isEmpty() && aly.get(0) == 'd')
						{
							for(int jj = 1; jj < aly.size(); jj++)
							{
								if(aly.get(jj) == 'd') d++;
								else if(aly.get(jj) == 's') s++;
								else o++;
							}
							if(d == 0 && o == 0) sum++;
						}
						aly.clear();
						d = s = o = 0;
						if(c[j] != ' ')
						{
							cnt++;
							System.out.print(sum + " ");
							sum = 0;
						}
					}
					else aly.add('o');
				}
			}
			System.out.println();
		}
	}
}