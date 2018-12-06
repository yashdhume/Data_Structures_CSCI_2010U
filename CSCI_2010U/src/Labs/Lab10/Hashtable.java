package Labs.Lab10;
import java.util.ArrayList;
import java.util.List;

public abstract class Hashtable<T> {

    protected int capacity = 0;
    private List<String> keys = null;
    private List<T> values = null;
    private int probeCount = 0;

    public int getProbeCount() {
        return probeCount;
    }

    public void resetProbeCount() {
        this.probeCount = 0;
    }

    public Hashtable(int capacity) {
        this.keys = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            this.keys.add(null);
        }
        this.values = new ArrayList<T>();
        for (int i = 0; i < capacity; i++) {
            this.values.add(null);
        }
        this.capacity = capacity;
    }

    public int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++)
            sum += (int) key.charAt(i);
        return sum % capacity;
    }

    public abstract int rehash(int previousHash);

    public void insert(String key, T value) {
        int hash= hash(key);
        while(values.get(hash)!=null){
            hash=rehash(hash);
            probeCount++;
        }
        values.set(hash,value);
    }
}