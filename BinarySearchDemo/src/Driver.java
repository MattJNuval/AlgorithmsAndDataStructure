public class Driver {

    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();

        int[] a = {2,1,23,5,8,1,9};

        b.mergeSort(a,0,a.length-1);

        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        b.search(3,a,0,a.length-1);

    }
}
