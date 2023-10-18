package com.dmg.nebulalearn.model.vertex;

import javax.persistence.Id;

import io.github.anyzm.graph.ocean.annotation.GraphProperty;
import io.github.anyzm.graph.ocean.annotation.GraphVertex;
import io.github.anyzm.graph.ocean.enums.GraphDataTypeEnum;
import io.github.anyzm.graph.ocean.enums.GraphKeyPolicy;
import io.github.anyzm.graph.ocean.enums.GraphPropertyTypeEnum;
import lombok.Data;

@Data
@GraphVertex(value = "person", keyPolicy = GraphKeyPolicy.string_key)
public class Person {
    @GraphProperty(value = "code", required = true, propertyTypeEnum = GraphPropertyTypeEnum.GRAPH_VERTEX_ID,dataType = GraphDataTypeEnum.STRING)
    private String code;
    @GraphProperty(value = "name", dataType = GraphDataTypeEnum.STRING)
    private String name;
    @GraphProperty(value = "position", dataType = GraphDataTypeEnum.STRING)
    private Integer string;
}
