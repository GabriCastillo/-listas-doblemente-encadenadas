package gajado.doublelinkedlistqueue;

import gajado.dequenode.DequeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest<T>  {
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
    void getListAfterAppendLeftOfOneElement(){
        int expectedValue = 1;
        dobleListaEnlazada.appendLeft(new DequeNode('x',null,null));
        assertEquals(expectedValue,dobleListaEnlazada.size());
    }

    @Test
    void getListAfterAppendLeftOfThreeElement(){
        int expectedValue = 3;
        dobleListaEnlazada.appendLeft(new DequeNode('x',null,null));
        dobleListaEnlazada.appendLeft(new DequeNode('y',null,null));
        dobleListaEnlazada.appendLeft(new DequeNode('w',null,null));
        assertEquals(expectedValue,dobleListaEnlazada.size());
    }

    @Test
    void getListAfterAppendOfOneElement(){
        int expectedValue = 1;
        dobleListaEnlazada.append(new DequeNode('x',null,null));
        assertEquals(expectedValue,dobleListaEnlazada.size());
    }

    @Test
    void getAEmptyListAfterDeleteFirst(){
        int expectedValue = 0;
        dobleListaEnlazada.append(new DequeNode('x',null,null));
        dobleListaEnlazada.deleteFirst();
        assertEquals(expectedValue,dobleListaEnlazada.size());
    }

    @Test
    void getAEmptyListAfterDeleteLast(){
        int expectedValue = 0;
        dobleListaEnlazada.append(new DequeNode('x',null,null));
        dobleListaEnlazada.deleteLast();
        assertEquals(expectedValue,dobleListaEnlazada.size());
    }

    @Test
    void raiseAnExceptionWhenDeleteFirstAnEmptyList(){
        assertThrows(RuntimeException.class,() -> dobleListaEnlazada.deleteFirst());
    }

    @Test
    void raiseAnExceptionWhenDeleteLastAnEmptyList(){
        assertThrows(RuntimeException.class,() -> dobleListaEnlazada.deleteFirst());
    }

    // Complex operations

    /**
     * getAt()
     */

    @Test
    void getThirdNodeOfALinkedList(){
        DequeNode<T> expectedNode = new DequeNode(3,null,null);
        dobleListaEnlazada.append(new DequeNode(1,null,null));
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(expectedNode);

        assertEquals(expectedNode,dobleListaEnlazada.getAt(3));
    }

    @Test
    void getFirstNodeOfALinkedList(){
        DequeNode<T> expectedNode = new DequeNode(1,null,null);
        dobleListaEnlazada.append(expectedNode);
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(new DequeNode(3,null,null));

        assertEquals(expectedNode,dobleListaEnlazada.getAt(1));
    }
    @Test
    void raiseAnExceptionWhenGetANodeOutOfBounds(){
        dobleListaEnlazada.append(new DequeNode(1,null,null));
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(new DequeNode(3,null,null));

        assertThrows(RuntimeException.class, () -> dobleListaEnlazada.getAt(4));
    }

    @Test
    void raiseAnExceptionWhenGetAtOnAEmptyList(){
        assertThrows(RuntimeException.class, () -> dobleListaEnlazada.getAt(2));
    }
    
/*
    @Test
    void getA() {
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
    void raiseAnExceptionWhenFindInAnEmptyList(){
        T a = null;
        assertThrows(RuntimeException.class,() -> dobleListaEnlazada.find(a));
    }

    @Test
    void raiseAnExceptionWhenFindANullItem(){


        dobleListaEnlazada.append(new DequeNode(1,null,null));
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(new DequeNode(3,null,null));


        assertThrows(RuntimeException.class,() -> dobleListaEnlazada.find(null));
    }

    @Test
    void findNodeWhenIsAtFirstPosition(){
        DequeNode<T> expectedNode = new DequeNode(1,null,null);
        dobleListaEnlazada.append(expectedNode);
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(new DequeNode(3,null,null));

        assertEquals(expectedNode,dobleListaEnlazada.find(expectedNode.getItem()));
    }

    @Test
    void findNodeWhenIsAtSecondPosition(){
        DequeNode<T> expectedNode = new DequeNode(2,null,null);
        dobleListaEnlazada.append(new DequeNode(1,null,null));
        dobleListaEnlazada.append(expectedNode);
        dobleListaEnlazada.append(new DequeNode(3,null,null));

        assertEquals(expectedNode,dobleListaEnlazada.find(expectedNode.getItem()));
    }

    @Test
    void findNodeWhenIsAtThirdPosition(){
        DequeNode<T> expectedNode = new DequeNode(3,null,null);
        dobleListaEnlazada.append(new DequeNode(1,null,null));
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(expectedNode);

        assertEquals(expectedNode,dobleListaEnlazada.find(expectedNode.getItem()));
    }


    @Test
    void findNodeWhenIsNotThereReturnsNull(){
        DequeNode<T> expectedNode = new DequeNode(4,null,null);
        dobleListaEnlazada.append(new DequeNode(1,null,null));
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(new DequeNode(3,null,null));

        assertNull(dobleListaEnlazada.find(expectedNode.getItem()));

    }

      /**
      * delete()
      **/

    @Test
    void deleteFromNullDequeShouldThrowException(){
        DequeNode<T> anyNode = new DequeNode<>(null, null, null);
        assertThrows(RuntimeException.class,() -> dobleListaEnlazada.delete(anyNode));
    }

    @Test
    void deleteOnlyElementOf1ShouldReturnEmptyDeque(){
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
    void deleteFirstElementOf123ShouldReturn23(){
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
    void deleteSecondElementOf123ShouldReturn13(){
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
    void deleteThirdElementOf123ShouldReturn12(){
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
    void deleteNonExistentElementFrom123ShouldReturn123(){
        //GIVEN
        DequeNode<Integer> firstNode = new DequeNode<>(1, null, null);
        DequeNode<Integer> middleNode = new DequeNode<>(2, null, null);
        DequeNode<Integer> lastNode = new DequeNode<>(3, null, null);

        dobleListaEnlazada.append(firstNode);
        dobleListaEnlazada.append(middleNode);
        dobleListaEnlazada.append(lastNode);

        //WHEN
        DequeNode<T> anyNode = new DequeNode<>(null, null, null);
        dobleListaEnlazada.delete(anyNode);

        firstNode.setNext(middleNode);
        middleNode.setPrevious(firstNode);
        middleNode.setNext(lastNode);
        lastNode.setPrevious(middleNode);

        //THEN
        assertEquals(firstNode, dobleListaEnlazada.peekFirst());
        assertEquals(middleNode, dobleListaEnlazada.getAt(2));
        assertEquals(lastNode, dobleListaEnlazada.peekLast());

        assertEquals(3, dobleListaEnlazada.size());
    }

    @Test
    void raiseAnExceptionDeleteLastEmptyList(){
        assertThrows(RuntimeException.class,()->dobleListaEnlazada.deleteLast());
    }

    /**
     * sort()
     *
     **/

    @Test
    void sortingEmptyListThrowsException(){

        OrdenarNodoPorOrdenNatural comparator = new OrdenarNodoPorOrdenNatural();

        assertThrows(RuntimeException.class,() -> dobleListaEnlazada.sort((Comparator<T>) comparator));
    }

    @ParameterizedTest
    @ValueSource(strings = {"213", "123", "321", "312", "231", "132"})
    void sortingParameterListsShouldAllReturn123(String args){
        //GIVEN
        DequeNode<Integer> firstNode = new DequeNode<>(Character.getNumericValue(args.charAt(0)), null, null);
        DequeNode<Integer> middleNode = new DequeNode<>(Character.getNumericValue(args.charAt(1)), null, null);
        DequeNode<Integer> lastNode = new DequeNode<>(Character.getNumericValue(args.charAt(2)), null, null);

        dobleListaEnlazada.append(firstNode);
        dobleListaEnlazada.append(middleNode);
        dobleListaEnlazada.append(lastNode);
        OrdenarNodoPorOrdenNatural comparator = new OrdenarNodoPorOrdenNatural();

        //WHEN
        dobleListaEnlazada.sort((Comparator<T>) comparator);

        //THEN
        assertEquals(1, dobleListaEnlazada.peekFirst().getItem());
        assertEquals(2, dobleListaEnlazada.getAt(2).getItem());
        assertEquals(3, dobleListaEnlazada.peekLast().getItem());
    }
}
