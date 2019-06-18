package com.kh.lgtw.community.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.lgtw.community.model.vo.Community;
import com.kh.lgtw.community.model.vo.CommunityAttachment;
import com.kh.lgtw.community.model.vo.CommunityComment;
import com.kh.lgtw.community.model.vo.CommunityPost;

public interface CommunityDao {

	Community SelectCommunity(SqlSessionTemplate sqlSession, Community cm);

	int UpdateCommunity(SqlSessionTemplate sqlSession, Community cm);

	int DelectCommunity(SqlSessionTemplate sqlSession, Community cm);

	int InsertCommunity(SqlSessionTemplate sqlSession, Community cm);

	CommunityPost SelectCommunityPost(SqlSessionTemplate sqlSession, CommunityPost cp);


	int InsertCommunityPostAtt(SqlSessionTemplate sqlSession, CommunityAttachment ca);

	int DelectCommunityPost(SqlSessionTemplate sqlSession, CommunityPost cp);

	int DelectCommunityPostAtt(SqlSessionTemplate sqlSession, CommunityAttachment ca);

	int UpdateCommunityPost(SqlSessionTemplate sqlSession, CommunityPost cp);

	int UpdateCommunityPostAtt(SqlSessionTemplate sqlSession, CommunityAttachment ca);

	int InsertCommunityPost(SqlSessionTemplate sqlSession, CommunityPost cp);

	CommunityComment SelectCommunityComment(SqlSessionTemplate sqlSession, CommunityComment cc);

	int insertCommunityComment(SqlSessionTemplate sqlSession, CommunityComment cc);

	int DeleteCommunityComment(SqlSessionTemplate sqlSession, CommunityComment cc);

	int UpdateCommunityComment(SqlSessionTemplate sqlSession, CommunityComment cc);

	

}
