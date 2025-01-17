package org.orient.l49jdbctemplate.config;

import lombok.extern.slf4j.Slf4j;
import org.orient.l49jdbctemplate.mapper.ProductRowMapper;
import org.orient.l49jdbctemplate.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product getProductById(Long id) {
        String query = "SELECT * FROM products where id = ?";

        List<Product> products = jdbcTemplate.query(query, new ProductRowMapper(), id);

        return products.isEmpty() ? null : products.get(0);
    }

    public boolean saveProduct(Product product) {
        String query = "INSERT INTO products (name,price) VALUES (?,?)";
        int updateCount = jdbcTemplate.update(query, product.getName(), product.getPrice());
        log.info("Product saved with name: " + product.getName());
        return updateCount == 1;
    }

    public void deleteProduct(Long id) {
        String query = "DELETE FROM products WHERE id =?";
        jdbcTemplate.update(query, id);
        log.info("Deleted product: " + id);
    }

    public  void execute(){
        String query = "DROP TABLE products";
        jdbcTemplate.update(query);
    }

}
