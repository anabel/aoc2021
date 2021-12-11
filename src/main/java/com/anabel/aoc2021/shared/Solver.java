package com.anabel.aoc2021.shared;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class Solver {
    private String name;
    private String resource;
    private Function<Stream<String>, String> solver;

    public Solver(String name, String resource, Function<Stream<String>, String> solver) {
        this.name = name;
        this.resource = resource;
        this.solver = solver;
    }

    public String getName() {
        return name;
    }

    public Optional<String> execute() {
        try {
            Path inputPath = Paths.get(Solver.class.getClassLoader()
                    .getResource(resource).toURI());
            try (Stream<String> input = Files.lines(inputPath)) {
                return Optional.of(solver.apply(input));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
