package repository;

import models.UserProduct;
import models.dto.CreateUserProduct;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserProductRepository extends BaseRepository<UserProduct, CreateUserProduct, Object> {
    public UserProductRepository() {
        super("user_product");
    }

    @Override
    UserProduct fromResultSet(ResultSet res) throws SQLException {
        return UserProduct.getInstance(res);
    }

    @Override
    public UserProduct create(CreateUserProduct createDto) {
        return null;
    }

    @Override
    public UserProduct update(Object updateDto){
        return null;
    }
}
