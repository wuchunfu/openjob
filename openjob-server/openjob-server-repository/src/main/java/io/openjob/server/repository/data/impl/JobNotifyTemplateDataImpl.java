package io.openjob.server.repository.data.impl;

import com.kezhilian.boot.common.util.BeanMapperUtil;
import com.kezhilian.boot.redis.operation.RedisOperation;
import io.openjob.server.repository.dao.JobNotifyTemplateDAO;
import io.openjob.server.repository.data.JobNotifyTemplateData;
import io.openjob.server.repository.dto.NotifyTemplateDTO;
import io.openjob.server.repository.entity.NotifyTemplate;
import io.openjob.server.repository.util.CacheUtil;
// import com.kezhilian.wzl.service.order.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author inhere
 * @date 2022-11-07 13:44:58
 * @since 1.0.0
 */
@Component
public class JobNotifyTemplateDataImpl implements JobNotifyTemplateData {

    private final JobNotifyTemplateDAO jobNotifyTemplateDAO;
    private final RedisOperation redisOperation;

    @Autowired
    public JobNotifyTemplateDataImpl(JobNotifyTemplateDAO jobNotifyTemplateDAO, RedisOperation redisOperation) {
        this.jobNotifyTemplateDAO = jobNotifyTemplateDAO;
        this.redisOperation = redisOperation;
    }

    @Override
    public Long add(NotifyTemplateDTO dto) {
        NotifyTemplate entity = BeanMapperUtil.map(dto, NotifyTemplate.class);

        // 序列化扩展信息
        // if (Objects.nonNull(dto.getExtra())) {
        //    entity.setExtra(JsonUtil.toJsonFilterEmpty(dto.getExtra()));
        // }

        return jobNotifyTemplateDAO.add(entity);
    }

    @Override
    public Integer batchAdd(List<NotifyTemplateDTO> dtoList) {
        List<NotifyTemplate> entityList = BeanMapperUtil.mapList(dtoList, NotifyTemplateDTO.class, NotifyTemplate.class);

        return jobNotifyTemplateDAO.batchAdd(entityList);
    }

    @Override
    public NotifyTemplateDTO getById(Long id) {
        return BeanMapperUtil.map(jobNotifyTemplateDAO.getById(id), NotifyTemplateDTO.class);
    }

    @Override
    public NotifyTemplateDTO getByIdFromCache(Long id) {
        return redisOperation.string()
                .key(CacheKey.getJobNotifyTemplateByIdKey(id))
                .orElseGet(() -> getById(id));
    }

    @Override
    public Integer updateById(NotifyTemplateDTO dto) {
        NotifyTemplate entity = BeanMapperUtil.map(dto, NotifyTemplate.class);

        redisOperation.delete(CacheKey.getJobNotifyTemplateByIdKey(dto.getId()));

        return jobNotifyTemplateDAO.updateById(entity);
    }
}

