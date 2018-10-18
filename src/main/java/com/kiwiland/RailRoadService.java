package com.kiwiland;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import com.kiwiland.executor.CommandBuilder;
import com.kiwiland.executor.Executor;
import com.kiwiland.executor.GraphBuilderExecutor;
import com.kiwiland.model.GraphBuilder;

public class RailRoadService {

    public static void main(final String[] args) throws Exception {
        final Commuter commuter = new CommuterImpl(GraphBuilder.getEmptyGraph());
        File inputFile = null;
        InputStream inputStream;
        if (args.length == 1) {
            inputFile = new File(args[0]);
            inputStream = new FileInputStream(inputFile);
        } else {
            inputStream = RailRoadService.class.getResourceAsStream("/input.txt");
        }

        final List<Executor> inputs = new CommandBuilder(System.out).getCommandsFromFile(inputStream);
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
