package GaJaDo.DequeNode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DequeNodeTest {
    DequeNode<Integer> firstNode, middleNode, lastNode;
    @BeforeEach
    public void setUp() {
        this.firstNode = new DequeNode<Integer>(1, this.middleNode, null);
        this.lastNode = new DequeNode<Integer>(3, null, this.middleNode);
        this.middleNode = new DequeNode<Integer>(2, this.lastNode, this.firstNode);
    }

    @AfterEach
    public void tearDown() {
        this.firstNode = null;
        this.middleNode = null;
        this.lastNode = null;
    }

    @Test
    public void getItem() {
        assertEquals(1, this.firstNode.getItem());
        assertEquals(2, this.middleNode.getItem());
        assertEquals(3, this.lastNode.getItem());
    }

    @Test
    public void getNext() {
        assertEquals(this.middleNode, this.firstNode.getNext());
        assertEquals(this.lastNode, this.middleNode.getNext());
        assertNull(this.lastNode.getNext());
    }

    @Test
    public void getPrevious() {
        assertNull(this.firstNode.getPrevious());
        assertEquals(this.firstNode, this.middleNode.getPrevious());
        assertEquals(this.middleNode, this.lastNode.getPrevious());
    }

    @Test
    public void isFirstNode() {
        assertTrue(this.firstNode.isFirstNode());
        assertFalse(this.middleNode.isFirstNode());
        assertFalse(this.lastNode.isFirstNode());
    }

    @Test
    public void isLastNode() {
        assertFalse(this.firstNode.isLastNode());
        assertFalse(this.middleNode.isLastNode());
        assertTrue(this.lastNode.isLastNode());
    }

    @Test
    public void isNotATerminalNode() {
        assertFalse(this.firstNode.isNotATerminalNode());
        assertTrue(this.middleNode.isNotATerminalNode());
        assertFalse(this.lastNode.isNotATerminalNode());
    }
}
