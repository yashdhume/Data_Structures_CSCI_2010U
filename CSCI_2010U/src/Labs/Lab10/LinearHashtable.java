package Labs.Lab10;

public class LinearHashtable<T> extends  Hashtable<T>{
    public LinearHashtable(int capacity){
        super(capacity);
    }

    @Override
    public int rehash(int previousHash) {
       if (this.capacity<previousHash+1)
            return (previousHash+1)%this.capacity;
        else return (previousHash+1);
    }
}
