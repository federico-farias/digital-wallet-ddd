package com.bintics.config;

import com.bintics.adapters.out.dbs.sql.mysql.jpa.adapter.DigitalAccountMySqlAdapter;
import com.bintics.adapters.out.dbs.sql.mysql.jpa.repositories.DigitalAccountMySqlRepository;
import com.bintics.adapters.out.dbs.sql.oracle.jpa.repositories.DigitalAccountOracleRepository;
import com.bintics.adapters.out.dbs.sql.oracle.jpa.adapter.DigitalAccountOracleAdapter;
import com.bintics.module.dIgitalaccount.application.ports.out.digital.DigitalAccountCreatePort;
import com.bintics.module.dIgitalaccount.application.ports.out.digital.DigitalAccountFindByIdPort;
import com.bintics.module.dIgitalaccount.application.services.digital.DigitalAccountService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class AppConfig {

    @Value("${MY_SERVICE_IMPL}")
    private String serviceImpl;

    @PostConstruct
    public void init() {
        System.out.println(serviceImpl);
    }

//    @Bean
//    public DigitalAccountCreateUseCase digitalAccountCreateUseCase(DigitalAccountCreatePort digitalAccountCreatePort, DigitalAccountFindByIdPort digitalAccountFindByIdPort) {
//        return new DigitalAccountService(digitalAccountCreatePort, digitalAccountFindByIdPort);
//    }
//    @Bean
//    public DigitalAccountFindByIdUseCase digitalAccountFindByIdUseCase(DigitalAccountCreatePort digitalAccountCreatePort, DigitalAccountFindByIdPort digitalAccountFindByIdPort){
//        return new DigitalAccountService(digitalAccountCreatePort, digitalAccountFindByIdPort);
//    }
//    @Bean
//    public DigitalAccountCreatePort digitalAccountCreatePort(DigitalAccountMySqlRepository digitalAccountRepository, DigitalAccountMapper digitalAccountMapper) {
//        return new DigitalAccountOracleAdapter(digitalAccountRepository, digitalAccountMapper);
//    }
//    @Bean
//    public DigitalAccountFindByIdPort digitalAccountFindByIdPort(DigitalAccountMySqlRepository digitalAccountRepository, DigitalAccountMapper digitalAccountMapper) {
//        return new DigitalAccountOracleAdapter(digitalAccountRepository, digitalAccountMapper);
//    }

    @Bean
    public DigitalAccountService digitalAccountFindByIdUseCase(DigitalAccountCreatePort digitalAccountCreatePort, DigitalAccountFindByIdPort digitalAccountFindByIdPort){
        return new DigitalAccountService(digitalAccountCreatePort, digitalAccountFindByIdPort);
    }

    @Bean
    @ConditionalOnProperty(name = "MY_SERVICE_IMPL", havingValue = "oracle")
    public DigitalAccountOracleAdapter digitalAccountFindByIdOraclePort(DigitalAccountOracleRepository digitalAccountRepository, com.bintics.adapters.out.dbs.sql.oracle.jpa.mappers.DigitalAccountMapper digitalAccountMapper) {
        return new DigitalAccountOracleAdapter(digitalAccountRepository, digitalAccountMapper);
    }

    @Bean
    @ConditionalOnProperty(name = "MY_SERVICE_IMPL", havingValue = "mysql")
    public DigitalAccountMySqlAdapter digitalAccountFindByIdMySqlPort(DigitalAccountMySqlRepository digitalAccountRepository, com.bintics.adapters.out.dbs.sql.mysql.jpa.mappers.DigitalAccountMapper digitalAccountMapper) {
        return new DigitalAccountMySqlAdapter(digitalAccountRepository, digitalAccountMapper);
    }

}
