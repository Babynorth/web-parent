package com.babynorth.web.common;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengbei
 * @date 2018/2/7.
 */
public class FreeMarkerUtil {

    /**
     * 生成HTML静态页面的公公方法
     * @param fmc
     * @param templateName
     * @param request
     * @param map
     * @param filePath
     * @param fileName
     */
    public static void createHtml(FreeMarkerConfig fmc, String templateName,
                                  HttpServletRequest request, Map<?, ?> map, String filePath,
                                  String fileName) {
        Writer out = null;
        try {
            Template template = fmc.getConfiguration()
                    .getTemplate(templateName);
            String htmlPath = request.getSession().getServletContext()
                    .getRealPath(filePath)
                    + "/" + fileName;
            File htmlFile = new File(htmlPath);
            if (!htmlFile.getParentFile().exists()) {
                htmlFile.getParentFile().mkdirs();
            }
            if (!htmlFile.exists()) {
                htmlFile.createNewFile();
            }
            out = new OutputStreamWriter(new FileOutputStream(htmlPath),"UTF-8");
            template.process(map, out);
            out.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                out = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param request
     * @param filePath  文件存放的路径
     * @param fileName  文件的名称，需要扩展名
     * @return
     */
    public static Map<String,Object> htmlFileHasExist(HttpServletRequest request,String filePath,
                                                      String fileName) {
        Map<String,Object> map = new HashMap<String,Object>();
        String htmlPath = request.getSession().getServletContext()
                .getRealPath(filePath)
                + "/" + fileName;
        File htmlFile = new File(htmlPath);
        if(htmlFile.exists()){
            map.put("exist", true);
        }else{
            map.put("exist",false);
        }
        return map ;
    }
}
