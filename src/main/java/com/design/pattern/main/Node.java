package com.design.pattern.main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DAO TUAN ANH (DENNIS).
 * @created on 26/6/16.
 */
public class Node {
    public Node[] children;
    public Node right;

    public Node root;

    private String name;

    public Node(String name) {
        this.name = name;
    }

    public Node(String name, Node root) {
        this.root = root;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void populateRight() {
        populateRightNode(root == null ? this : root, this);
    }

    public void populateRightNode(Node root, Node parent) {
        if (null != children) {
            for (int i = 0; i < children.length; i++) {
                Node node = children[i];
                int rightIndex = i + 1;
                if (rightIndex < children.length) {
                    node.setRight(children[rightIndex]);
                } else if (root != parent) {
                    node.setRight(getNextCousin(root, parent));
                }
                node.populateRightNode(root, node);
            }
        }
    }

    private Node getNextCousin(Node root, Node node) {
        Node rightNodeSiblingsWithChildren = getRightNodeSiblingsWithChildren(root, node);
        if (rightNodeSiblingsWithChildren != null) {
            Node[] cousins = rightNodeSiblingsWithChildren.getChildren();
            if (cousins != null) {
                return cousins[0];
            }
        }
        return null;
    }

    private Node getRightNodeSiblingsWithChildren(Node root, Node inputNode) {
        Queue<Node> queue = new LinkedList<>();
        boolean inThisLevel = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node == null) return null; // The most right sibling, return null instead of going next level
            Node[] children = node.getChildren();
            if(node == inputNode) {
                inThisLevel = true;
                continue;
            }
            if (inThisLevel) {
                if (inputNode != node && null != children) {
                    return node; // Return the next right node that has children
                }
            }
            if (children != null) {
                for (int i = 0; i < children.length; i++) {
                    Node childNode = children[i];
                    queue.add(childNode);
                    if (childNode == inputNode && i == children.length - 1) {
                        // Last item node of the level, next one should not be next level node.
                        queue.add(null);
                    }

                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Node{");
        sb.append("children=").append(children == null ? "null" : Arrays.asList(children).toString());
        sb.append(", right=").append(right == null ? "null" : right.getName());
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}