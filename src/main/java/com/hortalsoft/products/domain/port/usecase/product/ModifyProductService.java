package com.hortalsoft.products.domain.port.usecase.product;


import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.port.input.product.ModifyProductUseCase;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.domain.specification.implementation.product.ProductExistsByNameAndId;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ModifyProductService implements ModifyProductUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final ProductRepository productRepository;
    MapperDomainToEntity<Product, ProductEntity> mapperDomainToEntity = new MapperDomainToEntity<>();


    @Autowired
    public ModifyProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void execute(Product domain) {
        try {
            ProductEntity entity = mapperDomainToEntity.mapToEntity(domain, ProductEntity.class);
            ProductExistsByNameAndId productExistsByNameAndId = new ProductExistsByNameAndId(productRepository,entity);
            if (productExistsByNameAndId.isSatisfiedBy(entity)) {
                entity.setId(entity.getId());
                entity.setName(entity.getName());
                entity.setSubcategory(entity.getSubcategory());
                productRepository.save(entity);
            } else {
                throw new ExceptionHortalsoft("Producto no encontrado", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado modificando el producto", 500, layer, exception);
        }
    }
}
