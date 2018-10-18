package graph;

import org.junit.Before;
import org.junit.Test;

import com.kiwiland.exception.NoSuchRouteException;
import com.kiwiland.filter.MaxHopsPathFilter;
import com.kiwiland.filter.WeightPathFilter;
import com.kiwiland.model.Edge;
import com.kiwiland.model.Graph;
import com.kiwiland.model.GraphBuilder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DirectedGraphTest {
    private Graph<String> graph;

    @Before
    public void initGraph() {
        graph = GraphBuilder.getDefaultGraph();
    }

    @Test(expected = IllegalArgumentException.class)
    public void addVertexShouldNotAllowNullValues() {
        graph.addVertex(null);
    }

    @Test
    public void addVertexShouldNotAllowDuplicates() {
        assert(graph.addVertex("Z"));
        assertThat(graph.getAllVertex().contains("Z"), is(true));
        assertThat(graph.addVertex("Z"), is(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEdgeShouldFailWhenVertexDoesNotExist() {
        graph.addEdge("X", "A", 1);
    }

    @Test
    public void addEdgeShouldUpdateWeightIfDuplicate() {
        graph.addVertex("Z");
        assert (graph.addEdge("Z", "A", 5));
        assertThat(graph.getEdge("Z", "A").getWeight(), is(5));

        assert(graph.addEdge("Z", "A", 15));
        assertThat(graph.getEdge("Z", "A").getWeight(), is(15));
    }

    @Test
    public void testGetEdge() {
        graph.addVertex("Z");
        graph.addEdge("A", "Z", 15);
        final Edge<String> azEdge = graph.getEdge("A", "Z");

        assertThat(azEdge.getStartingVertex(), is("A"));
        assertThat(azEdge.getEndingVertex(), is("Z"));
        assertThat(azEdge.getWeight(), is(15));
    }

    @Test
    public void testGetAllEdges() {
        assertThat(graph.getAllVertex().contains("A"), is(true));
        assertThat(graph.getAllVertex().contains("B"), is(true));
        assertThat(graph.getAllVertex().contains("C"), is(true));
        assertThat(graph.getAllVertex().contains("D"), is(true));
        assertThat(graph.getAllVertex().contains("E"), is(true));

    }

    @Test(expected = NoSuchRouteException.class)
    public void getAllPathsShouldThrowExceptionWhenNoPathExists() throws NoSuchRouteException{
        graph.getAllPaths("A", "B", new WeightPathFilter<>(3));
    }

    @Test
    public void testGetAllPaths() throws NoSuchRouteException {
        assertThat(graph.getAllPaths("A", "D", new MaxHopsPathFilter<>(3)).size(), is(3));
        assertThat(graph.getAllPaths("A", "D", new MaxHopsPathFilter<String>(2)).size(), is(1));
    }

}
