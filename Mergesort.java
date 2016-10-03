public class Mergesort {
	public static void main(String[] args) {
		int[] a = {4, 2, 7, 3, 1, 5, 345, 3, 236, 45, 234, 23, 45, 456, 3456, 345, 6};
		sort(a);
		for(int b : a) { System.out.println(b); }
	}
	
	public static void sort(int[] list) {
		sortPartition(list, 0, list.length - 1);
	}
	
	public static void sortPartition(int[] list, int start, int end) {
		if(end - start < 1) return;
		else if (end - start == 1) {
			if(list[end] < list[start]) {
				swap(list, start, end);
			}
		}
		else {
			sortPartition(list, start, getCenter(start, end));
			sortPartition(list, getCenter(start, end) + 1, end);
			merge(list, start, getCenter(start, end), end);
		}
	}
	
	public static int getCenter(int start, int end) {
		return ((end - start) / 2) + start;
	}
	
	public static void merge(int[] list, int start, int center, int end) {
		int[] res = new int[list.length];
		int pos = start, i = start, j = center + 1;
		
		for(; i <= center && j <= end;) {
			if(list[i] < list[j]) {
				res[pos] = list[i];
				i++;
			} else {
				res[pos] = list[j];
				j++;
			}
			
			pos++;
		}
		
		while(i <= center) {
			res[pos] = list[i];
			i++;
			pos++;
		}
		
		while(j <= end) {
			res[pos] = list[j];
			j++;
			pos++;
		}
		
		System.arraycopy(res, start, list, start, end - start + 1);
	}
	
	public static void swap(int[] list, int a, int b) {
		int tmp = list[a];
		list[a] = list[b];
		list[b] = tmp;
	}
}