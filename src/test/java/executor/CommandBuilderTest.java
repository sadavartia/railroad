package executor;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.kiwiland.executor.CommandBuilder;
import com.kiwiland.executor.DistanceExecutor;
import com.kiwiland.executor.DurationExecutor;
import com.kiwiland.executor.Executor;
import com.kiwiland.executor.GraphBuilderExecutor;
import com.kiwiland.executor.ShortestDistanceExecutor;
import com.kiwiland.executor.TripsExecutor;

@RunWith(MockitoJUnitRunner.class)
public class CommandBuilderTest {
    @Mock
    private PrintStream outputStream;
    private CommandBuilder builder;

    @Before
    public void initCommandBuilder() {
        builder = new CommandBuilder(outputStream);
    }

    @Test
    public void shouldReadEveryCommandFromFile() throws URISyntaxException, IOException {
        final InputStream inputStream = getClass().getResourceAsStream("/graphInputTest01.txt");

        assertThat(builder.getCommandsFromFile(inputStream), is(getExpectedCommands()));
    }

    private List<Executor> getExpectedCommands() {
        final List<Executor> expectedExecutes = new ArrayList<>();
        expectedExecutes.add(new GraphBuilderExecutor("GRAPH: AB15, BC4, CD8, DC8, DE6, AD5, CE12, EB3, AE7"));
        expectedExecutes.add(new DistanceExecutor("DISTANCE: A-B-C", outputStream));
        expectedExecutes.add(new TripsExecutor("TRIPS: MAX_STOPS,3,C-C", outputStream));
        expectedExecutes.add(new TripsExecutor("TRIPS: EXACT_STOPS,4,A-C", outputStream));
        expectedExecutes.add(new ShortestDistanceExecutor("SHORTEST: B-B", outputStream));
        expectedExecutes.add(new TripsExecutor("TRIPS: MAX_DISTANCE,30,C-C", outputStream));
        expectedExecutes.add(new DurationExecutor("DURATION: A-B-C", outputStream));
        expectedExecutes.add(new DurationExecutor("DURATION: A-B-C-D", outputStream));
        return expectedExecutes;
    }
}
