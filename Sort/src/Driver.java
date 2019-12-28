public class Driver {

    public static void main(String[] args) {
        int[] arr = {2,3,5,7,4,1};

        Sort s = new Sort();
        s.insertionSort(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.print( arr[i]+", ");
        }



    }





}
