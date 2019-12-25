public class Sort {

    public void bubbleSort(int[] data) {
        for(int i = 0; i < data.length; i++) {
            // i was added to adjust the size of the array accordingly
            for(int j = 0; j < data.length - i-1; j++) {
                if(data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

    public void quickSort(int[] data, int low, int high) {
        if(low < high) {
            int pi = partition(data, low, high);

            quickSort(data,pi+1, high);
            quickSort(data, low, pi-1);
        }
    }

    private int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = (low-1);

        for(int j = low; j < high; j++) {
            if(data[j] < pivot) {
                i++;

                int temp = data[i];
                data[i] = data[j];
                data[j] = data[i];
            }
        }

        int temp  = data[i+1];
        data[i+1] = data[high];
        data[high] = temp;
        return i+1;
    }

    public void mergeSort(int[] data, int left, int right) {
        if(left < right) {
            int middle = (left+right)/2;

            mergeSort(data, left, middle);
            mergeSort(data, middle+1, right);
            merge(data, left, middle, right);
        }
    }

    private void merge(int[] data, int left, int middle, int right) {
        int slm = middle-left+1;
        int smr = right-middle;

        int[] lm = new int[slm];
        int[] mr = new int[smr];

        for(int i = 0; i < slm; i++) {
            lm[i] = data[left+i];
        }
        for(int j = 0; j < smr; j++) {
            mr[j] = data[middle+1+j];
        }

        int lc =0;
        int rc =0;
        int tc =left;

        while(lc < slm && rc < smr) {
            if(lm[lc] <= mr[rc]) {
                data[tc] = lm[lc];

                lc++;
                tc++;
            } else {
                data[tc] = mr[rc];

                rc++;
                tc++;
            }
        }

        while(lc < slm ){
            data[tc] = lm[lc];

            lc++;
            tc++;
        }
        while(rc < smr){
            data[tc] = mr[rc];

            rc++;
            tc++;
        }
    }




}
