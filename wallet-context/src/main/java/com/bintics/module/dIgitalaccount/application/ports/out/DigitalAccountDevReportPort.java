package com.bintics.module.dIgitalaccount.application.ports.out;

import com.bintics.module.dIgitalaccount.domain.DigitalAccount;

import java.util.Map;

@FunctionalInterface
public interface DeveloperReportGetPort {

    Map<String, String> createReport(Long id);
}