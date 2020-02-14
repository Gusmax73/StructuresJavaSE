package Entity;

import java.util.Comparator;

public class Employee implements Comparable{

    private int id;
    private String name;
    private int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age  = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "id = " + id + ", name = " + name + ", age = " + age;
    }

    public static Comparator<Employee> NameComparator= new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            String name1 = e1.getName().toUpperCase();
            String name2 = e2.getName().toUpperCase();

            //по возрастанию
            return name1.compareTo(name2);
            //по убыванию
            //return name2.compareTo(name1);
        }
    };

    @Override
    public int compareTo(Object o) {
        int compareId = ((Employee) o).getId();
        /* For Ascending order*/
        return this.id - compareId;

        /* For Descending order*/
        //return compareId-this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Employee emp = (Employee) obj;
        return id == emp.id
                && (name == emp.name || (name != null && name.equals(emp.getName())))
                && (age == emp.age);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + id;
        result = prime * result + age;
        return result;
    }
}
