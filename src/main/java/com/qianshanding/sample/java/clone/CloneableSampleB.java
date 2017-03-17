package com.qianshanding.sample.java.clone;

/**
 * Created by fish on 2017/3/7.
 */
public class CloneableSampleB {
    public static void main(String[] args) throws CloneNotSupportedException {
        Tree tree = new Tree();
        tree.setName("tree_name");

        Forest forest = new Forest();
        forest.setTree(tree);
        forest.setName("forest_name");

        Forest forestClone = (Forest) forest.clone();
        forestClone.setName("forestClone_name");
        forestClone.getTree().setName("forestClone_tree_name");
        System.out.println("forest hashcode:" + forest.hashCode() + "\ttree hashcode:" + forest.getTree().hashCode() +
                "\tname:" + forest.getName() + "\t\t-->treeName:" + forest.getTree().getName());
        System.out.println("forest hashcode:" + forestClone.hashCode() + "\ttree hashcode:" + forestClone.getTree().hashCode() +
                "\tname:" + forestClone.getName() + "\t-->treeName:" + forestClone.getTree().getName());
    }


    static class Tree implements Cloneable {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public Object clone() {
            Object o = null;
            try {
                o = super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return o;
        }
    }

    static class Forest implements Cloneable {
        private String name;
        private Tree tree;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Tree getTree() {
            return tree;
        }

        public void setTree(Tree tree) {
            this.tree = tree;
        }

        /**
         * 深拷贝
         */
        @Override
        protected Object clone() {
            Forest o = null;
            try {
                o = (Forest) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            o.tree = (Tree) tree.clone();
            return o;
        }
    }
}
