package com.wego.web.aop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wego.web.usr.User;

@Repository
public interface TxMapper {
	@Insert(" INSERT INTO USER (UID, PWD, UNAME, BIRTH, GENDER, TEL, PETTYPE) values (\n" + 
			"    #{uid}, #{pwd},#{uname}, #{birth}, #{gender}, #{tel}, #{pettype})")
	public void insertUser(User u);
}