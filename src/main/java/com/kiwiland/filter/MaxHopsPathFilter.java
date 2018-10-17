package com.kiwiland.filter;

import com.kiwiland.model.Path;

public class MaxHopsPathFilter<V> implements PathFilter<V> {
    private final int maxHops;

    public MaxHopsPathFilter(final int maxHops) {
        super();
        this.maxHops = maxHops;
    }

    @Override
    public boolean passFilter(final Path<V> path) {
        return path.getNumberOfHops() <= maxHops;
    }

}
