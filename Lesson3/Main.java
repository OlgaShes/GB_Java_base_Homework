import java.util.*;

public class Main {
    public static ArrayList<Integer> getRandomList(int size, int maxLevel) {
        ArrayList<Integer> resultList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            resultList.add(new Random().nextInt(maxLevel));
        }
        return resultList;
    }

    // Реализовать алгоритм сортировки списков слиянием
    public static void mergeSort(ArrayList<Integer> list) {
        if (list.size() > 1) {
            int mid = list.size() / 2;
            ArrayList<Integer> leftPart = new ArrayList<>(list.subList(0, mid));
            ArrayList<Integer> rightPart = new ArrayList<>(list.subList(mid, list.size()));
            mergeSort(leftPart);
            mergeSort(rightPart);
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < leftPart.size() && j < rightPart.size()) {
                if (leftPart.get(i) < rightPart.get(j)) {
                    list.set(k++, leftPart.get(i++));
                } else {
                    list.set(k++, rightPart.get(j++));
                }
            }
            while (i < leftPart.size()) {
                list.set(k++, leftPart.get(i++));
            }
            while (j < rightPart.size()) {
                list.set(k++, rightPart.get(j++));
            }
        }
    }

    // Пусть дан произвольный список целых чисел, удалить из него чётные числа
    public static void deleteEvenNumbers(ArrayList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0)
                iterator.remove();
        }
    }

    // Задан целочисленный список. Найти минимальное, максимальное и среднее
    // значение.
    public static int findMinInList(ArrayList<Integer> list) {
        list.sort(null);
        return list.get(0);
    }

    public static int findMaxInList(ArrayList<Integer> list) {
        list.sort(null);
        return list.get(list.size() - 1);
    }

    public static double findMedInList(ArrayList<Integer> list) {
        list.sort(null);
        if (list.size() % 2 == 0) {
            return (double) (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2;
        }
        return list.get(list.size() / 2);
    }

    // Дано два целочисленных списка, объеденить их не допуская элементы второго
    // списка уже встречающиеся в первом.
    public static ArrayList<Integer> joinLists(ArrayList<Integer> firstList, ArrayList<Integer> secondList) {
        ArrayList<Integer> resultList = new ArrayList<>(firstList);
        ArrayList<Integer> additionalList = new ArrayList<>(secondList);
        additionalList.removeAll(firstList);
        additionalList.forEach(n -> resultList.add(n));
        return resultList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> myList = getRandomList(20, 20);
        System.out.println(myList);
        mergeSort(myList);
        System.out.println(myList);
        deleteEvenNumbers(myList);
        System.out.println(myList);
        System.out.println("min: " + findMinInList(myList));
        System.out.println("max: " + findMaxInList(myList));
        System.out.println("med: " + findMedInList(myList));
        System.out.println();
        ArrayList<Integer> list1 = getRandomList(10, 10);
        System.out.println(list1);
        ArrayList<Integer> list2 = getRandomList(10, 15);
        System.out.println(list2);
        ArrayList<Integer> list3 = joinLists(list1, list2);
        System.out.println(list3);
        System.out.println();

        // Создать ArrayList<Integer> и добавить нулевым эллементом ноль 10000 раз.
        // Повторить пятый пункт но с LinkedList.
        // Сравнить время работы пятого и шестого пунктов.

        ArrayList<Integer> testArrayList = new ArrayList<>();
        long testSize = 100_000;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < testSize; i++) {
        testArrayList.add(0, 0);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time for ArrayList --> " + (end - begin));

        LinkedList<Integer> testLinkedList = new LinkedList<>();
        begin = System.currentTimeMillis();
        for (int i = 0; i < testSize; i++) {
        testLinkedList.add(0, 0);
        }
        end = System.currentTimeMillis();
        System.out.println("Time for LinkedList --> " + (end - begin));
    }
}
