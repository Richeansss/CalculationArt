package com.example.colculationart;

import java.util.ArrayList;

public class QuickSort {
    public static ArrayList<Character> quickSort(ArrayList<Character> arr, int from, int to) {

        if (from < to) {

            int divideIndex = partition(arr, from, to);

            //printSortStep(arr, from,to,divideIndex);

            quickSort(arr, from, divideIndex - 1);

            quickSort(arr, divideIndex, to);
        }
        return arr;
    }

    private static int partition(ArrayList<Character> arr, int from, int to) {
        int rightIndex = to;
        //System.out.println(to);
        int leftIndex = from;
        //System.out.println(from);

        int pivot = arr.get(from + (to - from) / 2).id_main_set;
        //System.out.print(pivot);
        while (leftIndex <= rightIndex) {

            while (arr.get(leftIndex).id_main_set < pivot) {
                //System.out.println(leftIndex);
                leftIndex++;
            }

            while (arr.get(rightIndex).id_main_set > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(ArrayList<Character> array, int index1, int index2) {
        ArrayList<Character> tmp = new ArrayList<>();
        tmp.add(array.get(index1));
        array.set(index1, array.get(index2));
        array.set(index2, tmp.get(0));
        tmp.clear(); // Юзаес
    }
}
