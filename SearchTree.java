package com.myAbstractChallenge;

public class SearchTree implements NodeInterface {
    private ListItem root;
    private int elementCount;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;

    }

    @Override
    public int getSize() {
        return this.elementCount;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            this.root = newItem;
            this.elementCount++;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) {
                //newItem is greater, so keep adding it to the right
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    //there is no more node, so add it to right there on the right
                    currentItem.setNext(newItem);
                    this.elementCount++;
                    return true;
                }
            } else if (comparison > 0) {
                //newItem is less, move to left if possible
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    //there is no more node, so add it right there on the left
                    currentItem.setPrevious(newItem);
                    this.elementCount++;
                    return true;
                }
            } else {
                System.out.println(newItem.getData() + " already exist in the tree");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item : " + item.getData());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison < 0) {
                //item is greater, keep search in the right side of the tree
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                //item is smaller, keep search in the left side of the tree
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                //item to delete found
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    public void performRemoval(ListItem item, ListItem parent) {
        //remove the item from the tree
        if (item.next() == null) {
            //no right child node, so make the node point to the left which will remove the node even though its pointing to null node
            if(parent.next() == item){
                //the item is the right child of the parent
                parent.setNext(item.previous());
            }else if(parent.previous() == item){
                //the item is the left child of the parent
                parent.setPrevious(item.previous());
            }else {
                //parent is the item, which means we are the root
                this.root = item.previous();
            }
        }else if(item.previous() == null){
            //no left child node, so make the node point to the right which will remove the node even though its pointing to null node
            if(parent.next() == item){
                //the item is the right child of the parent
                parent.setNext(item.next());
            }else if(parent.previous() == item){
                //the item is the left child of the parent
                parent.setPrevious(item.next());
            }else {
                this.root = item.next();
            }
        }else {
            //neither left or right are null,from the right sub-tree, find the smallest value(the leftmost)
            ListItem current = item.next();
            ListItem leftMostParent = item;
            while (current.previous()!=null){
                leftMostParent = current;
                current = current.previous();
            }
            //Now put the small value in the node to be deleted
            item.setData(current.getData());
            // and delete the smallest value into our node to be deleted
            if(leftMostParent == item){
                //there was no leftmost node, so 'current' points to the smallest node (the one that must be deleted)
                item.setNext(current.next());
            }else {
                //set the smallest node's parent to point to
                //the smallest  node's roght child (which may be null)
                leftMostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getData());
            traverse(root.next());

        }

    }
}
