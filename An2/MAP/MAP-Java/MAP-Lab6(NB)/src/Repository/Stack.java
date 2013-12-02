/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Utils.MyException;
import Utils.LinkedList.LinkedList;
import Utils.LinkedList.Node;


/**
 *
 * @author mihai
 */
public class Stack<T> {
    private int size = 0;
    private LinkedList<T> elements;
    
    public Stack(){
        elements = new LinkedList<T>();
    }
    
    public void push(T data){
        Node<T> lastNode = elements.getLastElement();
        Node<T> nodeToAdd = new Node<T>(data);
        
        if (lastNode != null)
            lastNode.next = nodeToAdd;
        else
            elements.firstNode = nodeToAdd;
        size++;
    }
    
    public T pop() throws MyException{
        if (this.isEmpty())
            throw new MyException("Cannot pop element from empty stack!");
        else {
            size--;
            Node<T> lastNode = elements.getLastElement();
            T returnData = lastNode.data;
            elements.removeNode(lastNode);
            return returnData;
        }
    }
   
    public int getStackSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size < 1;
    }

    public Stack<T> copy() {
        Stack<T> copy = new Stack();
        copy.elements = this.elements.copy();
        copy.size = this.size;
        
        return copy;
    }
    
}