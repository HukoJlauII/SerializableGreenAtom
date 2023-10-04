import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

class Person implements Serializable {
    private String name;
    private int age;
    private transient String occupation;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.occupation = calculateOccupation();
    }

    private String calculateOccupation() {
        if (age >= 0 && age < 3) {
            return "Сидит дома";
        } else if (age >= 3 && age < 7) {
            return "Ходит в детский сад";
        } else if (age >= 7 && age < 18) {
            return "Учится в школе";
        } else if (age >= 18 && age < 23) {
            return "Учится в институте";
        } else if (age >= 23 && age <= 65) {
            return "Работает";
        } else {
            return "На пенсии";
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        this.occupation = calculateOccupation();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
