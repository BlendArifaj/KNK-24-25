package repository;

import models.Product;
import models.dto.CreateProduct;
import models.dto.UpdateProduct;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepository extends BaseRepository<Product, CreateProduct, UpdateProduct>{
    public ProductRepository(){
        super("product");
    }

    @Override
    Product fromResultSet(ResultSet res) throws SQLException {
        return Product.getInstance(res);
    }

    @Override
    public Product create(CreateProduct createDto) {
        return null;
    }

    @Override
    public Product update(UpdateProduct updateDto) {
        return null;
    }
}
