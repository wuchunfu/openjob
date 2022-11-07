package io.openjob.server.repository.data;

import io.openjob.server.repository.dto.AdminConfigDTO;
import io.openjob.server.repository.entity.AdminConfig;

import java.util.List;

/**
 * @author inhere
 * @date 2022-11-07 13:33:07
 * @since 1.0.0
 */
public interface JobAdminConfigData {

    /**
     * add JobAdminConfig
     *
     * @param dto dto
     * @return id
     */
    Long add(AdminConfigDTO dto);

    /**
     * batch add JobAdminConfig
     *
     * @param dtoList dto list
     * @return id
     */
    Integer batchAdd(List<AdminConfigDTO> dtoList);

    /**
     * get JobAdminConfig by ID
     *
     * @param id id
     * @return JobAdminConfig
     */
    AdminConfigDTO getById(Long id);

    /**
     * get JobAdminConfig by ID, will try get from cache.
     *
     * @param id id
     * @return JobAdminConfig
     */
    AdminConfigDTO getByIdFromCache(Long id);

    /**
     * update JobAdminConfig by ID
     *
     * @param dto dto
     * @return number
     */
    Integer updateById(AdminConfigDTO dto);

}

