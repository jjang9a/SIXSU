package co.sixsu.app.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "co.sixsu.app.**.mapper")
public class MybatisConfig {

}
