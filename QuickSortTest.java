import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.LinearRegression;

public class QuickSortTest {
	public static Random r = new Random();

	public static void main(String[] args) {
		List<Double> wsk = new ArrayList<>();
		List<Double> wsv = new ArrayList<>();
		List<Double> nsk = new ArrayList<>();
		List<Double> nsv = new ArrayList<>();

		test(50000, wsk, wsv, nsk, nsv);
		test(100000, wsk, wsv, nsk, nsv);
		test(200000, wsk, wsv, nsk, nsv);
		test(400000, wsk, wsv, nsk, nsv);
		test(800000, wsk, wsv, nsk, nsv);
		test(1600000, wsk, wsv, nsk, nsv);
		test(3200000, wsk, wsv, nsk, nsv);

		LinearRegression lg = new LinearRegression(toArray(wsk), toArray(wsv));
		System.out.println("With shuffle, slope: " + lg.slope() + ", intercept: " + lg.intercept());
		
		LinearRegression lg2 = new LinearRegression(toArray(nsk), toArray(nsv));
		System.out.println("No shuffle, slope: " + lg2.slope() + ", intercept: " + lg2.intercept());
	}
	
	public static double[] toArray(List<Double> list) {
		double[] arr = new double[list.size()];
		for(int i = 0; i < list.size(); ++i) {
			arr[i] = list.get(i);
		}
		return arr;
	}
	
	public static void test(int size, List<Double> withShuffleKeys, List<Double> withShuffleValues, List<Double> noShuffleKeys, List<Double> noShuffleValues) {
		int[] array = genIntArray(size);
		int[] array2 = Arrays.copyOf(array, size);
		
		Stopwatch watch = new Stopwatch();
		QuickSort.sort(array);
		withShuffleValues.add(Math.log(watch.elapsedTime())/Math.log(2));
		withShuffleKeys.add(Math.log(size)/Math.log(2));
		
		watch = new Stopwatch();
		QuickSortNoShuffle.sort(array2);
		noShuffleValues.add(Math.log(watch.elapsedTime())/Math.log(2));
		noShuffleKeys.add(Math.log(size)/Math.log(2));
	}
	
	public static int[] genIntArray(int size) {
		int[] arr = new int[size];

		for(int i = 0; i < size; ++i) {
			arr[i] = r.nextInt(1000);
		}
		
		return arr;
	}
}