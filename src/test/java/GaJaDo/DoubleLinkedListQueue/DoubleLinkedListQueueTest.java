package GaJaDo.DoubleLinkedListQueue;

import GaJaDo.DequeNode.DequeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListQueueTest<T>  {
    private DoubleLinkedListQueue<T> dobleListaEnlazada;

    @BeforeEach
    public void setup(){
        dobleListaEnlazada = new DoubleLinkedListQueue<T>();
    }

    @AfterEach
    public void reboot(){
        dobleListaEnlazada = null;
    }

    @Test
    public void getListAfterAppendLeftOfOneElement(){
        int expectedValue = 1;
        dobleListaEnlazada.appendLeft(new DequeNode('x',null,null));
        assertEquals(expectedValue,dobleListaEnlazada.size());
    }

    @Test
    public void getListAfterAppendLeftOfThreeElement(){
        int expectedValue = 3;
        dobleListaEnlazada.appendLeft(new DequeNode('x',null,null));
        dobleListaEnlazada.appendLeft(new DequeNode('y',null,null));
        dobleListaEnlazada.appendLeft(new DequeNode('w',null,null));
        assertEquals(expectedValue,dobleListaEnlazada.size());
    }

    @Test
    public void getListAfterAppendOfOneElement(){
        int expectedValue = 1;
        dobleListaEnlazada.append(new DequeNode('x',null,null));
        assertEquals(expectedValue,dobleListaEnlazada.size());
    }

    @Test
    public void getAEmptyListAfterDeleteFirst(){
        int expectedValue = 0;
        dobleListaEnlazada.append(new DequeNode('x',null,null));
        dobleListaEnlazada.deleteFirst();
        assertEquals(expectedValue,dobleListaEnlazada.size());
    }

    @Test
    public void getAEmptyListAfterDeleteLast(){
        int expectedValue = 0;
        dobleListaEnlazada.append(new DequeNode('x',null,null));
        dobleListaEnlazada.deleteLast();
        assertEquals(expectedValue,dobleListaEnlazada.size());
    }

    @Test
    public void raiseAnExceptionWhenDeleteFirstAnEmptyList(){
        assertThrows(RuntimeException.class,() -> dobleListaEnlazada.deleteFirst());
    }

    @Test
    public void raiseAnExceptionWhenDeleteLastAnEmptyList(){
        assertThrows(RuntimeException.class,() -> dobleListaEnlazada.deleteFirst());
    }

    // Complex operations

    /**
     * getAt()
     */

    @Test
    public void getThirdNodeOfALinkedList(){
        DequeNode<T> expectedNode = new DequeNode(3,null,null);
        dobleListaEnlazada.append(new DequeNode(1,null,null));
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(expectedNode);

        assertEquals(expectedNode,dobleListaEnlazada.getAt(3));
    }

    @Test
    public void getFirstNodeOfALinkedList(){
        DequeNode<T> expectedNode = new DequeNode(1,null,null);
        dobleListaEnlazada.append(expectedNode);
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(new DequeNode(3,null,null));

        assertEquals(expectedNode,dobleListaEnlazada.getAt(1));
    }
    @Test
    public void raiseAnExceptionWhenGetANodeOutOfBounds(){
        dobleListaEnlazada.append(new DequeNode(1,null,null));
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(new DequeNode(3,null,null));

        assertThrows(RuntimeException.class, () -> dobleListaEnlazada.getAt(4));
    }

    @Test
    public void raiseAnExceptionWhenGetAtOnAEmptyList(){
        assertThrows(RuntimeException.class, () -> dobleListaEnlazada.getAt(2));
    }
    
/*
    @Test
    public void getA() {
        DoubleLinkedListQueue expectedList = new DoubleLinkedListQueue();
        expectedList.append(new DequeNode(1, null, null));
        expectedList.append(new DequeNode(3, null, null));
        expectedList.append(new DequeNode(2, null, null));

        dobleListaEnlazada.append(new DequeNode(1, null, null));
        dobleListaEnlazada.append(new DequeNode(3, null, null));
        dobleListaEnlazada.append(new DequeNode(2, null, null));

        assertEquals(expectedList, dobleListaEnlazada.sort(Comparator <T>));
    }
*/

    /**
     * find(T item)
     *
     **/

    @Test
    public void raiseAnExceptionWhenFindInAnEmptyList(){
        T a = null;
        assertThrows(RuntimeException.class,() -> dobleListaEnlazada.find(a));
    }

    @Test
    public void raiseAnExceptionWhenFindANullItem(){
        assertThrows(RuntimeException.class,() -> dobleListaEnlazada.find(null));
    }

    @Test
    public void findNodeWhenIsAtFirstPosition(){
        DequeNode<T> expectedNode = new DequeNode(1,null,null);
        dobleListaEnlazada.append(expectedNode);
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(new DequeNode(3,null,null));

        assertEquals(expectedNode,dobleListaEnlazada.find(expectedNode.getItem()));
    }

    @Test
    public void findNodeWhenIsAtSecondPosition(){
        DequeNode<T> expectedNode = new DequeNode(2,null,null);
        dobleListaEnlazada.append(new DequeNode(1,null,null));
        dobleListaEnlazada.append(expectedNode);
        dobleListaEnlazada.append(new DequeNode(3,null,null));

        assertEquals(expectedNode,dobleListaEnlazada.find(expectedNode.getItem()));
    }

    @Test
    public void findNodeWhenIsAtThirdPosition(){
        DequeNode<T> expectedNode = new DequeNode(3,null,null);
        dobleListaEnlazada.append(new DequeNode(1,null,null));
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(expectedNode);

        assertEquals(expectedNode,dobleListaEnlazada.find(expectedNode.getItem()));
    }


    @Test
    public void findNodeWhenIsNotThereReturnsNull(){
        DequeNode<T> expectedNode = new DequeNode(4,null,null);
        dobleListaEnlazada.append(new DequeNode(1,null,null));
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(new DequeNode(3,null,null));

        assertNull(dobleListaEnlazada.find(expectedNode.getItem()));

    }

      /**
      * delete()
      *
      **/

    @Test
    public void deleteFromNullDequeShouldThrowException(){
        assertThrows(RuntimeException.class,() -> dobleListaEnlazada.delete(new DequeNode<>(null, null, null)));
    }

    @Test
    public void deleteOnlyElementOf1ShouldReturnEmptyDeque(){
        //GIVEN
        DequeNode<Integer> firstNode = new DequeNode<>(1, null, null);
        dobleListaEnlazada.append(firstNode);

        //WHEN
        dobleListaEnlazada.delete(dobleListaEnlazada.getAt(1));

        //THEN
        assertNull(dobleListaEnlazada.peekFirst());
        assertNull(dobleListaEnlazada.peekLast());
        assertEquals(0, dobleListaEnlazada.size());
    }

    @Test
    public void deleteFirstElementOf123ShouldReturn23(){
        //GIVEN
        DequeNode<Integer> firstNode = new DequeNode<>(1, null, null);
        DequeNode<Integer> middleNode = new DequeNode<>(2, null, null);
        DequeNode<Integer> lastNode = new DequeNode<>(3, null, null);

        dobleListaEnlazada.append(firstNode);
        dobleListaEnlazada.append(middleNode);
        dobleListaEnlazada.append(lastNode);

        //WHEN
        dobleListaEnlazada.delete(dobleListaEnlazada.getAt(1));
        middleNode.setNext(lastNode);
        lastNode.setPrevious(middleNode);

        //THEN
        assertEquals(middleNode, dobleListaEnlazada.peekFirst());
        assertEquals(lastNode, dobleListaEnlazada.peekLast());
        assertEquals(3, dobleListaEnlazada.getAt(2).getItem());

        assertEquals(2, dobleListaEnlazada.size());
    }

    @Test
    public void deleteSecondElementOf123ShouldReturn13(){
        //GIVEN
        DequeNode<Integer> firstNode = new DequeNode<>(1, null, null);
        DequeNode<Integer> middleNode = new DequeNode<>(2, null, null);
        DequeNode<Integer> lastNode = new DequeNode<>(3, null, null);

        dobleListaEnlazada.append(firstNode);
        dobleListaEnlazada.append(middleNode);
        dobleListaEnlazada.append(lastNode);

        //WHEN
        dobleListaEnlazada.delete(dobleListaEnlazada.getAt(2));
        firstNode.setNext(lastNode);
        lastNode.setPrevious(firstNode);

        //THEN
        assertEquals(firstNode, dobleListaEnlazada.peekFirst());
        assertEquals(lastNode, dobleListaEnlazada.peekLast());
        assertEquals(3, dobleListaEnlazada.getAt(2).getItem());

        assertEquals(2, dobleListaEnlazada.size());
    }

    @Test
    public void deleteThirdElementOf123ShouldReturn12(){
        //GIVEN
        DequeNode<Integer> firstNode = new DequeNode<>(1, null, null);
        DequeNode<Integer> middleNode = new DequeNode<>(2, null, null);
        DequeNode<Integer> lastNode = new DequeNode<>(3, null, null);

        dobleListaEnlazada.append(firstNode);
        dobleListaEnlazada.append(middleNode);
        dobleListaEnlazada.append(lastNode);

        //WHEN
        dobleListaEnlazada.delete(dobleListaEnlazada.getAt(3));
        firstNode.setNext(middleNode);
        middleNode.setPrevious(firstNode);

        //THEN
        assertEquals(firstNode, dobleListaEnlazada.peekFirst());
        assertEquals(middleNode, dobleListaEnlazada.peekLast());
        assertEquals(2, dobleListaEnlazada.getAt(2).getItem());

        assertEquals(2, dobleListaEnlazada.size());
    }

    @Test
    public void raiseAnExceptionDeleteLastEmptyList(){
        assertThrows(RuntimeException.class,()->dobleListaEnlazada.deleteLast());
    }

    /**
     * sort()
     *
     **/

    @Test
    public void sortingEmptyListThrowsException(){

        ordenarNodoPorOrdenNatural comparator = new ordenarNodoPorOrdenNatural();

        assertThrows(RuntimeException.class,() -> dobleListaEnlazada.sort((Comparator<T>) comparator));
    }

    @Test
    public void sortingList213Returns123(){
        //GIVEN
        DequeNode<Integer> firstNode = new DequeNode<>(2, null, null);
        DequeNode<Integer> middleNode = new DequeNode<>(1, null, null);
        DequeNode<Integer> lastNode = new DequeNode<>(3, null, null);

        dobleListaEnlazada.append(firstNode);
        dobleListaEnlazada.append(middleNode);
        dobleListaEnlazada.append(lastNode);
        ordenarNodoPorOrdenNatural comparator = new ordenarNodoPorOrdenNatural();

        //WHEN
        dobleListaEnlazada.sort((Comparator<T>) comparator);

        //THEN
        assertEquals(1, dobleListaEnlazada.peekFirst().getItem());
        assertEquals(2, dobleListaEnlazada.getAt(2).getItem());
        assertEquals(3, dobleListaEnlazada.peekLast().getItem());
    }

}
