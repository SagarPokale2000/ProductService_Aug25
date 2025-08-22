package com.example.productservice_aug25.Service;

import com.example.productservice_aug25.DTOs.FakeStoreProductDTO;
import com.example.productservice_aug25.Exception.ProductNotFoundException;
import com.example.productservice_aug25.Models.Category;
import com.example.productservice_aug25.Models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.smartcardio.CardTerminal;
import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {

        ResponseEntity<FakeStoreProductDTO[]> responseEntity =
                this.restTemplate.getForEntity(
                        "https://fakestoreapi.com/products",
                        FakeStoreProductDTO[].class);

        FakeStoreProductDTO[] fakeStoreProductDTO = responseEntity.getBody();

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDTO dto : fakeStoreProductDTO) {
            products.add(getProductFromFakeProductDTO(dto));
        }

        return products;
    }

    @Override
    public Product getSingleProductById(Long productId) throws ProductNotFoundException {
        //Make call to fakeStore server
        ResponseEntity<FakeStoreProductDTO> responseEntity =
                this.restTemplate.getForEntity
                        ("https://fakestoreapi.com/products/"+productId,
                                FakeStoreProductDTO.class);

        FakeStoreProductDTO  fakeStoreProductDTO = responseEntity.getBody();

        if(fakeStoreProductDTO == null){
            throw new ProductNotFoundException("Product not found");
        }
        return getProductFromFakeProductDTO(fakeStoreProductDTO);
    }

    @Override
    public Product createProduct(Product product) {
//        new
//        newasldfds
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    private Product getProductFromFakeProductDTO(FakeStoreProductDTO fakeStoreProductDTO) {
        Product product = new Product();
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setImgUrl(fakeStoreProductDTO.getImage());
        product.setId(fakeStoreProductDTO.getId());

        Category category = new Category();
        category.setTitle(fakeStoreProductDTO.getCategory());
        product.setCategory(category);

        return product;
    }
}
