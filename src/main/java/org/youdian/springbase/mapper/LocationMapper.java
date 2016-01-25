package org.youdian.springbase.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.youdian.springbase.model.GeoLocation;
/**
 * 用户位置相关的数据库操作
 * @author zhouzhou
 *
 */
@Repository
public interface LocationMapper {

	public void insertLocation(GeoLocation location);
	public List<GeoLocation> findNearbyLocations(@Param("latitude") double latitude, 
			@Param("longtitude") double longtitude, @Param("distance") double distance);
}
