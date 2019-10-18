import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = Integer.parseInt(br.readLine());
        	int res = 0;
        	int idx = 1;
        	HashMap<String, Integer> hs = new HashMap<>();
        	hs.put("root", 0);
        	ArrayList<Integer>[] arr = new ArrayList[201];
        	String[] name = new String[201], str;
        	int[] parent = new int[201];
        	name[0] = "root";
        	for(int i = 0; i <= 200; i++)
        		arr[i] = new ArrayList<>();
        	boolean[] chk = new boolean[201];
        	Queue<Integer> q = new LinkedList<>();
        	StringTokenizer st;
        	for(int i = 0; i < N; i++)
        	{
//        		st = new StringTokenizer(br.readLine());
        		str = br.readLine().split(" ");
        		switch(str[0]){
        		case "Add":
        			if(hs.containsKey(str[1]))
        			{
        				if(arr[hs.get(str[1])].size() >= 4) break;
        				if(hs.containsKey(str[2]))
        					arr[hs.get(str[1])].add(hs.get(str[2]));
        				else
        				{
        					hs.put(str[2], idx);
        					name[idx] = str[2];
        					idx++;
        					arr[hs.get(str[1])].add(hs.get(str[2]));
        				}
        			}
        			else if(!hs.containsKey(str[1]))
        			{
        				hs.put(str[1], idx);
        				name[idx] = str[1];
        				idx++;
        				if(hs.containsKey(str[2]))
        					arr[hs.get(str[1])].add(hs.get(str[2]));
        				else
        				{
        					hs.put(str[2], idx);
        					name[idx] = str[2];
        					idx++;
        					arr[hs.get(str[1])].add(hs.get(str[2]));
        				}
        			}
        			parent[hs.get(str[2])] = hs.get(str[1]);
        			break;
        		case "Delete": 
        			q.clear();
        			for(int j = 0; j < arr[parent[hs.get(str[1])]].size(); j++)
        				if(arr[parent[hs.get(str[1])]].get(j) == hs.get(str[1]))
        				{
        					arr[parent[hs.get(str[1])]].remove(j);
        					break;
        				}
        			q.add(hs.get(str[1]));
        			chk[hs.get(str[1])] = true;
        			while(!q.isEmpty())
        			{
        				int x = q.poll();
        				hs.remove(name[x]);
        				name[x] = "";
        				int size = arr[x].size();
        				for(int j = size - 1; j >= 0; j--)
        				{
        					int next = arr[x].get(j);
        					if(chk[next]) continue;
        					chk[next] = true;
        					q.add(next);
        					arr[x].remove(j);
        				}
//        				arr[x].clear();
        			}
        			break;
        		case "Search": 
        			q.clear();
        			q.add(hs.get(str[1]));
        			chk[hs.get(str[1])] = true;
        			while(!q.isEmpty())
        			{
        				int x = q.poll();
//        				System.out.println(name[x]);
        				res++;
        				for(int next : arr[x])
        				{
        					if(chk[next]) continue;
        					chk[next] = true;
        					q.add(next);
        				}
        			}
        			break;
        		}
//        		for(int a = 0; a < idx; a++)
//            	{
//            		if(arr[a].isEmpty()) continue;
//            		System.out.print(name[a] + " : ");
//            		for(int j : arr[a])
//            			System.out.print(name[j] + " ");
//            		System.out.println();
//            	}
//        		System.out.println("===============");
        	}
        	bw.write("#" + test_case + " " + (res-1)+"\n");
        }
        bw.flush();
    }
}