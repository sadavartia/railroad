package com.kiwiland.filter.composite;

import com.kiwiland.filter.PathFilter;
import com.kiwiland.model.Path;

public class OrPathFilter<V> implements PathFilter<V>
{
    private final PathFilter<V> firstFilter;
    private final PathFilter<V> secondFilter;

    public OrPathFilter(final PathFilter<V> firstFilter, final PathFilter<V> secondFilter) {
        super();
        this.firstFilter = firstFilter;
        this.secondFilter = secondFilter;
    }

    @Override
    public boolean passFilter(final Path<V> path) {
        return firstFilter.passFilter(path) || secondFilter.passFilter(path);
    }

}
