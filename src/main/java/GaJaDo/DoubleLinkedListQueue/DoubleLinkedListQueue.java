package GaJaDo.DoubleLinkedListQueue;

import GaJaDo.Interface.DoubleEndedQueue;
import GaJaDo.DequeNode.DequeNode;

import java.util.Comparator;
import java.util.Deque;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T> {
    private DequeNode<T> first, last;
    private int size;

    public DoubleLinkedListQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public void appendLeft(DequeNode node) {
        if (size == 0) {
            first = node;
            last = node;
        } else {
            first.setPrevious(node);
        }
        first = node;
        size++;
    }

    public void append(DequeNode node) {
        if (size == 0) {
            first = node;
            last = node;
        } else {
            last.setNext(node);
        }
        last = node;
        size++;
    }


    public void deleteFirst() {
        if (size == 0) {
            throw new RuntimeException("No hay elementos");
        } else {
            if (first.getNext() != null) {
                first = first.getNext();
                first.setPrevious(null);
            } else {
                first = null;
            }
            size--;
        }

    }

    public void deleteLast() {
        if (size == 0) {
            throw new RuntimeException("No hay elementos");
        } else {
            if (last.getPrevious() != null) {
                last = last.getPrevious();
                last.setNext(null);
            } else {
                last = null;
            }
            size--;
        }

    }

    public DequeNode peekFirst() {
        return this.first;
    }

    public DequeNode peekLast() {
        return this.last;
    }

    public int size() {
        return this.size;
    }

    public DequeNode<T> getAt(int position) {
        if (this.size < 1) {
            throw new RuntimeException("Lista nula");
        } else {
            boolean founded = false;
            if (position != 1) {
                DequeNode<T> result = first;
                while (!founded || result.getNext() != null) {
                    position--;
                    if (position == 0) {
                        founded = true;
                    } else {
                        result = result.getNext();
                    }
                }
                if(result==null){
                    throw new RuntimeException("No está en la lista");
                }
                return result;
            } else {
                return first;
            }
        }
    }


    public DequeNode<T> find(T item) {
        if (this.size < 1) {
            throw new RuntimeException("Lista nula");
        }
        if(item==null){
            throw new RuntimeException("item nulo");
        }

        DequeNode node = null;
        DequeNode aux = first;
        boolean find = false;

        while (!find && aux!= null) {

            if (aux.getItem() == item) {
                node = aux;
                find = true;
            } else {
                aux = aux.getNext();
            }

        }

        if (find) {
            return node;
        } else {
            return null;
        }


    }

    public void delete(DequeNode<T> node) {

    }

    public void sort(Comparator<T> comparator) {
        if(this.size<1){
            throw new RuntimeException("Lista vacia");
        }else{
            DequeNode<T> aux=first;
            DequeNode<T> nextNode=null;
            DequeNode<T> temp = null;
            while(aux!=null){
                nextNode = aux.getNext();
                while (nextNode!=null){
                    if(comparator.compare(aux.getItem(),nextNode.getItem())>=0){
                        temp = aux;
                        aux = nextNode;
                    }
                    nextNode=nextNode.getNext();
                }
                aux=aux.getNext();
            }
        }
    }
}
