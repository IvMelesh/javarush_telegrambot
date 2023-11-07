package jrtb.javarushclient.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.criteria.CriteriaBuilder;
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class GroupDiscussionInfo extends GroupInfo{
    private UserDiscussionInfo userDiscussionInfo;
    private Integer commentsCount;
}
