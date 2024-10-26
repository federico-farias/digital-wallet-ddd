package com.bintics.shared;

public interface CommandHandler<T extends Command> {

    void execute(T command);

}
