import java.util.*;

class Car {

    private final String brand;
    private final String model;
    private final int year;

    public Car(String brand, String model,int year)
    {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

public class CarComparator {
    public static void main(String[] args) {
        printing();
    }


    public static void printing() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Yaris", 2005));
        cars.add(new Car("Ford", "Mustang", 2015));
        cars.add(new Car("Nissan", "GTR Nismo", 2008));
        cars.add(new Car("Volkswagen", "Golf", 2012));
        cars.add(new Car("Chevrolet", "Camaro", 2018));
        cars.add(new Car("Rolls Royce", "Cullinam", 2022));
        cars.add(new Car("Lamborghini", "Aventador", 2015));
        int a;
        System.out.println("1 -> sortowanie marka, model     2 -> sortowanie rocznik");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Wprowadź liczbę całkowitą: ");
        a = scanner.nextInt();
        scanner.close();

        switch (a) {
            case 1 -> brand(cars);
            case 2 -> year(cars);
        }
    }
    public static void brand(List<Car> cars)
    {
        cars.sort(new Comparator<>() {
            public int compare(Car car1, Car car2) {
                int brandComparison = car1.getBrand().compareTo(car2.getBrand());
                if (brandComparison == 0) {
                    return car1.getModel().compareTo(car2.getModel());
                }
                return brandComparison;
            }
        });

        System.out.println("Sortowanie według marki, a następnie modelu:");
        for (Car car : cars) {
            System.out.println(car.getBrand() + " " + car.getModel() + " " + car.getYear());
        }
    }

    public static void year(List<Car> cars) {
        cars.sort(new Comparator<>() {
            public int compare(Car car1, Car car2) {
                return Integer.compare(car1.getYear(), car2.getYear());
            }
        });

        System.out.println("\nSortowanie według rocznika od najstarszego do najnowszego:");
        for (Car car : cars) {
            System.out.println(car.getBrand() + " " + car.getModel() + " " + car.getYear());
        }
    }
}
