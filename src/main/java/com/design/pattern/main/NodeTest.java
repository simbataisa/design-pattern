package com.design.pattern.main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author DAO TUAN ANH (DENNIS).
 * @created on 26/6/16.
 */
public class NodeTest {

    @Test
    public void testRightNode() {
        Node root = new Node("Root");
        Node l1A = new Node("Lvl1A", root);
        Node l1B = new Node("Lvl1B", root);
        Node l1C = new Node("Lvl1C", root);

        Node l2D = new Node("Lvl2D", root);
        Node l2E = new Node("Lvl2E", root);
        Node l2F = new Node("Lvl2F", root);

        Node l3G = new Node("Lvl3G", root);
        Node l3H = new Node("Lvl3H", root);
        Node l3I = new Node("Lvl3I", root);
        Node l3J = new Node("Lvl3J", root);


        root.setChildren(new Node[] {l1A, l1B, l1C});
        l1A.setChildren(new Node[] {l2D, l2E});
        l1C.setChildren(new Node[] {l2F});

        l2D.setChildren(new Node[] {l3G, l3H});
        l2F.setChildren(new Node[] {l3I, l3J});

        /*assertEquals(l1C.getName(), root.getRightNodeSiblingsWithChildren(root, l1A).getName());
        assertEquals(null, root.getRightNodeSiblingsWithChildren(root, l1C));
        assertEquals(l2F.getName(), root.getRightNodeSiblingsWithChildren(root, l2D).getName());*/

        root.populateRight();
        // Level 1
        assertEquals(l1B.getName(), l1A.getRight().getName());
        assertEquals(l1C.getName(), l1B.getRight().getName());
        assertEquals(null, l1C.getRight());
        // Level 2
        assertEquals(l2E.getName(), l2D.getRight().getName());
        assertEquals(l2F.getName(), l2E.getRight().getName());
        assertEquals(null, l2F.getRight());
        //Level 3
        assertEquals(l3H, l3G.getRight());
        assertEquals(l3I, l3H.getRight());
        assertEquals(l3J.getName(), l3I.getRight().getName());
        assertEquals(null, l3J.getRight());

        System.out.println(String.format("l1A.getRight() == l1B [%s]", l1A.getRight() == l1B));
        System.out.println(String.format("l1A.getRight() == l1B [%s]", l1B.getRight() == l1C));
        System.out.println(String.format("l1C.getRight() == null[%s]", l1C.getRight() == null));
        System.out.println(String.format("l2D.getRight() == l2E [%s]", l2D.getRight() == l2E));
        System.out.println(String.format("l2E.getRight() == l2F [%s]", l2E.getRight() == l2F));
        System.out.println(String.format("l3G.getRight() == l3H [%s]", l3G.getRight() == l3H));
        System.out.println(String.format("l3H.getRight() == l3I [%s]", l3H.getRight() == l3I));
        System.out.println(String.format("l3I.getRight() == l3J [%s]", l3I.getRight() == l3J));
    }
}
