package GaJaDo.DoubleLinkedListQueue;
import GaJaDo.Interface.DoubleEndedQueue;
import GaJaDo.DequeNode.DequeNode;

import java.util.Deque;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T> {
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
            last =node;
        }else{
           first.setPrevious(node);
        }
        first = node;
        size++;
    }

    public void appendLeft(DequeNode node) {
        if (size == 0) {
            first = node;
            last=node;
        }else {
            last.setNext(node);
        }
        last = node;
        size++;
    }


    public void deleteFirst() {
        if(size==0){
           throw new RuntimeException("No hay elementos");
        }else{
            if(first.getNext()!=null){
                first = first.getNext();
                first.setPrevious(null) ;
            }else{
                first = null;
            }
            size--;
        }

    }

    public void deleteLast() {
       
    }

    public DequeNode peekFirst() {
        return this.first;
    }

    public DequeNode peekLast() {
        return this.last;
    }

    public int size(){
        return this.size;
    }
}
