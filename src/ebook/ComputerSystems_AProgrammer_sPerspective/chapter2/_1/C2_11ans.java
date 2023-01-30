package ebook.ComputerSystems_AProgrammer_sPerspective.chapter2._1;

public class C2_11ans {
    public static void main(String[] args) {
        C2_11ans c = new C2_11ans();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        c.reverse_array(arr, arr.length);
        for (int i = 0; i < c.arr.length; i++) {
            System.out.println(c.arr[i]);
        }
    }


    int[] arr;

    void reverse_array(int a[], int cnt) {
        this.arr = a;
        int first, last;
        for (first = 0, last = cnt - 1; first < last; first++, last--) {
            inplace_swap(first, last);
        }
    }

    void inplace_swap(int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    void reverse_array_wrong(int a[], int cnt) {
        this.arr = a;
        int first, last;
        for (first = 0, last = cnt - 1; first <= last; first++, last--) {
            inplace_swap(first, last);
        }
    }
}
