package executor;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import com.kiwiland.Commuter;
import com.kiwiland.exception.NoSuchRouteException;
import com.kiwiland.executor.Executor;
import com.kiwiland.executor.TripsExecutor;

@RunWith(MockitoJUnitRunner.class)
public class TripsExecutorTest
{
    private Executor executor;
    @Mock
    private Commuter commuter;
    @Mock
    private PrintStream stream;

    @Test
    public void shouldInvokeMaxStops() throws NoSuchRouteException{
        executor = new TripsExecutor("Trips: MAX_STOPS,3,C-C", stream);
        final int stops = 5;
        when(commuter.numberOfPathsWithMaxStops("C", "C", 3)).thenReturn(stops);

        executor.execute(commuter);

        verify(stream).println(stops);
    }

    @Test
    public void shouldInvokeMaxWeight() throws NoSuchRouteException{
        executor = new TripsExecutor("Trips: MAX_DISTANCE,30,B-C", stream);
        final int weight = 5;
        when(commuter.numberOfPathsWithMaxWeight("B", "C", 30)).thenReturn(weight);

        executor.execute(commuter);

        verify(stream).println(weight);
    }

    @Test
    public void shouldInvokeExactStops() throws NoSuchRouteException{
        executor = new TripsExecutor("Trips: EXACT_STOPS,4,A-C", stream);
        final int stops = 5;
        when(commuter.numberOfPathsWithExactStops("A", "C", 4)).thenReturn(stops);

        executor.execute(commuter);

        verify(stream).println(stops);
    }

}
