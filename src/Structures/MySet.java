package Structures;

import Entity.Employee;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MySet {
    private Set<Employee> bufSet;
    private Scanner in = new Scanner(System.in);
    public MySet(Set<Employee> bufSet){
        this.bufSet = bufSet;
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



                    showList();
                    break;

                case "7":
                    System.out.println("Сортировка по имени:");



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
        System.out.println("Введите id: ");
        int id = in.nextInt();
        System.out.println("Введите имя: ");
        String name = in.next();
        System.out.println("Введите возраст: ");
        int age = in.nextInt();
        bufSet.add(new Employee(id, name, age));
        System.out.println("Employee успешно добавлен!");
    }

    public void showList(){
        for (Employee employee : bufSet) {
            System.out.println(employee);
        }
    }

    public void searchForName(){
        System.out.println("Введите имя: ");
        String name = in.next();
        boolean flag = true;
        int i = 0;
        for(Employee employee : bufSet){
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
        for(Employee employee : bufSet){
            if(employee.getId() == id){
                System.out.println(i + ": " + employee.toString());
                flag = false;
            }
            i++;
        }
        if(flag) { System.out.println("Не найдено."); }
    }

    public void delete(){
        System.out.println("Введите id: ");
        int id = in.nextInt();
        System.out.println("Введите имя: ");
        String name = in.next();
        System.out.println("Введите возраст: ");
        int age = in.nextInt();
        Employee buf = new Employee(id, name, age);
        if(bufSet.contains(buf)){
            bufSet.remove(buf);
            System.out.println("Элемент удален.");
        }
        else {
            System.out.println("Такого элемента нет.");
        }
    }
}
