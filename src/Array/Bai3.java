package Array;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] a = new int [n];


        int max = 1;
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for(int i = 0;i < n-1 ; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                }
            }
        }

        int maxIndex = 0;
        for(int i = 0; i < a.length; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(a[i] == a[j]) {
                    count = count + 1;

                }

            }
            if(i ==0||a[i] != a[i-1]){

                System.out.println(a[i] + " xuat hien " + count +  " lan");
            }
            if(count > max) {
                max = count;
                maxIndex = i;
            }

        }

        System.out.println("Phan tu xuat hien nhieu nhat " + a[maxIndex]);

    }
}
