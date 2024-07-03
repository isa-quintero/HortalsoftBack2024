package com.hortalsoft.users.domain.port.input.association;

import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.port.input.UseCaseDomain;
import org.springframework.stereotype.Service;

@Service
public interface CreateAssociationUseCase extends UseCaseDomain<Association> {
}
