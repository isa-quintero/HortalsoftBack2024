package com.hortalsoft.products.application.facades.implementation.product;

import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.facades.facade.product.ModifyProductFacade;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.port.input.product.ModifyProductUseCase;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layers;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ModifyProductFacadeImpl implements ModifyProductFacade {

    MapperDTOToDomain<ProductDTO ,Product> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final ModifyProductUseCase useCase;
    private final Layers layer = Layers.APPLICATION;

    public ModifyProductFacadeImpl(ModifyProductUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Executes the modification of a product.
     *
     * @param dto The ProductDTO object containing the data for the product to be modified.
     * @throws ExceptionHortalsoft If an error occurs during the execution of the modification.
     */
    @Override
    public void execute(ProductDTO dto) {
        try{
            Product domain = mapperDTOToDomain.mapToDomain(dto, Product.class);
            useCase.execute(domain);
        }
        catch(Exception e){
            if (e instanceof ExceptionHortalsoft){
                throw (ExceptionHortalsoft) e;
            }else{
                throw new ExceptionHortalsoft("Ha ocurrido un error",500, layer);
            }
        }
    }
}
