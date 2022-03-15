package GaJaDo.DoubleLinkedListQueue;

import GaJaDo.DequeNode.DequeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoubleLinkedListQueueTest<T> {
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
}
