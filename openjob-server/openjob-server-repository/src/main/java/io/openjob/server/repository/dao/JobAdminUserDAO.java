package io.openjob.server.repository.dao;

import io.openjob.server.repository.entity.AdminUser;

import java.util.List;

/**
 * @author inhere
 * @date 2022-11-07 13:33:40
 * @since 1.0.0
 */
public interface JobAdminUserDAO {

    /**
     * add JobAdminUser
     *
     * @param entity entity
     * @return id
     */
    Long add(AdminUser entity);

    /**
     * batch add JobAdminUser
     *
     * @param entityList entity list
     * @return number
     */
    void batchAdd(List<AdminUser> entityList);

    /**
     * get JobAdminUser by Id
     *
     * @param id id
     * @return JobAdminUser
     */
    AdminUser getById(Long id);

    /**
     * update JobAdminUser by ID
     *
     * @param entity entity
     * @return number
     */
    Integer updateById(AdminUser entity);

}

