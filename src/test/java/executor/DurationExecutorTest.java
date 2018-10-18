package executor;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.kiwiland.Commuter;
import com.kiwiland.exception.NoSuchRouteException;
import com.kiwiland.executor.DurationExecutor;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DurationExecutorTest
{
    @Mock
    private Commuter commuter;
    
    @Test
    public void executeShouldInvokeRouteDuration() throws NoSuchRouteException {
        DurationExecutor executor = new DurationExecutor("DURATION: A-B-C", System.out);
        List<String> intermediate = new ArrayList<String>();
        intermediate.add("B");
        
        executor.execute(commuter);
        
        verify(commuter).routeDuration("A", "C", intermediate);
    }
    
    @Test
    public void executeShouldInvokeRouteDurationWithMultipleItermediateStops() throws NoSuchRouteException {
        DurationExecutor executor = new DurationExecutor("DURATION: A-B-C-D-E-F", System.out);
        List<String> intermediate = new ArrayList<String>();
        intermediate.add("B");
        intermediate.add("C");
        intermediate.add("D");
        intermediate.add("E");
        
        executor.execute(commuter);
        
        verify(commuter).routeDuration("A", "F", intermediate);
    }

}
