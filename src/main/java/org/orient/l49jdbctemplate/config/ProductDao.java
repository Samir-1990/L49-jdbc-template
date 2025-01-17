package org.orient.l49jdbctemplate.config;

import org.orient.l49jdbctemplate.mapper.ProductRowMapper;
import org.orient.l49jdbctemplate.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDao {

    private  final JdbcTemplate jdbcTemplate;

    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product getProductById(Long id){
        String query = "SELECT * FROM products where id = ?";

       List<Product> products = jdbcTemplate.query(query,new ProductRowMapper(), id);

       return products.isEmpty() ? null : products.get(0);
    }
}
