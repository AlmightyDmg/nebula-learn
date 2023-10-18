package com.dmg.nebulalearn.service;

import java.util.Arrays;
import java.util.Collections;

import com.dmg.nebulalearn.model.edge.OrgToOrg;
import com.dmg.nebulalearn.model.vertex.Country;
import com.dmg.nebulalearn.model.vertex.Organization;
import com.google.common.collect.Lists;
import com.vesoft.nebula.client.graph.exception.AuthFailedException;
import com.vesoft.nebula.client.graph.exception.ClientServerIncompatibleException;
import com.vesoft.nebula.client.graph.exception.IOErrorException;
import com.vesoft.nebula.client.graph.exception.NotValidConnectionException;
import io.github.anyzm.graph.ocean.domain.GraphQuery;
import io.github.anyzm.graph.ocean.domain.VertexQuery;
import io.github.anyzm.graph.ocean.domain.impl.QueryResult;
import io.github.anyzm.graph.ocean.engine.NebulaQueryUtils;
import io.github.anyzm.graph.ocean.engine.NebulaVertexQuery;
import io.github.anyzm.graph.ocean.mapper.NebulaGraphMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyTestServiceImpl {

    @Autowired
    private NebulaGraphMapper nebulaGraphMapper;

    public void insertVertexAndEdge() {



//        Organiza organiza = new Organiza();
//        organiza.setCountryCode("US");
//        organiza.setOrgCode("ZCY");

        OrgToOrg orgToOrg = new OrgToOrg();
        orgToOrg.setSrcOrgCode("BBY");
        orgToOrg.setDstOrgCode("BBL");
        orgToOrg.setRelation("管理");

        try {
            nebulaGraphMapper.saveEdgeEntitiesWithVertex(Arrays.asList(orgToOrg),srcId -> {
                Organization organization = new Organization();
                organization.setCode(srcId);
                organization.setName("步兵营");
                return organization;
            }, dstId -> {
                Organization organization = new Organization();
                organization.setCode(dstId);
                organization.setName("步兵连");
                return organization;
            });
        } catch (ClientServerIncompatibleException e) {
            throw new RuntimeException(e);
        } catch (AuthFailedException e) {
            throw new RuntimeException(e);
        } catch (NotValidConnectionException e) {
            throw new RuntimeException(e);
        } catch (IOErrorException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 新增国家
     * @author zhum
     * @date 2023/10/18 15:40
     * @param country
     * @return boolean
     */
    public boolean insertCountryVertex(Country country) {
        try {
            nebulaGraphMapper.saveVertexEntities(Collections.singletonList(country));
        } catch (ClientServerIncompatibleException e) {
            throw new RuntimeException(e);
        } catch (AuthFailedException e) {
            throw new RuntimeException(e);
        } catch (NotValidConnectionException e) {
            throw new RuntimeException(e);
        } catch (IOErrorException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    /**
     * 获取所有的国家
     * @author zhum
     * @date 2023/10/18 15:59
     * @param
     * @return java.lang.String
     */
    public QueryResult getAllCountry() {
        QueryResult records;
        try {
            VertexQuery vertexQuery = NebulaVertexQuery.build()
                    .fetchPropOn(Country.class,"CN")
                    .yield(Country.class,"code","name");
            records = nebulaGraphMapper.executeQuery(vertexQuery);

            //records = nebulaGraphMapper.executeQuerySql("match (v:country) return v");
        } catch (ClientServerIncompatibleException e) {
            throw new RuntimeException(e);
        } catch (AuthFailedException e) {
            throw new RuntimeException(e);
        } catch (NotValidConnectionException e) {
            throw new RuntimeException(e);
        } catch (IOErrorException e) {
            throw new RuntimeException(e);
        }

        return records;
    }
}
