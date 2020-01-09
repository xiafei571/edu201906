package edu201906.spring.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import edu201906.spring.domain.ChartInfo;
import edu201906.spring.domain.ClubInfo;
import edu201906.spring.domain.NationInfo;
import edu201906.spring.domain.PlayerInfo;

public interface PlayerMapper {
	static String COLUMN = "rowid, pid, pname, photo, cid, nid, overall, wage";

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
	@ResultMap("nationResultMap")
	List<NationInfo> getNationList();

	@Select("SELECT nid, nation, flag FROM nation where nid = #{nid}")
	@ResultMap("nationResultMap")
	NationInfo getNation(@Param("nid") Integer nid);

	@Select("SELECT " + COLUMN + " FROM players limit #{size}")
	List<PlayerInfo> getPlayerList(@Param("size") Integer pageSize);
	
	List<ChartInfo> getNationDist(@Param("cid")Integer cid);
	
	@Select("SELECT " + COLUMN + " FROM players WHERE cid = #{cid}")
	@ResultMap("playerResultMap")
	List<PlayerInfo> getPlayerListByCid(@Param("cid")Integer cid);
}
