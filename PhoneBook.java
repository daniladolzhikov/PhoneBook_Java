import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Иван", "79990000001");
        addContact(phoneBook, "Петр", "79990000002");
        addContact(phoneBook, "Иван", "79990000003");
        addContact(phoneBook, "Анна", "79990000004");
        addContact(phoneBook, "Мария", "79990000005");
        addContact(phoneBook, "Петр", "79990000006");

        printPhoneBook(phoneBook);
    }

    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.compute(name, (key, existingPhones) -> {
            if (existingPhones == null) {
                existingPhones = new ArrayList<>();
            }
            existingPhones.add(phoneNumber);
            return existingPhones;
        });
    }

    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> sortedEntries = phoneBook.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .collect(Collectors.toList());

        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }
}
