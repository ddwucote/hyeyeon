import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visit;
	static int[] result;
	static int cnt = 0;
	static int cnt2 = 0;
	static StringBuilder sb = new StringBuilder();
	
	//전체
	static void dfs(int start, int depth, int n) {
		if(depth == n) {
			cnt++;
			return;
		}
		
		for(int i=start;i<N*M;i++) {
			if(!visit[i]) {
				visit[i] = true;
				result[depth] = i+1;
				dfs(i, depth+1, n);
				visit[i] = false;
			}

		}
	}
	
	
	static void dfs2(int start, int depth, int n) {
		if(depth == n) {
			cnt2++;
			return;
		}		
		
		for(int i=start;i<N*M;i++) {
			if(!visit[i]) {
				visit[i] = true;
				result[depth] = i+1;
				dfs2(i, depth+1, n);
				visit[i] = false;
			}

		}
	}
	
	static int sum(int n) {
		int total = 0;
		for(int i=1;i<=M;i++) {
			total += 3*(N+2*(i-1)-4)+1;
		}
		return total;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N*M];

		for(int i=0;i<=N*M;i++) {
			result = new int[i];
			dfs(0, 0, i);
		}

		result = new int[N*M];
		if(N*M<=4) {
			dfs2(0, 0, N*M);
		}
		else {
			for(int j=2;j<=N;j++) {
				for(int i=3;i<=M;i++) {
					cnt2 += 3*(j+2*(i-1)-4)+1;
				}
			}
			
		
		}
		System.out.println(cnt);
		System.out.println(cnt2);
		System.out.println(cnt-cnt2);
	}
}
