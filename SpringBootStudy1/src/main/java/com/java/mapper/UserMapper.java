package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.java.dto.UserDTO;

@Mapper
public interface UserMapper {

	
	@Select("SELECT * FROM user")
	public List<UserDTO> findList();
	
	@Select("SELECT * FROM user WHERE id = #{id}")
	public UserDTO findOne(UserDTO dto);
	
	@Update("UPDATE user SET empno = #{empno}, user_nm = #{user_nm}, dept_nm = #{dept_nm}, postion = #{postion}, email = #{email}, other = #{other} WHERE id = #{id}")
	public int edit(UserDTO dto);
	
	@Update("UPDATE user SET status = #{status} WHERE id = #{id}")
	public int accept(UserDTO dto);
	
	@SelectKey(statementType = StatementType.PREPARED, statement = "SELECT LAST_INSERT_ID() AS id", keyProperty = "id", before=false, resultType= UserDTO.class)
	@Insert("INSERT INTO user (empno, user_nm, dept_nm, position, email, other) value (#{empno}, #{user_nm}, #{dept_nm}, #{position}, #{email}, #{other})")
	public int save(UserDTO dto);
	
}
