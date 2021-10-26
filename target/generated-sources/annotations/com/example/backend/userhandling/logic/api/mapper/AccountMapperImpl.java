package com.example.backend.userhandling.logic.api.mapper;

import com.example.backend.userhandling.dataaccess.api.entity.AccountEntity;
import com.example.backend.userhandling.logic.api.to.AccountEto;
import com.example.backend.userhandling.logic.api.to.AccountTo;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-25T20:17:02+0200",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 11.0.4 (JetBrains s.r.o)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountEntity toAccountEntity(AccountTo accountTo) {
        if ( accountTo == null ) {
            return null;
        }

        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setPassword( accountTo.getPassword() );
        accountEntity.setEmail( accountTo.getEmail() );

        return accountEntity;
    }

    @Override
    public AccountEto toAccountEto(AccountEntity accountEntity) {
        if ( accountEntity == null ) {
            return null;
        }

        AccountEto accountEto = new AccountEto();

        accountEto.setId( accountEntity.getId() );
        accountEto.setUsername( accountEntity.getUsername() );
        accountEto.setPassword( accountEntity.getPassword() );
        accountEto.setEmail( accountEntity.getEmail() );
        accountEto.setActivated( accountEntity.isActivated() );

        return accountEto;
    }
}
