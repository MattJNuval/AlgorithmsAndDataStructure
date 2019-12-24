public class BinarySearch {

    public void search(int target, int data[], int left, int right) {
        if(right > left) {
            int middle = left +(right-left)/2;
            printLR(data, left, right);
            System.out.println("\nCurrent left: " + left + "\n"
                    + "Current middle: " + middle + "\n"
                    + "Current right: " + right);
            if(data[middle] == target || data[left] == target || data[right] == target) {
                System.out.println("\nFound " + target);
                return;
            }
            if(target <= data[middle]) {
                search(target,data,left,middle);
            } else if(target >= data[middle]) {
                search(target,data,middle,right);
            }

        }
    }


    public void printLR(int[] data, int left, int right) {
        for(int i = left; i < right; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public void sort(int[] data, int low, int high) {
        if(low < high) {
            int pi = partition(data, low, high);

            sort(data, pi +1, high);
            sort(data, low, pi-1);
        }
    }

    public int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = (low - 1);
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
        return i+1 ;
    }
}
