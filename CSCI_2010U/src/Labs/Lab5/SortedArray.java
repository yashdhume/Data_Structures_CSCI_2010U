package Labs.Lab5;

public class SortedArray {
    private Warrior[] arr;
    private int n;
    private int capacity;
    public int assignmentCount;
    public SortedArray(){
        arr = new Warrior[100];
        n=0;
        capacity= arr.length;
    }
    int insert(Warrior val){
        int key = val.getSpeed();
        if (n >= capacity) return n;
        int i;
       for ( i=n-1; (i >= 0 && arr[i].getSpeed() < key); i--){
            arr[i + 1] = arr[i];
            assignmentCount+=2;
        }
        arr[i+1] = val;
        n++;
        assignmentCount++;
        return (n+1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i =0; i <capacity; i++){
            sb.append(arr[i]+ " ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}

