import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class ArrayLinkedList {
    public static void main(String[] args) {
        RunningApp(1000);
        RunningApp(1000000);
    }

    public static void RunningApp(int size){
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long arrayListExecutionTime = measureListOperations(arrayList, size);
        long linkedListExecutionTime = measureListOperations(linkedList, size);

        System.out.println("Czas wykonania operacji dla " + size + " elementów");
        System.out.println("Czas wykonania operacji na ArrayList: " + arrayListExecutionTime + " nanosekund");
        System.out.println("Czas wykonania operacji na LinkedList: " + linkedListExecutionTime + " nanosekund\n");

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