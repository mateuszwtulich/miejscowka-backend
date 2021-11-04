package com.example.backend.placehandling.logic.api.usecase;

import com.example.backend.general.logic.api.exception.EntityAlreadyExistsException;
import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.placehandling.logic.api.to.CategoryEto;
import com.example.backend.placehandling.logic.api.to.CategoryTo;
import java.util.List;
import java.util.Optional;

public interface UcCategory {

    Optional<CategoryEto> createCategory(CategoryTo categoryTo) throws EntityAlreadyExistsException;
    Optional<CategoryEto> updateCategory(CategoryTo categoryTo, Long categoryId) throws EntityDoesNotExistException;
    void deleteCategory(Long categoryId) throws EntityDoesNotExistException;
    Optional<CategoryEto> findCategory(Long categoryId) throws EntityDoesNotExistException;
    Optional<List<CategoryEto>> findAllCategories();

}
