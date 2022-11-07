package io.openjob.server.repository.data;

import io.openjob.server.repository.dto.AdminUserDTO;
import io.openjob.server.repository.entity.AdminUser;

import java.util.List;

/**
 * @author inhere
 * @date 2022-11-07 13:33:41
 * @since 1.0.0
 */
public interface JobAdminUserData {

    /**
     * add JobAdminUser
     *
     * @param dto dto
     * @return id
     */
    Long add(AdminUserDTO dto);

    /**
     * batch add JobAdminUser
     *
     * @param dtoList dto list
     * @return id
     */
    Integer batchAdd(List<AdminUserDTO> dtoList);

    /**
     * get JobAdminUser by ID
     *
     * @param id id
     * @return JobAdminUser
     */
    AdminUserDTO getById(Long id);

    /**
     * get JobAdminUser by ID, will try get from cache.
     *
     * @param id id
     * @return JobAdminUser
     */
    AdminUserDTO getByIdFromCache(Long id);

    /**
     * update JobAdminUser by ID
     *
     * @param dto dto
     * @return number
     */
    Integer updateById(AdminUserDTO dto);

}

