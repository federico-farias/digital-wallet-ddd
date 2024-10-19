package com.bintics.shared;

import com.bintics.module.customer.application.DemoCommand;
import com.bintics.module.customer.application.DemoHandler;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class CommandBusImplTest {

    @Test
    public void testExecute() {
        List<CommandHandler> commandHandlers = new LinkedList<>();
        commandHandlers.add(new DemoHandler());

        CommandBusImpl commandBusImpl = new CommandBusImpl(commandHandlers);

        commandBusImpl.execute(new DemoCommand("test"));
    }

}
