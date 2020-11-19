import java.util.Arrays;
import java.util.Random;

public class ArrayTask {
    public static void main(String[] args) {
        int[] arr1 = getRandomArray(10, 2);
        System.out.println("Задание 1\n" + Arrays.toString(arr1));
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0) {
                arr1[i] = 1;
            } else {
                arr1[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println();

        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
        }
        System.out.println("Задание 2\n" + Arrays.toString(arr2));
        System.out.println();

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Задание 3");
        for (int i = 0; i < arr3.length; i++) {
            System.out.printf("%-4d", arr3[i]);
        }
        System.out.println();
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
            System.out.printf("%-4d", arr3[i]);
        }
        System.out.println();

        System.out.println("\nЗадание 4");
        int[][] arr4 = getDiagArr(6);
        printArray(arr4);

        int[] arr5 = getRandomArray(10, 100);
        System.out.println("Задание 5\n" + Arrays.toString(arr5));
        int minValue = getMinValueArray(arr5);
        System.out.println("Min = "+ minValue);
        int maxValue = getMaxValueArray(arr5);
        System.out.println("Max = " + maxValue);

        int[] arr6 = getRandomArray(10, 2);
        System.out.println("Задание 6\n" + Arrays.toString(arr6));
        System.out.println(isElement(arr6));

        int[] arr7= getRandomArray(10, 5);
        System.out.println("Задание 7\nСдвиг влево\n" + Arrays.toString(arr7));
        shiftElementsArray(arr7, 3);
        System.out.println(Arrays.toString(arr7));

        int[] arr7New= getRandomArray(10, 5);
        System.out.println("Сдвиг вправо\n"+Arrays.toString(arr7New));
        shiftElementsArray(arr7New, -3);
        System.out.println(Arrays.toString(arr7New));

    }
    public static int[][] getDiagArr (int index){
        int[][] arr = new int[index][index];
        for (int i = 0; i < index; i++) {
            arr[i][i] = 1;
            arr[i][index-1-i] = 1;
        }
        return arr;
    }

    public static void printArray (int [][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%3d", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] getRandomArray (int length, int maxValue){
        int[] arr= new int[length];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(maxValue);
        }
        return arr;
    }
 // Методы для задания №5
    public static int getMinValueArray(int[] numbers) {
        int minValue = numbers[0];
        for (int i = 1; i < (numbers.length); i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
            return minValue;
    }

    public static int getMaxValueArray(int[] numbers) {
        int maxValue = numbers[0];
        for (int i = 1; i < (numbers.length); i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }
// Метод по заданию №6
    public static boolean isElement( int [] arr){
        int leftValue=0;
        int rightValue=sumElementsArray(arr);
        for (int i = 0; i < arr.length-1; i++) {
           leftValue+=arr[i];
           rightValue -= arr[i];
           if (leftValue==rightValue){
               System.out.println("i=" + i);//строчки оставлены для демонстрации работы метода
               System.out.println("leftValue = " + leftValue + "\nrightValue = " + rightValue);//* то же
                return true;
           } else if (leftValue>rightValue){
               return false;
           }
       }
       return false;
    }

    public static int sumElementsArray (int [] arr){
        int sum = 0;
        for (int i = 0; i <arr.length ; i++) {
            sum +=arr[i];
        }
        return sum;
    }

    // Метод к заданию №7
    public static void shiftElementsArray (int[] arr, int shift){  //shift задает шаг сдвига элементов
        int index = arr.length - 1;
        for (int i = 0; i < Math.abs(shift); i++) {
            if(shift>0) {
                int temp = arr[0];
                for (int j = 0; j < index; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[index] = temp;
            } else {
                int temp = arr[index];
                for (int j = 0; j < index ; j++) {
                    arr[index-j] = arr[index-(j + 1)];
                }
                arr[0] = temp;
            }
        }
    }
}
