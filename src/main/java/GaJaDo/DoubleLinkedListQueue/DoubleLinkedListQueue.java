package GaJaDo.DoubleLinkedListQueue;
import GaJaDo.Interface.DoubleEndedQueue;
import GaJaDo.DequeNode.DequeNode;

import java.util.Deque;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue {
    private DequeNode<T> first,last;
    private int size;

    public DoubleLinkedListQueue(){
        first=null;
        last=null;
        size=0;
    }

    public void append(DequeNode node) {
        if(size==0){
            first = node;
        }else{

        }
    }

    public void appendLeft(DequeNode node) {

        if (size == 0) {
            first = node;
        }else {
            
        }
        last = node;
        size++;
    }


    public void deleteFirst() {

    }

    public void deleteLast() {

    }

    public DequeNode peekFirst() {
        return null;
    }

    public DequeNode peekLast() {
        return null;
    }

    public int size(){
        return this.size;
    }
}
