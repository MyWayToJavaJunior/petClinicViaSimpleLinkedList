package kz.petsclinic.clinic.pets;

/**
 * ���
 */
public class Cat extends Pet {
    private static final String CAT_ABILITY = "Kill birds";


    public Cat(final String nameOfCat) {
        super(nameOfCat, CAT_ABILITY);
    }
}
