package com.myAbstractChallenge;

public interface NodeInterface {
    ListItem getRoot();
    int getSize();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);
}
