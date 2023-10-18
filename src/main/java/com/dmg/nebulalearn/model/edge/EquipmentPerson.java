package com.dmg.nebulalearn.model.edge;

import com.dmg.nebulalearn.model.vertex.Organization;
import com.dmg.nebulalearn.model.vertex.Person;
import io.github.anyzm.graph.ocean.annotation.GraphEdge;
import io.github.anyzm.graph.ocean.annotation.GraphProperty;
import io.github.anyzm.graph.ocean.enums.GraphDataTypeEnum;
import io.github.anyzm.graph.ocean.enums.GraphPropertyTypeEnum;
import lombok.Data;

@Data
@GraphEdge(value = "equipment_person", srcVertex = Organization.class, dstVertex = Person.class)
public class EquipmentPerson {
    @GraphProperty(value = "org_code", required = true, propertyTypeEnum = GraphPropertyTypeEnum.GRAPH_EDGE_SRC_ID, dataType = GraphDataTypeEnum.STRING)
    private String orgCode;
    @GraphProperty(value = "person_code", required = true, propertyTypeEnum = GraphPropertyTypeEnum.GRAPH_EDGE_DST_ID, dataType = GraphDataTypeEnum.STRING)
    private String weaponryCode;
}
