/**
 * Pair exercise — build sorted array, pick target, time both searches.
 * TODO: complete main after SearchLib is implemented.
 */
public class SearchBenchmark {

    public static void main(String[] args) {
        // TODO: size N, fill sorted even integers, pick target, time SearchLib.linearSearch vs binarySearch
        // Round 1 - N = 1,000,000
        int[] arr1 = buildSortedEvens(1_000_000);
        int target1 = arr1[500_000];

        long start = System.nanoTime();
        int linResult1 = SearchLib.linearSearch(arr1, target1);
        long linTime1 = System.nanoTime() - start;

        start = System.nanoTime();
        int binResult1 = SearchLib.binarySearch(arr1, target1);
        long binTime1 = System.nanoTime() - start;

        System.out.println("Round 1 N= 1,000,000 target=" + target1);
        System.out.println("Linear index =" + linResult1 + " time =" + linTime1 + "ns");
        System.out.println("Binary index =" + binResult1 + " time =" + binTime1 + "ns");

        // Round 2 - N = 5,000,000
        int[] arr2 = buildSortedEvens(5_000_000);
        int target2 = arr2[arr2.length - 1];

        start = System.nanoTime();
        int linResult2 = SearchLib.linearSearch(arr2, target2);
        long linTime2 = System.nanoTime() - start;

        start = System.nanoTime();
        int binResult2 = SearchLib.binarySearch(arr2, target2);
        long binTime2 = System.nanoTime() - start;

        System.out.println("Round 2 N= 5,000,000 target =" + target2);
        System.out.println("Linear index =" + linResult2 + " time =" + linTime2 + "ns");
        System.out.println("Binary index =" + binResult2 + " time =" + binTime2 + "ns");
    }

    static int[] buildSortedEvens(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i * 2;
        }
        return arr;
    }
}
