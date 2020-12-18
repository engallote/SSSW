import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			bw.write("#" + test_case + " ");
			
			int cir = cSolve(a, b, p, q, r) + cSolve(a, d, p, q, r) + cSolve(c, b, p, q, r) + cSolve(c, d, p, q, r);
			int rec = rSolve(p, q + r, a, b, c, d) + rSolve(p, q - r, a, b, c, d) + rSolve(p + r, q, a, b, c, d) + rSolve(p - r, q, a, b, c, d);
			
			if(cir == 4 && rec == 4) bw.write("NN\n");
			else if(cir == 4) bw.write("YN\n");
			else if(rec == 4) bw.write("NY\n");
			else bw.write("YY\n");
		}
		bw.flush();
	}

	private static int rSolve(int x, int y, int a, int b, int c, int d) {
		if(a <= x && x <= c && b <= y && y <= d) return 1;
		return 0;
	}

	private static int cSolve(int x, int y, int p, int q, int r) {
		if((x - p) * (x - p) + (y - q) * (y - q) <= r * r) return 1;
		return 0;
	}
}