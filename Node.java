package com.myAbstractChallenge;

public class Node extends ListItem {
    public Node(Object data) {
        super(data);
    }

    @Override
    ListItem next() {
        return this.nextItem;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.nextItem = item;
        return this.nextItem;

    }

    @Override
    ListItem previous() {
        return this.previousItem;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.previousItem = item;
        return this.previousItem;
    }

    @Override
    int compareTo(ListItem item) {
        if(item != null){
            return (super.data.toString().compareTo(item.getData().toString()));
        }else {
            return -1;
        }
    }
}
