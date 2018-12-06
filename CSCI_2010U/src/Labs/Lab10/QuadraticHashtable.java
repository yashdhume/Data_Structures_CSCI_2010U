package Labs.Lab10;

public class QuadraticHashtable<T> extends Hashtable<T> {
    public QuadraticHashtable(int capacity){
        super(capacity);
    }

    @Override
    public int rehash(int previousHash) {
        if (this.capacity<previousHash*previousHash)
        return (previousHash*previousHash)%this.capacity;
        else return (previousHash*previousHash);
    }
}
