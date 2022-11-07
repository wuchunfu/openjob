package io.openjob.server.repository.data.impl;

import com.kezhilian.boot.common.util.BeanMapperUtil;
import com.kezhilian.boot.redis.operation.RedisOperation;
import io.openjob.server.repository.dao.JobAdminUserDAO;
import io.openjob.server.repository.data.JobAdminUserData;
import io.openjob.server.repository.dto.AdminUserDTO;
import io.openjob.server.repository.entity.AdminUser;
import io.openjob.server.repository.util.CacheUtil;
// import com.kezhilian.wzl.service.order.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author inhere
 * @date 2022-11-07 13:33:42
 * @since 1.0.0
 */
@Component
public class JobAdminUserDataImpl implements JobAdminUserData {

    private final JobAdminUserDAO jobAdminUserDAO;
    private final RedisOperation redisOperation;

    @Autowired
    public JobAdminUserDataImpl(JobAdminUserDAO jobAdminUserDAO, RedisOperation redisOperation) {
        this.jobAdminUserDAO = jobAdminUserDAO;
        this.redisOperation = redisOperation;
    }

    @Override
    public Long add(AdminUserDTO dto) {
        AdminUser entity = BeanMapperUtil.map(dto, AdminUser.class);

        // 序列化扩展信息
        // if (Objects.nonNull(dto.getExtra())) {
        //    entity.setExtra(JsonUtil.toJsonFilterEmpty(dto.getExtra()));
        // }

        return jobAdminUserDAO.add(entity);
    }

    @Override
    public Integer batchAdd(List<AdminUserDTO> dtoList) {
        List<AdminUser> entityList = BeanMapperUtil.mapList(dtoList, AdminUserDTO.class, AdminUser.class);

        return jobAdminUserDAO.batchAdd(entityList);
    }

    @Override
    public AdminUserDTO getById(Long id) {
        return BeanMapperUtil.map(jobAdminUserDAO.getById(id), AdminUserDTO.class);
    }

    @Override
    public AdminUserDTO getByIdFromCache(Long id) {
        return redisOperation.string()
                .key(CacheKey.getJobAdminUserByIdKey(id))
                .orElseGet(() -> getById(id));
    }

    @Override
    public Integer updateById(AdminUserDTO dto) {
        AdminUser entity = BeanMapperUtil.map(dto, AdminUser.class);

        redisOperation.delete(CacheKey.getJobAdminUserByIdKey(dto.getId()));

        return jobAdminUserDAO.updateById(entity);
    }
}

