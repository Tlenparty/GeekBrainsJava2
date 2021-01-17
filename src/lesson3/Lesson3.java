package lesson3;

import java.util.*;

public class Lesson3 {
    /**
     * 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).                       +++
     * a) Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).                         +++
     * б) Посчитать, сколько раз встречается каждое слово.                                                                  +++
     * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.           +++
     * В этот телефонный справочник с помощью метода add() можно добавлять записи.                                          +++
     * С помощью метода get() искать номер телефона по фамилии. Следует учесть,                                             +++
     * что под одной фамилией может быть несколько телефонов (в случае однофамильцев),                                      +++
     * тогда при запросе такой фамилии должны выводиться все телефоны.                                                      +++
     * Желательно как можно меньше добавлять своего, чего нет в задании
     * (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
     * делать взаимодействие с пользователем через консоль и т.д.).
     * Консоль желательно не использовать (в том числе Scanner),
     * тестировать просто из метода main(), прописывая add() и get().
     */

    public static void main(String[] args) {

/*
        HashMap<String,String> hm = new HashMap<>();
        hm.put("Russia","Moscow");
        hm.put("France","Paris");
        hm.put("Germany","Berlin");
        hm.put("Norway","Oslo");
        for (Map.Entry<String, String> o : hm.entrySet()) {
            System.out.println("Ключи = " + o.getKey() + "Значение = " + o.getValue());
        }
*/
        String[] fruits = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "banana", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pea", "pepper", "pineapple", "pumpkin", "potato", "potato", "mushroom", "avocado", "apple", "peanut",
        "apple", "lemon", "grape", "pea", "leak"};
        System.out.println("Начальный массив фруктов \n" + Arrays.toString(fruits));
        System.out.println("++++++++++++++++++++++++++");

        // 1а + 1b
        Set<String>fruitsSet = new HashSet<>(Arrays.asList(fruits));
        System.out.println("Количество фруктов = " + fruitsSet.size() + " Список фруктов = \n" + fruitsSet);
        System.out.println("++++++++++++++++++++++++++");

        // 1b (вариант 2)
        Map <String, Integer> fruitsMap = new HashMap<>();
        for (String fruit : fruits) {
            fruitsMap.put(fruit,fruitsMap.getOrDefault(fruit,0) + 1);
        }
            System.out.println(fruitsMap);
            System.out.println("+++++++++++++++++++++");

        // 2

        PhoneBook pb = new PhoneBook();

        pb.add("Ivanov", "89312578597");
        pb.add("Ivanov", "88005553535");
        pb.add("Petrov", "00000000000");
        System.out.println(pb.get("Ivanov"));




    }
}
