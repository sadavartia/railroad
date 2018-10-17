package com.kiwiland.filter.composite;

import com.kiwiland.filter.PathFilter;
import com.kiwiland.model.Path;

public class NotPathFilter<V> implements PathFilter<V>
{
    private final PathFilter<V> originalFilter;

    public NotPathFilter(final PathFilter<V> originalFilter) {
        super();
        this.originalFilter = originalFilter;
    }

    @Override
    public boolean passFilter(final Path<V> path) {
        return !originalFilter.passFilter(path);
    }

}
