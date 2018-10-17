package com.kiwiland.filter;

import com.kiwiland.model.Path;

public class RepeatedEdgePathFilter<V> implements PathFilter<V> {

    @Override
    public boolean passFilter(final Path<V> path) {
        return !path.hasRepeatedEdges();
    }

}
