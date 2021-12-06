package com.chen.compareToTest;

/**
 * @author chenchen
 * @date 2021-12-03 9:47
 */
public class 二叉树排序Test {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(8);
        bt.add(3);
        bt.add(3);
        bt.add(10);
        bt.add(9);
        bt.add(1);
        bt.add(5);
        bt.add(5);//加入重复元素
        System.out.println("排序之后的结果：");
        bt.print();
    }
}

class BinaryTree{
    class Node{//声明一个节点类
        private Comparable data;//保存具体的内容
        private Node left;
        private Node right;
        public void addNode(Node newNode){
            //要确定是放在左子树还是右子树
            if(newNode.data.compareTo(this.data)<0){
                if(this.left == null){//放在左子树
                    this.left = newNode;
                }else {
                    this.left.addNode(newNode);
                }
            }
            if (newNode.data.compareTo(this.data)>=0){
                if(this.right == null){ //放在右子树
                    this.right = newNode;
                }else {
                    this.right.addNode(newNode);
                }
            }
        }
        public void printNode(){//输出时采用中序遍历
            if (this.left != null){//先输出左子树
                this.left.printNode();
            }
            System.out.print(this.data + "\t");//再输出根节点
            if (this.right !=null){
                this.right.printNode();
            }
        }
    }
    private Node root;
    public void add(Comparable data){
        Node newNode = new Node();//每传入一个新的内容就声明一个根节点
        newNode.data = data;
        if(root == null){
            root = newNode;//如果是第1个元素，设置成根元素
        }else{
            root.addNode(newNode);//确定节点是放在左子树还是右子树
        }
    }
    public void print(){//输出节点
        this.root.printNode();
    }
}
