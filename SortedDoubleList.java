/*
 * Provides an interface for utilizing proj2.java, an array based ADT
 */

public interface SortedDoubleList {

    public boolean sortedListIsEmpty();

    public String displayAll(String s);

    public int getIndex(double value, double[] items);

    public int sortedListSize();

    public void sortedListInsert(double newItem);

    public void sortedListDelete(int posi);

    public double sortedListRetrieve(int posi);

    public void listSort(double[] items);

}
