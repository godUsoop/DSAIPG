package com.phasmidsoftware.dsaipg.util;

import java.util.Arrays;
import java.util.Random;

public class ArrayGenerator {

    private int length;

    private final Random random;

    public ArrayGenerator(int length) {
        this.length = length;
        random = new Random();
    }

    public Integer[][] generateArray(int numberOfArrays, String type) {
        Integer[][] arr = new Integer[numberOfArrays][];
        for (int i = 0; i < numberOfArrays; i++) {
            arr[i] = new Integer[length];
            for (int j = 0; j < length; j++){
                arr[i][j] = random.nextInt(1000);
            }
            switch (type.toLowerCase()) {
                case "ordered":
                    Arrays.sort(arr[i]);
                    break;
                case "reverse":
                    Arrays.sort(arr[i], (a, b) -> b - a);
                    break;
                case "partially":
                    Arrays.sort(arr[i]);
                    shufflePartially(arr[i]);
                    break;
                default:
                    break;
            }
            length *= 2;
        }
        return arr;
    }

    private void shufflePartially(Integer[] array) {
        int start = (int) (array.length * random.nextDouble());
        for (int i = start; i < array.length; i++) {
            int j = random.nextInt(array.length - start) + start;
            swap(array, i, j);
        }
    }

    private void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
