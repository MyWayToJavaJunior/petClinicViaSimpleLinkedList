package kz.petsclinic.clinic.linkedlist;

import kz.petsclinic.clinic.Person;

import java.util.Iterator;

/**
 * Простая реализация LinkedList
 */
public class SLinkedList<E> implements Iterable<Person> {

    /**
     * Голова, или основание
     * списка.
     */
    private Node head;

    /**
     * размер Списка
     */
    private int size = 0;

    public SLinkedList() {
        this.head = new Node(null, null, null);
    }

    /**
     * добавление первого элемента
     * @param person новая Персона
     */
    public void addFirst(Person person) {
        Node newNode = new Node(head, person, head);
        head.prev = newNode;
        head.next = newNode;
        size++;
    }

    /**
     * Не используется, но могло
     * быть реализовано в варианте
     * с произвольным добавлением элементов
     * по индексу
     * @param person новая Персона
     */
    public void addLast(Person person) {
        Node newNode = new Node(head, person, head);
        head.prev = newNode;
        head.next = newNode;
        size++;
    }

    /**
     * Добавление Персон,
     * если это первая персона в
     * списке то добавление происходит
     * с помощью addFirst()
     * иначе новый элемент вставляется
     * между head и следующим
     * за head элементом.
     * @param person новая Персона
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
     * Возвращает размер
     * списка
     * @return текущий размер
     * сриска
     */
    public int getSize() {
        return size;
    }

    /**
     * выводит весь список
     */
    public void viewList() {
        Node current = head.next;
        for (int i = 0; i < size; i++) {
            System.out.println(current.element);
            current = current.next;
        }
    }

    /**
     * Находит запись по имени Персоны
     * @param nameOfPerson имя Персоны
     * @return Персону, или null если
     * Персона с заданным именем не
     * найдена
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
     * Удаление элемента списка по Персоне
     * @param person Персона
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
     * Простая реализация итератора
     * @return итератор
     */
    @Override
    public Iterator<Person> iterator() {
        return new SIterator(head);
    }

    /**
     * Поиск записи по имени животного
     * @param nameOfPet имя животного
     * для поиска
     * @return возвращает Персону
     * или null если персона с
     * заданным именем не найдена
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
