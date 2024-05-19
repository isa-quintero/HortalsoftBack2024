package com.hortalsoft.products.domain.port.usecase.product;


import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.port.input.product.ModifyProductUseCase;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.domain.specification.implementation.product.ProductExistsByIdSpecification;
import com.hortalsoft.products.domain.specification.implementation.product.UniqueProductNameSpecification;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ModifyProductService implements ModifyProductUseCase {

    private final ProductRepository productRepository;
    MapperDomainToEntity<Product,ProductEntity> mapperDomainToEntity = new MapperDomainToEntity<>();


    @Autowired
    public ModifyProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public void execute(Product domain) {
        try{
            UniqueProductNameSpecification uniqueNameSpec = new UniqueProductNameSpecification(domain.getName(), productRepository);
            ProductEntity entity =  mapperDomainToEntity.mapToEntity(domain,ProductEntity.class);
            ProductExistsByIdSpecification productExistsSpec = new ProductExistsByIdSpecification(entity.getId(), productRepository);
            if (productExistsSpec.isSatisfiedBy(entity)) {
                if (uniqueNameSpec.isSatisfiedBy(entity)){
                    entity.setId(entity.getId());
                    entity.setName(entity.getName());
                    entity.setSubcategory(entity.getSubcategory());
                    productRepository.save(entity);
                } else{
                    throw  new ExceptionHortalsoft("No es posible modificar el producto", 5001, Layer.DOMAIN);
                }

            }
            else{
                throw  new ExceptionHortalsoft("Producto no encontrado", 6001, Layer.DOMAIN);
            }
        } catch (ExceptionHortalsoft e) {
            throw e;
        } catch (Exception e) {
            throw new ExceptionHortalsoft(e.getMessage(), 500, Layer.DOMAIN);
        }
    }
}
