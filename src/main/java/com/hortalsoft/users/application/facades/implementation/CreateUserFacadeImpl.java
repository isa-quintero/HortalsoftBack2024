package com.hortalsoft.users.application.facades.implementation;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.users.application.dto.AssociationDTO;
import com.hortalsoft.users.application.dto.CustomerDTO;
import com.hortalsoft.users.application.dto.FarmerDTO;
import com.hortalsoft.users.application.dto.UserDTO;
import com.hortalsoft.users.application.facades.facade.user.CreateUserFacade;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.domain.Customer;
import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.port.input.association.CreateAssociationUseCase;
import com.hortalsoft.users.domain.port.input.customer.CreateCustomerUseCase;
import com.hortalsoft.users.domain.port.input.farmer.CreateFarmerUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateUserFacadeImpl implements CreateUserFacade {

    MapperDTOToDomain<FarmerDTO, Farmer> mapperDTOToDomainFarmer = new MapperDTOToDomain<>();
    MapperDTOToDomain<CustomerDTO, Customer> mapperDTOToDomainCustomer = new MapperDTOToDomain<>();
    MapperDTOToDomain<AssociationDTO, Association> mapperDTOToDomainAssociation = new MapperDTOToDomain<>();

    private final CreateFarmerUseCase createFarmerUseCase;
    private final CreateCustomerUseCase createCustomerUseCase;
    private final CreateAssociationUseCase createAssociationUseCase;
    private final ExceptionHandlingAspect exceptionHandlingAspect;

    public CreateUserFacadeImpl(CreateFarmerUseCase createFarmerUseCase, CreateCustomerUseCase createCustomerUseCase, CreateAssociationUseCase createAssociationUseCase, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.createFarmerUseCase = createFarmerUseCase;
        this.createCustomerUseCase = createCustomerUseCase;
        this.createAssociationUseCase = createAssociationUseCase;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    @Override
    public void execute(UserDTO dto) {
        try {
            if (dto instanceof FarmerDTO) {
                Farmer domain = mapperDTOToDomainFarmer.mapToDomain((FarmerDTO) dto, Farmer.class);
                createFarmerUseCase.execute(domain);
            } else if (dto instanceof CustomerDTO) {
                Customer domain = mapperDTOToDomainCustomer.mapToDomain((CustomerDTO) dto, Customer.class);
                createCustomerUseCase.execute(domain);
            } else if (dto instanceof AssociationDTO) {
                Association domain = mapperDTOToDomainAssociation.mapToDomain((AssociationDTO) dto, Association.class);
                createAssociationUseCase.execute(domain);
            } else {
                throw new IllegalArgumentException("Tipo de usuario desconocido");
            }
        } catch (Exception exception) {
            exceptionHandlingAspect.exceptionsApplication(exception);
        }
    }
}
