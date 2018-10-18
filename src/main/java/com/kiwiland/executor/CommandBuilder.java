package com.kiwiland.executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CommandBuilder {
    private static final String DISTANCE_REGEX = "DISTANCE:\\s\\D-\\D(-\\D)*";
    private static final String TRIPS_REGEX = "TRIPS:\\s(MAX_STOPS|EXACT_STOPS|MAX_DISTANCE),(\\d)+,\\D-\\D";
    private static final String GRAPH_REGEX = "GRAPH:\\s(\\D\\D\\d+)(, \\D\\D\\d+)*";
    private static final String SHORTEST_REGEX = "SHORTEST:\\s\\D-\\D";
    private static final String DURATION_REGEX = "DURATION:\\s\\w-\\w(-\\w)*";

    private final PrintStream outputStream;

    public CommandBuilder(final PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    public List<Executor> getCommandsFromFile(final InputStream inputStream) throws IOException {
        final List<Executor> executors = new ArrayList<Executor>();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (reader.ready()) {
            final Executor toAdd = processLine(reader);
            if (toAdd != null) {
                executors.add(toAdd);
            }
        }
        reader.close();
        return executors;
    }

    private Executor processLine(final BufferedReader reader) throws IOException {
        Executor processedExecutor = null;
        final String currentLine = reader.readLine().toUpperCase();
        if (currentLine.matches(GRAPH_REGEX)) {
            processedExecutor = new GraphBuilderExecutor(currentLine);
        } else if (currentLine.matches(SHORTEST_REGEX)) {
            processedExecutor = new ShortestDistanceExecutor(currentLine, outputStream);
        } else if (currentLine.matches(TRIPS_REGEX)) {
            processedExecutor = new TripsExecutor(currentLine, outputStream);
        } else if (currentLine.matches(DISTANCE_REGEX)) {
            processedExecutor = new DistanceExecutor(currentLine, outputStream);
        } else if (currentLine.matches(DURATION_REGEX)) {
            processedExecutor = new DurationExecutor(currentLine, outputStream);
        } else {
            System.out.println("Line: " + currentLine + " is invalid");
        }
        return processedExecutor;
    }

}
