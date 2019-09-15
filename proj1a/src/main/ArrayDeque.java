package src.main;

public class ArrayDeque <T> {
    private T[] items;
    private int size;
    private int nextFirst = 0;
    private int nextLast = 1;

    private static final int INITIAL_CAPACITY = 8;

    public ArrayDeque() {
        items = (T[])new Object[INITIAL_CAPACITY];
        size = 0;
    }

//    public ArrayDeque(ArrayDeque other){}

    public void resize(int capacity){
        int n = items.length;
        T[] a = (T[]) new Object[capacity];
        int pointer = 0;
        while(items[pointer] == null){
            pointer ++;
        }
        System.arraycopy(this.items, pointer, a, 0, size);
        items = a;
        nextFirst = capacity - 1;
        nextLast = n;
    }

    public void addFirst(T item){
        if (item == null){
            throw new NullPointerException();
        }
        items[nextFirst] = item;
        size ++;

        if(nextFirst == 0){
            nextFirst = items.length -1;
        } else {
            nextFirst--;
        }

        if(size == items.length){
            resize(items.length * 2);
        }
    }

    public void addLast(T item){
        if (item == null){
            throw new NullPointerException();
        }
        items[nextLast] = item;
        size ++;

        if(nextLast == INITIAL_CAPACITY-1){
            nextLast = 0;
        } else {
            nextLast++;
        }

        if( size == items.length){
            resize(items.length * 2);
        }
    }

    public void removeFirst(T item){


    }
//    public void removeLast(T item)
//    public void get(T item)
//public void printDeque()

    public int size(){
        return size;
    }

    public static void main (String[] args){
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        a.addLast(4);
        a.addLast(5);
        a.addLast(6);
        //3,2,1,4,5,6,7,8
        a.addLast(7);
        a.addLast(8);
        a.addLast(9);
    }
}
