package kz.petsclinic.clinic.pets;

/**
 * ������
 */
public class Dog extends Pet {
    private static final String DOG_ABILITY = "Kill cats";


    public Dog(final String nameOfDog) {
        super(nameOfDog, DOG_ABILITY);
    }
}
