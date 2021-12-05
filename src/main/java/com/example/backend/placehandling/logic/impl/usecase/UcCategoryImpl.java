package com.example.backend.placehandling.logic.impl.usecase;

import com.example.backend.general.logic.api.exception.EntityAlreadyExistsException;
import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.placehandling.dataaccess.api.dao.CategoryDao;
import com.example.backend.placehandling.dataaccess.api.entity.CategoryEntity;
import com.example.backend.placehandling.logic.api.mapper.CategoryMapper;
import com.example.backend.placehandling.logic.api.to.CategoryEto;
import com.example.backend.placehandling.logic.api.to.CategoryTo;
import com.example.backend.placehandling.logic.api.usecase.UcCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Validated
@Named
public class UcCategoryImpl implements UcCategory {

    private static final Logger LOG = LoggerFactory.getLogger(UcCategoryImpl.class);
    private static final String ID_CANNOT_BE_NULL = "id cannot be a null value";
    private static final String CREATE_CATEGORY_LOG = "Create Category with name {} in database.";
    private static final String UPDATE_CATEGORY_LOG = "Update Category with id {} in database.";
    private static final String GET_CATEGORY_LOG = "Get Category with id {} from database.";
    private static final String GET_ALL_CATEGORIES_LOG = "Get all Categories from database.";
    private static final String DELETE_CATEGORY_LOG = "Delete Category with id {} in database.";


    @Inject
    private CategoryMapper categoryMapper;

    @Inject
    private CategoryDao categoryDao;

    @Override
    public Optional<CategoryEto> createCategory(CategoryTo categoryTo) throws EntityAlreadyExistsException {
        LOG.debug(CREATE_CATEGORY_LOG, categoryTo.getName());
        CategoryEntity categoryEntity = categoryMapper.toCategoryEntity(categoryTo);
        CategoryEntity categorySaved = categoryDao.save(categoryEntity);
        return toCategoryEto(categorySaved);
    }

    @Override
    public Optional<CategoryEto> updateCategory(CategoryTo categoryTo, Long categoryId) throws EntityDoesNotExistException {
        LOG.debug(UPDATE_CATEGORY_LOG, categoryId);
        CategoryEntity categoryEntity = getCategoryById(categoryId);
        categoryEntity.setName(categoryTo.getName());
        categoryEntity.setDescription(categoryTo.getDescription());
        return toCategoryEto(categoryEntity);
    }

    @Override
    public void deleteCategory(Long categoryId) throws EntityDoesNotExistException {
        LOG.debug(DELETE_CATEGORY_LOG, categoryId);

        CategoryEntity categoryEntity = getCategoryById(categoryId);
        categoryDao.deleteById(categoryEntity.getId());
    }

    @Override
    public Optional<CategoryEto> findCategory(Long categoryId) throws EntityDoesNotExistException {
        LOG.debug(GET_CATEGORY_LOG, categoryId);
        Objects.requireNonNull(categoryId, ID_CANNOT_BE_NULL);

        CategoryEntity categoryEntity = getCategoryById(categoryId);
        return toCategoryEto(categoryEntity);
    }

    @Override
    public Optional<List<CategoryEto>> findAllCategories() {
        LOG.debug(GET_ALL_CATEGORIES_LOG);

        return Optional.of(categoryDao.findAll().stream()
            .map(categoryEntity -> categoryMapper.toCategoryEto(categoryEntity))
            .collect(Collectors.toList()));
    }

    private Optional<CategoryEto> toCategoryEto(CategoryEntity categoryEntity){
        CategoryEto categoryEto = categoryMapper.toCategoryEto(categoryEntity);
        return Optional.of(categoryEto);
    }

    private CategoryEntity getCategoryById(Long categoryId) throws EntityDoesNotExistException{
        Objects.requireNonNull(categoryId, ID_CANNOT_BE_NULL);

        return categoryDao.findById(categoryId).orElseThrow(() ->
                new EntityDoesNotExistException("Category with id " + categoryId + " does not exists"));
    }
}
