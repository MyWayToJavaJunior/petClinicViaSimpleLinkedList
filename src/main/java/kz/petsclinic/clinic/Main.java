package kz.petsclinic.clinic;

import kz.petsclinic.clinic.inputotput.IO;
import kz.petsclinic.clinic.linkedlist.SLinkedList;
import kz.petsclinic.clinic.pets.Bird;
import kz.petsclinic.clinic.pets.Cat;
import kz.petsclinic.clinic.pets.Dog;
import kz.petsclinic.clinic.pets.Pet;

/**
 * Основной исполняемый класс
 */
public class Main {

    private static boolean mainMenuSelector = true;

    public static void main(String[] args) {

        SLinkedList clinic = new SLinkedList();


        while (mainMenuSelector) {
            mainMenu(clinic);
        }


    }

    /**
     * Метод переводит поле отвечающее
     * за проверку продолжения исполнения цикла
     * основного меню в "выключенное состояние"
     * присваивая ему значение false
     */
    private static void turnOffSelector() {
        mainMenuSelector = false;
    }

    /**
     * основное меню в котором выводится
     * список операций, и пользователь
     * делает выбор посредством введения
     * номера операции
     * выполняется в цикле, пока пользователь
     * не выберет выход в меню
     * @param clinic клиника
     */
    private static void mainMenu(SLinkedList clinic) {
        IO.showMainMenu();
        String userChoice = IO.getUserChoice();
        switch (userChoice) {
            default:    break;
            case "1":   viewAllPersons(clinic);
                        break;
            case "2":   addPerson(clinic);
                        break;
            case "3":   remByPersonName(clinic);
                        break;
            case "4":   renByPersonName(clinic);
                        break;
            case "5":   viewByPersonName(clinic);
                        break;
            case "6":   remByPetName(clinic);
                        break;
            case "7":   renByPetName(clinic);
                        break;
            case "8":   viewByPetName(clinic);
                        break;
            case "0":   turnOffSelector();
                        break;
        }
    }

    /**
     * Выводит запись
     * содержащую Персону с именем
     * которое введет пользователь
     * @param clinic клиника
     */
    private static void viewByPersonName(SLinkedList clinic) {
        String nameOfPerson = IO.askAndGetNameOfPersonForView();
        Person person = clinic.findByPersonName(nameOfPerson);
        if (person == null) IO.notFound();
        else IO.print(person.toString());
    }


    private static void viewAllPersons(SLinkedList clinic) {
        clinic.viewList();
    }

    /**
     * Удаляет дальнюю от head запись
     * содержащю Персону с именем
     * которое введет пользователь
     * @param clinic клиника
     */
    private static void remByPersonName(SLinkedList clinic) {
        String nameOfPerson = IO.askAndGetNameOfPersonForRemoving();
        Person person = clinic.findByPersonName(nameOfPerson);
        if (person == null) IO.notFound();
        else clinic.remove(person);
    }

    /**
     * Переименование Персоны
     * @param clinic клиника
     */
    private static void renByPersonName(SLinkedList clinic) {
        String nameOfPerson = IO.askAndGetNameOfPersonForRename();
        Person person = clinic.findByPersonName(nameOfPerson);
        if (person == null) IO.notFound();
        else {
            person.setNameOfPerson(getValidNameForPerson(clinic));
        }
    }

    /**
     * Получение нового имени для
     * Персоны посредством пользовательского
     * ввода, происходит проверка используется
     * ли уже введенное имя
     * @param clinic клиника
     * @return новое имя для Персоны
     */
    private static String getValidNameForPerson(SLinkedList clinic) {
        String newNameForPerson;
        boolean selector = true;
        do {
            newNameForPerson = IO.askAndGetNewNameForPerson();
            if (clinic.findByPersonName(newNameForPerson) == null) selector = false;
            else IO.nameAlreadyUsed();
        } while (selector);
        return newNameForPerson;
    }

    /**
     * Добавление новой записи
     * в клинику, позльзовательский
     * ввод
     * @param clinic клиника
     */
    private static void addPerson(SLinkedList clinic) {
        String nameOfPerson = getValidNameForPerson(clinic);
        Pet newPet = getPetFromUserInput();
        clinic.add(new Person(nameOfPerson, newPet));
    }

    /**
     * Часть процедуры добавления новой
     * записи в клинику, отвечает за ввод
     * пользователем данных животного
     * @return возвращает животное
     */
    private static Pet getPetFromUserInput() {
        String petName = IO.askAndGetNameForPet();
        IO.askForPetType();
        Pet pet;
        switch (IO.getUserChoice()) {
            default:
            case "1":   pet = new Cat(petName);
                break;
            case "2":   pet = new Bird(petName);
                break;
            case "3":   pet = new Dog(petName);
        }
        return pet;
    }

    /**
     * Выводит дальнюю от head запись
     * содержащую животное с именем
     * которое введет пользователь
     * @param clinic клиника
     */
    private static void viewByPetName(SLinkedList clinic) {
        String nameOfPet = IO.askAndGetNameOfPet();
        Person person = clinic.findByPetName(nameOfPet);
        if (person == null) IO.notFound();
        else IO.print(person.toString());
    }

    /**
     * Удаляет дальнюю от head запись
     * содержащю животное с именем
     * которое введет пользователь
     * @param clinic клиника
     */
    private static void remByPetName(SLinkedList clinic) {
        String nameOfPet = IO.askAndGetNameOfPetForRemoving();
        Person person = clinic.findByPetName(nameOfPet);
        if (person == null) IO.notFound();
        else clinic.remove(person);
    }

    /**
     * Переименовывание животного
     * @param clinic клиника
     */
    private static void renByPetName(SLinkedList clinic) {
        String nameOfPet = IO.askAndGetNameOfPetForRename();
        Person person = clinic.findByPetName(nameOfPet);
        if (person == null) IO.notFound();
        else {
            person.setNameOfPet(IO.askAndGetNewNameForPet());
        }
    }
}