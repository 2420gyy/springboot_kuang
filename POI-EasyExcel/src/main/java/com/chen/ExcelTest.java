package com.chen;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.util.*;

/**
 * @author chenchen
 * @date 2021-12-03 17:38
 */
public class ExcelTest {
    public static void main(String[] args) {
        List<ExcelData> excelData = parseData();
        // 将list写入excel
        String filepath = System.getProperty("user.dir")+"/POI-EasyExcel/demo_copy.xlsx";
        EasyExcel.write(filepath)
                .excelType(ExcelTypeEnum.XLSX)
                .head(ExcelData.class)
                .sheet("用户登录表")
                .doWrite(excelData);
    }
    public static List<ExcelData> parseData(){
        List<ExcelData> list = new LinkedList<>();
        String filepath = System.getProperty("user.dir")+"/POI-EasyExcel/demo.xlsx";
        EasyExcel.read(filepath)
                .head(ExcelData.class)
                .sheet()
                .registerReadListener(new AnalysisEventListener<ExcelData>() {
                    @Override
                    public void invoke(ExcelData excelData, AnalysisContext analysisContext) {
                        list.add(excelData);
                    }

                    @Override
                    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                        System.out.println("数据读取完毕");
                    }
                }).doRead();
        // for (ExcelData excelData : list) {
        //     System.out.println(excelData);
        // }
        // for (Map<Integer, String> integerStringMap : list) {
        //     Set<Integer> keySet = integerStringMap.keySet();
        //     Iterator<Integer> iterator = keySet.iterator();
        //     while (iterator.hasNext()) {
        //         Integer integer = iterator.next();
        //         System.out.print(integer+"::"+integerStringMap.get(integer)+" ");
        //     }
        //     System.out.println();
        // }
            return list;
    }
}
