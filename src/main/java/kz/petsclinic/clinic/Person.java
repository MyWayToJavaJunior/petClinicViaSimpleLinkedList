package kz.petsclinic.clinic;

import kz.petsclinic.clinic.pets.Pet;

/**
 * Запись в клинике
 */
public class Person {
    private String nameOfPerson;
    private Pet petOfPerson;

    public Person(final String nameOfPerson, Pet petOfPerson) {
        this.nameOfPerson = nameOfPerson;
        this.petOfPerson = petOfPerson;
    }

    public String getNameOfPerson() {
        return this.nameOfPerson;
    }

    public String getNameOfPet() {
        return this.petOfPerson.getPetName();
    }

    public void setNameOfPet(String newNameOfPet) {
        this.petOfPerson.setPetName(newNameOfPet);
    }

    public void setNameOfPerson(String newNameOfPerson) {
        this.nameOfPerson = newNameOfPerson;
    }

    @Override
    public String toString() {
        return "Person name: " + this.nameOfPerson + ", " + petOfPerson.toString();
    }

}
