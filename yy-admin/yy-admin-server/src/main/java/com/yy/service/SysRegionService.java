package com.yy.service;

import com.yy.commons.mybatis.service.BaseService;
import com.yy.dto.SysRegionDTO;
import com.yy.dto.region.RegionProvince;
import com.yy.entity.SysRegionEntity;

import java.util.List;
import java.util.Map;

/**
 * 行政区域
 *
 * @author shelei
 */
public interface SysRegionService extends BaseService<SysRegionEntity> {

	List<SysRegionDTO> list(Map<String, Object> params);

	List<Map<String, Object>> getTreeList();

	SysRegionDTO get(Long id);

	void save(SysRegionDTO dto);

	void update(SysRegionDTO dto);

	void delete(Long id);

	int getCountByPid(Long pid);

	List<RegionProvince> getRegion(boolean threeLevel);
}