package com.dmg.nebulalearn.model.edge;

import com.dmg.nebulalearn.model.vertex.Organization;
import io.github.anyzm.graph.ocean.annotation.GraphEdge;
import io.github.anyzm.graph.ocean.annotation.GraphProperty;
import io.github.anyzm.graph.ocean.enums.GraphDataTypeEnum;
import io.github.anyzm.graph.ocean.enums.GraphPropertyTypeEnum;
import lombok.Data;

@Data
@GraphEdge(value = "org_to_org", srcVertex = Organization.class, dstVertex = Organization.class)
public class OrgToOrg {
    @GraphProperty(value = "src_org_code", required = true, propertyTypeEnum = GraphPropertyTypeEnum.GRAPH_EDGE_SRC_ID, dataType = GraphDataTypeEnum.STRING)
    private String srcOrgCode;
    @GraphProperty(value = "dst_org_code", required = true, propertyTypeEnum = GraphPropertyTypeEnum.GRAPH_EDGE_DST_ID, dataType = GraphDataTypeEnum.STRING)
    private String dstOrgCode;
    @GraphProperty(value = "relation", dataType = GraphDataTypeEnum.STRING)
    private String relation;
}
