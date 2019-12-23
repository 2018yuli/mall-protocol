package com.ydual.mall.admin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.code.ssm.CacheFactory;
import com.google.code.ssm.config.AbstractSSMConfiguration;
import com.google.code.ssm.config.DefaultAddressProvider;
import com.google.code.ssm.providers.CacheConfiguration;

@Configuration
public class LocalSSMConfiguration extends AbstractSSMConfiguration {
    
	@Bean
    @Override
    public CacheFactory defaultMemcachedClient() {
        final CacheConfiguration conf = new CacheConfiguration();
        conf.setConsistentHashing(true);
        final CacheFactory cf = new CacheFactory();
        cf.setCacheClientFactory(new com.google.code.ssm.providers.xmemcached.MemcacheClientFactoryImpl());
        cf.setAddressProvider(new DefaultAddressProvider("47.101.11.182:2222"));
        cf.setConfiguration(conf);
        return cf;
    }
} 