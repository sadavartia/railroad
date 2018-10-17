package com.kiwiland.filter;

import com.kiwiland.model.Path;

public class ExactHopsPathFilter<V> implements PathFilter<V> {
    private final int hopsNumber;

    public ExactHopsPathFilter(final int hopsNumber) {
        super();
        this.hopsNumber = hopsNumber;
    }

    @Override
    public boolean passFilter(final Path<V> path) {
        return path.getNumberOfHops() == hopsNumber;
    }

}
