package com.kiwiland.filter;

import com.kiwiland.model.Path;

public class WeightPathFilter<V> implements PathFilter<V> {
    private final int maxWeight;

    public WeightPathFilter(final int maxWeight) {
        super();
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean passFilter(final Path<V> path) {
        return path.getPathTotalWeight() < maxWeight;
    }

}
