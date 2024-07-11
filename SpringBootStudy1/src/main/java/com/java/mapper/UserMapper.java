package com.java.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.java.dto.UserDTO;

@Mapper
public interface UserMapper {

	
	@Select({"<script>"
			+ "SELECT id, empno, user_nm, dept_nm, position, email, CASE WHEN status = 1 THEN '재직' "
			+ "WHEN Status = 2 THEN '퇴사' end as status, other FROM user "
			+ "<if test=\"status == 1\">WHERE status = 1 </if> "
			+ "<if test=\"status == 2\">WHERE status = 2 </if> "
			+ "ORDER BY id DESC "
			+ "</script>"})
	public List<UserDTO> findList(String status);
	
	@Select("SELECT id, empno, user_nm, dept_nm, position, email, CASE WHEN status = 1 THEN '재직'"
			+ "WHEN Status = 2 THEN '퇴사' end as status, other FROM user WHERE id = #{id}")
	public UserDTO findOne(UserDTO dto);
	
	@Update("UPDATE user SET empno = #{empno}, user_nm = #{user_nm}, dept_nm = #{dept_nm}, position = #{position}, email = #{email}, other = #{other} WHERE id = #{id}")
	public int edit(UserDTO dto);
	
	@Update({"<script>"
			+ "UPDATE user "
			+ "<set> "
			+ "<if test=\"status == '재직'\"> status = 1 </if> "
			+ "<if test=\"status == '퇴사'\"> status = 2 </if> "
			+ "</set> "
			+ "WHERE id = #{id}"
			+ "</script>"})
	public int status(UserDTO dto);
	
	@SelectKey(statementType = StatementType.PREPARED, statement = "SELECT LAST_INSERT_ID() AS id", keyProperty = "id", before=false, resultType= UserDTO.class)
	@Insert("INSERT INTO user (empno, user_nm, dept_nm, position, email, other) value (#{empno}, #{user_nm}, #{dept_nm}, #{position}, #{email}, #{other})")
	public int save(UserDTO dto);
	
	
}
