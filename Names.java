import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Names {
	public static void main(String[] args) {
		String[] l1 = {"a","b"};
		String[] l2 = {"b","c"};
		String[] l3 = {"c","d"};
		String[] l4 = {"a","b"};
		
		String res = search(Arrays.asList(l1), Arrays.asList(l2), Arrays.asList(l3), Arrays.asList(l4));
		
		if(res != null) System.out.println("Found name: " + res);
		else System.out.println("No name found");
	}
	
	public static String search(List<String> l1, List<String> l2, List<String> l3, List<String> l4) {
		List<String> list = new ArrayList<>();
		list.addAll(l1);
		list.addAll(l2);
		list.addAll(l3);
		list.addAll(l4);
		
		Collections.sort(list);
		
		System.out.println(list);
		
		int count = 1;
		for(int i = 1; i < list.size(); ++i) {
			if(list.get(i).equals(list.get(i-1))) {
				count++;
				if(count == 3) return list.get(i);
			}
			else
				count = 1;
		}
		
		return null;
	}
}