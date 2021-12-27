package com.chen.springboot_jsp_shirp;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;


//https://github.com/baomidou/generator
//一堆东西。。。
public class FastAutoGeneratorTest {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/mybatis?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8", "root", "root");

    @Test
    public void testFastAutoGenerator() {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("chenchen")
                            .fileOverride()
                            .outputDir(System.getProperty("user.dir") + "/src/main/java")
                            ;
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.moduleName("bzUser")
                            .parent("com.chen.springboot_jsp_shirp");
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("bz_user")
                            .entityBuilder()
                            .enableLombok()
                            .naming(NamingStrategy.underline_to_camel)
                            // .logicDeleteColumnName("IS_DELETE")
                            .enableTableFieldAnnotation()
                            .controllerBuilder()
                            .enableRestStyle()
                            .mapperBuilder()
                            .enableMapperAnnotation()
                            .enableBaseColumnList()
                            .enableBaseResultMap();

                })
                .execute();
    }
}
