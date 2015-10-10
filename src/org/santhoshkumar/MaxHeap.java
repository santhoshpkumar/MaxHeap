package org.santhoshkumar;
import java.io.*;
import java.util.*;

public class MaxHeap {
    ArrayList<Integer> heap;

    MaxHeap(){
        heap = new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        MaxHeap h = new MaxHeap();
        h.insert(5);
        h.insert(4);
        h.insert(10);
        h.insert(12);
        h.insert(3);
        h.insert(1);
        h.insert(9);

        System.out.println(h.getMax());
        System.out.println(h.getMax());
        System.out.println(h.getMax());
        System.out.println(h.getMax());
        System.out.println(h.getMax());
        System.out.println(h.getMax());
        System.out.println(h.getMax());
        System.out.println(h.getMax());
    }

    public void insert(int data){
        heap.add(data);
        bubbleUp(heap.size() - 1);
    }

    public int getMax(){
        int result = -1;
        if(heap.size() >0 ) {
            result = heap.get(0);
            int lastIndex = heap.size() - 1;
            heap.set(0, heap.get(lastIndex));
            heap.remove(lastIndex);
            sinkDown(0);
        }
        return result;
    }

    // You can change the logic to a non-recursive version by using a
    // while and swap the index to largest instead of the call to sinkDown
    private void sinkDown(int index){
        int largest = index;
        int left = index*2+1;
        int right = index*2+2;

        if(left < heap.size() && heap.get(index) < heap.get(left)){
            largest = left;
        }
        if(right < heap.size() && heap.get(largest) < heap.get(right)){
            largest = right;
        }
        if(largest != index){
            int swap = heap.get(index);
            heap.set(index, heap.get(largest));
            heap.set(largest, swap);
            sinkDown(largest);
        }
    }

    // You can change the logic to a non-recursive version by using a
    // while and swap the index to parent instead of the call to bubbleUp
    private void bubbleUp(int index){
        int parent = (int)index/2;
        if(heap.get(parent) < heap.get(index)){
            int swap = heap.get(parent);
            heap.set(parent, heap.get(index));
            heap.set(index, swap);
            bubbleUp(parent);
        }
    }
}
