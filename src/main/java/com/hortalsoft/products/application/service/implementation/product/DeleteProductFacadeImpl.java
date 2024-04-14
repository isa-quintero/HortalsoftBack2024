package com.hortalsoft.products.application.service.implementation.product;


import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.service.facade.product.DeleteProductFacade;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.port.product.DeleteProductUseCase;
import com.hortalsoft.products.util.mapper.MapperDTOToDomain;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeleteProductFacadeImpl implements DeleteProductFacade {
    MapperDTOToDomain<ProductDTO ,Product> mapperDTOToDomain = new MapperDTOToDomain();
    MapperDTOToDomain<OfferDTO, Offer> mapperDTOsToDomains = new MapperDTOToDomain();
    private final DeleteProductUseCase useCase;


    public DeleteProductFacadeImpl(DeleteProductUseCase useCase) {
        this.useCase = useCase;

    }
    @Override
    public void execute(ProductDTO dto) {
        try{
            Product domain = mapperDTOToDomain.mapToDomain(dto, Product.class);
            useCase.execute(domain);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
