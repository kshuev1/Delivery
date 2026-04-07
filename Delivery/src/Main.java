import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Address {
    private String country;
    private String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) &&
                Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Address, Integer> costPerAddress = new HashMap<>();

        // заполняем карту
        costPerAddress.put(new Address("Россия", "Москва"), 200);
        costPerAddress.put(new Address("Россия", "Казань"), 200);
        costPerAddress.put(new Address("США", "Нью-Йорк"), 500);
        costPerAddress.put(new Address("Германия", "Берлин"), 300);

        int totalCost = 0;

        while (true) {
            System.out.println("\nЗаполнение нового заказа.");

            System.out.print("Введите страну (или end): ");
            String country = scanner.nextLine();
            if (country.equalsIgnoreCase("end")) {
                break;
            }

            System.out.print("Введите город: ");
            String city = scanner.nextLine();

            System.out.print("Введите вес (кг): ");
            int weight = Integer.parseInt(scanner.nextLine());

            Address address = new Address(country, city);

            if (!costPerAddress.containsKey(address)) {
                System.out.println("Доставки по этому адресу нет");
                continue;
            }

            int pricePerKg = costPerAddress.get(address);
            int deliveryCost = pricePerKg * weight;
            totalCost += deliveryCost;

            System.out.println("Стоимость доставки составит: " + deliveryCost + " руб.");
            System.out.println("Общая стоимость доставок: " + totalCost + "руб.");
        }
    }
}