package com.kiwiland.executor;

import java.io.PrintStream;
import java.util.List;

import com.kiwiland.Commuter;
import com.kiwiland.exception.NoSuchRouteException;

class DistanceExecutor extends RouteExecutor {
    public DistanceExecutor(final String commandLine, final PrintStream stream) {
        super(commandLine, stream);
    }

    @Override
    protected int callCommuter(Commuter commuter, String start, String end, List<String> intermediate) throws NoSuchRouteException{
        return commuter.routeDistance(start, end, intermediate);
    }

}
