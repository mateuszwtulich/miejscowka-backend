package com.example.backend.general.utils.annotations;

import com.example.backend.general.security.enums.ApplicationPermissions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionRestrict {
  ApplicationPermissions[] permissions();
}