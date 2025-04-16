package models.dto;

public class UserBuyProductDto {
    private int userId;
    private int productId;
    private int qty;

    public UserBuyProductDto(int userId, int productId, int qty) {
        this.userId = userId;
        this.productId = productId;
        this.qty = qty;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
