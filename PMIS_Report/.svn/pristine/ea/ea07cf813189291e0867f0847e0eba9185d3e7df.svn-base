package com.tetrapak.metaclass;

import java.util.ArrayList;
import java.util.List;

public class EdgeStack {
    private List<Integer> edgeList;

    public EdgeStack() {
	edgeList = new ArrayList<Integer>();
    }

    /**
     * push a value to the stack
     * 
     * @return the value
     * */
    public int push(int value) {
	edgeList.add(value);
	return value;
    }

    /**
     * return the edge list size
     * 
     * @return the size
     * */
    public int size() {
	return edgeList.size();
    }

    /**
     * pop a value from the stack
     * 
     * @return the value
     * */
    public int pop() {
	return edgeList.remove(edgeList.size() - 1);
    }

    /**
     * empty the edge list
     * */
    public void empty() {
	edgeList.clear();
    }

    /**
     * check whether the edge stack is empty
     * */
    public boolean isEmpty() {
	return edgeList.isEmpty();
    }
}
