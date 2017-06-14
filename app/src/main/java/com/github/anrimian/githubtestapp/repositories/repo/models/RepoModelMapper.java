package com.github.anrimian.githubtestapp.repositories.repo.models;

import com.github.anrimian.githubtestapp.dataset.retrofit.responses.repo.RepoResponse;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

/**
 * Created on 14.6.17. It is awesome java class.
 */

@Mapper
public interface RepoModelMapper {

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "htmlUrl", source = "htmlUrl")
    })
    RepoInfoModel mapUserInfoResponse(RepoResponse repoResponse);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<RepoInfoModel> mapUserInfoResponseList(List<RepoResponse> repoResponseList);
}
