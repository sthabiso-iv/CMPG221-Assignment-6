/**
 * Test program for MyLinkedList /**
  *
  * @author (32465092 MSM Dhlamini)
  * @version (5 October 2023)
*/

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.append(1);
        list.append(2);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(4);
        list.append(5);

        System.out.println("Original List: " + list);

        list.findAndRemoveDuplicates();

        System.out.println("List after removing duplicates: " + list);
    }
}