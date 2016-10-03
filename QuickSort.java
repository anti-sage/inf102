import edu.princeton.cs.algs4.In; import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
public class QuickSort { // better generics than in the book
  
public static void sort(int[] a) {
  StdRandom.shuffle(a);  // bad for demo, not needed in randomized experiments
  quicksort(a,0,a.length-1);
}

public static void quicksort(int[] a, int lo, int hi) {
  if (lo>=hi) return;
  int m = partition(a,lo,hi);
  assert show(m,a); // misuse of assert, good for demo
  quicksort(a,lo,m-1);
  quicksort(a,m+1,hi);
}

public static int partition(int[] a, int lo, int hi) {
  int v = a[lo];
  int l=lo, h=hi;
  for(;;){ // inv: if lo<=i<=l, then !less(v,a[i]); if h<j<=hi, then less(v,a[j]) 
    while (less(v,a[h])) h--; // inv: l<=h
    while (l<h && !less(v,a[l+1])) l++; // inv: l<=h
 // postcondition: l<=h && !less(v,a[h]) && !(l<h && less(a[l+1],v))  
    if (l+1<h) {exch(a,l+1,h); l++;} else break;
  }
  exch(a,l,lo); // not always needed
  return l;  
}

private static boolean less(int v, int w){
  return v < w; }

private static void exch(int[] a, int i, int j){
  int t = a[i]; a[i] = a[j]; a[j] = t; }

private static boolean show(int m, int[] a){
  StdOut.print("pivot position " + m + " in \t");
  for (int key : a) StdOut.print(key + " "); StdOut.println(); return true;}

public static boolean isSorted(int[] a){
  for (int i=1; i<a.length; i++) if (less(a[i],a[i-1])) return false;
  return true;}
}//End of QuickSort based on Algorithms, 4th Edition, p. 278