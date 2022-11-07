package io.openjob.server.repository.dao;

import io.openjob.server.repository.entity.AdminConfig;

import java.util.List;

/**
 * @author inhere
 * @date 2022-11-07 13:33:03
 * @since 1.0.0
 */
public interface JobAdminConfigDAO {

    /**
     * add JobAdminConfig
     *
     * @param entity entity
     * @return id
     */
    Long add(AdminConfig entity);

    /**
     * batch add JobAdminConfig
     *
     * @param entityList entity list
     * @return number
     */
    Integer batchAdd(List<AdminConfig> entityList);

    /**
     * get JobAdminConfig by Id
     *
     * @param id id
     * @return JobAdminConfig
     */
    AdminConfig getById(Long id);

    /**
     * update JobAdminConfig by ID
     *
     * @param entity entity
     * @return number
     */
    Integer updateById(AdminConfig entity);

}

