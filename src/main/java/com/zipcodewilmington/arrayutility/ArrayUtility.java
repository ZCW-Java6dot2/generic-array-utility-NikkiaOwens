package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] array;

    public ArrayUtility(T[] inputArray) {
        this.array = inputArray;
    }

    public T[] removeValue(T valueToRemove) {
        T[] tempArray = Arrays.copyOf(array, array.length - getNumberOfOccurrences(valueToRemove));

        int j =0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != valueToRemove) {
                    tempArray[j] = array[i];
                    j++;
            }



        }
        return tempArray;
    }

    public T[] mergeArray(T[] arrayToMerge){
//        List list = new ArrayList(Arrays.asList(array));
//        list.addAll(Arrays.asList(arrayToMerge));
//        T[] merged = (T[]) list.toArray();
//        return merged;

//        T[] result = T[array.length + arrayToMerge.length];
//    final List<T> merged = new ArrayList<>();
//    List<T> base = Arrays.asList(array);
//    List<T> added = Arrays.asList(arrayToMerge);
//    merged.addAll(base);
//    merged.addAll(added);
//    return (T[]) merged.toArray();

        return (T[]) Stream.of(array, arrayToMerge)
                .flatMap(Stream::of)
                .toArray();
    }

    // merge practice on int[]

//    public int[] mergeIntArray(int[] arrayToMerge){
//
//    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
       array = mergeArray(arrayToMerge);

        Integer dupes = getNumberOfOccurrences(valueToEvaluate);
        // count duplicates array



        return dupes;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valueToEvaluate) {
                count++;
            }

        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        Integer mostCommon = Integer.MIN_VALUE;
        List<T> arrayList = new ArrayList<>();
        T mostCommonVal = null; //most common val doesn't exist, go thru and get it
        arrayList.addAll(Arrays.asList(arrayToMerge));
        arrayList.addAll(Arrays.asList(array));
        for (T t : arrayList) {
            Integer current =  Collections.frequency(arrayList, t);
            if (current > mostCommon) {
                mostCommon = current;
                mostCommonVal = t;
            }
        }
        return mostCommonVal;
    }
    }

//        public T getMostCommonFromMerge (T[] arrayToMerge){
//            return (T) arrayToMerge;
//        }
//    }

