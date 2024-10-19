package com.bintics.module.customer.application;

import com.bintics.shared.CommandHandler;

public class DemoHandler implements CommandHandler<DemoCommand> {

    @Override
    public void execute(DemoCommand command) {
        System.out.println("DemoHandler executed: " + command.getName());
    }

}
