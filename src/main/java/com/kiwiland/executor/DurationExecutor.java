package com.kiwiland.executor;

import com.kiwiland.Commuter;
import com.kiwiland.exception.NoSuchRouteException;

import java.io.PrintStream;
import java.util.List;

public class DurationExecutor extends RouteExecutor {

    public DurationExecutor(String commandLine, PrintStream outputStream) {
        super(commandLine, outputStream);
    }

    @Override
    protected int callCommuter(Commuter commuter, String start, String end, List<String> intermediate) throws NoSuchRouteException {
        return commuter.routeDuration(start, end, intermediate);
    }
}
