package com.xupt.read.configuration.plugins;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 运行此方法生成mybatis代码
 * 生成代码自动放入对应目录
 * 配置文件targetProject应从项目名称开始到要生成到的classpath
 */
@Slf4j
public class MyBatisGeneratorRun {

    public static void main(String[] args) throws Exception {
        MyBatisGeneratorRun app = new MyBatisGeneratorRun();

        log.info(app.getClass().getResource("/").getPath());
        app.generator();
        log.info(System.getProperty("user.dir"));
    }

    public void generator() throws Exception {

        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("generator/generatorConfig.xml");
        log.info(resourceAsStream.toString());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(resourceAsStream);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        for (String warning : warnings) {
            log.info(warning);
        }
    }
}
