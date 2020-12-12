package com.sparta.daniel.tools;

public class Swap {
    public static void swapArrayTwoNumbers( int[] arrayList, int index1, int index2){

        int number3 = arrayList[index1];
        arrayList[index1] = arrayList[index2];
        arrayList[index2] = number3;
    }

    public static void swapTwoNumbers(int number1, int number2) {
        int number3 = number1;
        number1 = number2;
        number2 = number3;
    }
}
