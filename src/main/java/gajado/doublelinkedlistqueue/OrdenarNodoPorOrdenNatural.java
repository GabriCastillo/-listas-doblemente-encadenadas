package gajado.doublelinkedlistqueue;

import gajado.dequenode.DequeNode;

import java.util.Comparator;

public class OrdenarNodoPorOrdenNatural implements Comparator<DequeNode<?>> {

    @Override
    public int compare(DequeNode o1, DequeNode o2) {
        return ((Integer) o1.getItem()) - ((Integer) o2.getItem());

    }
}
