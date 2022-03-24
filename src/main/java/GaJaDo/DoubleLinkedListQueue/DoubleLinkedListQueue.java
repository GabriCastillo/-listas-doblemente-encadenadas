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
            this.first = node;
            this.last = node;
        } else {
            node.setNext(this.first);
            this.first.setPrevious(node);
        }
        this.first = node;
        ++this.size;
    }

    public void append(DequeNode node) {
        if (size == 0) {
            this.first = node;
            this.last = node;
        } else {
            node.setPrevious(this.last);
            this.last.setNext(node);
        }
        this.last = node;
        ++this.size;
    }


    public void deleteFirst() {
        if (size == 0) {
            throw new RuntimeException("No hay elementos");
        }

        if (first.getNext() != null) {
            first = first.getNext();
            first.setPrevious(null);
        } else {
            first = null;
            last = null;
        }
        --this.size;
    }

    public void deleteLast() {
        if (size == 0) {
            throw new RuntimeException("No hay elementos");
        }

        if (last.getPrevious() != null) {
            last = last.getPrevious();
            last.setNext(null);
        } else {
            first = null;
            last = null;
        }
        --this.size;
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
        if (position <= 0 || this.size < position) {
            throw new RuntimeException("Posición no válida para esta lista.");
        }

        DequeNode<T> current = this.first;
        int currentPosition = 1;
        while (current != null) {
            if (currentPosition == position) {
                break;
            }
            ++currentPosition;
            current = current.getNext();
        }
        return current;
    }


    public DequeNode<T> find(T item) {
        if (this.size < 1) {
            throw new RuntimeException("Lista nula");
        }

        if (item == null) {
            throw new RuntimeException("item nulo");
        }

        DequeNode node = null;
        DequeNode aux = first;
        boolean find = false;

        while (!find && aux != null) {

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
        if (this.peekFirst() == null) {
            throw new RuntimeException("No hay elementos.");
        }

        if (this.peekFirst() == node) {
            this.deleteFirst();
        } else if (this.peekLast() == node) {
            this.deleteLast();
        } else {
            if (node.getNext() != null) {
                node.getNext().setPrevious(node.getPrevious());
            }

            if (node.getPrevious() != null) {
                node.getPrevious().setNext(node.getNext());
            }

            --this.size;
        }
    }

    public void sort(Comparator<T> comparator) {
        if (this.size < 1) {
            throw new RuntimeException("Lista vacia");
        } else {
            DequeNode<T> current = null, index = null;
            T temp;
            //Check whether list is empty

            //Current will point to head
            for (current = this.peekFirst(); current.getNext() != null; current = current.getNext()) {
                //Index will point to node next to current
                for (index = current.getNext(); index != null; index = index.getNext()) {
                    //If current's data is greater than index's data, swap the data of current and index
                    if (comparator.compare((T) current, (T) index) > 0) {
                        temp = current.getItem();
                        current.setItem(index.getItem());
                        index.setItem(temp);
                    }
                }
            }
        }
    }
}

