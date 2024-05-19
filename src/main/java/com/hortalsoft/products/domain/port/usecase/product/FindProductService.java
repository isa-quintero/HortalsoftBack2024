package com.hortalsoft.products.domain.port.usecase.product;


import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.port.input.product.FindProductUseCase;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.products.domain.specification.implementation.product.ProductExistsByIdSpecification;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class FindProductService implements FindProductUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final ProductRepository productRepository;
    MapperDomainToEntity<Product, ProductEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    MapperEntityToDomain<ProductEntity, Product> mapperEntityToDomain = new MapperEntityToDomain<>();


    @Autowired
    public FindProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product execute(Product domain) {
        try {
            ProductEntity entity = mapperDomainToEntity.mapToEntity(domain, ProductEntity.class);
            ProductExistsByIdSpecification productExistsSpec = new ProductExistsByIdSpecification(productRepository);
            if (productExistsSpec.isSatisfiedBy(entity)) {
                return mapperEntityToDomain.mapToDomain(entity, Product.class);
            } else {
                throw new ExceptionHortalsoft("Producto no encontrado", 6001, layer);
            }

        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando el producto", 500, layer, exception);
        }
    }
}
