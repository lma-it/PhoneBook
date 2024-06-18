//import java.util.ArrayList;
/*
 * Класс User, который используется в качестве ключа в телефонной книге в классе {@code PhoneBook}
 */
public class User {

    /*
     * Имя контакта
     */
    protected String name;

    /*
     * Метод, который позволяет получить имя контакта
     */
    public String getName(){
        return name;
    }

    /**
     * Создает новый объект User с указанным именем.
     *
     * @param name Имя пользователя, которое будет присвоено создаваемому объекту.
     */
    public User(String name){
        this.name = name;
    }

    
    @Override
    public String toString() {
        return name;
    }

}
