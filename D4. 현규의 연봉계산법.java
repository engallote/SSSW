import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	long N = sc.nextLong();
        	int M = sc.nextInt();
        	
        	if(N == 2016)
        		System.out.println("#" + test_case + " " + N + " " + M);
        	else
        	{
        		if((N - 2015) % 13 == 0)
        		{
        			long newYear = N - ((N - 2015) / 13);
            		String yearString = "";
            		int idx = Double.toString(newYear).indexOf('E');
            		if(idx != -1)
            		{
            			char[] c = Double.toString(newYear).toCharArray();
            			yearString = "";
            			for(int i = 0; i < idx; i++)
            				if(c[i] != '.') yearString += "" + c[i];
            			System.out.println("#" + test_case + " " + yearString + " " + (M+1));
            		}
            		else
            		{
            			System.out.println("#" + test_case + " " + newYear + " " + (M+1));
            		}
        			
        		}
        		else
        		{
        			long NN = N;
        			
        			while((NN - 2015) % 13 != 0)
        			{
//        				System.out.println(NN);
        				NN++;
        			}
        			long MM = NN - ((NN - 2015) / 13), M2 = 12, M1 = 13;
//        			System.out.println("> " + MM + " " + NN);
        			while(NN > N)
        			{
        				MM--;
        				NN--;
        				M2--;
        				
        				if(M2 == 0)
        				{
        					NN--;
        					M2 = 12;
        				}
        			}
//        			System.out.println(">> " + MM + " " + M1 + ", " + NN + " " + M2);
        			if(NN > N)
        			{
        				while(NN > N)
        				{
        					M2--;
        					if(M2 == 0)
        					{
        						NN--;
        						M2 = 12;
        					}
        					M1--;
        					if(M1 == 0)
        					{
        						M1 = 13;
        						MM--;
        					}
        				}
        			}
        			else if(NN < N)
        			{
        				while(NN < N)
        				{
        					M2++;
        					if(M2 > 12)
        					{
        						NN++;
        						M2 = 1;
        					}
        					M1++;
        					if(M1 > 13)
        					{
        						M1 = 1;
        						MM++;
        					}
        				}
        			}
        			if(M2 > M && NN == N)
        			{
        				while(M2 > M)
        				{
        					M2--;
        					if(M2 == 0)
        					{
        						NN--;
        						M2 = 12;
        					}
        					M1--;
        					if(M1 == 0)
        					{
        						M1 = 13;
        						MM--;
        					}
        				}
        			}
        			else if(M2 < M && NN == N)
        			{
        				while(M2 < M)
        				{
        					M2++;
        					if(M2 > 12)
        					{
        						NN++;
        						M2 = 1;
        					}
        					M1++;
        					if(M1 > 13)
        					{
        						M1 = 1;
        						MM++;
        					}
        				}
        			}
//        			System.out.println(">> " + MM + " " + M1 + ", " + NN + " " + M2);
        			
        			System.out.println("#" + test_case + " " + MM + " " + M1);
        		}
        	}
        }
	}
}