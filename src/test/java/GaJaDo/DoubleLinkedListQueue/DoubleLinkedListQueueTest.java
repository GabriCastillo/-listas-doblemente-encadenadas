package GaJaDo.DoubleLinkedListQueue;

import GaJaDo.DequeNode.DequeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

<<<<<<< Updated upstream
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
=======
import static org.junit.jupiter.api.Assertions.*;
>>>>>>> Stashed changes

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

    @Test
    public void raiseAnExceptionWhenFindInAnEmptyList(){
        T a = null;
        assertThrows(RuntimeException.class,() -> dobleListaEnlazada.find(a));
    }

    @Test
    public void raiseAnExceptionWhenFindANullItem(){
        T a = null;
        assertThrows(RuntimeException.class,() -> dobleListaEnlazada.find(a));
    }

    @Test
    public void getThirdNodeOfALinkedList(){
        DequeNode<T> expectedNode = new DequeNode(3,null,null);
        dobleListaEnlazada.append(new DequeNode(1,null,null));
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(expectedNode);

        assertEquals(expectedNode,dobleListaEnlazada.getAt(3));
    }

    @Test
    public void raiseAnExceptionWhenGetAtOnAEmptyList(){
        assertThrows(RuntimeException.class, () -> dobleListaEnlazada.getAt(2));
    }

    @Test
    public void getFirstNodeOfALinkedList(){
        DequeNode<T> expectedNode = new DequeNode(1,null,null);
        dobleListaEnlazada.append(expectedNode);
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(new DequeNode(3,null,null));

        assertEquals(expectedNode,dobleListaEnlazada.getAt(1));
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

<<<<<<< Updated upstream
=======
    @Test
    public void findNodeWhenIsNotThereReturnsNull(){
        DequeNode<T> expectedNode = new DequeNode(4,null,null);
        dobleListaEnlazada.append(new DequeNode(1,null,null));
        dobleListaEnlazada.append(new DequeNode(2,null,null));
        dobleListaEnlazada.append(new DequeNode(3,null,null));

        assertNull(dobleListaEnlazada.find(expectedNode.getItem()));

    }
>>>>>>> Stashed changes
}
