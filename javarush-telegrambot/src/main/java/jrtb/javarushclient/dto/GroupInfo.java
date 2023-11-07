package jrtb.javarushclient.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GroupInfo {
    private String avatarUrl;
    private String createTime;
    private String description;
    private Integer id;
    private String key;
    private GroupLanguage language;
    private Integer levelToEditor;
    private MeGroupInfo meGroupInfo;
    private String pictureUrl;
    private String title;
    private GroupInfoType groupInfoType;
    private Integer usersCount;
    private GroupVisibilityStatus groupVisibilityStatus;

}