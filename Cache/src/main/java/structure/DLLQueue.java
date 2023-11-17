package main.java.structure;


/*
    head -> n1 -> n2 -> n3 ... -> n10 -> tail
    head <- n1 <- n2 <- n3 ... <- n10 <- tail
 */
public class DLLQueue<T> {
    DLLNode<T> head;
    DLLNode<T> tail;

    public DLLQueue() {
        head = new DLLNode<>(null);
        tail = new DLLNode<>(null);

        // head -> tail
        // head <- tail
        head.next = tail;
        tail.prev = head;
    }

    public void insertNode(DLLNode<T> node) {
        // add node at the end of queue

        // tprev -> node -> tail
        // tprev <- node <- tail

        DLLNode<T> tprev = tail.prev;
        tprev.next = node;
        node.prev = tprev;
        node.next = tail;
        tail.prev = node;
    }

    public DLLNode<T> detachNode(DLLNode<T> node) {

        DLLNode<T> nprev = node.prev;
        nprev.next = node.next;
        node.next.prev = nprev;

        node.prev = null;
        node.next = null;
        return node;
    }

    public DLLNode<T> getFirstNode() {
        if(head.next != tail)
            return head.next;
        return null;
    }

    public DLLNode<T> getLastNode() {
        if(tail.prev != head)
            return tail.prev;
        return null;
    }
}
