
public class Heap {
    int arr[];
    int size;   // ye wala hoga initialize.
    Heap(int size){
        arr = new int[size];
        arr[0] = -1;
        this.size = 0;      // kya soch raha hai bhai, upar dekh.
    }
    void insert(int val){
        size = size + 1;
        int index = size;
        arr[index] = val;

        while(index > 1){

            int parent = index / 2;

            // compare
            if(arr[parent] < arr[index]){
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
                index = parent;
            }
            else{
                return;
            }
        }
    }
    void deleteRootElementFromTheHeap(){
        if(size == 0){
            System.out.println("Nothing to delete..");
            return;
        }

        // step-1
        arr[1] = arr[size];

        // step-2
        size--;

        // step-3        take root node to its correct position..
        int i = 1;
        while(i < size){
            int left_child = 2*i;
            int right_child = 2*i+1;

            if(left_child < size && arr[i] < arr[left_child]){
                int temp = arr[i];
                arr[i] = arr[left_child];
                arr[left_child] = temp;
                i = left_child;
            }else if(right_child < size && arr[i] < arr[right_child]){
                int temp = arr[i];
                arr[i] = arr[right_child];
                arr[right_child] = temp;
                i = right_child;
            }
            return;
        }
    }
    void heapify(int arr[], int size ,int i){
        // maxHeap

        int parent = i;
        int left_child = 2*i;
        int right_child = 2*i+1;

        if(left_child < size && arr[parent] < arr[left_child]){
            parent = left_child;
        }
        if(right_child < size && arr[parent] < arr[right_child]){
            parent = right_child;
        }

        if(parent != i){
            int temp = arr[parent];
            arr[parent] = arr[i];
            arr[i] = temp;

            heapify(arr,size,parent);
        }
    }


    void print(){
        for(int i = 1; i <= size; i++){
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String args[]){
        Heap obj = new Heap(100);
        obj.insert(50);
        obj.insert(55);
        obj.insert(53);
        obj.insert(54);
        obj.insert(70);

        obj.print();

        System.out.println("\n--let me delete---");


        obj.deleteRootElementFromTheHeap();
        obj.print();

        System.out.println("\n---heapify----");
        int arr[] = {-1,54,53,55,52,50};
        int size = arr.length-1;
        for(int i = size/2; i > 0; i--){
            obj.heapify(arr,arr.length-1,i);
        }

        for(int i = 1; i <= size; i++){
            System.out.print(arr[i] + " ");
        }


    }
}
