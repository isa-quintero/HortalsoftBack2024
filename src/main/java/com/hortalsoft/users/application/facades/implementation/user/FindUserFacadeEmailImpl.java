package com.hortalsoft.users.application.facades.implementation.user;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.application.dto.AssociationDTO;
import com.hortalsoft.users.application.dto.CustomerDTO;
import com.hortalsoft.users.application.dto.FarmerDTO;
import com.hortalsoft.users.application.dto.UserDTO;
import com.hortalsoft.users.application.facades.facade.user.FindUserFacadeEmail;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.application.mapper.MapperDomainToDto;
import com.hortalsoft.users.domain.domain.Customer;
import com.hortalsoft.users.domain.domain.User;
import com.hortalsoft.users.domain.port.input.user.FindUserEmailUseCase;
import com.hortalsoft.users.util.UserType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindUserFacadeEmailImpl implements FindUserFacadeEmail {
    MapperDTOToDomain<UserDTO, Customer> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<User, CustomerDTO> mapperDomainToDtoCustomer = new MapperDomainToDto<>();
    MapperDomainToDto<User, AssociationDTO> mapperDomainToDtoAssociation = new MapperDomainToDto<>();
    MapperDomainToDto<User, FarmerDTO> mapperDomainToDtoFarmer = new MapperDomainToDto<>();

    private final FindUserEmailUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public FindUserFacadeEmailImpl(FindUserEmailUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public UserDTO execute(UserDTO dto) {
        try {
            User domain = mapperDTOToDomain.mapToDomain(dto, Customer.class);
            if(domain.getUserType() == UserType.FARMER){
                return mapperDomainToDtoFarmer.mapToDto(useCase.execute(domain), FarmerDTO.class);
            } else if(domain.getUserType() == UserType.CUSTOMER){
                return mapperDomainToDtoCustomer.mapToDto(useCase.execute(domain), CustomerDTO.class);
            } else if (domain.getUserType() == UserType.ASSOCIATION) {
                return mapperDomainToDtoAssociation.mapToDto(useCase.execute(domain), AssociationDTO.class);

            } else {
                throw new ExceptionHortalsoft("Error encontrando el usuario", 5001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
