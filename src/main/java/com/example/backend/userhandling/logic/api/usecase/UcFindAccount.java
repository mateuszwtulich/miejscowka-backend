package com.example.backend.userhandling.logic.api.usecase;

import com.example.backend.userhandling.logic.api.to.AccountEto;

import java.util.List;
import java.util.Optional;

public interface UcFindAccount {

  Optional<List<AccountEto>> findAllAccounts();
}
