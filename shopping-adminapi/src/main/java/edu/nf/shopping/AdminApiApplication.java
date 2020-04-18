package edu.nf.shopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Achine
 * @date 2020/3/4
 */
@SpringBootApplication
@ServletComponentScan(basePackages = {"edu.nf.shopping.filter"})
@MapperScan(basePackages = {"edu.nf.shopping.goods.dao",
        "edu.nf.shopping.order.dao",
        "edu.nf.shopping.comment.dao",
        "edu.nf.shopping.message.dao",
        "edu.nf.shopping.warehouse.dao",
        "edu.nf.shopping.page.dao",
        "edu.nf.shopping.shopcart.dao",
        "edu.nf.shopping.user.dao"})
public class AdminApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApiApplication.class, args);
    }
}
