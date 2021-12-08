package com.anabel.aoc2021.day02.part02.command;

import java.util.Optional;

public class CommandAdapter {
    public static Integer COMMAND_SIZE = 2;

    private CommandAdapter() {}

    public static Optional<Command> toCommand(String commandString) {
        String[] splittedCommand = commandString.split(" ");
        if (splittedCommand.length != COMMAND_SIZE) {
            return Optional.empty();
        }
        CommandType commandType = CommandType.from(splittedCommand[0]);
        Integer units = Integer.parseInt(splittedCommand[1]);
        return Optional.of(new Command(commandType, units));
    }
}
