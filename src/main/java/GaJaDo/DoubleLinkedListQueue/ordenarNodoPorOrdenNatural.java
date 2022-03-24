package GaJaDo.DoubleLinkedListQueue;

import GaJaDo.DequeNode.DequeNode;

import java.util.Comparator;

public class ordenarNodoPorOrdenNatural implements Comparator<DequeNode> {

    @Override
    public int compare(DequeNode o1, DequeNode o2) {
        return ((Integer) o1.getItem()) - ((Integer) o2.getItem());

    }
}
