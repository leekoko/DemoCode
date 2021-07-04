package com.leekoko.configuration;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@MapperScan("com.leekoko.nytzj")
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class MyBatisConfig implements TransactionManagementConfigurer {
    @Autowired
    private DataSource dataSource;

    public MyBatisConfig() {
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(this.dataSource);
    }


    @Bean(
            name = {"sqlSessionFactory"}
    )
    public SqlSessionFactory sqlSessionFactoryBean() {
        // 调整为mybatis-plus的SqlSessionFactory
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(this.dataSource);
        bean.setTypeAliasesPackage("com.leekoko.nytzj");
//        bean.setTypeAliasesSuperType(BaseEntity.class);
//        bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        bean.setTypeHandlers(getTypeHandlers());
        try {
//            bean.setMapperLocations(resolver.getResources("classpath*:mappings/modules/**/*.xml"));
            return bean.getObject();
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
