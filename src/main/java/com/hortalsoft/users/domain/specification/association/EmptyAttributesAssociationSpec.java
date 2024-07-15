package com.hortalsoft.users.domain.specification.association;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.users.domain.entity.AssociationEntity;

import java.util.Objects;

public class EmptyAttributesAssociationSpec extends AbstractSpecification<AssociationEntity> {

    @Override
    public boolean isSatisfiedBy(AssociationEntity association) {
        return Objects.equals(association.getName(),"");
    }
}
