import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.LinearRegression;

public class Countsort {
 	public static Random r = new Random();
	public static List<Double> keys = new ArrayList<>();
	public static List<Double> values = new ArrayList<>();

	public static void main(String[] args) {
        test(1600000);
        test(3200000);
        test(6400000);
        test(12800000);
        test(25600000);
        test(51200000);
        test(102400000);
        test(204800000);
        
		LinearRegression lg = new LinearRegression(toArray(keys), toArray(values));
		System.out.println("With shuffle, slope: " + lg.slope() + ", intercept: " + lg.intercept());
	}
	
	public static double[] toArray(List<Double> list) {
		double[] arr = new double[list.size()];
		for(int i = 0; i < list.size(); ++i) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	public static void test(int size) {
		int[] array = genIntArray(size);
		int[] array2 = Arrays.copyOf(array, size);

		Stopwatch watch = new Stopwatch();
		sort(array, 100000000);
		values.add(Math.log(watch.elapsedTime())/Math.log(2));
		keys.add(Math.log(size)/Math.log(2));
	}

	public static int[] genIntArray(int size) {
		int[] arr = new int[size];

		for(int i = 0; i < size; ++i) {
			arr[i] = r.nextInt(100000000);
		}

		return arr;
	}
	
	public static void sort(int[] arr, int max) {
		int[] counts = new int[max];
		
		for(int i = 0; i < arr.length; ++i) {
			counts[arr[i]]++;
		}
		
		int index = 0;
		
		for(int i = 0; i < counts.length; ++i) {
			for(int j = 0; j < counts[i]; ++j) {
				arr[index++] = i;
			}
		}
	}
}
