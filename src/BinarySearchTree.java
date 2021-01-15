public class BinarySearchTree<T extends Comparable<? super T>>
{

    private class Node<T extends Comparable<? super T>>
    {
        private Node<T> left;
        private T data;
        private Node<T> right;

        public Node(Node<T> l, T d, Node<T> r)
        {
            left = l;
            data = d;
            right = r;
        }

        public Node<T> getLeft()
        {
            return left;
        }

        public T getData()
        {
            return data;
        }

        public Node<T> getRight()
        {
            return right;
        }

        public void setLeft(Node<T> newLeft)
        {
            left = newLeft;
        }

        public void setData(T newData)
        {
            data = newData;
        }

        public void setRight(Node<T> newRight)
        {
            right = newRight;
        }
    }


    public Node<T> root;

    public void insertIteratively(T newValue)
    {
        Node<T> newNode = new Node<>(null, newValue, null);

        if(isEmpty())
            root = newNode;
        else
        {
            Node<T> tempNode = root;

            while(true)
            {
                // newValue < tempNode.getData()
                if(newValue.compareTo(tempNode.getData()) < 0)

                {
                    if(tempNode.getLeft() == null)
                    {
                        tempNode.setLeft(newNode);
                        break;
                    }
                    else
                        tempNode = tempNode.getLeft();
                }
                else
                {
                    if(tempNode.getRight() == null)
                    {
                        tempNode.setRight(newNode);
                        break;
                    }
                    else
                        tempNode = tempNode.getRight();
                }
            }
        }
    }


    public Node<T> deleteRecursively(Node<T> root, T value) {

        if (root == null)
            return root;
        if (root.data.compareTo(value) > 0) {
            root.left = deleteRecursively(root.left, value);
        } else if (root.data.compareTo(value) < 0) {
            root.right = deleteRecursively(root.right, value);
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null)
                return root.left;

            root.data = inOrderSuccessor(root.right);
            root.right = deleteRecursively(root.right, root.data);
        }
        return root;
    }

    public T inOrderSuccessor(Node<T> root) {
         T minimum = root.data;
        while (root.left != null) {
            minimum = root.left.data;
            root = root.left;
        }
        return minimum;
    }


    public void insertRecursively(T newValue)
    {
        root = insertRecursively(newValue, root);
    }

    private Node<T> insertRecursively(T newValue, Node<T> tempNode)
    {
        if( tempNode == null )
            return new Node<>(null, newValue, null);

        if( newValue.compareTo(tempNode.getData()) > 0)
            tempNode.setLeft(insertRecursively(newValue, tempNode.getLeft()));
        else
            tempNode.setRight(insertRecursively(newValue, tempNode.getRight()));

        return tempNode;
    }

    public void printPreorder()
    {
        printPreorder(root);
    }

    private void printPreorder(Node<T> tempNode)
    {
        if(tempNode == null)
            return;

        System.out.print(tempNode.getData() + " ");
        printPreorder(tempNode.getLeft());
        printPreorder(tempNode.getRight());
    }

    public void printPostorder()
    {
        printPostorder(root);
    }

    private void printPostorder(Node<T> tempNode)
    {
        if(tempNode == null)
            return;

        printPostorder(tempNode.getLeft());
        printPostorder(tempNode.getRight());
        System.out.println(tempNode.getData() + " ");
    }

    public void printInorder()
    {
        printInorder(root);
    }

    private void printInorder(Node<T> tempNode)
    {
        if(tempNode == null)
            return;

        printInorder(tempNode.getLeft());
        System.out.print(tempNode.getData() + " ");
        printInorder(tempNode.getRight());
    }

    public boolean isEmpty()
    {
        return root == null;
    }
}
