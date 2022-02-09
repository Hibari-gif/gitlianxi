package kakin.demo.mybatis.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = MyBatisConfig.BASE_PACKAGES, sqlSessionTemplateRef = MyBatisConfig.SQL_SESSION_TEMPLATE_NAME)
public class MyBatisConfig {

    public static final String BASE_PACKAGES = "kakin.demo.mybatis.repository.mapper";

    public static final String MAPPER_XML_PATH = "classpath:" + BASE_PACKAGES.replace(".", "/") + "*/mapper/*.xml";

    public static final String SQL_SESSION_FACTORY_NAME = "KakinSqlSessionFactory";
    
    public static final String SQL_SESSION_TEMPLATE_NAME = "KakinSqlSessionTemplate";

    @Bean(SQL_SESSION_FACTORY_NAME)
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_PATH));

        return bean;
    }

    @Bean(SQL_SESSION_TEMPLATE_NAME)
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier(MyBatisConfig.SQL_SESSION_FACTORY_NAME) SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
