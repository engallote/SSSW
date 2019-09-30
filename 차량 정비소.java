import java.util.*;

public class Main {
	static int N, M, K, A, B, res;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	M = sc.nextInt();
        	K = sc.nextInt();
        	A = sc.nextInt();
        	B = sc.nextInt();
        	res = 0;
        	int[] desk = new int[N+1], repair = new int[M+1];
        	int[] d = new int[N+1], r = new int[M+1], d2 = new int[N+1];
        	int[][] chk = new int[K+1][2];
        	ArrayList<Integer>[] arr = new ArrayList[1001];
        	Queue<Integer> wd = new LinkedList<>(), wr = new LinkedList<>();
        	
        	for(int i = 0; i <= 1000; i++)
        		arr[i] = new ArrayList<>();
        	
        	for(int i = 1; i <= N; i++)
        		desk[i] = sc.nextInt();
        	
        	for(int i = 1; i <= M; i++)
        		repair[i] = sc.nextInt();
        	
        	int max = 0, time = 0, cnt = K;
        	for(int i = 1; i <= K; i++)
        	{
        		int num = sc.nextInt();
        		max = Math.max(max, num);
        		arr[num].add(i);
        	}
        	
        	if(N == 1 && M == 1)
        	{
        		for(int i = 1; i <= K; i++)
        			res+=i;
        		System.out.println("#" + test_case + " " + res);
        		continue;
        	}
        	boolean flag = false;
        	for(int i = 0; i <= max; i++)
        	{
        		if(arr[i].size() > 0)
        			for(int x : arr[i]) wd.add(x);
        		
        		//접수 받기
        		while(!wd.isEmpty())
        		{
        			flag = false;
        			for(int t = 1; t <= N; t++)
        				if(d[t] == 0)
        				{
        					flag = true;
        					d[t] = desk[t];
        					d2[t] = wd.poll();
//        					System.out.println(i + "초에 " + t + "번 접수 : " + d2[t]);
        					chk[d2[t]][0] = t;
        					break;
        				}
        			if(!flag) break;
        		}
        		
        		//접수 진행
        		for(int t = 1; t <= N; t++)
        		{
        			if(d[t] == 0) continue;
        			d[t] -= 1;
        			if(d[t] == 0)
        				wr.add(d2[t]);
        		}
        		
        		//정비 진행
        		for(int t = 1; t <= M; t++)
        		{
        			if(r[t] == 0) continue;
        			r[t] -= 1;
        		}
        		
        		//정비 접수
        		while(!wr.isEmpty())
        		{
        			flag = false;
        			for(int t = 1; t <= M; t++)
        				if(r[t] == 0)
        				{
        					r[t] = repair[t];
        					int idx = wr.poll();
        					chk[idx][1] = t;
//        					System.out.println(i + "초에 " + t + "번 정비소 : " + idx);
        					flag = true;
        					cnt--;
        					break;
        				}
        			if(!flag) break;
        		}
        	}
        	time = max + 1;
        	
        	while(cnt > 0)
        	{
        		//접수 받기
        		while(!wd.isEmpty())
        		{
        			flag = false;
        			for(int t = 1; t <= N; t++)
        				if(d[t] == 0)
        				{
        					flag = true;
        					d[t] = desk[t];
        					d2[t] = wd.poll();
//        					System.out.println(time + "초에 " + t + "번 접수 : " + d2[t]);
        					chk[d2[t]][0] = t;
        					break;
        				}
        			if(!flag) break;
        		}
        		
        		//접수 진행
        		for(int t = 1; t <= N; t++)
        		{
        			if(d[t] == 0) continue;
        			d[t] -= 1;
        			if(d[t] == 0)
        				wr.add(d2[t]);
        		}
        		
        		//정비 진행
        		for(int t = 1; t <= M; t++)
        		{
        			if(r[t] == 0) continue;
        			r[t] -= 1;
        		}
        		
        		//정비 접수
        		while(!wr.isEmpty())
        		{
        			flag = false;
        			for(int t = 1; t <= M; t++)
        				if(r[t] == 0)
        				{
        					r[t] = repair[t];
        					int idx = wr.poll();
        					chk[idx][1] = t;
//        					System.out.println(time + "초에 " + t + "번 정비소 : " + idx);
        					flag = true;
        					cnt--;
        					break;
        				}
        			if(!flag) break;
        		}
        		time++;
        	}
        	
        	for(int i = 1; i <= K; i++)
        	{
//        		System.out.println(chk[i][0] + " " + chk[i][1]);
        		if(chk[i][0] == A && chk[i][1] == B) res += i;
        	}
            System.out.println("#" + test_case + " " + (res == 0 ? -1 : res));
        }
	}
}