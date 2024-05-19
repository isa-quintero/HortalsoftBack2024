package com.hortalsoft.products.application.facades.implementation.product;

import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.facades.facade.product.ListProductsFacade;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.port.input.product.ListProductsUseCase;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListProductsFacadeImpl implements ListProductsFacade {
    MapperDomainToDto<Product, ProductDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final ListProductsUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public ListProductsFacadeImpl(ListProductsUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Executes the list products use case and maps the resulting domain objects to DTOs.
     *
     * @return a list of ProductDTO objects representing the products
     * @throws ExceptionHortalsoft if an ExceptionHortalsoft is thrown during the execution
     */
    @Override
    public List<ProductDTO> execute() {
        try {
            return mapperDomainToDto.mapToDtoList(useCase.execute(), ProductDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
