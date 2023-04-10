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
        ArrayList<Character> tmp = new ArrayList<Character>();
        tmp.add(array.get(index1));
        //System.out.println(tmp.get(0).id_chr_name);
        array.set(index1, array.get(index2));
        array.set(index2, tmp.get(0));
        tmp.clear(); // Юзаес
        //for (int i=0;i < array.size();i++){
        //    System.out.print(array.get(i).id_main_set + " ");
        //}
        //System.out.print("\n");
    }

    private static String arrayToString(ArrayList<Character> array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array.get(i).id_chr_name);
        }
        sb.append("]");
        return sb.toString();
    }

    private static void printSortStep(ArrayList<Character> arr, int from, int to, int partitionIndex) {
        //System.out.print(arrayToString(arr));
        System.out.print("\npartition at index: " + partitionIndex);
        for (int i = from; i < to;i++){
            System.out.print(", left: " + arr.get(i).id_main_set);
        }
        System.out.println("\n");
        for (int i = partitionIndex; i < to + 1;i++){
            System.out.print(", right: " + arr.get(i).id_main_set);
        }
        System.out.println("\n");
    }


    public static ArrayList<Character> mergeSort(ArrayList<Character> array) {
        ArrayList<Character> currentSrc = new ArrayList<Character>(array);
        ArrayList<Character> currentDest = new ArrayList<Character>();
        ArrayList<Character> tmp = new ArrayList<Character>();

        int size = 1;
        while (size < array.size()) {
            for (int i = 0; i < array.size(); i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }
            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;
        }
        return currentSrc;
    }

    private static void merge(ArrayList<Character> src1, int src1Start, ArrayList<Character> src2, int src2Start, ArrayList<Character> dest, int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.size());
        int src2End = Math.min(src2Start + size, src2.size());

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1.get(index1).id_main_set < src1.get(index1).id_main_set)) {
                dest.add(src1.get(index1));
                index1++;
            } else {
                dest.add(src2.get(index2));
                index2++;
            }
        }
    }
}
