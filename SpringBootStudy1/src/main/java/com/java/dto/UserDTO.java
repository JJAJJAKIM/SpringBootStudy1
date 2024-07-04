package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private int id;
	private String empno;
	private String user_nm;
	private String dept_nm;
	private String position;
	private String email;
	private String status;
	private String other;
	
	
}
