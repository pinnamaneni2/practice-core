package com.psksoft.slove;

import java.util.Objects;

public class Node {
    String before;
    String after;
    String nodeValue;

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public String getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (!Objects.equals(before, node.before)) return false;
        if (!Objects.equals(after, node.after)) return false;
        return Objects.equals(nodeValue, node.nodeValue);
    }

    @Override
    public int hashCode() {
        int result = before != null ? before.hashCode() : 0;
        result = 31 * result + (after != null ? after.hashCode() : 0);
        result = 31 * result + (nodeValue != null ? nodeValue.hashCode() : 0);
        return result;
    }

    public Node(String before, String after, String nodeValue) {
        this.before = before;
        this.after = after;
        this.nodeValue = nodeValue;
    }

    @Override
    public String toString() {
        return "Node{" +
                "before='" + before + '\'' +
                ", after='" + after + '\'' +
                ", nodeValue='" + nodeValue + '\'' +
                '}';
    }
}
