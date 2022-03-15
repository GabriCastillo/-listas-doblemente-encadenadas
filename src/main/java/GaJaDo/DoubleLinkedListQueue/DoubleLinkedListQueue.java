package GaJaDo.DoubleLinkedListQueue;
import GaJaDo.Interface.DoubleEndedQueue;
import GaJaDo.DequeNode.DequeNode;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue {
    private DequeNode<T> first,last;
    private int size;

    public DoubleLinkedListQueue(){
        first=null;
        last=null;
        size=0;
    }

    @Override
    public void append(DequeNode node) {
        
    }

    @Override
    public void appendLeft(DequeNode node) {

    }

    @Override
    public void deleteFirst() {

    }

    @Override
    public void deleteLast() {

    }

    @Override
    public DequeNode peekFirst() {
        return null;
    }

    @Override
    public DequeNode peekLast() {
        return null;
    }

    @Override
    public int size(){
        return this.size;
    }
}
