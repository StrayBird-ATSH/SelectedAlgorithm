package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-1, 78, 9, 7, 5, 567, -5));
        System.out.println(insertionSort(list));
        System.out.println(mergeSort(list));
    }

    private static ArrayList<Integer> insertionSort(ArrayList<Integer> input) {
        if (input == null || input.size() == 1) return input;
        for (int j = 1; j < input.size(); j++) {
            int key = input.get(j);
            int i = j - 1;
            while (i >= 0 && input.get(i) > key) {
                input.set(i + 1, input.get(i));
                i--;
            }
            input.set(i + 1, key);
        }
        return input;
    }

    private static List<Integer> mergeSort(List<Integer> input) {
        if (input.size() <= 1) return input;
        List<Integer> left = mergeSort(input.subList(0, input.size() / 2));
        List<Integer> right = mergeSort(input.subList(input.size() / 2, input.size()));
        ArrayList<Integer> finalList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size())
            if (left.get(leftIndex) < right.get(rightIndex)) finalList.add(left.get(leftIndex++));
            else finalList.add(right.get(rightIndex++));
        if (leftIndex < left.size()) for (; leftIndex < left.size(); leftIndex++) finalList.add(left.get(leftIndex));
        else for (; rightIndex < right.size(); rightIndex++) finalList.add(right.get(rightIndex));
        return finalList;
    }
}
