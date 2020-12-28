/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.ArrayList;

/**
 *
 * @author tudv
 */
public class BinaryTree<T> {

    public Node root = null;
    public int size = 0;

    public void addTree(Node node) {
        if (root == null) {
            root = node;
        } else {
            Node p = root;
            while (p != null) {
                if (node.getElement().compareTo(p.getElement()) >= 0) {
                    if (p.getNodeRight() == null) {
                        p.setNodeRight(node);
                        break;
                    }
                    p = p.getNodeRight();
                } else if (node.getElement().compareTo(p.getElement()) < 0) {
                    if (p.getNodeLeft() == null) {
                        p.setNodeLeft(node);
                       // System.out.println("ppppppppppp == " + p.getNodeLeft().getElement());
                        break;
                    }
                    p =  p.getNodeLeft();
                }
            }
        }
        size++;
    }
    
    public void printTree() {
        inOrderTree(root);
    }

    public void preOrderTree(Node p) {
        if (p.getNodeLeft() != null) {
            preOrderTree(p.getNodeLeft());
        }
        System.out.println(p.getElement());
        if (p.getNodeRight() != null) {
            preOrderTree(p.getNodeRight());
        }
    }
    
    public void inOrderTree(Node p) {
        System.out.println(p.getElement());
        if (p.getNodeLeft() != null) {
            preOrderTree(p.getNodeLeft());
        }
        if (p.getNodeRight() != null) {
            preOrderTree(p.getNodeRight());
        }
    }
    
    public void postOrderTree(Node p) {
        if (p.getNodeLeft() != null) {
            preOrderTree(p.getNodeLeft());
        }
        if (p.getNodeRight() != null) {
            preOrderTree(p.getNodeRight());
        }
        System.out.println(p.getElement());
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.addTree(new Node(10));
        bt.addTree(new Node(5));
        bt.addTree(new Node(11));
        bt.addTree(new Node(3));
        bt.addTree(new Node(20));
        bt.printTree();
        System.out.println("size == " + bt.size);
    }

}
