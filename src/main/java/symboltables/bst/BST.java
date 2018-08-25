package symboltables.bst;

import symboltables.SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class BST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {

    private Node<Key, Value> root;
    private int sz;

    /**
     * Put key value pair into the table
     *
     * @param key
     * @param value
     */
    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node<Key, Value> node, Key key, Value value){
        if(node==null) {
            sz++;
            return new Node<>(key, value);
        }
        int cmp = key.compareTo(node.getKey());
        if(cmp<0){
            node.setLeft(put(node.getLeft(), key, value));
        }else if(cmp>0) {
            node.setRight(put(node.getRight(), key, value));
        }else {
            node.setValue(value);
        }
        node.setCount(1+size(node.getLeft())+size(node.getRight()));
        return node;
    }

    /**
     * get value paired with Key
     *
     * @param key
     * @return
     */
    @Override
    public Value get(Key key) {
        Node<Key, Value> tempRoot = root;
        while(tempRoot!=null){
            int cmp = key.compareTo(tempRoot.getKey());
            if(cmp<0) tempRoot = tempRoot.getLeft();
            else if(cmp>0) tempRoot = tempRoot.getRight();
            else return tempRoot.getValue();
        }
        return null;
    }

    /**
     * remove key and its associated value
     *
     * @param key
     */
    @Override
    public void delete(Key key) {

    }

    /**
     * all keys in the table, in sorted order
     *
     * @return
     */
    @Override
    public Iterable<Key> keys() {
        List<Key> q = new ArrayList<>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node<Key, Value> node, List<Key> q){
        if(node==null) return;
        inorder(node.getLeft(), q);
        q.add(node.getKey());
        inorder(node.getRight(), q);
    }

    /**
     * is the table empty?
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return root==null;
    }

    /**
     * number of key-value pairs
     *
     * @return
     */
    @Override
    public int size() {
        return size(root);
    }

    private int size(Node<Key, Value> node){
        return node==null?0:node.getCount();
    }

    /**
     * minimum key in the table
     *
     * @return
     */
    @Override
    public Key min() {
        if(root==null){
            return null;
        }
        Node<Key, Value> tempRoot = root;
        while(tempRoot.getLeft()!=null) tempRoot = tempRoot.getLeft();
        return tempRoot.getKey();
    }

    /**
     * maximum key in the table
     *
     * @return
     */
    @Override
    public Key max() {
        if(root==null){
            return null;
        }
        Node<Key, Value> tempRoot = root;
        while(tempRoot.getRight()!=null) tempRoot = tempRoot.getRight();
        return tempRoot.getKey();
    }

    /**
     * largest key less than or equal to key
     *
     * @param key
     * @return
     */
    @Override
    public Key floor(Key key) {
        Node<Key, Value> node = floor(root, key);
        if(node==null) return  null;
        return node.getKey();
    }

    private Node<Key, Value> floor(Node<Key, Value> node, Key key){
        if(node==null) return null;
        int cmp = key.compareTo(node.getKey());
        //Keys are equal this is the value
        if(cmp==0) return node;
        //the current node can't be the floor as it is greater than key,
        //hence we propogate what we get from left subtree
        if(cmp<0)  return floor(node.getLeft(), key);
        //if we go to right, it can be the current node or some key in right subtree
        //as the key is greater than the current node
        Node<Key, Value> t = floor(node.getRight(), key);
        return t!=null?t:node;
    }

    /**
     * smallest key greater than or equal to key
     *
     * @param key
     * @return
     */
    @Override
    public Key ceiling(Key key) {
        Node<Key, Value> node = ceiling(root, key);
        if(node==null) return  null;
        return node.getKey();
    }

    private Node<Key, Value> ceiling(Node<Key, Value> node, Key key){
        if(node==null) return null;
        int cmp = key.compareTo(node.getKey());
        //Keys are equal this is the value
        if(cmp==0) return node;
        //the current node can't be the floor as it is less than key,
        //hence we propogate what we get from right subtree
        if(cmp>0)  return floor(node.getRight(), key);
        //if we go to left, it can be the current node or some key in left subtree
        //as the key is less than the current node
        Node<Key, Value> t = floor(node.getLeft(), key);
        return t!=null?t:node;
    }

    /**
     * number of keys less than key
     *
     * @param key
     * @return
     */
    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node<Key, Value> node, Key key){
        if(node==null) return 0;
        int cmp = key.compareTo(node.getKey());

        if(cmp<0) return rank(node.getLeft(), key);
        else if(cmp>0) return 1 + size(node.getLeft()) + rank(node.getRight(), key);
        else size(node.getLeft());
    }

    /**
     * Key of rank k
     *
     * @param k
     * @return
     */
    @Override
    public Key select(int k) {
        return null;
    }

    /**
     * delete smallest key
     */
    @Override
    public void deleteMin() {

    }

    /**
     * delete largest key
     */
    @Override
    public void deleteMax() {

    }

    /**
     * Number of keys between lo & hi
     *
     * @param lo
     * @param hi
     * @return
     */
    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }

    /**
     * keys m [lo..hi] in sorted order
     *
     * @param lo
     * @param hi
     * @return
     */
    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }
}
