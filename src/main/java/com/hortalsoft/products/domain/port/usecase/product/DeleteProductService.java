package com.hortalsoft.products.domain.port.usecase.product;


import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.port.input.product.DeleteProductUseCase;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class DeleteProductService implements DeleteProductUseCase {

    private final ProductRepository productRepository;
    private static final Layer layer = Layer.DOMAIN;


    @Autowired
    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void execute(Product domain) {
        try {
            if (productRepository.existsById(domain.getId())) {
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
