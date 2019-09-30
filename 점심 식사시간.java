import java.util.*;

public class Main {
	static int N, M, res;
	static int[][] arr;
	static ArrayList<Pair> human = new ArrayList<>();
	static Pair[] stairs = new Pair[2];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	int idx = 0;
        	res = Integer.MAX_VALUE;
            arr = new int[N][N];
            human.clear();
            for(int i = 0; i < N; i++)
            	for(int j = 0; j < N; j++)
            	{
            		arr[i][j] = sc.nextInt();
            		if(arr[i][j] == 1)//사람
            			human.add(new Pair(i, j));
            		else if(arr[i][j] > 1)//계단
            			stairs[idx++] = new Pair(i, j);
            	}
            
            solve(0, 0);
            System.out.println("#" + test_case + " " + res);
        }
	}
	private static void solve(int idx, int chk) {
		if(idx == human.size())
		{
			run(chk);
			return;
		}
		solve(idx + 1, chk|(1<<idx));
		solve(idx + 1,chk);
	}
	private static void run(int chk) {
		int[] arr1 = new int[100], arr2 = new int[100];
		int max1 = 0, max2 = 0;
		for(int i = 0; i < human.size(); i++)
		{
			if((chk&(1<<i)) != 0)
			{
//				System.out.print(i + " , ");
				int num = Math.abs(human.get(i).x - stairs[0].x) + Math.abs(human.get(i).y - stairs[0].y);
				arr1[num]++;
				max1 = Math.max(max1, num);
			}
			else
			{
				int num = Math.abs(human.get(i).x - stairs[1].x)+Math.abs(human.get(i).y - stairs[1].y);
				arr2[num]++;
				max2 = Math.max(max2, num);
			}
		}
//		System.out.println();
		//1번 계단
		int step1 = 0, step2 = 0, size = 0, time = arr[stairs[0].x][stairs[0].y], delay = 0;
		Queue<Integer> cur = new LinkedList<>();
		for(int i = 0; i <= max1; i++)
		{
			step1++;
			size = cur.size();
			for(int k = 0; k < size; k++)
			{
				int x = cur.poll();
				if(x - 1 > 0) cur.add(x - 1);
			}
			
			if(arr1[i] > 0)
			{
				if(cur.size() == 3) delay += arr1[i];
				else
				{
					if(delay > 0) 
					{
						while(cur.size() < 3)
						{
							delay--;
							cur.add(time);
						}
						delay++;
					}
					else
					{
						while(cur.size() < 3 && arr1[i] > 0)
						{
							arr1[i]--;
							cur.add(time);
						}
						while(arr1[i] > 0)
						{
							arr1[i]--;
							delay++;
						}
					}
				}
			}
		}
		
		if(cur.size() > 0 || delay > 0)
		{
			while(!cur.isEmpty())
			{
				step1++;
				size = cur.size();
				for(int i = 0; i < size; i++)
				{
					int x = cur.poll();
					if(x - 1 > 0) cur.add(x - 1);
				}
				
				if(delay > 0)
				{
					while(cur.size() < 3)
					{
						cur.add(time);
						delay--;
					}
				}
			}
		}
		
		//2번 계단
		time = arr[stairs[1].x][stairs[1].y];
		delay = 0;
		
		for(int i = 0; i <= max2; i++)
		{
			step2++;
			size = cur.size();
			for(int k = 0; k < size; k++)
			{
				int x = cur.poll();
				if(x - 1 > 0) cur.add(x - 1);
			}
			
			if(arr2[i] > 0)
			{
				if(cur.size() == 3) delay += arr2[i];
				else
				{
					if(delay > 0) 
					{
						while(cur.size() < 3)
						{
							delay--;
							cur.add(time);
						}
						delay++;
					}
					else
					{
						while(cur.size() < 3 && arr2[i] > 0)
						{
							arr2[i]--;
							cur.add(time);
						}
						while(arr2[i] > 0)
						{
							arr2[i]--;
							delay++;
						}
					}
				}
			}
		}
		
		if(cur.size() > 0 || delay > 0)
		{
			while(!cur.isEmpty())
			{
				step2++;
				size = cur.size();
				for(int i = 0; i < size; i++)
				{
					int x = cur.poll();
					if(x - 1 > 0) cur.add(x - 1);
				}
				
				if(delay > 0)
				{
					while(cur.size() < 3)
					{
						cur.add(time);
						delay--;
					}
				}
			}
		}
		
//		if(chk == (1<<4)-1)
//			System.out.println(step1 + " " + step2);
//		System.out.println(step1 + " " + step2);
		res = Math.min(res, Math.max(step2, step1));
	}
}
class Pair implements Comparable<Pair>{
	int x, y;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		return o.y > this.y ? -1 : 1;
	}
}