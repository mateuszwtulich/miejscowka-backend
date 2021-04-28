package com.example.backend.userhandling.logic.impl.usecase;

import com.example.backend.userhandling.dataaccess.api.dao.AccountDao;
import com.example.backend.userhandling.logic.api.mapper.AccountMapper;
import com.example.backend.userhandling.logic.api.to.AccountEto;
import com.example.backend.userhandling.logic.api.usecase.UcFindAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Validated
@Named
public class UcFindAccountImpl implements UcFindAccount {

  private static final Logger LOG = LoggerFactory.getLogger(UcFindAccountImpl.class);
  private static final String GET_ALL_ACCOUNTS_LOG = "Get all Accounts from database.";

  @Inject
  private AccountDao accountDao;

  @Inject
  private AccountMapper accountMapper;

  @Override
  public Optional<List<AccountEto>> findAllAccounts() {
    LOG.debug(GET_ALL_ACCOUNTS_LOG);

    return Optional.of(accountDao.findAll().stream()
        .map(accountEntity -> accountMapper.toAccountEto(accountEntity))
        .collect(Collectors.toList()));
  }
}
