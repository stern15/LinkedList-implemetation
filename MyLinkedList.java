package com.myAbstractChallenge;

public class MyLinkedList implements NodeInterface {
    private ListItem root;
    private int elementCount;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public int getSize() {
        return this.elementCount;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            this.root = newItem;
            elementCount++;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);

            if (comparison < 0) {
                //the parameter is greater than the data, so put it to the right

                if (currentItem.next() != null) {
                    //keep moving till the end
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    elementCount++;
                    return true;
                }
            } else if (comparison > 0) {
                //the parameter is less than the data, so put it to the left

                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);

                } else {
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    this.root = newItem;
                }
                elementCount++;
                return true;
            } else {
                System.out.println(newItem.getData() + " already exist in the list");
                return false;
            }


        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting element " + item.getData());
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            //found the element to delete
            if (comparison == 0) {
                if (currentItem == root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                elementCount--;
                return true;

            } else if (comparison < 0) {
                //element not reached yet
                currentItem = currentItem.next();
            }
            //
            else {
                //passed the element
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("Empty list");
        } else {
            while (root != null) {
                System.out.println(root.getData());
                root = root.next();
            }
        }
//        if(root != null){
//            System.out.println(root.getData());
//            traverse(root.next());
//        }
    }
}
