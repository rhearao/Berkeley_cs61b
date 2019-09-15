public class ArrayDeque <T> implements Deque<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    private static final int INITIAL_CAPACITY = 4;
    private static final int RFACTOR = 2;
    private static final double MIN_USAGE_RATIO = 0.25;

    /** Creates an empty array deque.
     *  The starting size of your array  is 8.
     *  The initial position is also arbitrarily decided.
     */
    public ArrayDeque() {
        items = (T[])new Object[INITIAL_CAPACITY];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }
    }

    public void resize(int capacity){
        T[] newArr = (T[]) new Object[capacity];

        int curr = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            newArr[i] = items[curr];
            curr = plusOne(curr);
        }

        items = newArr;
        nextFirst = capacity-1;
        nextLast = size;
    }

    /** Helper functions. */
    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    @Override
    public void addFirst(T item){
        if (size == items.length) {
            resize(size * RFACTOR);
        }

        items[nextFirst] = item;
        size ++;

        nextFirst = (nextFirst - 1 + items.length) % items.length;
    }

    @Override
    public void addLast(T item){
        if (size == items.length) {
            resize(size * RFACTOR);
        }

        items[nextLast] = item;
        size ++;

        nextLast = (nextLast + 1) % items.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque(){
        int i = plusOne(nextFirst);
        while(i != nextLast){
            System.out.print(items[i] + " ");
            i = plusOne(i);
        }
    }

    @Override
    public T removeFirst(){
        if (size == 0) {
            return null;
        }

        int firstIdx = plusOne(nextFirst);
        T firstItem = items[firstIdx];
        items[firstIdx] = null;
        nextFirst = firstIdx;
        size --;

        if (items.length >= (INITIAL_CAPACITY*RFACTOR) && size < items.length * MIN_USAGE_RATIO) {
            resize(items.length / 2);
        }

        return firstItem;
    }

    @Override
    public T removeLast(){
        if(size == 0){
            return null;
        }

        int lastIdx = minusOne(nextLast);
        T lastItem = items[lastIdx];
        items[lastIdx] = null;
        nextLast = lastIdx;

        if (items.length >= (INITIAL_CAPACITY*RFACTOR) && size < items.length * MIN_USAGE_RATIO) {
            resize(items.length / 2);
        }

        return lastItem;
    }

    @Override
    public T get(int index){
        if(index > size){
            return null;
        }
        return items[index];
    }

    public static void main (String[] args){
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        a.addLast(4);
        a.addLast(5);
        a.addLast(6);
        a.addLast(7);
        a.addLast(8);
        a.addFirst(9);
        a.addLast(10);
        a.addLast(11);
    }
}
