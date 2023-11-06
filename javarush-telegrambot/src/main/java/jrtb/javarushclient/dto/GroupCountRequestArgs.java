package jrtb.javarushclient.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;
@Builder
@Getter
public class GroupCountRequestArgs {
    private final String query;
    private final GroupInfoType type;
    private  final Integer offSet;
    private final GroupFilter filter;
    private final Integer limit;

    public Map populateQueries(){
        Map queries = new HashMap<>();
        if(nonNull(query)){
            queries.put("query", query);
        }
        if(nonNull(type)){
            queries.put("type", type);
        }
        if(nonNull(offSet)){
            queries.put("offSet", offSet);
        }
        if(nonNull(filter)){
            queries.put("filter", filter);
        }
        if(nonNull(limit)){
            queries.put("limit", limit);
        }

        return queries;
    }
}
