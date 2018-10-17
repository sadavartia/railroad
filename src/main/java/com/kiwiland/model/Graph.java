package com.kiwiland.model;

import com.kiwiland.exception.NoSuchRouteException;
import com.kiwiland.filter.PathFilter;
import java.util.List;
import java.util.Set;

public interface Graph<V> {

    boolean addEdge(V from, V to, int weight);

    boolean addVertex(V vertex);

    Edge<V> getEdge(V from, V to);

    Set<V> getAllVertex();

    List<Path<V>> getAllPaths(V startingNode, V endingNode, PathFilter<V> filter) throws NoSuchRouteException;

}
