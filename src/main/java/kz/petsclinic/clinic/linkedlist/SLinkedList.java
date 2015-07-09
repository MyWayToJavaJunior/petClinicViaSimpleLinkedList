package kz.petsclinic.clinic.linkedlist;

import kz.petsclinic.clinic.Person;

import java.util.Iterator;

/**
 * ������� ���������� LinkedList
 */
public class SLinkedList<E> implements Iterable<Person> {

    /**
     * ������, ��� ���������
     * ������.
     */
    private Node head;

    /**
     * ������ ������
     */
    private int size = 0;

    public SLinkedList() {
        this.head = new Node(null, null, null);
    }

    /**
     * ���������� ������� ��������
     * @param person ����� �������
     */
    public void addFirst(Person person) {
        Node newNode = new Node(head, person, head);
        head.prev = newNode;
        head.next = newNode;
        size++;
    }

    /**
     * �� ������������, �� �����
     * ���� ����������� � ��������
     * � ������������ ����������� ���������
     * �� �������
     * @param person ����� �������
     */
    public void addLast(Person person) {
        Node newNode = new Node(head, person, head);
        head.prev = newNode;
        head.next = newNode;
        size++;
    }

    /**
     * ���������� ������,
     * ���� ��� ������ ������� �
     * ������ �� ���������� ����������
     * � ������� addFirst()
     * ����� ����� ������� �����������
     * ����� head � ���������
     * �� head ���������.
     * @param person ����� �������
     */
    public void add(Person person) {
        if (size == 0) {
            addFirst(person);
        }
        else {
            Node nextNode = head.next;
            Node newNode = new Node(head, person, nextNode);
            head.next = newNode;
            nextNode.prev = newNode;
            size++;
        }
    }

    /**
     * ���������� ������
     * ������
     * @return ������� ������
     * ������
     */
    public int getSize() {
        return size;
    }

    /**
     * ������� ���� ������
     */
    public void viewList() {
        Node current = head.next;
        for (int i = 0; i < size; i++) {
            System.out.println(current.element);
            current = current.next;
        }
    }

    /**
     * ������� ������ �� ����� �������
     * @param nameOfPerson ��� �������
     * @return �������, ��� null ����
     * ������� � �������� ������ ��
     * �������
     */
    public Person findByPersonName(String nameOfPerson) {
        Node current = head.next;
        Person resultPerson = null;
        for (int i = 0; i < size; i++) {
            if (nameOfPerson.equals(current.element.getNameOfPerson())) {
                resultPerson = current.element;
            }
            current = current.next;
        }
        return resultPerson;
    }

    /**
     * �������� �������� ������ �� �������
     * @param person �������
     */
    public void remove(Person person) {
        Node current = head.next;
        for (int i = 0; i < size; i++) {
            if (person.equals(current.element)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            current = current.next;
        }
        size--;
    }

    /**
     * ������� ���������� ���������
     * @return ��������
     */
    @Override
    public Iterator<Person> iterator() {
        return new SIterator(head);
    }

    /**
     * ����� ������ �� ����� ���������
     * @param nameOfPet ��� ���������
     * ��� ������
     * @return ���������� �������
     * ��� null ���� ������� �
     * �������� ������ �� �������
     */
    public Person findByPetName(String nameOfPet) {
        Node current = head.next;
        Person resultPerson = null;
        for (int i = 0; i < size; i++) {
            if (nameOfPet.equals(current.element.getNameOfPet())) {
                resultPerson = current.element;
            }
            current = current.next;
        }
        return resultPerson;
    }
}
