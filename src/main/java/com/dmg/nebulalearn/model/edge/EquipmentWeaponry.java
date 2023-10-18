package com.dmg.nebulalearn.model.edge;

import com.dmg.nebulalearn.model.vertex.Organization;
import com.dmg.nebulalearn.model.vertex.Weaponry;
import io.github.anyzm.graph.ocean.annotation.GraphEdge;
import io.github.anyzm.graph.ocean.annotation.GraphProperty;
import io.github.anyzm.graph.ocean.enums.GraphDataTypeEnum;
import io.github.anyzm.graph.ocean.enums.GraphPropertyTypeEnum;
import lombok.Data;

@Data
@GraphEdge(value = "equipment_weaponry", srcVertex = Organization.class, dstVertex = Weaponry.class)
public class EquipmentWeaponry {
    @GraphProperty(value = "org_code", required = true, propertyTypeEnum = GraphPropertyTypeEnum.GRAPH_EDGE_SRC_ID, dataType = GraphDataTypeEnum.STRING)
    private String orgCode;
    @GraphProperty(value = "weaponry_code", required = true, propertyTypeEnum = GraphPropertyTypeEnum.GRAPH_EDGE_DST_ID, dataType = GraphDataTypeEnum.STRING)
    private String weaponryCode;
}
