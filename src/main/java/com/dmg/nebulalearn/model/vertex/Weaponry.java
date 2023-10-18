package com.dmg.nebulalearn.model.vertex;

import io.github.anyzm.graph.ocean.annotation.GraphProperty;
import io.github.anyzm.graph.ocean.annotation.GraphVertex;
import io.github.anyzm.graph.ocean.enums.GraphDataTypeEnum;
import io.github.anyzm.graph.ocean.enums.GraphKeyPolicy;
import io.github.anyzm.graph.ocean.enums.GraphPropertyTypeEnum;
import lombok.Data;

@Data
@GraphVertex(value = "weaponry", keyPolicy = GraphKeyPolicy.string_key)
public class Weaponry {
    @GraphProperty(value = "code", required = true, propertyTypeEnum = GraphPropertyTypeEnum.GRAPH_VERTEX_ID,dataType = GraphDataTypeEnum.STRING)
    private String code;
    @GraphProperty(value = "name", dataType = GraphDataTypeEnum.STRING)
    private String name;
    @GraphProperty(value = "type", dataType = GraphDataTypeEnum.STRING)
    private String type;
}
