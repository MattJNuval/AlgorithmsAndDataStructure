public class Driver {

    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();

        int[] a = {2,1,23,5,8,1,9};

        b.sort(a,0,a.length-1);


        b.search(9,a,0,a.length-1);

    }
}
