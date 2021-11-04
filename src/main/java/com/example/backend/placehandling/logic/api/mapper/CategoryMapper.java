package com.example.backend.placehandling.logic.api.mapper;

import com.example.backend.placehandling.dataaccess.api.entity.CategoryEntity;
import com.example.backend.placehandling.logic.api.to.CategoryEto;
import com.example.backend.placehandling.logic.api.to.CategoryTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryEntity toCategoryEntity(CategoryTo categoryTo);
    CategoryEto toCategoryEto(CategoryEntity categoryEntity);

}
