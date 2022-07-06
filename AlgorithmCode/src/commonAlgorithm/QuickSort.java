package commonAlgorithm;

public class QuickSort {
    public static void main(String[] args) {
           int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i]=(int) (Math.random()*100);
//            ints[i]=50;
//            if (i%3==0){
//                ints[i]=3;
//            }
        }



        qs(ints,0,ints.length-1);
        for  (int i = 0; i <ints.length; i++) {
            System.out.println(ints[i]);
        }
        System.out.println(ints);
            /*

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arr.add((int)(Math.random()*1000));
        }

        arr = quickSort(arr);
*/

    }

    private static void   qs(int[] arr,int start,int end){

        if (start>=end){
           return;
        }

        int left = start;
        int right = end;
        int k  = arr[left];
        while(left < right){
            while(left<right&&arr[right]>=k){
                right--;
            }
            arr[left]=arr[right];
            while(left<right&&arr[left]<k){
                left++;
            }
            arr[right]=arr[left];

        }
        arr[left]=k;
        qs(arr,start,left-1);
        qs(arr,right+1,end);


    }
}
