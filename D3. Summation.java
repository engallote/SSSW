import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int min = Integer.MAX_VALUE, max = 0, sum = 0, num;
			for(int i = 0; i < 10; i++)
			{
				num = sc.nextInt();
				sum = 0;
				while(num > 0)
				{
					sum += num % 10;
					num /= 10;
				}
				min = Math.min(min, sum);
				max = Math.max(max, sum);
			}
			
			System.out.println("#" + test_case + " " + max + " " + min);
		}
	}
}