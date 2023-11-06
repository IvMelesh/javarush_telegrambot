package jrtb.javarushclient;

import jrtb.javarushclient.dto.GroupRequestArgs;
import jrtb.javarushclient.dto.GroupDiscussionInfo;
import jrtb.javarushclient.dto.GroupInfo;
import jrtb.javarushclient.dto.GroupCountRequestArgs;
import kong.unirest.GenericType;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JavaRushGroupClientImp implements JavaRushGroupClient{
    private final String javarushApiGroupPath;

    public JavaRushGroupClientImp(
            @Value("${javarush.api.path}")String javarushPath ) {
        this.javarushApiGroupPath = javarushPath +"/groups";
    }

    @Override
    public List<GroupInfo> getGroupList(GroupRequestArgs groupRequestArgs) {
        return Unirest.get(javarushApiGroupPath)
                .queryString(groupRequestArgs.populateQueries())
                .asObject(new GenericType<List<GroupInfo>>() {
                })
                .getBody();
    }

    @Override
    public List<GroupDiscussionInfo> getGroupDiscussionInfo(GroupRequestArgs groupRequestArgs) {
        return Unirest.get(javarushApiGroupPath)
                .queryString(groupRequestArgs.populateQueries())
                .asObject(new GenericType<List<GroupDiscussionInfo>>() {
                })
                .getBody();
    }

    @Override
    public Integer getGroupCount(GroupCountRequestArgs groupCountRequestArgs) {
        return Integer.valueOf(
                Unirest.get(String.format("%s/count", javarushApiGroupPath))
                .queryString(groupCountRequestArgs.populateQueries())
                .asString()
                .getBody()
        );
    }

    @Override
    public GroupDiscussionInfo getGroupById(Integer id) {
        return Unirest.get(String.format("%s/group%s",javarushApiGroupPath,id.toString()))
                .asObject(GroupDiscussionInfo.class)
                .getBody();
    }
}
