package com.kh.lgtw.community.model.service;

import com.kh.lgtw.community.model.vo.Community;
import com.kh.lgtw.community.model.vo.CommunityAttachment;
import com.kh.lgtw.community.model.vo.CommunityComment;
import com.kh.lgtw.community.model.vo.CommunityPost;

public interface CommunityService   
{

	Community SelectCommunity(Community cm);

	int UpdateCommunity(Community cm);

	int DelectCommunity(Community cm);

	int InsertCommunity(Community cm);

	

	CommunityPost SelectCommunityPost(CommunityPost cp);

	int InsertCommunityPost(CommunityPost cp, CommunityAttachment ca);

	int DelectCommunityPost(CommunityPost cp, CommunityAttachment ca);

	int UpdateCommunityPost(CommunityPost cp, CommunityAttachment ca);

	
	CommunityComment SelectCommunityComment(CommunityComment cc);

	int insertCommunityComment(CommunityComment cc);

	int DeleteCommunityComment(CommunityComment cc);

	int UpdateCommunityComment(CommunityComment cc);

	

	

}
