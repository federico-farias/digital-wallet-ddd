package com.bintics.shared;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CommandBusImplTest {

    @Test
    public void testExecute() {
        var spyHandler = spy(new Demo2Decorator2CommandHandler(new Demo2DecoratorCommandHandler(new Demo2CommandHandler())));

        CommandBusImpl commandBus = new CommandBusImpl();
        commandBus.add(spyHandler);

        var command = new Demo2Command("test 1");
        commandBus.execute(command);

        verify(spyHandler, times(1)).execute(command);
    }

    @AllArgsConstructor
    class Demo2DecoratorCommandHandler implements CommandHandler<Demo2Command> {

        private final CommandHandler<Demo2Command> cmd;

        @Override
        public void execute(Demo2Command command) {
            System.out.println("begin transaction");
            this.cmd.execute(command);
            System.out.println("commit transaction");
        }

    }

    @AllArgsConstructor
    class Demo2Decorator2CommandHandler implements CommandHandler<Demo2Command> {

        private final CommandHandler<Demo2Command> cmd;

        @Override
        public void execute(Demo2Command command) {
            System.out.println("Segundo decorador");
            this.cmd.execute(command);
        }

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
