import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> person = new ArrayList<>();
        person.add(new Person("Иван", 25));
        person.add(new Person("Мария", 10));
        person.add(new Person("Алексей", 5));
        person.add(new Person("Елена", 70));
        person.forEach(System.out::println);


        try (FileOutputStream fos = new FileOutputStream("person.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(person);
            System.out.println("Список людей сериализован и сохранен в файл");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (FileInputStream fis = new FileInputStream("person.bin");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Person> deserializedPeople = (List<Person>) ois.readObject();
            System.out.println("Список людей успешно восстановлен из файла:");
            deserializedPeople.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
