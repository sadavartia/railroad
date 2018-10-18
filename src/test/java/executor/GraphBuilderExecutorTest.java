package executor;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.kiwiland.Commuter;
import com.kiwiland.executor.Executor;
import com.kiwiland.executor.GraphBuilderExecutor;
import com.kiwiland.model.Graph;

@RunWith(MockitoJUnitRunner.class)
public class GraphBuilderExecutorTest
{
    @Mock
    private Graph<String> graph;
    @Mock
    private Commuter commuter;

    @Test
    public void shouldInvokeCommuterGraph() {
        final Executor executor = new GraphBuilderExecutor("Graph: AB3, BC15");
        when(commuter.getAllRoutes()).thenReturn(graph);

        executor.execute(commuter);

        verify(commuter, atLeastOnce()).getAllRoutes();
        verify(graph, times(1)).addVertex("A");
        verify(graph, times(2)).addVertex("B");
        verify(graph, times(1)).addVertex("C");
        verify(graph).addEdge("A", "B", 3);
        verify(graph).addEdge("B", "C", 15);
    }

}
