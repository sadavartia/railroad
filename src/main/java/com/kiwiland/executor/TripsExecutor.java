package com.kiwiland.executor;

import java.io.PrintStream;

import com.kiwiland.Commuter;

public class TripsExecutor extends AbstractExecutor {
    private final PrintStream outputStream;

    public TripsExecutor(final String commandLine, final PrintStream stream) {
        super(commandLine);
        this.outputStream = stream;
    }

    @Override
    public void execute(final Commuter commuter) {
        final String routeLine = getCommandLine().substring(7);
        final String[] commandParts = routeLine.split(",");

        final String filterCriteria = commandParts[0];
        final int filterValue = Integer.valueOf(commandParts[1]);
        final String startNode = String.valueOf(commandParts[2].charAt(0));
        final String endNode = String.valueOf(commandParts[2].charAt(2));

        int numberOfTrips = 0;

        try {
            if (filterCriteria.equalsIgnoreCase("MAX_STOPS")) {
                numberOfTrips = commuter.numberOfPathsWithMaxStops(startNode, endNode, filterValue);
            } else if (filterCriteria.equalsIgnoreCase("EXACT_STOPS")) {
                numberOfTrips = commuter.numberOfPathsWithExactStops(startNode, endNode, filterValue);
            } else if (filterCriteria.equalsIgnoreCase("MAX_DISTANCE")) {
                numberOfTrips = commuter.numberOfPathsWithMaxWeight(startNode, endNode, filterValue);
            }
            outputStream.println(numberOfTrips);
        } catch (final Exception e) {
            outputStream.println(RouteExecutor.NO_ROUTE_MSG);
        }

    }

}
