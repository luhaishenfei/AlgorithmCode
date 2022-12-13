package commonAlgorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,8,9,11,12,15,53};
        System.out.println(BinarySearch.binarySearch(arr, -1));
    }

    public static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length);
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        for (int i = start; i < end; i++) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return binarySearch(arr,target,mid+1,end);
            } else {
                return binarySearch(arr,target,start,end-1);
            }
        }
        return -1;
    }
}
