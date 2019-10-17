import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	double res = 0;
        	int N = sc.nextInt();
        	int K = sc.nextInt();
        	PriorityQueue<Double> pq = new PriorityQueue<>();
        	for(int i = 0; i < N; i++)
        		pq.add(sc.nextDouble());
        	
        	while(pq.size() > K)
        		pq.poll();
        	
        	double A = 0, M = 0;
        	while(!pq.isEmpty())
        	{
        		M = pq.poll();
        		res = (A + M) / 2;
        		A = res;
        	}
        	
        	System.out.printf("#%d %.6f\n", test_case, res);
        }
    }
}