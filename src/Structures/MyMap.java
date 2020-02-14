package Structures;

import Entity.Employee;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class MyMap {
    private Map<Integer, Employee> bufMap;
    private Scanner in = new Scanner(System.in);
    public MyMap(Map<Integer, Employee> bufMap){
        this.bufMap = bufMap;
    }

    public void start() {
        String choice = "1";
        while( !(choice.equals("0")) ) {
            System.out.println("Для продолжения нажмите Enter");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("\nЧто сделать со словарем?");
            System.out.println("\"1\" - вывести");
            System.out.println("\"2\" - добавить элемент");
            System.out.println("\"3\" - поиск по ключу");
            System.out.println("\"4\" - поиск по id");
            System.out.println("\"5\" - поиск по имени");
            System.out.println("\"6\" - удалить");
            System.out.println("\"7\" - сортировка по ключу");
            System.out.println("\"8\" - сортировка по id");
            System.out.println("\"0\" - выход");
            choice = in.next();

            switch (choice) {
                case "1":
                    System.out.println("Вывод списка:");
                    showList();
                    break;

                case "2":
                    System.out.println("Добавление элемента:");
                    add();
                    break;

                case "3":
                    System.out.println("Поиск элемента по ключу:");
                    searchForKey();
                    break;

                case "4":
                    System.out.println("Поиск элемента по id:");
                    searchForId();
                    break;

                case "5":
                    System.out.println("Поиск элемента по имени:");
                    searchForName();
                    break;

                case "6":
                    System.out.println("Удаление элемента:");
                    delete();
                    break;

                case "7":
                    System.out.println("Сортировка по ключу:");
                    if(bufMap instanceof TreeMap) {
                        System.out.println("У вас TreeMap! Сортировка уже выполнена.");
                    }
                    if(bufMap instanceof HashMap) {
                        Map<Integer, Employee> treeMap = new TreeMap<Integer, Employee>(bufMap);
                        bufMap.putAll(treeMap);
                    }
                    showList();
                    break;

                case "8":
                    System.out.println("Сортировка по id:");
                    if(bufMap instanceof TreeMap) {

                    }
                    if(bufMap instanceof HashMap) {
                        Stream<Map.Entry<Integer, Employee>> sorted =
                                bufMap.entrySet().stream()
                                        .sorted(Map.Entry.comparingByValue());

                    }
                    //showList();
                    break;

                case "0":
                    System.out.println("Завершение...");
                    break;

                default:
                    System.out.println("Такого номера нет.");
                    break;
            }
        }

    }

    public void add(){
        System.out.println("Введите ключ (число): ");
        int key = in.nextInt();
        System.out.println("Введите id: ");
        int id = in.nextInt();
        System.out.println("Введите имя: ");
        String name = in.next();
        System.out.println("Введите возраст: ");
        int age = in.nextInt();
        bufMap.put(key, new Employee(id, name, age));
        System.out.println("Employee успешно добавлен!");
    }

    public void showList(){
        for(Map.Entry<Integer, Employee> m: bufMap.entrySet()) {
            System.out.println("Ключ " + m.getKey() + ": " + m.getValue().toString());
        }
    }

    public void searchForKey(){
        System.out.println("Введите ключ: ");
        int key = in.nextInt();
        if(bufMap.containsKey(key)) {
            System.out.println("Ключ " + key + ":  " + bufMap.get(key).toString());
        }
        else {
            System.out.println("Не найдено.");
        }
    }

    public void searchForName(){
        System.out.println("Введите имя: ");
        String name = in.next();
        boolean flag = true;
        for(Map.Entry<Integer, Employee> m: bufMap.entrySet()){
            if(m.getValue().getName().equals(name)){
                System.out.println("Ключ " + m.getKey() + ": " + m.getValue());
                flag = false;
            }
        }
        if(flag) { System.out.println("Не найдено."); }
    }

    public void searchForId(){
        System.out.println("Введите id: ");
        int id = in.nextInt();
        boolean flag = true;
        for(Map.Entry<Integer, Employee> m: bufMap.entrySet()){
            if(m.getValue().getId() == id){
                System.out.println("Ключ " + m.getKey() + ": " + m.getValue());
                flag = false;
            }
        }
        if(flag) { System.out.println("Не найдено."); }
    }

    public void delete(){
        System.out.println("Введите ключ: ");
        int key = in.nextInt();
        if(bufMap.containsKey(key)){
            bufMap.remove(key);
            System.out.println("Элемент удален.");
        }
        else {
            System.out.println("Записи с таким ключем нет.");
        }
    }
}
