package org.orient.l49jdbctemplate;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.orient.l49jdbctemplate.config.ProductDao;
import org.orient.l49jdbctemplate.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class L49JdbcTemplateApplication implements CommandLineRunner {

    ProductDao productDao;

    public static void main(String[] args) {
        SpringApplication.run(L49JdbcTemplateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Product product = productDao.getProductById(1L);
        System.out.println(product);
    }
}
