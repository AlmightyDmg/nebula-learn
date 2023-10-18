package com.dmg.nebulalearn.model.edge;

import com.dmg.nebulalearn.model.vertex.Country;
import com.dmg.nebulalearn.model.vertex.Organization;
import io.github.anyzm.graph.ocean.annotation.GraphEdge;
import io.github.anyzm.graph.ocean.annotation.GraphProperty;
import io.github.anyzm.graph.ocean.enums.GraphDataTypeEnum;
import io.github.anyzm.graph.ocean.enums.GraphPropertyTypeEnum;
import lombok.Data;

@Data
@GraphEdge(value = "organiza", srcVertex = Country.class, dstVertex = Organization.class)
public class Organiza {
    @GraphProperty(value = "country_code", required = true, propertyTypeEnum = GraphPropertyTypeEnum.GRAPH_EDGE_SRC_ID, dataType = GraphDataTypeEnum.STRING)
    private String countryCode;
    @GraphProperty(value = "org_code", required = true, propertyTypeEnum = GraphPropertyTypeEnum.GRAPH_EDGE_DST_ID, dataType = GraphDataTypeEnum.STRING)
    private String orgCode;
}
