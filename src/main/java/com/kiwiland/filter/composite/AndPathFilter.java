package com.kiwiland.filter.composite;

import com.kiwiland.filter.PathFilter;
import com.kiwiland.model.Path;

public class AndPathFilter<V> implements PathFilter<V>
{
    private final PathFilter<V> firstFilter;
    private final PathFilter<V> secondFilter;

    public AndPathFilter(final PathFilter<V> firstFilter, final PathFilter<V> secondFilter) {
        this.firstFilter = firstFilter;
        this.secondFilter = secondFilter;
    }

    @Override
    public boolean passFilter(final Path<V> path) {
        return firstFilter.passFilter(path) && secondFilter.passFilter(path);
    }

}
