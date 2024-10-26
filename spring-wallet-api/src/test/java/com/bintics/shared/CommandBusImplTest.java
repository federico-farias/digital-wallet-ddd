package com.bintics.shared;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CommandBusImplTest {

    @Test
    public void testExecute() {
        var spyHandler = spy(new Demo2CommandHandler());

        CommandBusImpl commandBus = new CommandBusImpl();
        commandBus.add(spyHandler);


        var command = new Demo2Command("test 1");
        commandBus.execute(command);

        verify(spyHandler, times(1)).execute(command);
    }

    class Demo2CommandHandler implements CommandHandler<Demo2Command> {

        @Override
        public void execute(Demo2Command command) {
            System.out.println("Demo2CommandHandler: " + command.getTitle());
        }

    }

    @Getter
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    class Demo2Command extends Command {
        private final String title;
    }

}
