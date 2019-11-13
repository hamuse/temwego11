package com.wego.web.contents;
import java.util.HashMap;
import org.springframework.stereotype.Repository;
@Repository
public interface CommunityMapper {
    public void createCommunity(HashMap<String, String> paramMap);
    public void dropCommunity(HashMap<String, String> paramMap);
    public void insertComm(Community community);
    public int countCommunity();
}