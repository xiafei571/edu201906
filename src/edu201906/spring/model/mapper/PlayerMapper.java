package edu201906.spring.model.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import edu201906.spring.domain.PlayerInfo;

public interface PlayerMapper {

	@Select("select pid, pname, photo, cid, nid, overall from players where pid = #{id}")
	@ResultMap("playerResultMap")
	PlayerInfo getPlayer(@Param("id") Integer id);

}
