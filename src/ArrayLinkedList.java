import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class ArrayLinkedList {
    public static void main(String[] args) {
        int numberOfElements = 1000; // Możesz dostosować tę wartość do swoich potrzeb.

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long arrayListExecutionTime = measureListOperations(arrayList, numberOfElements);
        long linkedListExecutionTime = measureListOperations(linkedList, numberOfElements);

        System.out.println("Czas wykonania operacji dla " + numberOfElements + " elementów");
        System.out.println("Czas wykonania operacji na ArrayList: " + arrayListExecutionTime + " nanosekund");
        System.out.println("Czas wykonania operacji na LinkedList: " + linkedListExecutionTime + " nanosekund\n");

        numberOfElements = 100000;

        arrayListExecutionTime = measureListOperations(arrayList, numberOfElements);
        linkedListExecutionTime = measureListOperations(linkedList, numberOfElements);

        System.out.println("Czas wykonania operacji dla " + numberOfElements + " elementów");
        System.out.println("Czas wykonania operacji na ArrayList: " + arrayListExecutionTime + " nanosekund");
        System.out.println("Czas wykonania operacji na LinkedList: " + linkedListExecutionTime + " nanosekund");
    }

    //Uzupełnienie list elementami
    private static void fillList(List<Integer> list, int numberOfElements) {
        for (int i = 0; i < numberOfElements; i++) {
            list.add(i);
        }
    }

    //Mierzenie czasu wykonywania sie działań
    private static long measureListOperations(List<Integer> list, int numberOfElements) {
        long startTime = System.nanoTime();

        //Dodawanie elementów do listy
        fillList(list, numberOfElements);

        // Usuwanie elementów z listy
        for (int i = numberOfElements - 1; i >= 0; i--) {
            list.remove(i);
        }

        // Modyfikowanie elementów w liście
        for (int i = 0; i < numberOfElements; i++) {
            list.add(i);
            list.set(i, list.get(i) + 1);
        }

        return System.nanoTime() - startTime;
    }
}