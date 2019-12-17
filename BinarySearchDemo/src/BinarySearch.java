public class BinarySearch {

    public void search(int target, int data[], int left, int right) {
        int middle = (left+right)/2;
        if(middle == 0){
            System.out.println( target +" no found");
        } else if (target < data[middle]) {
            search(target,data,left,middle);
        } else if (target > data[middle]){
            search(target,data,middle+1,right);
        } else {
            System.out.println("Found em!!");
        }
    }

    public void mergeSort(int[] a, int l, int r) {
        if(r > l) {
            int m = (l+r)/2;
            mergeSort(a,l,m);
            mergeSort(a,m+1,r);
            merge(a,l,m,r);
        }
    }

    private void merge(int[] a, int l, int m, int r) {
        int slm = m-l+1;
        int smr = r-m;

        int[] lm = new int[slm];
        int[] mr = new int[smr];

        for(int i = 0; i < slm; i++) {
            lm[i] = a[l + i];
        }
        for(int j = 0; j < smr; j++) {
            mr[j] = a[m+1+j];
        }

        int lc = 0;
        int rc = 0;
        int tc = l;

        while(lc < slm && rc < smr) {
            if(lm[lc] <= mr[rc]) {
                a[tc] = lm[lc];
                lc++;

            } else {
                a[tc] = mr[rc];
                rc++;

            }
            tc++;
        }

        while(lc < slm) {
            a[tc] = lm[lc];
            lc++;
            tc++;
        }
        while(rc < smr) {
            a[tc] = mr[rc];
            rc++;
            tc++;
        }


    }
}
