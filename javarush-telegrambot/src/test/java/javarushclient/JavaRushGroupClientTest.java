package javarushclient;

import jrtb.javarushclient.JavaRushGroupClient;
import jrtb.javarushclient.JavaRushGroupClientImp;
import jrtb.javarushclient.dto.GroupDiscussionInfo;
import jrtb.javarushclient.dto.GroupInfo;
import jrtb.javarushclient.dto.GroupCountRequestArgs;
import jrtb.javarushclient.dto.GroupRequestArgs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static jrtb.javarushclient.dto.GroupInfoType.TECH;

public class JavaRushGroupClientTest {
    private final JavaRushGroupClient groupClient = new JavaRushGroupClientImp("https://javarush.com/api/1.0/rest");

    @Test
    public void shouldProperlyGetGroupsWithEmptyArgs(){
        GroupRequestArgs args = GroupRequestArgs.builder().build();
        List<GroupInfo> groups=groupClient.getGroupList(args);
        Assertions.assertNotNull(groups);
        Assertions.assertFalse(groups.isEmpty());
    }

    @Test
    public void shouldProperlyGetGroupsWithOffsetAndLimit() {
        GroupRequestArgs args = GroupRequestArgs.builder()
                .offSet(1)
                .limit(3)
                .build();
        List<GroupInfo> groups = groupClient.getGroupList(args);
        Assertions.assertNotNull(groups);
        Assertions.assertEquals(3, groups.size());
    }

    @Test
    public void shouldProperlyGetGroupsDiscWithEmptyArgs(){
        GroupRequestArgs args = GroupRequestArgs.builder().build();
        List<GroupDiscussionInfo> groups = groupClient.getGroupDiscussionInfo(args);
        Assertions.assertNotNull(groups);
        Assertions.assertFalse(groups.isEmpty());

    }

    @Test
    public void shouldProperlyGetGroupsDiscWithOffsetAndLimit() {
        GroupRequestArgs args = GroupRequestArgs.builder()
                .offSet(1)
                .limit(3)
                .build();
        List<GroupDiscussionInfo> groups = groupClient.getGroupDiscussionInfo(args);
        Assertions.assertNotNull(groups);
        Assertions.assertEquals(3, groups.size());
    }

    @Test
    public  void shouldProperlyGetGroupsCount(){
        GroupCountRequestArgs args = GroupCountRequestArgs.builder().build();
        Integer groupCount = groupClient.getGroupCount(args);
        Assertions.assertEquals(26, groupCount);
    }

    @Test
    public  void shouldProperlyGetTECHGroupsCount() {
        GroupCountRequestArgs args = GroupCountRequestArgs.builder()
                .type(TECH)
                .build();
        Integer techGroupCount = groupClient.getGroupCount(args);
        Assertions.assertNotNull(techGroupCount);
        Assertions.assertEquals(7, techGroupCount);
    }

    @Test
    public void shouldProperlyGetGroupById() {
        Integer androidGroupId = 16;
        GroupDiscussionInfo groupById = groupClient.getGroupById(androidGroupId);

        Assertions.assertNotNull(groupById);
        Assertions.assertEquals("android", groupById.getKey());
        Assertions.assertEquals(16, groupById.getId());

    }




}
