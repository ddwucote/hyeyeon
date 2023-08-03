import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = "";
		HashMap<String, Integer> tree = new HashMap<>();
		
		int total = 0;
		//input 안 받으면 입력 종료
		while(true) {
			input=br.readLine();
			if(input==null||input.equals(""))
				break;
			tree.put(input, tree.getOrDefault(input, 0)+1);
			total++;
		}
		
		List<String> keyArr = new ArrayList<>(tree.keySet());
		Collections.sort(keyArr);
		
		for(int i=0;i<keyArr.size();i++) {
			sb.append(keyArr.get(i)+" "+String.format("%.4f",(double)tree.get(keyArr.get(i))*100/(double)total)+"\n");
		}
		
		System.out.println(sb);
	}
}
