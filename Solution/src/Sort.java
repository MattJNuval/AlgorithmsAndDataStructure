public class Sort {

    public void selectionSort(int[] data) {
        for(int i = 0; i < data.length; i++) {
            int min_index = i;
            for(int j = i+1; j < data.length; j++) {
                if(data[j] < data[min_index]) {
                    min_index = j;
                }
            }
            int temp = data[i];
            data[i] = data[min_index];
            data[min_index] = temp;
        }
    }

    public void insertionSort(int[] data) {
        for(int i = 0; i < data.length; i++) {
            int key = data[i];
            int j = i-1;
            while(j >= 0 && data[j] > key) {
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = key;
        }
    }

    public void quickSort(int[] data, int low, int high) {
        if(high > low) {
            int pi = partition(data, low, high);

            quickSort(data, low, pi-1);
            quickSort(data, pi+1, high);
        }
    }

    private int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = low-1;

        for(int j = low; j < high; j++) {
            if(data[j] < pivot) {
                i++;

                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        int temp = data[i+1];
        data[i+1] = data[high];
        data[high] = temp;

        return i+1;
    }

}
