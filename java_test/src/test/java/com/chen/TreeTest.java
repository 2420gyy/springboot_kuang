package com.chen;

import com.alibaba.fastjson.JSONObject;
import com.chen.pojo.STreeNodeVO;
import com.chen.pojo.TreeDto;
import com.chen.util.STreeToolUtils;
import com.chen.util.TreeToolUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenchen
 * @date 2021-11-20 15:33
 */
public class TreeTest {

    @Test
    public void test1(){

        TreeDto treeDto = new TreeDto("1", "总店", "null", "true",null);
        TreeDto treeDto1 = new TreeDto("2", "市分店", "1", "true",null);
        TreeDto treeDto2 = new TreeDto("3", "县分店", "2", "true",null);
        TreeDto treeDto3 = new TreeDto("710", "店长", "3", "true",null);
        TreeDto treeDto4= new TreeDto("713", "财务部", "3", "true",null);
        TreeDto treeDto5 = new TreeDto("20032", "后勤部", "3", "true",null);
        TreeDto treeDto6 = new TreeDto("1909", "小王", "710", "false",null);
        TreeDto treeDto7= new TreeDto("1974", "小张", "713", "false",null);
        TreeDto treeDto8 = new TreeDto("388187", "佳佳", "20032", "false",null);
        TreeDto treeDto9 = new TreeDto("1949", "阿达", "20032", "false",null);
        ArrayList<TreeDto> rootList = new ArrayList<>();//根节点
        ArrayList<TreeDto> bodyList = new ArrayList<>();//子节点
        rootList.add(treeDto);
        bodyList.add(treeDto1);
        bodyList.add(treeDto2);
        bodyList.add(treeDto3);
        bodyList.add(treeDto4);
        bodyList.add(treeDto5);
        bodyList.add(treeDto6);
        bodyList.add(treeDto7);
        bodyList.add(treeDto8);
        bodyList.add(treeDto9);
        TreeToolUtils utils =  new TreeToolUtils(rootList,bodyList);
        List<TreeDto> result =  utils.getTree();
        String jsonString = JSONObject.toJSONString(result.get(0));
        System.out.println(jsonString);
    }
    @Test
    public void test2(){
        // 如果parentId为-1 即为根节点
        STreeNodeVO sTreeNodeVO = new STreeNodeVO("F086409B-399D-4A36-B541-5597606F1FD9","北京市","-1",null);
        STreeNodeVO sTreeNodeVO1 = new STreeNodeVO("049c5953-2dff-425f-8fb2-5d20de157d34", "北京市人民政府", "F086409B-399D-4A36-B541-5597606F1FD9", null);
        STreeNodeVO sTreeNodeVO2 = new STreeNodeVO("503b0a3b-a10d-4b03-a671-e75590c0f029", "北京市文化市场行政执法总队", "049c5953-2dff-425f-8fb2-5d20de157d34", null);
        STreeNodeVO sTreeNodeVO3 = new STreeNodeVO("a51e648e-1778-42db-8d22-e91b5f55c500", "北京市公安局", "049c5953-2dff-425f-8fb2-5d20de157d34", null);
        ArrayList<STreeNodeVO> rootList = new ArrayList<>();//根节点
        ArrayList<STreeNodeVO> bodyList = new ArrayList<>();//子节点
        rootList.add(sTreeNodeVO);
        bodyList.add(sTreeNodeVO1);
        bodyList.add(sTreeNodeVO2);
        bodyList.add(sTreeNodeVO3);
        STreeToolUtils sTreeToolUtils = new STreeToolUtils(rootList, bodyList);
        List<STreeNodeVO> tree = sTreeToolUtils.getTree();
        String s = JSONObject.toJSONString(tree.get(0));
        System.out.println(s);

        // List<STreeNodeVO> sTreeNodeVOS = new ArrayList<>();
        // sTreeNodeVOS.add(sTreeNodeVO);
        // sTreeNodeVOS.add(sTreeNodeVO2);
        // sTreeNodeVOS.add(sTreeNodeVO3);

    }


    @Test
    public void test3(){
        String str = "{\"createTime\":\"2021-03-27T18:11:09\",\"deleteFlag\":0,\"description\":\"北京北大软件工程股份有限公司\",\"effectivetime\":\"2021-02-19T00:00:00\",\"failuretime\":\"2022-03-30T00:00:00\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"北京市\",\"nodeid\":\"F086409B-399D-4A36-B541-5597606F1FD9\",\"nodename\":\"北京市\",\"nodeshort\":\"北京市\",\"nodestart\":0,\"nodetype\":\"\",\"parentid\":\"-1\",\"porder\":\"0\",\"sTreeNodeVOList\":[{\"createTime\":\"2021-07-01T10:41:23\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"11000000\",\"nodeid\":\"049c5953-2dff-425f-8fb2-5d20de157d34\",\"nodename\":\"北京市人民政府\",\"nodeshort\":\"北京市人民政府\",\"nodestart\":0,\"nodetype\":\"02\",\"parentid\":\"F086409B-399D-4A36-B541-5597606F1FD9\",\"porder\":\"0-001\",\"sTreeNodeVOList\":[{\"createTime\":\"2021-07-01T10:52:20\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"1100000065\",\"nodeid\":\"07e03cf3-9f2c-4adc-b581-9e02aa45d13a\",\"nodename\":\"北京市场监管局\",\"nodeshort\":\"北京市场监管局\",\"nodestart\":0,\"nodetype\":\"02\",\"parentid\":\"049c5953-2dff-425f-8fb2-5d20de157d34\",\"porder\":\"0-001-004\",\"sTreeNodeVOList\":[{\"createTime\":\"2021-07-01T11:00:03\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"110000006501\",\"nodeid\":\"44e72b2b-bf05-4e0b-bcb1-9f3fb12c8d3d\",\"nodename\":\"东城区市场监管局\",\"nodeshort\":\"东城区市场监管局\",\"nodestart\":0,\"nodetype\":\"02\",\"parentid\":\"07e03cf3-9f2c-4adc-b581-9e02aa45d13a\",\"porder\":\"0-001-004-001\",\"sTreeNodeVOList\":[],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/07e03cf3-9f2c-4adc-b581-9e02aa45d13a/44e72b2b-bf05-4e0b-bcb1-9f3fb12c8d3d/\",\"updateTime\":\"2021-07-06T15:40:30\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"}],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/07e03cf3-9f2c-4adc-b581-9e02aa45d13a/\",\"updateTime\":\"2021-07-06T15:39:50\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"},{\"createTime\":\"2021-07-01T10:51:34\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"11010602060222\",\"nodeid\":\"503b0a3b-a10d-4b03-a671-e75590c0f029\",\"nodename\":\"北京市文化市场行政执法总队\",\"nodeshort\":\"北京市文化市场行政执法总队\",\"nodestart\":0,\"nodetype\":\"02\",\"parentid\":\"049c5953-2dff-425f-8fb2-5d20de157d34\",\"porder\":\"0-001-003\",\"sTreeNodeVOList\":[],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/503b0a3b-a10d-4b03-a671-e75590c0f029/\",\"updateTime\":\"2021-07-06T15:39:39\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"},{\"createTime\":\"2021-07-01T10:49:54\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"1100000202\",\"nodeid\":\"a51e648e-1778-42db-8d22-e91b5f55c500\",\"nodename\":\"北京市公安局\",\"nodeshort\":\"北京市公安局\",\"nodestart\":0,\"nodetype\":\"02\",\"parentid\":\"049c5953-2dff-425f-8fb2-5d20de157d34\",\"porder\":\"0-001-002\",\"sTreeNodeVOList\":[{\"createTime\":\"2021-07-01T10:58:06\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"110000020279823\",\"nodeid\":\"60d8464f-b309-4311-b2df-75f78b7343fd\",\"nodename\":\"出入境管理局\",\"nodeshort\":\"出入境管理局\",\"nodestart\":0,\"nodetype\":\"02\",\"parentid\":\"a51e648e-1778-42db-8d22-e91b5f55c500\",\"porder\":\"0-001-002-002\",\"sTreeNodeVOList\":[],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/a51e648e-1778-42db-8d22-e91b5f55c500/60d8464f-b309-4311-b2df-75f78b7343fd/\",\"updateTime\":\"2021-07-06T15:41:01\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"},{\"createTime\":\"2021-07-26T09:16:51\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"maxgroupnum\":63,\"nodecode\":\"85225050\",\"nodeid\":\"854e6e44-db43-4de0-b909-dc039f933e74\",\"nodename\":\"天安门地区分局\",\"nodeshort\":\"天安门地区分局\",\"nodestart\":0,\"nodetype\":\"01\",\"parentid\":\"a51e648e-1778-42db-8d22-e91b5f55c500\",\"porder\":\"0-001-002-003\",\"sTreeNodeVOList\":[],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/a51e648e-1778-42db-8d22-e91b5f55c500/854e6e44-db43-4de0-b909-dc039f933e74/\"},{\"createTime\":\"2021-07-01T10:57:31\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"110000020279091\",\"nodeid\":\"8bd7bd08-667f-4654-b363-effd3c5cc85f\",\"nodename\":\"北京市交通执法总队\",\"nodeshort\":\"北京市交通执法总队\",\"nodestart\":0,\"nodetype\":\"02\",\"parentid\":\"a51e648e-1778-42db-8d22-e91b5f55c500\",\"porder\":\"0-001-002-001\",\"sTreeNodeVOList\":[{\"createTime\":\"2021-07-01T10:59:04\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"1100000202790911\",\"nodeid\":\"3893409d-d886-48f9-ae79-28ad2c4a73f7\",\"nodename\":\"交警一支队\",\"nodeshort\":\"交警一支队\",\"nodestart\":0,\"nodetype\":\"04\",\"parentid\":\"8bd7bd08-667f-4654-b363-effd3c5cc85f\",\"porder\":\"0-001-002-001-001\",\"sTreeNodeVOList\":[],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/a51e648e-1778-42db-8d22-e91b5f55c500/8bd7bd08-667f-4654-b363-effd3c5cc85f/3893409d-d886-48f9-ae79-28ad2c4a73f7/\",\"updateTime\":\"2021-07-06T15:42:44\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"},{\"createTime\":\"2021-07-01T10:59:22\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"1100000202790912\",\"nodeid\":\"e9cd9b55-461b-4504-8009-51188d8768c8\",\"nodename\":\"交警二支队\",\"nodeshort\":\"交警二支队\",\"nodestart\":0,\"nodetype\":\"04\",\"parentid\":\"8bd7bd08-667f-4654-b363-effd3c5cc85f\",\"porder\":\"0-001-002-001-002\",\"sTreeNodeVOList\":[],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/a51e648e-1778-42db-8d22-e91b5f55c500/8bd7bd08-667f-4654-b363-effd3c5cc85f/e9cd9b55-461b-4504-8009-51188d8768c8/\",\"updateTime\":\"2021-07-06T15:42:52\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"}],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/a51e648e-1778-42db-8d22-e91b5f55c500/8bd7bd08-667f-4654-b363-effd3c5cc85f/\",\"updateTime\":\"2021-07-19T09:10:16\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"}],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/a51e648e-1778-42db-8d22-e91b5f55c500/\",\"updateTime\":\"2021-07-06T15:39:31\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"},{\"createTime\":\"2021-07-01T10:43:41\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"1101010020\",\"nodeid\":\"a84ee1b8-e63b-4840-b527-9fd0ed1bca3d\",\"nodename\":\"北京市东城区人民政府\",\"nodeshort\":\"北京市东城区人民政府\",\"nodestart\":0,\"nodetype\":\"01\",\"parentid\":\"049c5953-2dff-425f-8fb2-5d20de157d34\",\"porder\":\"0-001-001\",\"sTreeNodeVOList\":[{\"createTime\":\"2021-07-01T10:54:00\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"11010100202132421\",\"nodeid\":\"380bfb9a-b86d-433a-8119-1949c6c3faf5\",\"nodename\":\"北京市东城区文化市场行政执法总队\",\"nodeshort\":\"北京市东城区文化市场行政执法总队\",\"nodestart\":0,\"nodetype\":\"05\",\"parentid\":\"a84ee1b8-e63b-4840-b527-9fd0ed1bca3d\",\"porder\":\"0-001-001-001\",\"sTreeNodeVOList\":[{\"createTime\":\"2021-07-01T10:55:50\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"1101010020213549786\",\"nodeid\":\"5cb7ea98-462c-4831-b67c-a29a913c4f13\",\"nodename\":\"执法二队\",\"nodeshort\":\"执法二队\",\"nodestart\":0,\"nodetype\":\"04\",\"parentid\":\"380bfb9a-b86d-433a-8119-1949c6c3faf5\",\"porder\":\"0-001-001-001-002\",\"sTreeNodeVOList\":[],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/a84ee1b8-e63b-4840-b527-9fd0ed1bca3d/380bfb9a-b86d-433a-8119-1949c6c3faf5/5cb7ea98-462c-4831-b67c-a29a913c4f13/\",\"updateTime\":\"2021-07-06T15:42:24\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"},{\"createTime\":\"2021-07-01T10:54:39\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"11010100202135443\",\"nodeid\":\"ff2fb3c9-c4e5-4040-99e5-37b7aec5cb77\",\"nodename\":\"执法一队\",\"nodeshort\":\"执法一队\",\"nodestart\":0,\"nodetype\":\"04\",\"parentid\":\"380bfb9a-b86d-433a-8119-1949c6c3faf5\",\"porder\":\"0-001-001-001-001\",\"sTreeNodeVOList\":[],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/a84ee1b8-e63b-4840-b527-9fd0ed1bca3d/380bfb9a-b86d-433a-8119-1949c6c3faf5/ff2fb3c9-c4e5-4040-99e5-37b7aec5cb77/\",\"updateTime\":\"2021-07-06T15:42:00\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"}],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/a84ee1b8-e63b-4840-b527-9fd0ed1bca3d/380bfb9a-b86d-433a-8119-1949c6c3faf5/\",\"updateTime\":\"2021-08-04T15:58:16\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"}],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/a84ee1b8-e63b-4840-b527-9fd0ed1bca3d/\",\"updateTime\":\"2021-07-06T15:39:16\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"},{\"createTime\":\"2021-07-06T16:35:15\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"maxgroupnum\":63,\"nodecode\":\"69778680\",\"nodeid\":\"fdba7047-6e47-49ad-a5a1-97a145598847\",\"nodename\":\"北京市医疗保障局\",\"nodeshort\":\"北京市医疗保障局\",\"nodestart\":0,\"nodetype\":\"02\",\"parentid\":\"049c5953-2dff-425f-8fb2-5d20de157d34\",\"porder\":\"0-001-005\",\"sTreeNodeVOList\":[{\"createTime\":\"2021-07-06T16:36:58\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"7987898\",\"nodeid\":\"743590ba-99f6-4837-9e0d-6ac8cddff91d\",\"nodename\":\"北京市医疗保障执法大队\",\"nodeshort\":\"北京市医疗保障执法大队\",\"nodestart\":0,\"nodetype\":\"02\",\"parentid\":\"fdba7047-6e47-49ad-a5a1-97a145598847\",\"porder\":\"0-001-005-001\",\"sTreeNodeVOList\":[{\"createTime\":\"2021-07-06T16:53:10\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"7876579870\",\"nodeid\":\"16c6943c-4e1e-4505-ae9c-0fa4f0bdcc9f\",\"nodename\":\"第二执法分队\",\"nodeshort\":\"第二执法分队\",\"nodestart\":0,\"nodetype\":\"04\",\"parentid\":\"743590ba-99f6-4837-9e0d-6ac8cddff91d\",\"porder\":\"0-001-005-001-003\",\"sTreeNodeVOList\":[],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/fdba7047-6e47-49ad-a5a1-97a145598847/743590ba-99f6-4837-9e0d-6ac8cddff91d/16c6943c-4e1e-4505-ae9c-0fa4f0bdcc9f/\",\"updateTime\":\"2021-07-06T16:58:10\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"},{\"createTime\":\"2021-07-06T16:38:13\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"5789\",\"nodeid\":\"9889da95-09a4-45d2-97a0-b81f53d0e456\",\"nodename\":\"第一执法分队\",\"nodeshort\":\"第一执法分队\",\"nodestart\":0,\"nodetype\":\"04\",\"parentid\":\"743590ba-99f6-4837-9e0d-6ac8cddff91d\",\"porder\":\"0-001-005-001-002\",\"sTreeNodeVOList\":[],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/fdba7047-6e47-49ad-a5a1-97a145598847/743590ba-99f6-4837-9e0d-6ac8cddff91d/9889da95-09a4-45d2-97a0-b81f53d0e456/\",\"updateTime\":\"2021-07-06T16:52:52\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"},{\"createTime\":\"2021-07-06T16:58:32\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"maxgroupnum\":63,\"nodecode\":\"5879721321\",\"nodeid\":\"d0e1acba-ecfc-4594-86a0-33dc2114ab8d\",\"nodename\":\"第三执法分队\",\"nodeshort\":\"第三执法分队\",\"nodestart\":0,\"nodetype\":\"04\",\"parentid\":\"743590ba-99f6-4837-9e0d-6ac8cddff91d\",\"porder\":\"0-001-005-001-004\",\"sTreeNodeVOList\":[],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/fdba7047-6e47-49ad-a5a1-97a145598847/743590ba-99f6-4837-9e0d-6ac8cddff91d/d0e1acba-ecfc-4594-86a0-33dc2114ab8d/\"}],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/fdba7047-6e47-49ad-a5a1-97a145598847/743590ba-99f6-4837-9e0d-6ac8cddff91d/\",\"updateTime\":\"2021-07-06T16:52:04\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"},{\"createTime\":\"2021-07-27T14:45:05\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"weqwf213\",\"nodeid\":\"ac0e6794-5696-4c36-9b69-5103c701285e\",\"nodename\":\"北京市门头沟区医疗保障局\",\"nodeshort\":\"北京市门头沟区医疗保障局\",\"nodestart\":0,\"nodetype\":\"02\",\"parentid\":\"fdba7047-6e47-49ad-a5a1-97a145598847\",\"porder\":\"0-001-005-003\",\"sTreeNodeVOList\":[],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/fdba7047-6e47-49ad-a5a1-97a145598847/ac0e6794-5696-4c36-9b69-5103c701285e/\",\"updateTime\":\"2021-07-28T14:00:52\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"},{\"createTime\":\"2021-07-27T14:35:11\",\"createuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\",\"deleteFlag\":0,\"description\":\"\",\"isadminnode\":0,\"isrelevance\":1,\"isused\":0,\"levelvalue\":\"\",\"maxgroupnum\":63,\"nodecode\":\"124987jjn\",\"nodeid\":\"bc4caa57-ca28-4572-a17c-eef2b928ca5d\",\"nodename\":\"北京市平谷区医疗保障局\",\"nodeshort\":\"北京市平谷区医疗保障局\",\"nodestart\":0,\"nodetype\":\"02\",\"parentid\":\"fdba7047-6e47-49ad-a5a1-97a145598847\",\"porder\":\"0-001-005-002\",\"sTreeNodeVOList\":[],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/fdba7047-6e47-49ad-a5a1-97a145598847/bc4caa57-ca28-4572-a17c-eef2b928ca5d/\",\"updateTime\":\"2021-07-28T14:46:51\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"}],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/fdba7047-6e47-49ad-a5a1-97a145598847/\"}],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/049c5953-2dff-425f-8fb2-5d20de157d34/\",\"updateTime\":\"2021-07-29T11:33:20\",\"updateuser\":\"72e69b32-8ba2-11eb-acf3-00155dd9c415\"}],\"treepath\":\"-1/F086409B-399D-4A36-B541-5597606F1FD9/\",\"updateTime\":\"2021-08-17T08:43:19\"}";
        Object parse = JSONObject.parse(str);
        System.out.println(parse);
    }
    void printDigit(int n){
        System.out.println(n%10);
        if(n>10){
            printDigit(n/10);
        }
    }
    //
    void hanoi(int n,char from,char tmp,char to){
        if(n>0){
            hanoi(n-1, from, tmp, to);
            System.out.println("take " + n + " from " + from + " to " + to);
            hanoi(n-1, to, tmp, from);
        }
    }
    int fact(int n){
        if(n==0 || n==1){
            return 1;
        }else {
            int res = n*fact(n-1);
            return res;
        }
    }
    @Test
    public void test4(){
        char x = 'a',y = 'b',z = 'c';
        // printDigit(12345);
        // hanoi(3,x,y,z);
        int fact = fact(4);
        System.out.println(fact);
    }


}
