package jrtb.javarushclient;

import jrtb.javarushclient.dto.GroupCountRequestArgs;
import jrtb.javarushclient.dto.GroupDiscussionInfo;
import jrtb.javarushclient.dto.GroupInfo;
import jrtb.javarushclient.dto.GroupRequestArgs;

import java.util.List;

public interface JavaRushGroupClient {
    List<GroupInfo> getGroupList(GroupRequestArgs groupRequestArgs);
    List<GroupDiscussionInfo> getGroupDiscussionInfo(GroupRequestArgs groupRequestArgs);
    Integer getGroupCount(GroupCountRequestArgs groupCountRequestArgs);
    GroupDiscussionInfo getGroupById(Integer id);
}
