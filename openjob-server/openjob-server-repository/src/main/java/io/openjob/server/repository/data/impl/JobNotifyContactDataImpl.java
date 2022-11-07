package io.openjob.server.repository.data.impl;

import com.kezhilian.boot.common.util.BeanMapperUtil;
import com.kezhilian.boot.redis.operation.RedisOperation;
import io.openjob.server.repository.dao.JobNotifyContactDAO;
import io.openjob.server.repository.data.JobNotifyContactData;
import io.openjob.server.repository.dto.NotifyContactDTO;
import io.openjob.server.repository.entity.NotifyContact;
import io.openjob.server.repository.util.CacheUtil;
// import com.kezhilian.wzl.service.order.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author inhere
 * @date 2022-11-07 13:45:11
 * @since 1.0.0
 */
@Component
public class JobNotifyContactDataImpl implements JobNotifyContactData {

    private final JobNotifyContactDAO jobNotifyContactDAO;
    private final RedisOperation redisOperation;

    @Autowired
    public JobNotifyContactDataImpl(JobNotifyContactDAO jobNotifyContactDAO, RedisOperation redisOperation) {
        this.jobNotifyContactDAO = jobNotifyContactDAO;
        this.redisOperation = redisOperation;
    }

    @Override
    public Long add(NotifyContactDTO dto) {
        NotifyContact entity = BeanMapperUtil.map(dto, NotifyContact.class);

        // 序列化扩展信息
        // if (Objects.nonNull(dto.getExtra())) {
        //    entity.setExtra(JsonUtil.toJsonFilterEmpty(dto.getExtra()));
        // }

        return jobNotifyContactDAO.add(entity);
    }

    @Override
    public Integer batchAdd(List<NotifyContactDTO> dtoList) {
        List<NotifyContact> entityList = BeanMapperUtil.mapList(dtoList, NotifyContactDTO.class, NotifyContact.class);

        return jobNotifyContactDAO.batchAdd(entityList);
    }

    @Override
    public NotifyContactDTO getById(Long id) {
        return BeanMapperUtil.map(jobNotifyContactDAO.getById(id), NotifyContactDTO.class);
    }

    @Override
    public NotifyContactDTO getByIdFromCache(Long id) {
        return redisOperation.string()
                .key(CacheKey.getJobNotifyContactByIdKey(id))
                .orElseGet(() -> getById(id));
    }

    @Override
    public Integer updateById(NotifyContactDTO dto) {
        NotifyContact entity = BeanMapperUtil.map(dto, NotifyContact.class);

        redisOperation.delete(CacheKey.getJobNotifyContactByIdKey(dto.getId()));

        return jobNotifyContactDAO.updateById(entity);
    }
}

