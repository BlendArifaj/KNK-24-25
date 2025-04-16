package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserProduct {
    private int id;
    private int userId;
    private int productId;

    private UserProduct(int id, int userId, int productId) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
    }

    public static UserProduct getInstance(ResultSet res) throws SQLException{
        int id = res.getInt("id");
        int userId = res.getInt("user_id");
        int productId = res.getInt("product_id");
        return new UserProduct(id, userId, productId);
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getProductId() {
        return productId;
    }
}
