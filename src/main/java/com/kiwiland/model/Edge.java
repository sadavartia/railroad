package com.kiwiland.model;

public interface Edge<V> {
    V getStartingVertex();

    V getEndingVertex();

    int getWeight();
}
