package jrtb.javarushclient.dto;

import lombok.Data;

@Data
public class UserDiscussionInfo {
    private Boolean isBookmarked;
    private Integer lastTime;
    private Integer newCommentCount;
}
