package com.divashchenko;


public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(getFiboNumber(i) + " ");
        }


    }

    private static int getFiboNumber (int index) {
        if (index == 0) {
            return 0;
        } else  if (index == 1) {
            return 1;
        } else {
            return getFiboNumber(index - 1) + getFiboNumber(index - 2);
        }
    }
}
