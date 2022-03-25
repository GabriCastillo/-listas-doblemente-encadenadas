package gajado.dequenode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DequeNodeTest {
    DequeNode<Integer> firstNode, middleNode, lastNode;

    @BeforeEach
    void setUp() {
        this.firstNode = new DequeNode<>(1, null, null);
        this.middleNode = new DequeNode<>(2, null, null);
        this.lastNode = new DequeNode<>(3, null, null);

        this.firstNode.setNext(this.middleNode);
        this.middleNode.setPrevious(this.firstNode);
        this.middleNode.setNext(this.lastNode);
        this.lastNode.setPrevious(this.middleNode);
    }

    @AfterEach
    void tearDown() {
        this.firstNode = null;
        this.middleNode = null;
        this.lastNode = null;
    }

    @Test
    void getItem() {
        assertEquals(1, this.firstNode.getItem());
        assertEquals(2, this.middleNode.getItem());
        assertEquals(3, this.lastNode.getItem());
    }

    @Test
    void getNext() {
        assertEquals(this.middleNode, this.firstNode.getNext());
        assertEquals(this.lastNode, this.middleNode.getNext());
        assertNull(this.lastNode.getNext());
    }

    @Test
    void getPrevious() {
        assertNull(this.firstNode.getPrevious());
        assertEquals(this.firstNode, this.middleNode.getPrevious());
        assertEquals(this.middleNode, this.lastNode.getPrevious());
    }

    @Test
    void isFirstNode() {
        assertTrue(this.firstNode.isFirstNode());
        assertFalse(this.middleNode.isFirstNode());
        assertFalse(this.lastNode.isFirstNode());
    }

    @Test
    void isLastNode() {
        assertFalse(this.firstNode.isLastNode());
        assertFalse(this.middleNode.isLastNode());
        assertTrue(this.lastNode.isLastNode());
    }

    @Test
    void isNotATerminalNode() {
        assertFalse(this.firstNode.isNotATerminalNode());
        assertTrue(this.middleNode.isNotATerminalNode());
        assertFalse(this.lastNode.isNotATerminalNode());
    }
}
