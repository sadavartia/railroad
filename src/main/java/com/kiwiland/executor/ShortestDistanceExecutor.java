package com.kiwiland.executor;

import java.io.PrintStream;

import com.kiwiland.Commuter;
import com.kiwiland.exception.NoSuchRouteException;

public class ShortestDistanceExecutor extends AbstractExecutor {
    private final PrintStream outputStream;

    public ShortestDistanceExecutor(final String commandLine, final PrintStream stream) {
        super(commandLine);
        this.outputStream = stream;
    }

    @Override
    public void execute(final Commuter commuter) {
        final String routeLine = getCommandLine().substring(10);
        final String from = String.valueOf(routeLine.charAt(0));
        final String to = String.valueOf(routeLine.charAt(2));
        try {
            outputStream.println(commuter.shortestDistance(from, to));
        } catch (final NoSuchRouteException e) {
            outputStream.println(RouteExecutor.NO_ROUTE_MSG);
        }
    }
}
