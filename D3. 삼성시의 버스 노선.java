import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	int[][] bus = new int[N][2];
        	
        	for(int i = 0; i < N; i++)
        	{
        		bus[i][0] = sc.nextInt();
        		bus[i][1] = sc.nextInt();
        	}
        	
        	int P = sc.nextInt();
        	int[] p = new int[P];
        	int[] arr = new int[P];
        	for(int i = 0; i < P; i++)
        		p[i] = sc.nextInt();
        	
        	for(int i = 0; i < P; i++)
        	{
        		for(int j = 0; j < N; j++)
        			if(bus[j][0] <= p[i] && p[i] <= bus[j][1])
        				arr[i]++;
        	}
        	
        	System.out.print("#" + test_case + " ");
        	for(int i = 0; i < P; i++)
        		System.out.print(arr[i] + " ");
        	System.out.println();
        }
    }
}