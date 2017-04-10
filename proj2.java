/* 
 * Provides an assortment of methods to create an array based ADT
 */

import java.util.Scanner;

public class proj2 implements SortedDoubleList {

    private static final int LIST_SIZE = 10;
    private static double[] items;
    private int numItems;
// a method to get the position of a number given by the user

    public int getIndex(double value, double[] items) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == value) {
                return i;
            }
        }

        return -1;
    }
// constructor to create the list

    public proj2() {
        items = new double[LIST_SIZE];
        numItems = 0;
    }
// a method to inform the user if the list is empty or not

    public boolean sortedListIsEmpty() {
        return (numItems == 0);
    }
// a method to display the list

    public String displayAll(String s) {
        for (int i = 0; i < LIST_SIZE; i++) {
            s += items[i] + " ";
        }
        return s;
    }
// a method to get the number of items in the list

    public int sortedListSize() {
        return numItems;
    }
// a method to insert a number given from the user into the list

    public void sortedListInsert(double newItem) {
        if (numItems >= LIST_SIZE) {
            throw new RuntimeException("List is full");
        } else if (numItems == 0) {
            items[0] = newItem;
            numItems++;
        } else {
            items[numItems + 1] = newItem;
            numItems++;
        }
    }

// a method to delete a number by asking the user what number they wants to delete
    public void sortedListDelete(int posi) {
        if (posi >= 1 && posi <= numItems) {

            for (int i = getIndex(posi, items); i < items.length - 1; i++) {
                items[i] = items[i + 1];
            }
        }

        numItems--;
    }

// a method to sort the numbers in the list in order
    public void listSort(double[] items) {
        for (int index = 0; index < numItems; index++) {
            for (int j = index + 1; j < numItems; j++) {
                if (items[j] < items[index]) {
                    double temp = items[j];
                    items[j] = items[index];
                    items[index] = temp;
                }
            }
        }
    }
// a method to retrieve and print the number by asking the user for the index

    public double sortedListRetrieve(int posi) throws IndexOutOfBoundsException {
        if (posi >= 1 && posi <= numItems) {
            return items[posi - 1];
        }

        return 1;
    }

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        proj2 aList = new proj2();
        while (true) {
            System.out.println("Enter 1 to check if the list is empty, Enter 2 to get the size of the list, enter 3 to add another number, Enter 4 to remove a number, Enter 5 to retrieve a number, Enter 6 to get the index of a number, enter 7 to display the list ");
            double userInput2 = scan.nextDouble();
            if (userInput2 == 1) {
                boolean emptyornot = aList.sortedListIsEmpty();
                System.out.println(emptyornot);
            }
            if (userInput2 == 2) {
                int listSize = aList.sortedListSize();
                System.out.println(listSize);

            }
            if (userInput2 == 3) {
                System.out.println("Enter the number to be added:");
                double userInput3 = scan.nextDouble();
                aList.sortedListInsert(userInput3);
                aList.listSort(items);

            }
            if (userInput2 == 4) {
                System.out.println("Enter the number to be removed:");
                int userInput4 = scan.nextInt();
                aList.sortedListDelete(userInput4);
                aList.listSort(items);

            }
            if (userInput2 == 5) {
                System.out.println("Enter the index to get the number:");
                int userInput5 = scan.nextInt();
                double retrievedNum = aList.sortedListRetrieve(userInput5);
                System.out.println(retrievedNum);

            }
            if (userInput2 == 6) {
                System.out.println("Enter the number to get the index :");

                double userInput6 = scan.nextDouble();
                int numIndex = aList.getIndex(userInput6, items);
                System.out.println(numIndex);
            }
            if (userInput2 == 7) {
                String s = " ";
                String builtString = aList.displayAll(s);
                System.out.println(builtString);
            }

        }

    }
}
