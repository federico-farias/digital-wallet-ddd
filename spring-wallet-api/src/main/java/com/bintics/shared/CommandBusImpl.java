package com.bintics.shared;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class CommandBusImpl implements CommandBus {

    private Map<String, CommandHandler> map = new LinkedHashMap<>();

    @Override
    public void execute(Command command) {
        var key = command.getClass().getSimpleName();
        if (map.containsKey(key)) {
            var handler = map.get(key);
            handler.execute(command);
        }
    }

    public void add(CommandHandler handler) {
        var methodsContract = CommandHandler.class.getMethods();
        if (methodsContract.length != 1) {
            throw new RuntimeException("no valid interface");
        }

        var name = methodsContract[0].getName();

        var methods = handler.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().equals(name)) {
                var params = method.getParameters();
                if (params.length != 1) {
                    throw new RuntimeException("no valid param");
                }
                var commandName = params[0].getType().getSimpleName();
                this.map.put(commandName, handler);
                return;
            }
        }
    }

}
