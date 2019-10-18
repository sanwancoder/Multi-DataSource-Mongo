package com.wyfdc.multi.datasource.go.config.db;

import com.wyfdc.multi.datasource.go.config.AbstractMongoConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;


@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb.archives")
public class ArchiveDbConfig extends AbstractMongoConfig {
  //设置为默认数据源，如果定义mongoTemplate的时候未指定数据源，将默认为此数据源
  @Primary
  @Override
  public @Bean(name = "archivesMongoTemplate") MongoTemplate getMongoTemplate(MongoMappingContext context) throws Exception {
    //去除保存实体时，spring data mongodb 自动添加的_class字段
    MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory()), context);
    converter.setTypeMapper(new DefaultMongoTypeMapper(null));

    MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);

    return mongoTemplate;
  }
}

