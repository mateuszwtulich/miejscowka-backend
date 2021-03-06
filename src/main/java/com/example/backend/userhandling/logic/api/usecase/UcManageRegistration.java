package com.example.backend.userhandling.logic.api.usecase;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import org.springframework.web.servlet.view.RedirectView;
import java.util.Optional;

public interface UcManageRegistration {

  Optional<RedirectView> confirmRegistration(String token) throws EntityDoesNotExistException;
}
