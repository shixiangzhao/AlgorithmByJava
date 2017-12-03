package shixzh.abj.markallen;

public class BinarySearch {

    private static final int NOT_FOUND = -1;

    public static void main(String[] args) {
        int count = 10;
        Integer[] a = TestDataUtil.getOrderIntegerArray(count);
        System.out.println("result: " + binarySearch(a, 9));
    }

    /**
     * Performs the standard search.
     * 
     * @param a
     * @param x
     * @return index while item is found, or -1 if not found.
     */
    public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType[] a, AnyType x) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (x.compareTo(a[mid]) > 0) {
                low = mid + 1;
            } else if (x.compareTo(a[mid]) < 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return NOT_FOUND;
    }
}
