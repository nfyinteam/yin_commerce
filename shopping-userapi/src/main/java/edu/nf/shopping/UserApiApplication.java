package edu.nf.shopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Achine
 * @date 2020/3/4
 */
@SpringBootApplication
@MapperScan(basePackages = {"edu.nf.shopping.goods.dao", "edu.nf.shopping.comment.dao","edu.nf.shopping.page.dao"})
public class UserApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
    }
}
