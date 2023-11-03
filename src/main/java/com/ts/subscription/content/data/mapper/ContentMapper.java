package com.ts.subscription.content.data.mapper;

import com.ts.subscription.content.data.dto.ContentCreateRequest;
import com.ts.subscription.content.data.dto.ContentCreateResponse;
import com.ts.subscription.content.data.dto.ContentValue;
import com.ts.subscription.content.data.entity.Text;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ContentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "content", source = "request.content")
    @Mapping(target = "subscriptionId", source = "subscriptionId")
    @Mapping(target = "subscriptionTitle", source = "request.subscriptionTitle")
    @Mapping(target = "orderNumber", source = "request.orderNumber")
    Text toText(UUID subscriptionId, ContentCreateRequest request);

    ContentCreateResponse toContentCreateResponse(Text text);

    List<ContentValue> toContentWithOrderNumberList(List<Text> textList);

}
