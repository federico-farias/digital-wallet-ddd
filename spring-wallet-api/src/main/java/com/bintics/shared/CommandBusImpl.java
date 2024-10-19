package com.bintics.shared;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CommandBusImpl implements CommandBus {

    private final List<CommandHandler> commandHandlers;

    @Override
    public void execute(Command command) {
        String name = command.getClass().getSimpleName(); // Demo Command
        System.out.println("CommandBusImpl executed: " + name);
        for (CommandHandler commandHandler : commandHandlers) {
            String[] tokens = name.split("Command");
            String commandName = tokens[0].toLowerCase();

            String handlerName = commandHandler.getClass().getSimpleName().toLowerCase();
            String[] handlerTokens = handlerName.split("handler");
            handlerName = handlerTokens[0];

            if (commandName.equals(handlerName)) {
                commandHandler.execute(command);
                return;
            }
        }
    }
}
