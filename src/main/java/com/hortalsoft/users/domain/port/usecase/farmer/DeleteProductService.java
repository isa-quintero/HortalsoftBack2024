package com.hortalsoft.users.domain.port.usecase.farmer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.domain.specification.implementation.product.ProductExistsByIdSpec;
import com.hortalsoft.users.domain.port.input.product.DeleteProductUseCase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class DeleteProductService implements DeleteProductUseCase {

    private final ProductRepository productRepository;
    private static final Layer layer = Layer.DOMAIN;
    MapperDomainToEntity<Product, ProductEntity> mapperDomainToEntity = new MapperDomainToEntity<>();


    @Autowired
    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void execute(Product domain) {
        try {
            ProductEntity entity = mapperDomainToEntity.mapToEntity(domain, ProductEntity.class);
            ProductExistsByIdSpec productExistsSpec = new ProductExistsByIdSpec(productRepository);
            if (productExistsSpec.isSatisfiedBy(entity)) {
                productRepository.deleteById(domain.getId());
            } else {
                throw new ExceptionHortalsoft("Producto no encontrado", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado eliminando el producto", 500, layer, exception);
        }
    }
}
