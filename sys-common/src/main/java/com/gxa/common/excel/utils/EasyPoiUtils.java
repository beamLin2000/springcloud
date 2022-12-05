package com.gxa.common.excel.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
* @Description:    导入导出工具类封装
* @Author:         张智云
* @CreateDate:     2021/10/19 16:30
*/
public class EasyPoiUtils {

    public static <T> List<T> importExcel(MultipartFile file, Class<T> clz) {
        if (file == null) {
            return null;
        } else {
            ImportParams params = new ImportParams();
            params.setTitleRows(0);
            params.setHeadRows(1);


            try {
                return ExcelImportUtil.importExcel(file.getInputStream(), clz, params);
            } catch (Exception var4) {
                throw new RuntimeException(var4);
            }
        }
    }

    public static <T> void exportExcel(List<T> dataList, String title, String sheetName, Class<?> clz, String fileName, HttpServletResponse response) {
        defaultExport(dataList, clz, fileName, response, new ExportParams(title, sheetName));
    }

    private static <T> void defaultExport(List<T> dataList, Class<?> clz, String fileName, HttpServletResponse response, ExportParams exportParams) {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, clz, dataList);
        if (workbook != null) {
            downLoadExcel(fileName, response, workbook);
        }
    }


    public static <T> void exportExcelByType(List<T> dataList, String title, String sheetName, Class<?> clz, String fileName, HttpServletResponse response, ExcelType excelType) {
        defaultExport(dataList, clz, fileName, response, new ExportParams(title, sheetName,excelType));
    }

    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException var4) {
            throw new RuntimeException(var4);
        }
    }
}
