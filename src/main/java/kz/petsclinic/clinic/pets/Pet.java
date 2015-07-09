package kz.petsclinic.clinic.pets;

/**
 * ����������� ����� ������ ��� ����
 * ������� ��������
 */
public abstract class Pet {
    private String nameOfPet;
    private String abilityOfPet;

    public Pet(final String nameOfPet, final String abilityOfPet) {
        this.nameOfPet = nameOfPet;
        this.abilityOfPet = abilityOfPet;
    }

    public String getPetName() {
        return nameOfPet;
    }

    public void setPetName(final String newNameOfPet) {
        this.nameOfPet = newNameOfPet;
    }

    /**
     *
     * @return ��������� ��
     * �������� ���������
     */
    public Pet getSelf() {
        return this;
    }

    @Override
    public String toString() {
        return "Pet name: " + nameOfPet + ", ability is " + abilityOfPet;
    }

}
