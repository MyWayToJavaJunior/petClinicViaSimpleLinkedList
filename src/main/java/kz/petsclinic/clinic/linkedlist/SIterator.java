package kz.petsclinic.clinic.linkedlist;


import java.util.Iterator;

/**
 * ������� ��������
 */
public class SIterator<T> implements Iterator<Node> {
    private final Node head;
    private Node currentNode;

    SIterator(Node head) {
        this.head = head;
        this.currentNode = head;
    }

    @Override
    public boolean hasNext() {
        return currentNode.next != null;
    }

    @Override
    public Node next() {
        return currentNode.next;
    }

    /**
     * ����� �� �������������,
     * ������� ����������� ������
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
