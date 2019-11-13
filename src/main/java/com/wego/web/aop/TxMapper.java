package com.wego.web.aop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TxMapper {
	/*
	insert into community ( rating,img,uid, comments, msg, boardType, title, content) values(
	        #{rating},#{img},#{uid},#{comments},#{msg},#{boardType},#{title},#{content}
	    )*/
}