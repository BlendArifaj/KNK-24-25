package services;

import models.Product;
import models.UserProduct;
import models.dto.CreateUserProduct;
import models.dto.UpdateProduct;
import models.dto.UserBuyProductDto;
import repository.ProductRepository;
import repository.UserProductRepository;

public class UserProductService {
    private ProductRepository productRepository;
    private UserProductRepository userProductRepository;

//    Constructor ...

    public boolean buyProduct(UserBuyProductDto userProduct) throws Exception{
        if(userProduct.getQty() <= 0){
            throw new Exception("QTY cannot be zero!");
        }
        Product product = this.productRepository.getById(userProduct.getProductId());
        if(product.getStock() < userProduct.getQty()){
            throw new Exception("QTY is greater than stock!");
        }
        CreateUserProduct createUserProductDto = new CreateUserProduct(
                userProduct.getUserId(), userProduct.getProductId(), userProduct.getQty()
        );
        UserProduct createdUserProduct = this.userProductRepository.create(
                createUserProductDto);
        if(createdUserProduct == null){
            throw new Exception("User buy product failed!");
        }
        UpdateProduct updateProductDto = new UpdateProduct();
        updateProductDto.setStock(product.getStock() - userProduct.getQty());
        this.productRepository.update(updateProductDto);
        return true;
    }
}
