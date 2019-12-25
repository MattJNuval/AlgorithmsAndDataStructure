public class Driver {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 7, 7, 4, 8, 9, 0};

        Sort s = new Sort();
        s.mergeSort(arr,0,arr.length-1);

        for(int i = 0; i < arr.length; i++) {
            System.out.print( arr[i]+", ");
        }



    }





}
