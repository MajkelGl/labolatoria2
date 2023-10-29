import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
    private String Name;
    private int Age;

    public Person(String Name, int wiek) {
        this.Name = Name;
        this.Age = wiek;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }
}

public class Persons {
    public static void main(String[] args) {
        printing();
    }

    public static void printing(){
        List<Person> PeopleList = new ArrayList<>();
        PeopleList.add(new Person("Anna", 30));
        PeopleList.add(new Person("Marek", 30));
        PeopleList.add(new Person("Jan", 25));
        PeopleList.add(new Person("Kacper", 18));
        PeopleList.add(new Person("Katarzyna", 35));
        PeopleList.add(new Person("Paweł", 22));
        PeopleList.add(new Person("Zbigniew", 21));
        Comparator<Person> AgeComparator = new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };

        // Sortowanie listy za pomocą komparatora
        Collections.sort(PeopleList, AgeComparator);

        // Wyświetlenie posortowanej listy
        for (Person Person : PeopleList) {
            System.out.println("Imię: " + Person.getName() + ", Wiek: " + Person.getAge());
        }
    }
}