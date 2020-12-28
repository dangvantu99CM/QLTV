/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author tudv
 */
public class Node<T extends Comparable<T>> {

    private T element;
    private Node nodeLeft = null;
    private Node nodeRight = null;

    public Node(T element) {
        this.element = element;
    }

    /**
     * @return the element
     */
    public T getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * @return the nodeLeft
     */
    public Node getNodeLeft() {
        return nodeLeft;
    }

    /**
     * @param nodeLeft the nodeLeft to set
     */
    public void setNodeLeft(Node nodeLeft) {
        this.nodeLeft = nodeLeft;
    }

    /**
     * @return the nodeRight
     */
    public Node getNodeRight() {
        return nodeRight;
    }

    /**
     * @param nodeRight the nodeRight to set
     */
    public void setNodeRight(Node nodeRight) {
        this.nodeRight = nodeRight;
    }
}
