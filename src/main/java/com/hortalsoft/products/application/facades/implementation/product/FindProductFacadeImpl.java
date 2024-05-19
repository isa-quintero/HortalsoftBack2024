package com.hortalsoft.products.application.facades.implementation.product;

import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.facades.facade.product.FindProductFacade;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.port.input.product.FindProductUseCase;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindProductFacadeImpl implements FindProductFacade {

    MapperDTOToDomain<ProductDTO, Product> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<Product, ProductDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final FindProductUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public FindProductFacadeImpl(FindProductUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Executes the FindProductFacadeImpl by mapping the given ProductDTO to a Product domain object,
     * and then calling the execute method of the FindProductUseCase with the domain object as a parameter.
     * The result is then mapped back to a ProductDTO and returned.
     *
     * @param dto The ProductDTO object to be executed.
     * @return The resulting ProductDTO object.
     * @throws ExceptionHortalsoft if an ExceptionHortalsoft is thrown during execution.
     */
    @Override
    public ProductDTO execute(ProductDTO dto) {
        try {
            Product domain = mapperDTOToDomain.mapToDomain(dto, Product.class);
            return mapperDomainToDto.mapToDto(useCase.execute(domain), ProductDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
