package symboltables;

public interface SymbolTable<Key extends Comparable<Key>, Value> {

    /**
     * Put key value pair into the table
     * @param key
     * @param value
     */
    public void put(Key key, Value value);

    /**
     * get value paired with Key
     * @param key
     * @return
     */
    public Value get(Key key);

    /**
     * remove key and its associated value
     * @param key
     */
    public void delete(Key key);

    /**
     * all keys in the table, in sorted order
     * @return
     */
    public Iterable<Key> keys();

    /**
     * Is there a value paired with the key
     * @param key
     * @return
     */
    default boolean contains(Key key){
        return get(key)!=null;
    }

    /**
     * is the table empty?
     * @return
     */
    public boolean isEmpty();

    /**
     * number of key-value pairs
     * @return
     */
    public int size();

    /**
     * minimum key in the table
     * @return
     */
    public Key min();

    /**
     * maximum key in the table
     * @return
     */
    public Key max();

    /**
     * largest key less than or equal to key
     * @param key
     * @return
     */
    public Key floor(Key key);

    /**
     * smallest key greater than or equal to key
     * @param key
     * @return
     */
    public Key ceiling(Key key);

    /**
     * number of keys less than key
     * @param key
     * @return
     */
    public int rank(Key key);

    /**
     * Key of rank k
     * @param k
     * @return
     */
    public Key select(int k);

    /**
     * delete smallest key
     */
    public void deleteMin();

    /**
     * delete largest key
     */
    public void deleteMax();

    /**
     * Number of keys between lo & hi
     * @param lo
     * @param hi
     * @return
     */
    public int size(Key lo, Key hi);

    /**
     * keys m [lo..hi] in sorted order
     * @param lo
     * @param hi
     * @return
     */
    public Iterable<Key> keys(Key lo, Key hi);
}
