/**
 * Lab 1 — Arrays & loops. Implement the bodies.
 * See ../README.md
 */
public class ArrayLoopsLab {

    /** Reverse array in place. */
    public static void reverse(int[] data) {
        int left = 0;
        int right = data.length - 1;

        while (left < right) {
            int value = data[left];
            data[left] = data[right];
            data[right] = value;

            left++;
            right--;
        }
    }

    /** Smallest element; illegal if null or empty. */
    public static int min(int[] data) {
        if (data == null | data.length == 0) {
            throw new IllegalArgumentException();
        }
        int min = data[0];
        for (int i = 1; i < data.length; i++){
            if (data[i] < min){
                min = data[i];
            }
        }
        return min;
    }

    /** Largest element; illegal if null or empty. */
    public static int max(int[] data) {
        int max = data[0];

        for (int i = 1; i < data.length; i++){
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    /** In-place ascending sort using nested loops only (no Arrays.sort). */
    // Using Selection Sort, which has the time omplexity of O(n^2)
    public static void sortAscending(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for(int j = i +1; j < data.length; j++){
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int value = data[i];
            data[i] = data[minIndex];
            data[minIndex] = value;
        }
    }

    public static void main(String[] args) {
        int[] data = {5, 2, 9, 1, 4};

        System.out.println("original: " + java.util.Arrays.toString(data));
        System.out.println("min: " + min(data));
        System.out.println("max: " + max(data));

        reverse(data);
        System.out.println("reversed: " + java.util.Arrays.toString(data));

        sortAscending(data);
        System.out.println("sorted ascending: " + java.util.Arrays.toString(data));
    }
}
