package kz.petsclinic.clinic.pets;

/**
 * �����
 */
public class Bird extends Pet {
    private static final String BIRD_ABILITY = "Kill dogs";


    public Bird(final String nameOfBird) {
        super(nameOfBird, BIRD_ABILITY);
    }
}
