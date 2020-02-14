package Structures;

import Entity.Employee;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MyList {
    private List<Employee> bufList;
    private Scanner in = new Scanner(System.in);
    public MyList(List<Employee> bufList){
        this.bufList = bufList;
    }

    public void start(){
        String choice = "1";
        while( !(choice.equals("0")) ) {
            System.out.println("Для продолжения нажмите Enter");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("\nЧто сделать со списком?");
            System.out.println("\"1\" - вывести");
            System.out.println("\"2\" - добавить элемент");
            System.out.println("\"3\" - поиск по id");
            System.out.println("\"4\" - поиск по имени");
            System.out.println("\"5\" - удалить");
            System.out.println("\"6\" - сортировка по id");
            System.out.println("\"7\" - сортировка по имени");
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
                    System.out.println("Поиск элемента по id:");
                    searchForId();
                    break;

                case "4":
                    System.out.println("Поиск элемента по имени:");
                    searchForName();
                    break;

                case "5":
                    System.out.println("Удаление элемента:");
                    delete();
                    break;

                case "6":
                    System.out.println("Сортировка по id:");
                    Collections.sort(bufList);
                    showList();
                    break;

                case "7":
                    System.out.println("Сортировка по имени:");
                    bufList.sort(Employee.NameComparator);
                    showList();
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
        System.out.println("В какую позицию вставить новый элемент? (\"-1\" - в конец)");
        int pos = in.nextInt();
        if( !(pos >= -1 && pos < bufList.size())) {
            System.out.println("Такой позиции нет.");
            return;
        }
        System.out.println("Введите id: ");
        int id = in.nextInt();
        System.out.println("Введите имя: ");
        String name = in.next();
        System.out.println("Введите возраст: ");
        int age = in.nextInt();
        if(pos == -1) {
            bufList.add(new Employee(id, name, age));
        }
        else {
            bufList.add(pos, new Employee(id, name, age));
        }
        System.out.println("Employee успешно добавлен!");
    }

    public void showList(){
        for(int i = 0; i < bufList.size(); i++) {
            System.out.println(i + ": " + bufList.get(i).toString());
        }
    }

    public void searchForName(){
        System.out.println("Введите имя: ");
        String name = in.next();
        boolean flag = true;
        int i = 0;
        for(Employee employee : bufList){
            if(employee.getName().equals(name)){
                System.out.println(i + ": " + employee.toString());
                flag = false;
            }
            i++;
        }
        if(flag) { System.out.println("Не найдено."); }
    }

    public void searchForId(){
        System.out.println("Введите id: ");
        int id = in.nextInt();
        boolean flag = true;
        int i = 0;
        for(Employee employee : bufList){
            if(employee.getId() == id){
                System.out.println(i + ": " + employee.toString());
                flag = false;
            }
            i++;
        }
        if(flag) { System.out.println("Не найдено."); }
    }

    public void delete(){
        System.out.println("Введите позицию: ");
        int pos = in.nextInt();
        if(pos >= 0 && pos < bufList.size()){
            bufList.remove(pos);
            System.out.println("Элемент удален.");
        }
        else {
            System.out.println("Такой позиции нет.");
        }
    }
}
