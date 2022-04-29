package com.tcs.edu.utils;

public class CustomCollectionOperations {

    public static <T> void reverse(T[] array){
        for (int i = 0; i < array.length / 2; i++){
            int rPointer = array.length - i - 1;
            T tmp = array[i];
            array[i] = array[rPointer];
            array[rPointer] = tmp;
        }
    }
}
