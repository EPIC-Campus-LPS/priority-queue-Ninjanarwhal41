import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @org.junit.jupiter.api.Test
    void add() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        pq.add(18);
        pq.add(19);
        pq.add(29);
        pq.add(32);
        pq.add(54);
        pq.add(56);
        pq.add(67);
        assertEquals("18 19 29 32 54 56 67 ", pq.toString());
        pq2.add(67);
        pq2.add(56);
        pq2.add(54);
        pq2.add(32);
        pq2.add(29);
        pq2.add(19);
        pq2.add(18);
        assertEquals("18 32 19 67 54 56 29 ", pq2.toString());

    }

    @org.junit.jupiter.api.Test
    void contains() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        assertFalse(pq.contains(67));
        pq.add(67);
        pq.add(56);
        pq.add(54);
        pq.add(32);
        pq.add(29);
        assertTrue(pq.contains(67));
        assertTrue(pq.contains(32));
        assertTrue(pq.contains(56));
        assertTrue(pq.contains(54));
        assertTrue(pq.contains(29));
        assertFalse(pq.contains(19));

    }

    @org.junit.jupiter.api.Test
    void peek() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(67);
        assertEquals(67, pq.peek());
        pq.add(56);
        assertEquals(56, pq.peek());
        pq.add(54);
        assertEquals(54, pq.peek());
        pq.add(32);
        assertEquals(32, pq.peek());
        pq.add(29);
        assertEquals(29, pq.peek());
    }

    @org.junit.jupiter.api.Test
    void poll() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        assertNull(pq.poll());
        pq.add(67);
        assertEquals(67, pq.poll());
        pq.add(56);
        assertEquals(56, pq.poll());
        pq.add(54);
        assertEquals(54, pq.poll());
        pq.add(32);
        assertEquals(32, pq.poll());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        pq.add(67);
        pq.add(56);
        pq.add(54);
        pq.add(32);
        pq.add(29);
        pq.add(19);
        pq.add(18);
        assertTrue(pq.remove(19));
        assertTrue(pq.remove(29));
        assertTrue(pq.remove(18));
        assertTrue(pq.remove(67));
        assertFalse(pq.remove(67));
        assertFalse(pq.remove(88));

        pq2.add(67);
        pq2.add(56);
        pq2.add(54);
        pq2.add(32);
        pq2.add(29);
        pq2.add(19);
        pq2.add(18);
        assertEquals("18 32 19 67 54 56 29 ", pq2.toString());
        pq2.remove(18);
        assertEquals("19 32 29 67 54 56", pq2.toString());


    }

    @org.junit.jupiter.api.Test
    void size() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        assertEquals(0, pq.size());
        pq.add(67);
        pq.add(56);
        assertEquals(2, pq.size());
        pq.add(54);
        assertEquals(3, pq.size());
        pq.remove(56);
        pq.remove(67);
        assertEquals(1, pq.size());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        pq.add(18);
        pq.add(19);
        pq.add(29);
        pq.add(32);
        pq.add(54);
        pq.add(56);
        pq.add(67);
        assertEquals("18 19 29 32 54 56 67 ", pq.toString());
        pq2.add(67);
        pq2.add(56);
        pq2.add(54);
        pq2.add(32);
        pq2.add(29);
        pq2.add(19);
        pq2.add(18);
        assertEquals("18 32 19 67 54 56 29 ", pq2.toString());
    }
}