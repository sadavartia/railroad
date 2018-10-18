package graph;

import org.junit.Test;

import com.kiwiland.model.DefaultEdge;
import com.kiwiland.model.Edge;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DefaultEdgeTest {
    private final Edge<String> edge = DefaultEdge.getWeightedEdge("A", "B", 15);

    @Test
    public void equalShouldNotConsiderWeight() {
        final Edge<String> edgeWithDifferentWeight = DefaultEdge.getWeightedEdge("A", "B", 5);
        assert(edgeWithDifferentWeight.equals(edge));

        final Edge<String> differentEdge = DefaultEdge.getWeightedEdge("B", "C", 5);
        assertThat(differentEdge.equals(edge), is(false));
    }
}
