package src.main;

import edu.princeton.cs.algs4.StdOut;

public class LinkedListDeque <T> {

    private static class Node<T>{
        private T value;
        private Node prev, next;

        Node(T item, Node p, Node n){
            value = item;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    //constructor
    public LinkedListDeque() {
        sentinel = new Node(0, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentinel = new Node(0, null, null);
        Node first = new Node(item, sentinel, sentinel);
        sentinel.prev = first;
        sentinel.next = first;
        size = 1;
    }

    //create a deep copy of other
    public LinkedListDeque(LinkedListDeque other){

    }

    public void addFirst(T item){
        Node first = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size ++;
    }

    public void addLast(T item){
        Node last = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size ++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node pointer = sentinel.next;
        while(true){
            System.out.print(pointer.value + " ");
            if(pointer == sentinel.prev) {
                break;
            }
            pointer = pointer.next;
        }
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }
        T firstVal = (T) sentinel.next.value;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size --;
        return firstVal;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        T lastVal = (T) sentinel.prev.value;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size --;
        return lastVal;
    }

    public T get(int index){
        if(size < index){
            return null;
        }
        Node p = sentinel;
        for(int i=-1;i<index; i++){
            p = p.next;
        }
        return (T)p.value;
    }

    public T getRecursive(int index){
        if(index > size){
            return null;
        }
        if(index == 0){
            return (T)sentinel.next.value;
        }
        return getRecursive(index, sentinel.next);
    }

    public T getRecursive(int index, Node p){
        if(index == 0){
            return (T)p.value;
        } else {
            return getRecursive(index-1, p.next);
        }
    }
}
