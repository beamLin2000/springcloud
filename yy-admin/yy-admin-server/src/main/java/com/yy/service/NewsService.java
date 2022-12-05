package com.yy.service;

import com.yy.commons.mybatis.service.BaseService;
import com.yy.commons.tools.page.PageData;
import com.yy.dto.NewsDTO;
import com.yy.entity.NewsEntity;

import java.util.Map;

/**
 * 新闻
 *
 * @author shelei
 */
public interface NewsService extends BaseService<NewsEntity> {

    PageData<NewsDTO> page(Map<String, Object> params);

    NewsDTO get(Long id);

    void save(NewsDTO dto);

    void update(NewsDTO dto);
}

