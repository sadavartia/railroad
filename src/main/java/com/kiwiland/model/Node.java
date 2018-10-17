package com.kiwiland.model;

import java.util.HashMap;
import java.util.Objects;
import java.util.StringJoiner;

public class Node {
    private HashMap<Node, Integer> neighbours;

    private String name;

    public Node(String name) {
        this.neighbours = new HashMap<>();
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        Node other = (Node) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        if (this.name == null) return 0;
        return this.name.hashCode();
    }

    @Override
    public String toString() {

        StringJoiner sj = new StringJoiner(",");

        for (Node n : neighbours.keySet()){
            sj.add(n.name);
        }

        return "Node{" +
                "neighbours=" + sj.toString() +
                ", name='" + name + '\'' +
                '}';
    }



    public HashMap<Node, Integer> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(HashMap<Node, Integer> neighbours) {
        this.neighbours = neighbours;
    }

    public void addNeighbour(Node neighbour, int weight) {
        getNeighbours().putIfAbsent(neighbour, weight);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
