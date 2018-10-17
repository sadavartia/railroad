package com.kiwiland;

import java.io.File;
import java.util.List;

import com.kiwiland.executor.CommandBuilder;
import com.kiwiland.executor.Executor;
import com.kiwiland.executor.GraphBuilderExecutor;
import com.kiwiland.model.GraphBuilder;

public class RailRoadService {

    public static void main(final String[] args) throws Exception {
        final Commuter commuter = new CommuterImpl(GraphBuilder.getEmptyGraph());
        File inputFile = null;
        if (args.length == 1) {
            inputFile = new File(args[0]);
        } else {
            inputFile = new File(RailRoadService.class.getResource("/input.txt").toURI());
        }

        final List<Executor> inputs = new CommandBuilder(System.out).getCommandsFromFile(inputFile);
        int i = 1;

        for (final Executor eachExecutor : inputs) {
            if (!(eachExecutor instanceof GraphBuilderExecutor)) {
                System.out.print("Output #"+ i + ": ");
                i++;
            }
            eachExecutor.execute(commuter);

        }
    }
}
