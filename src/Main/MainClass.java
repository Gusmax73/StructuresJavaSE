package Main;

import Entity.Employee;
import Structures.MyList;
import Structures.MyMap;
import Structures.MySet;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        Employee one = new Employee(3, "Василий", 20);
        Employee two = new Employee(5, "Иван", 35);
        Employee three = new Employee(7, "Дмитрий", 15);

        Scanner in = new Scanner(System.in);
        System.out.println("С какой структурой работать? (ArrayList, LinkedList, HashMap, TreeMap, HashSet, TreeSet) \n");
        String choice = in.next();
        switch (choice){
            case "ArrayList":
                System.out.println("Выбран ArrayList");
                List<Employee> arrayList = new ArrayList<>();
                arrayList.add(one);
                arrayList.add(two);
                arrayList.add(three);
                MyList myList1 = new MyList(arrayList);
                myList1.start();
                break;

            case "LinkedList":
                System.out.println("Выбран LinkedList");
                List<Employee> linkedList = new LinkedList<>();
                linkedList.add(one);
                linkedList.add(two);
                linkedList.add(three);
                MyList myList2 = new MyList(linkedList);
                myList2.start();
                break;

            case "HashMap":
                System.out.println("Выбран HashMap");
                Map<Integer, Employee> hashMap = new HashMap<>();
                hashMap.put(0, one);
                hashMap.put(7, two);
                hashMap.put(5, three);
                MyMap myMap1 = new MyMap(hashMap);
                myMap1.start();
                break;

            case "TreeMap":
                System.out.println("Выбран TreeMap");
                Map<Integer, Employee> treeMap = new TreeMap<>();
                treeMap.put(0, one);
                treeMap.put(7, two);
                treeMap.put(5, three);
                MyMap myMap2 = new MyMap(treeMap);
                myMap2.start();
                break;

            case "HashSet":
                System.out.println("Выбран HashSet");
                Set<Employee> hashSet = new HashSet<>();
                hashSet.add(one);
                hashSet.add(two);
                hashSet.add(three);
                MySet mySet1= new MySet(hashSet);
                mySet1.start();
                break;

            case "TreeSet":
                System.out.println("Выбран TreeSet");
                Set<Employee> treeSet = new TreeSet<>();
                treeSet.add(one);
                treeSet.add(two);
                treeSet.add(three);
                MySet mySet2= new MySet(treeSet);
                mySet2.start();
                break;



            default:
                System.out.println("\nТакой структуры нет.");
                break;
        }
        System.out.println("Программа окончена.");
    }
}
