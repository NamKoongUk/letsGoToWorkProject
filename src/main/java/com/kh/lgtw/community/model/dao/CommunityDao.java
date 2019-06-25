package com.kh.lgtw.community.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.lgtw.community.model.vo.Community;
import com.kh.lgtw.community.model.vo.CommunityAttachment;
import com.kh.lgtw.community.model.vo.CommunityComment;
import com.kh.lgtw.community.model.vo.CommunityPost;

public interface CommunityDao {

	ArrayList<Community> SelectCommunity(SqlSessionTemplate sqlSession);

	ArrayList<CommunityPost> CommunityPostList(int bno, SqlSessionTemplate sqlSession);

	
	

	

		

}
