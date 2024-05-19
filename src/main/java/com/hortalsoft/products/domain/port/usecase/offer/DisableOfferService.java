package com.hortalsoft.products.domain.port.usecase.offer;


import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.port.input.offer.DisableOfferUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class DisableOfferService implements DisableOfferUseCase {

    private final static Layer layer = Layer.DOMAIN;
    private final OfferRepository offerRepository;


    @Autowired
    public DisableOfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;

    }

    @Override
    public void execute(Offer domain) {
        try {
            Optional<OfferEntity> findbyId = offerRepository.findById(domain.getId());
            if (findbyId.isPresent()) {
                offerRepository.delete(findbyId.get());
            } else {
                throw new ExceptionHortalsoft("Producto no encontrado", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado deshabilitando la oferta", 500, layer, exception);
        }
    }
}
