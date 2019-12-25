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
	
	/*
	 * "中国人".replace(/(?<=中国)人/, "rr") // 匹配中国人中的人，将其替换为rr，结果为 中国rr
	 * "法国人".replace(/(?<=中国)人/, "rr") // 结果为 法国人，因为人前面不是中国，所以无法匹配到
	 */
	public static void main(String[] args) {
		String s = "47.101.11.182:2222 47.101.11.182:2222";
		// (?:)表示非捕获分组，和捕获分组唯一的区别在于，非捕获分组匹配的值不会保存起来
		String[] sa = s.split("(?:\\s|,)+");
		System.out.println(sa.length);
	}
} 