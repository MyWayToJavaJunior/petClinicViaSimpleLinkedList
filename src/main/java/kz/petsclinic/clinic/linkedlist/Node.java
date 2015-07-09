package kz.petsclinic.clinic.linkedlist;

import kz.petsclinic.clinic.Person;

/**
 * Единица LinkedList
 */
public class Node<E> {
    Person element;
    Node<Person> next;
    Node<Person> prev;

    Node (Node<Person> prev, Person element, Node<Person> next) {
        this.prev = prev;
        this.element = element;
        this.next = next;
    }

}
