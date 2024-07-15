package com.hortalsoft.users.domain.specification.farmer;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.users.domain.entity.FarmerEntity;

import java.util.Objects;

public class EmptyAttributesFarmerSpec extends AbstractSpecification<FarmerEntity> {

    @Override
    public boolean isSatisfiedBy(FarmerEntity farmer) {
        return Objects.equals(farmer.getAssociation(), 0);
    }
}
