package com.chen;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author chenchen
 * @date 2021-12-03 16:00
 */
public class test {
    public static void main(String[] args) {
        // 读取文件
        // 创建ExcelReaderBuilder
        ExcelReaderBuilder readerBuilder = EasyExcel.read();
        // 获取文件对象
        String filepath = System.getProperty("user.dir")+"/POI-EasyExcel/demo.xlsx";
        readerBuilder.file(filepath);
        // 指定sheet
        readerBuilder.sheet("用户登录表");
        // 自动关闭输入流
        readerBuilder.autoCloseStream(true);
        // 设置excel文件格式
        readerBuilder.excelType(ExcelTypeEnum.XLSX);
        // 注册监听器，进行数据的读取
        readerBuilder.registerReadListener(new AnalysisEventListener<Map<Integer,String>>() {

            @Override
            public void invoke(Map<Integer, String> integerStringMap, AnalysisContext analysisContext) {
                Set<Integer> integers = integerStringMap.keySet();
                Iterator<Integer> iterator = integers.iterator();
                while (iterator.hasNext()) {
                    Integer key = iterator.next();
                    System.out.print(key+"::"+integerStringMap.get(key)+" ");
                }
                System.out.println();
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                // 通知文件读取完毕
                System.out.println("数据读取完毕");
            }
        });
        // 构建读取器
        ExcelReader reader = readerBuilder.build();
        // 读取数据
        reader.readAll();
        // 读取完毕
        reader.finish();
    }
}
