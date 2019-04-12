package net.yiyutao.seata.account.config;

import com.alibaba.fescar.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * fescar配置
 */
@Configuration
public class FescarConfig {

    /**
     * 事务配置
     * @return
     */
    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner("account-gts-fescar-example", "my_test_tx_group");
    }
}
