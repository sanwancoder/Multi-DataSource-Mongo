package com.wyfdc.multi.datasource.go.config.db;


import com.wyfdc.multi.datasource.go.config.AbstractMongoConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;


@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb.picture")
public class PictureDbConfig extends AbstractMongoConfig {

  @Override
  public @Bean(name = "pictureMongoTemplate") MongoTemplate getMongoTemplate(MongoMappingContext context) throws Exception {
    //去除保存实体时，spring data mongodb 自动添加的_class字段
    MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory()), context);
    converter.setTypeMapper(new DefaultMongoTypeMapper(null));

    MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);

    return mongoTemplate;
  }
}

