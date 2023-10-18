package com.dmg.nebulalearn.service;

import java.util.Arrays;

import com.dmg.nebulalearn.model.edge.OrgToOrg;
import com.dmg.nebulalearn.model.edge.Organiza;
import com.dmg.nebulalearn.model.vertex.Country;
import com.dmg.nebulalearn.model.vertex.Organization;
import com.dmg.nebulalearn.model.vertex.Person;
import com.google.common.collect.Lists;
import com.vesoft.nebula.client.graph.NebulaPoolConfig;
import com.vesoft.nebula.client.graph.exception.AuthFailedException;
import com.vesoft.nebula.client.graph.exception.ClientServerIncompatibleException;
import com.vesoft.nebula.client.graph.exception.IOErrorException;
import com.vesoft.nebula.client.graph.exception.NotValidConnectionException;
import com.vesoft.nebula.client.graph.net.NebulaPool;
import io.github.anyzm.graph.ocean.mapper.NebulaGraphMapper;
import io.github.anyzm.graph.ocean.session.NebulaPoolSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl {

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

    public void demos() {
        // 实现 两个节点插入
//        Person tom = new Person();
//        tom.setName("Tom");
//
//        dao.insert(tom);
//
//        Person jerry = new Person();
//        jerry.setName( "Jerry" );
//        dao.insert(jerry);
//
//        // 建立两个节点的关系
//        Like like = new Like( 0.99999 );
//        dao.insertEdge( tom, like, jerry );
//
//        // 查找喜欢 jerry 的人
//        String jerryId = jerry.getName();
//        List<Person> whoLikeJerry = dao.listStartNodes( Like.class, jerryId );
//
//        // 查找唯一喜欢 jerry 的人。非唯一时报错。（限定在特定关系仅有一个上游的场景）
//        Person tom = dao.startNode( Like.class, jerryId );
//
//        // 查看 Tom 跟 Jerry 之间的 Like关系
//        String tomId = tom.getName();
//        Boolean tomLikeJerry = dao.existsEdge( tomId, Like.class, jerryId ); // true
//        Boolean jerryLikeTom = dao.existsEdge( jerryId, Like.class, tomId ); // false
//        // 可怜的 Tom
//
//        // 根据 Tom 的名字查找全部信息
//        Person tomDb = dao.selectById( "Tom" );
//
//        // 查找分页
//        Page<Person> page = new Page<>();
//        List<Person> personPage = dao.selectPage( page );
//        page.getTotal(); // 2 rows， Tom and Jerry
//        Boolean theyAreFamily = page.getRows() == personPage; // true
//
//        // 故事总想要有个好的结局
//        dao.insertEdge( jerry, like, tom );

        // 更多 基类的操作还在开发中。期待
    }


}
