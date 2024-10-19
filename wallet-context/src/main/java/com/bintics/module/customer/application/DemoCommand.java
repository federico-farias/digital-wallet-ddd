package com.bintics.module.customer.application;

import com.bintics.shared.Command;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DemoCommand extends Command {
    private String name;
}
