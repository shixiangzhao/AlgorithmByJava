package shixzh.abj.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] cap = { 1, 3, 4, 5, 7, 8 };
        binarySearch(cap, 9);
    }

    public static int binarySearch(int[] cap, int tar) {
        int fir = 0;
        int las = cap.length - 1;
        while (las >= fir) {
            int mid = (fir + las) / 2;
            if (cap[mid] < tar) {
                fir = mid + 1;
            }
            if (cap[mid] > tar) {
                las = mid - 1;
            }
            if (cap[mid] == tar) {
                System.out.println("Find it, index is " + (mid + 1));
                return mid;
            }
        }
        System.out.println("No funnd!");
        return -1;
    }

}
