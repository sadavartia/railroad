package executor;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.kiwiland.Commuter;
import com.kiwiland.exception.NoSuchRouteException;
import com.kiwiland.executor.DistanceExecutor;
import com.kiwiland.executor.Executor;
import com.kiwiland.executor.RouteExecutor;

@RunWith(MockitoJUnitRunner.class)
public class DistanceExecutorTest
{
    @Mock
    private Commuter commuter;
    @Mock
    private PrintStream outputStream;
    private Executor distanceExecutor;

    @Before
    public void intExecutor() {
        distanceExecutor = new DistanceExecutor("Distance: A-B-C", outputStream);
    }

    @Test
    public void shouldInvokeRouteDistance() throws NoSuchRouteException{
        final List<String> intermediateNodes = new ArrayList<String>();
        intermediateNodes.add("B");
        final int routeDistance = 5;
        when(commuter.routeDistance("A", "C", intermediateNodes)).thenReturn(routeDistance);

        distanceExecutor.execute(commuter);

        verify(outputStream).println(routeDistance);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldPrintNoRouteWhenExceptionIsThrown() throws NoSuchRouteException {
        final List<String> intermediateNodes = new ArrayList<String>();
        intermediateNodes.add("B");
        when(commuter.routeDistance("A", "C", intermediateNodes)).thenThrow(NoSuchRouteException.class);

        distanceExecutor.execute(commuter);

        verify(outputStream).println(RouteExecutor.NO_ROUTE_MSG);
    }

}
