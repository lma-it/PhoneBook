/*
* Aidar - 111, 222, 000
* Alena - 777
* Oleg - 2222, 87987, 54546, 548, 6549
*
* -> 1 класс User {name, List<Integer>}, 2 class Phonebook { Map }
*
* -> User - переопредилить 2 метода Object : equals и hashcode
*
* Phonebook -> addPhone(long), removePhone(long), printAll() ->
*
* Oleg - 2222, 87987, 54546, 548, 6549
* Aidar - 111, 222, 000
* Alena - 777
*
*
* Comparator -> примеры кода с компаратором (google)
* 
*/

import static print_module.print_library.println;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

/**
 * Основной класс, содержит метод main, в котором происходит вся логика программы.
 * Класс содержит приватный список {@code private HashMap<User, ArrayList<Long>>}, который хранит в себе телефонный справочник.
 * Ключом справочника является User, а в качестве значения выступает список номеров для каждого User'а
 */
public class PhoneBook {
    private HashMap<User, ArrayList<Long>> phoneBook = new HashMap<>();
    
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        User alex = new User("Alex");
        User john = new User("John");
        User dave = new User("Dave");
        User alice = new User("Alice");
        User ann = new User("Ann");
        User victoriya = new User("Victoriya");
        User joan = new User("Joan");
        User elice = new User("Elice");

        phoneBook.add(elice, 124125L);
        phoneBook.add(elice, 4634L);
        phoneBook.add(elice, 1315L);
        phoneBook.add(elice, 346341L);

        phoneBook.add(ann, List.of(23525L, 2521L, 4363573L));
        phoneBook.add(joan, List.of(12512362L, 45656L, 4645634L, 34634L, 495343L));
        phoneBook.add(dave, List.of(46534L, 2342L, 1231L, 34574532L));
        phoneBook.add(alex, List.of(23523L, 236734L));
        phoneBook.add(alice, List.of(34634L, 8547678L, 934367L, 2365342L));
        phoneBook.add(victoriya, 13412L);
        phoneBook.add(victoriya, 23634621L);
        phoneBook.add(john, List.of(1231254L, 1242361L, 639L));

        phoneBook.printAll();
    }

    /**
     * Добавляет номер телефона для пользователя в телефонную книгу.
     * Если пользователь уже существует в телефонной книге, номер добавляется к списку его номеров.
     * Если пользователя нет в телефонной книге, создается новый список с этим номером и пользователь добавляется в книгу.
     *
     * @param user Пользователь, для которого нужно добавить номер телефона.
     * @param phone Номер телефона, который нужно добавить.
     */
    public void add(User user, Long phone){

        if(phoneBook.containsKey(user)){
            phoneBook.get(user).add(phone);
        }else{
            ArrayList<Long> list = new ArrayList<>();
            list.add(phone);
            phoneBook.put(user, list);
        }

    }

    /**
     * Добавляет список номеров телефонов для указанного пользователя в телефонную книгу.
     * Если пользователь уже существует в телефонной книге, номера из списка добавляются к его текущим номерам.
     * Если пользователя нет в телефонной книге, создается новый список с этими номерами и пользователь добавляется в книгу.
     *
     * @param user Пользователь, для которого нужно добавить список номеров телефонов.
     * @param list Список номеров телефонов для добавления.
     */
    public void add(User user, List<Long> list){

        if(phoneBook.containsKey(user)){
            phoneBook.get(user).addAll(list);
        }else{
            ArrayList<Long> phoneList = new ArrayList<>(list);
            phoneBook.put(user, phoneList);
        }

    }

    /**
     * Удаляет номер телефона из телефонной книги.
     * Если номер найден и удален, возвращает удаленный номер.
     * Если номер не найден, выводит сообщение и возвращает -1.
     *
     * @param phone Номер телефона для удаления из телефонной книги.
     * @return Удаленный номер телефона или -1, если номер не найден.
     */
    public Long remove(Long phone){
        /*
         * Создаем перемнную типа User
         */
        User key = null;
        /*
         * Создаем переменную remove для хранения номера, который мы будем удалять
         * чтоб потом его вывести на экран.
         */
        Long remove = 0L;
        if(phoneBook.containsValue(phone)){
            for(Entry<User, ArrayList<Long>> entry : phoneBook.entrySet()){
                if(entry.getValue().contains(phone)){
                    key = entry.getKey();
                    remove = phone;
                    break;
                }
            }
            phoneBook.get(key).remove(phone);
            return remove;
        }else{
            println("Такого номера нет в телефонном справочнике");
            /*
             * Если удалять нечего, то возвращаем -1
             */
            return -1L;
        }
    }

    /**
     * Выводит все записи в телефонной книге, отсортированные по убыванию количества номеров телефонов.
     * Записи с большим количеством номеров телефонов выводятся первыми.
     */
    public void printAll(){
        // Создаем список записей из HashMap
        List<Map.Entry<User, ArrayList<Long>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем список по возрвстанию количества номеров
        Collections.sort(entries, (o1, o2) -> Integer.compare(o2.getValue().size(), o1.getValue().size()));

        // Выводим отсортированные записи
        for (Map.Entry<User, ArrayList<Long>> entry : entries) {
            println("Имя: " + entry.getKey() + ", Список телефонов: " + entry.getValue());
        }
        
    }
}