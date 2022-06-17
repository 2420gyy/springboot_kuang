package com.chen;

import com.chen.Test.entity.S_treenode;
import com.chen.Test.mapper.Zf_area_dividedMapper;
import com.chen.Test.service.IS_treenodeService;
import com.chen.Test.vo.ZfAreaDividedVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class SpringbootMybatisplusApplicationTests {

    @Resource
    private IS_treenodeService is_treenodeService;

    @Resource
    private Zf_area_dividedMapper zf_area_dividedMapper;

    @Test
    void contextLoads() {
        List<S_treenode> list = is_treenodeService.getAllTree();
        for (S_treenode s_treenode : list) {
            System.out.println(s_treenode);
        }

    }

    @Test
    public void test(){

        //得到所有的省
        List<ZfAreaDividedVO> provincialList =  zf_area_dividedMapper.selectAllProvincial();
        //得到所有的市
        List<ZfAreaDividedVO> cityList =  zf_area_dividedMapper.selectAllCity();
        //市的List转Map
        Map<String,List<ZfAreaDividedVO>> cityListMap = cityList.stream().collect(Collectors.groupingBy(ZfAreaDividedVO::getParentCode));
        //得到所有的区
        List<ZfAreaDividedVO> districtList =  zf_area_dividedMapper.selectAllDistrict();
        //区的List转Map
        Map<String,List<ZfAreaDividedVO>> districtListMap = districtList.stream().collect(Collectors.groupingBy(ZfAreaDividedVO::getParentCode));

        System.out.println(cityListMap);
        System.out.println("======================================================");

        //把市的list装入省中
        provincialList.stream().forEach(provincial->{ //循环遍历省的list
            //得到省的code
            String adminDivisionCode = provincial.getAdminDivisionCode();
            //获得市的list 然后把市的List装入省的VO中
            provincial.setZfAreaDividedVOList(cityListMap.get(adminDivisionCode));
        });
        //将区的list装入市中
        provincialList.stream().forEach(provincial->{
            //通过省的的VO 获得市的List
            List<ZfAreaDividedVO> zfAreaDividedVOList = provincial.getZfAreaDividedVOList();
            //循环市的List
            zfAreaDividedVOList.stream().forEach(zfAreaDividedVO -> {
                //获得区的list 然后把区的list装入市的VO中
                zfAreaDividedVO.setZfAreaDividedVOList(districtListMap.get(zfAreaDividedVO.getAdminDivisionCode()));
            });
        });
        System.out.println(provincialList);
    }

}
