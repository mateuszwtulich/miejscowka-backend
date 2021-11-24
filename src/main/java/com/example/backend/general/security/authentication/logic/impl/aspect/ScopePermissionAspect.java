package com.example.backend.general.security.authentication.logic.impl.aspect;

import com.example.backend.general.security.authentication.logic.impl.exception.ForbiddenException;
import com.example.backend.general.security.authentication.logic.impl.to.ScopePermission;
import com.example.backend.general.security.authentication.logic.impl.to.UserAuthenticationRequest;
import com.example.backend.general.security.enums.ApplicationPermissions;
import com.example.backend.general.utils.annotations.PermissionRestrict;
import com.example.backend.userhandling.dataaccess.api.dao.UserDao;
import com.example.backend.userhandling.dataaccess.api.entity.PermissionEntity;
import com.example.backend.userhandling.dataaccess.api.entity.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Aspect
@Component
public class ScopePermissionAspect {

  @Inject
  private UserDao userDao;

  @Before(value = "@annotation(com.example.backend.general.utils.annotations.PermissionRestrict)")
  public void hasScopes(final JoinPoint joinPoint) throws Throwable {

    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    PermissionRestrict annotation = signature.getMethod().getAnnotation(PermissionRestrict.class);
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
        .currentRequestAttributes())
        .getRequest();

    String url = request.getRequestURL().toString();
    if(!url.contains("/user/account/registrationConfirm")) {

      String authorizationHeader = request.getHeader("Authorization");
      String token = authorizationHeader.replace("Bearer ", "");

      try {
        Jws<Claims> claimsJws = Jwts.parser()
            .setSigningKey(Keys.hmacShaKeyFor("SecuredpASSWOedpASSWORDSecuedpASredpASSWORDSecuredpASSWORD".getBytes()))
            .parseClaimsJws(token);

        Claims body = claimsJws.getBody();
        String username = body.getSubject();

        UserEntity userEntity = userDao.findByAccount_Username(username).get();

        if (!hasAccess(userEntity, annotation.permissions())) {
          throw new ForbiddenException();
        }
      } catch (JwtException e) {
        throw new IllegalStateException(String.format("Token %s cannot be trusted", token));
      }
    }
  }

  private boolean hasAccess(UserEntity userEntity, ApplicationPermissions[] applicationPermissions) {
    boolean accessed = false;

    List<PermissionEntity> permissions = userEntity.getRole().getPermissions();

    for(ApplicationPermissions applicationPermission : applicationPermissions) {
      for(PermissionEntity userPermission: permissions) {
        if(userPermission.getName().name().equals(applicationPermission.name())) {
          accessed = true;
        }
      }
    }
    return accessed;
  }
}