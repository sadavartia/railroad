package com.kiwiland.filter;

import com.kiwiland.model.Path;

public class ContainsPathFilter<V> implements PathFilter<V> {
    private final Path<V> objectivePath;

    public ContainsPathFilter(final Path<V> objectivePath) {
        this.objectivePath = objectivePath;
    }

    @Override
    public boolean passFilter(final Path<V> path) {
        return objectivePath.startsWith(path);
    }

}
