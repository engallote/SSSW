import java.util.*;

public class Main {
	static int res;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int[] red = new int[10], blue = new int[10], green = new int[10];
        	char[] num = sc.next().toCharArray();
        	char[] c = sc.next().toCharArray();
        	res = 0;
        	for(int i = 0; i < 9; i++)
        	{
        		if(c[i] == 'R') red[num[i]-'0']++;
        		else if(c[i] == 'B') blue[num[i]-'0']++;
        		else green[num[i]-'0']++;
        	}
        	
        	solve(0, red, blue, green);
        	System.out.print("#" + test_case + " ");
        	if(res >= 3)
        		System.out.println("Win");
        	else
        		System.out.println("Continue");        	
        }
    }

	private static void solve(int cnt, int[] red, int[] blue, int[] green) {
		if(res >= 3) return;
		res = Math.max(res, cnt);
		
		for(int i = 1; i <= 9; i++)
		{
			if(red[i] > 0)
			{
				if(i + 2 < 10)
				{
					if(red[i+1] > 0 && red[i+2] > 0)
					{
						red[i]--;
						red[i+1]--;
						red[i+2]--;
						solve(cnt + 1, red, blue, green);
						red[i]++;
						red[i+1]++;
						red[i+2]++;
					}
				}
				if(red[i] >= 3)
				{
					red[i] -= 3;
					solve(cnt + 1, red, blue, green);
					red[i] += 3;
				}
			}
			else if(blue[i] > 0)
			{
				if(i + 2 < 10)
				{
					if(blue[i+1] > 0 && blue[i+2] > 0)
					{
						blue[i]--;
						blue[i+1]--;
						blue[i+2]--;
						solve(cnt + 1, red, blue, green);
						blue[i]++;
						blue[i+1]++;
						blue[i+2]++;
					}
				}
				if(blue[i] >= 3)
				{
					blue[i] -= 3;
					solve(cnt + 1, red, blue, green);
					blue[i] += 3;
				}
			}
			else if(green[i] > 0)
			{
				if(i + 2 < 10)
				{
					if(green[i+1] > 0 && green[i+2] > 0)
					{
						green[i]--;
						green[i+1]--;
						green[i+2]--;
						solve(cnt + 1, red, blue, green);
						green[i]++;
						green[i+1]++;
						green[i+2]++;
					}
				}
				if(green[i] >= 3)
				{
					green[i] -= 3;
					solve(cnt + 1, red, blue, green);
					green[i] += 3;
				}
			}
		}
	}
}