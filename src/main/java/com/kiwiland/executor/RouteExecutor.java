package com.kiwiland.executor;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.kiwiland.Commuter;
import com.kiwiland.exception.NoSuchRouteException;

public abstract class RouteExecutor extends AbstractExecutor {

    public static final String NO_ROUTE_MSG = "NO SUCH ROUTE";
    protected final PrintStream outputStream;

    public RouteExecutor(String commandLine, PrintStream outputStream) {
        super(commandLine);
        this.outputStream = outputStream;
    }
    
    protected abstract int callCommuter(Commuter commuter,String start, String end, List<String> intermediate) throws NoSuchRouteException;

    @Override
    public void execute(final Commuter commuter) {
        final String routeLine = getCommandLine().substring(10);
        final String[] nodes = routeLine.split("-");
        try {
            outputStream.println(callCommuter(commuter,nodes[0], nodes[nodes.length - 1], getIntermediateList(nodes)));
        } catch (final NoSuchRouteException e) {
            outputStream.println(NO_ROUTE_MSG);
        }
    }

    private List<String> getIntermediateList(final String[] nodes) {
        final List<String> intermediateList = new ArrayList<String>();
        for (int i = 1; i < nodes.length - 1; i++) {
            intermediateList.add(nodes[i]);
        }
        return intermediateList;
    }

}
