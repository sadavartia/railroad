package executor;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.kiwiland.Commuter;
import com.kiwiland.exception.NoSuchRouteException;
import com.kiwiland.executor.Executor;
import com.kiwiland.executor.RouteExecutor;
import com.kiwiland.executor.ShortestDistanceExecutor;

import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)
public class ShortestDistanceExecutorTest
{
    @Mock
    private Commuter commuter;
    @Mock
    private PrintStream stream;
    private Executor executor;

    @Before
    public void initExecutor() {
        executor = new ShortestDistanceExecutor("Shortest: A-E", stream);
    }

    @Test
    public void shouldInvokeShortestDistance() throws NoSuchRouteException {
        final int distance = 5;
        when(commuter.shortestDistance("A", "E")).thenReturn(distance);

        executor.execute(commuter);

        verify(stream).println(distance);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldPrintNoRouteWhenExceptionIsThrown() throws NoSuchRouteException {
        when(commuter.shortestDistance("A", "E")).thenThrow(NoSuchRouteException.class);

        executor.execute(commuter);

        verify(stream).println(RouteExecutor.NO_ROUTE_MSG);
    }
}
