package com.kiwiland.filter;

import com.kiwiland.model.Path;

public interface PathFilter<V> {
    boolean passFilter(final Path<V> path);

}
