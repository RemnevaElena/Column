package com.company;

public class Main {
    public static void main(String[] args) {
        Graf test = new Graf(4);

        for (Integer[] stroke : test.desk) {
            for (Integer item : stroke) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println();
        test.DeleteOfTop(2);
        for (Integer[] stroke : test.desk) {
            for (Integer item : stroke) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
//        System.out.println();
//        test.AdditionOfTop();
//        for (Integer[] stroke : test.desk) {
//            for (Integer item : stroke) {
//                System.out.print(item + " ");
//            }
//            System.out.println();
//        }
//        test.EnteringTops(1);
//        test.OutgoingTops(0);
//        test.DeleteOfAnEdge(1, 3);
//        test.AdditionEdges(2, 3, 10);
//        for (Integer[] stroke : test.desk) {
//            for (Integer item : stroke) {
//                System.out.print(item + " ");
//            }
//            System.out.println();
//        }
   }

}
