package com.myAbstractChallenge;

public abstract class ListItem {
    protected ListItem nextItem;
    protected ListItem previousItem;
    protected Object data;

    public ListItem(Object data) {
        this.nextItem = null;
        this.previousItem = null;
        this.data = data;
    }
    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);
    abstract int compareTo(ListItem item);

    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
