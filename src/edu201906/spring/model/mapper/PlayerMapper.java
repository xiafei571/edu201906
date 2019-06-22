package edu201906.spring.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import edu201906.spring.domain.ClubInfo;
import edu201906.spring.domain.NationInfo;
import edu201906.spring.domain.PlayerInfo;

public interface PlayerMapper {
	static String COLUMN = "rowid, pid, pname, photo, cid, nid, overall";

	@Select("SELECT " + COLUMN + " FROM players WHERE pid = #{id}")
	@ResultMap("playerResultMap")
	PlayerInfo getPlayer(@Param("id") Integer id);
	
	@Select("SELECT cid,cname,logo FROM club WHERE cid = #{id}")
	@ResultMap("clubResultMap")
	ClubInfo getClub(@Param("id") Integer id);
	
	@Select("SELECT " + COLUMN + " FROM players ORDER BY rowId LIMIT #{cursor}, #{offset}")
	@ResultMap("playerResultMap")
	List<PlayerInfo> getPlayerPage(@Param("cursor") Integer cursor, @Param("offset") Integer offset);

	@Select("SELECT COUNT(*) FROM players")
	Integer getPlayerCount();

	@Select("SELECT cid, cname, logo FROM club")
	List<ClubInfo> getClubList();

	@Select("select nid, nation, flag FROM nation")
	List<NationInfo> getNationList();
}
