import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int t = 1; t <= tc; t++)
        {
        	String num = sc.next();
        	int N = sc.nextInt();
        	String[] arr = new String[10];
        	Arrays.fill(arr, "");
        	for(int i = 0; i < N; i++)
        	{
        		String s = sc.next();
        		switch(s)
        		{
        		case "ZRO":
        			arr[0] += s + " ";
        			break;
        		case "ONE":
        			arr[1] += s + " ";
        			break;
        		case "TWO":
        			arr[2] += s + " ";
        			break;
        		case "THR":
        			arr[3] += s + " ";
        			break;
        		case "FOR":
        			arr[4] += s + " ";
        			break;
        		case "FIV":
        			arr[5] += s + " ";
        			break;
        		case "SIX":
        			arr[6] += s + " ";
        			break;
        		case "SVN":
        			arr[7] += s + " ";
        			break;
        		case "EGT":
        			arr[8] += s + " ";
        			break;
        		case "NIN":
        			arr[9] += s + " ";
        			break;
        		}
        	}
        	
        	System.out.println(num);
        	for(int i = 0; i < 10; i++)
        		System.out.print(arr[i]);
        	System.out.println();
        }
    }
}