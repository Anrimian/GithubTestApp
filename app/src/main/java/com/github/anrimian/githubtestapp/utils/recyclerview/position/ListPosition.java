package com.github.anrimian.githubtestapp.utils.recyclerview.position;

/**
 * Created on 17.04.2017.
 */

public class ListPosition {

    private int index;
    private int top;

    public ListPosition(int index, int top) {
        this.index = index;
        this.top = top;
    }

    public int getIndex() {
        return index;
    }

    public int getTop() {
        return top;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("position, ");
        sb.append("index: ");
        sb.append(index);
        sb.append(", top: ");
        sb.append(top);
        return sb.toString();
    }
}
