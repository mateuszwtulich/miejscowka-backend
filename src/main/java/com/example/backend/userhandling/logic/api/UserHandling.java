package com.example.backend.userhandling.logic.api;

import com.example.backend.userhandling.logic.api.usecase.UcDeleteRole;
import com.example.backend.userhandling.logic.api.usecase.UcDeleteUser;
import com.example.backend.userhandling.logic.api.usecase.UcFindAccount;
import com.example.backend.userhandling.logic.api.usecase.UcFindRole;
import com.example.backend.userhandling.logic.api.usecase.UcFindUser;
import com.example.backend.userhandling.logic.api.usecase.UcManageRegistration;
import com.example.backend.userhandling.logic.api.usecase.UcManageRole;
import com.example.backend.userhandling.logic.api.usecase.UcManageUser;

public interface UserHandling extends
    UcDeleteRole,
    UcDeleteUser,
    UcFindAccount,
    UcFindRole,
    UcFindUser,
    UcManageRegistration,
    UcManageRole,
    UcManageUser {
}
