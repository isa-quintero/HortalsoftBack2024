package com.hortalsoft.products.domain.port.usecase.product;


import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.port.input.product.ModifyProductUseCase;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.util.ExceptionHortalsoft;
import com.hortalsoft.products.util.Layers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


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
            ProductEntity entity =  mapperDomainToEntity.mapToEntity(domain,ProductEntity.class);
            Optional<ProductEntity> resultEntity= productRepository.findById(entity.getId());
            if (resultEntity.isPresent()) {
                if (resultEntity.get().getName().equals(entity.getName())){
                    resultEntity.get().setId(entity.getId());
                    resultEntity.get().setName(entity.getName());
                    resultEntity.get().setSubcategory(entity.getSubcategory());
                    productRepository.save(resultEntity.get());
                }
                else if (productRepository.existsByName(entity.getName())){
                    resultEntity.get().setId(entity.getId());
                    resultEntity.get().setName(entity.getName());
                    resultEntity.get().setSubcategory(entity.getSubcategory());
                    productRepository.save(resultEntity.get());
                } else{
                    throw  new ExceptionHortalsoft("No es posible modificar el producto", 5001,Layers.DOMAIN);
                }

            }
            else{
                throw  new ExceptionHortalsoft("Producto no encontrado", 6001, Layers.DOMAIN);
            }
        }
        catch(Exception e){
            if (e instanceof ExceptionHortalsoft){
                throw (ExceptionHortalsoft) e;
            }else{
                throw new ExceptionHortalsoft(e.getMessage(),500,Layers.DOMAIN);
            }
        }
    }
}
