package graph;

import org.junit.Before;
import org.junit.Test;

import com.kiwiland.model.DefaultEdge;
import com.kiwiland.model.Edge;
import com.kiwiland.model.GraphPath;
import com.kiwiland.model.Path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GraphPathTest {
    private Path<String> path;
    private final Edge<String> abEdge = DefaultEdge.getWeightedEdge("A", "B", 5);
    private final Edge<String> bcEdge = DefaultEdge.getWeightedEdge("B", "C", 15);
    private final Edge<String> cdEdge = DefaultEdge.getWeightedEdge("C", "D", 5);

    @Before
    public void initPath() {
        path = GraphPath.emptyPath();
        path.addEdge(abEdge);
        path.addEdge(bcEdge);
        path.addEdge(cdEdge);
    }

    @Test
    public void addEdgeShouldIncreaseWeightAndHops() {
        final Edge<String> newEdge = DefaultEdge.getWeightedEdge("D", "E", 5);
        path.addEdge(newEdge);

        assertThat(path.getPathTotalWeight(), is(30));
        assertThat(path.getNumberOfHops(), is(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEdgeShouldFailWhenEdgeIsNotConsecutive() {
        final Edge<String> nonConsecutiveEdge = DefaultEdge.getWeightedEdge("E", "A", 1);
        path.addEdge(nonConsecutiveEdge);
    }

    @Test
    public void getPathTotalWeightShouldEqualEdgesSum() {
        assertThat(path.getPathTotalWeight(), is(25));
    }

    @Test
    public void getNumberOfHopsShouldEqualEdgeNumber() {
        assertThat(path.getNumberOfHops(), is(3));
    }

    @Test
    public void getLastNodeShouldReturnLastEdgeEndingVertex() {
        assertThat(path.getLastNode(), is("D"));
    }

    @Test
    public void removeLastEdgeShouldDecreaseWeightAndHops() {
        path.removeLastEdge();

        assertThat(path.getPathTotalWeight(), is(20));
        assertThat(path.getNumberOfHops(), is(2));
    }

}
