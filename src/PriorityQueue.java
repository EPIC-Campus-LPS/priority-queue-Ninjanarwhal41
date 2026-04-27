import java.util.ArrayList;

/**
 * This class represents a Priority Queue (heap) based on the ordering
 * defined by the compareTo method for the element. "Lower" value will
 * mean "higher" priority.
 *
 * @param <E> the type of elements in the queue
 * @author Eli
 */
public class PriorityQueue<E extends Comparable<E>> {
    private int size;
    private ArrayList<E> myHeap; //array representation of the heap
    /**
     * Creates an empty Priority Queue
     */
    public PriorityQueue() {
        myHeap = new ArrayList<E>();
        size = 0;
    }

    private int parent(int index){
        return (index-1)/2;
    }

    private int leftChild(int index){
        return (index*2)+1;
    }

    private int rightChild(int index){
        return (index*2)+2;
    }

    /**
     * Adds the element to the priority queue
     *
     * @param element the element to be added
     */
    public void add(E element) {
        int currentIndex = size;
        size++;
        myHeap.add(element);
        while (currentIndex > 0 && (myHeap.get(currentIndex)).compareTo(myHeap.get(parent(currentIndex))) < 0) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    /**
     * Swaps two elements in the queue.
     * Pre-condition: 0 <= posOne, posTwo < size of queue
     *
     * @param posOne the first element's position in the queue
     * @param posTwo the second element's position in the queue
     */
    private void swap(int posOne, int posTwo) {
        E element2 = myHeap.get(posTwo); //gets the element in the second position
        myHeap.set(posTwo, myHeap.get(posOne)); //sets the element in second position to the value of the element in the first position
        myHeap.set(posOne, element2); //sets the element in the first position to the value of the element in the second position
    }

    /**
     * Returns whether the element is in the heap
     *
     * @param element the element to be searched for
     * @return true if the element is in the queue, false otherwise
     */
    public boolean contains(E element) {
        for (E item : myHeap) {
            if (item.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the element of highest priority, null if queue is empty.
     * Post-condition: the queue is not changed
     *
     * @return the element of highest priority queue
     */
    public E peek() {
        return myHeap.get(0);
    }

    /**
     * Removes and returns the element of highest priority,
     * returns null if queue is empty.
     *
     * @return the element of highest priority
     */
    public E poll() {
        if(myHeap.isEmpty()){
            return null;
        }
        size--;
        return myHeap.remove(0);
    }

    /**
     * Will "sift down" the element at the given position
     * down to restore the heap property
     *
     * @param pos the starting position for heapify
     */
    private void heapify(int pos) {
        //remember, to get the index of the left and right child of a node, use 2i+1 and 2i+2.
        while(pos < size){
            if(((myHeap.get(pos).compareTo(myHeap.get(leftChild(pos))) > 0)) && leftChild(pos) < size){
                swap(pos, leftChild(pos));
                pos = leftChild(pos);
            }
            //if the parent is greater than the left child, swap them.
            else if((myHeap.get(pos).compareTo(myHeap.get(rightChild(pos)))) > 0 && rightChild(pos) < size){
                swap(pos, rightChild(pos));
                pos = rightChild(pos);
            }
            //if the parent is greater than the right child, swap them.
            //continues swapping down a path until there are no more children.
        }

    }

    /**
     * "Sifts up" to restore the heap property
     *
     * @param pos the starting position for deheapify
     */
    private void deheapify(int pos){
        //2i +1, 2i+ 2 reversed so (i-1)/2
        do {
            if (((myHeap.get(pos).compareTo(myHeap.get(parent(pos))) < 0))) {
                swap(pos, parent(pos));
            }
            pos = parent(pos);
            //if the parent is greater than the left or right child, swap them.
            //continues swapping up a path until the root is reached.
        } while (pos != 0);
    }

    /**
     * Finds and removes the given element from the queue.
     * Returns true if an element was deleted from the queue,
     * false otherwise.
     *
     * @param element the element to be removed from the queue
     * @return true if an element was removed from the queue, false otherwise
     */
    public boolean remove(E element) {
        if (size == 0){
            return false;
        }

        for(int i = 0; i < myHeap.size(); i++){
            if (myHeap.get(i).compareTo(element) == 0){
                myHeap.remove(myHeap.get(i));
                deheapify(myHeap.size()-1);
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in the queue
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return size;
    }

    /**
     * Returns the String representation of the heap
     * (by the order of list, each element separated
     * with a single space)
     *
     * @return the String representation of the heap
     */
    public String toString() {
        String result = "";
        for (E e : myHeap) {
            result += e + " ";
        }
        return result;
    }

    /**
     * Main method - contains console program used
     * for testing of the PriorityQueue class.
     *
     * @param args
     */
    public static void main(String[] args) {
// TODO Auto-generated method stub
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        pq.add(18);
        pq.add(19);
        pq.add(29);
        pq.add(32);
        pq.add(54);
        pq.add(56);
        pq.add(67);
        System.out.println(pq);
        pq.remove(67);
        System.out.println(pq);
        pq.remove(18);
        System.out.println(pq);
        pq2.add(67);
        pq2.add(56);
        pq2.add(54);
        pq2.add(32);
        pq2.add(29);
        pq2.add(19);
        pq2.add(18);
        System.out.println(pq2);
        PriorityQueue<Integer> pq3 = new PriorityQueue<>();
        pq3.add(65);
        pq3.add(32);
        pq3.add(23);
        System.out.println(pq.toString());
    }

}