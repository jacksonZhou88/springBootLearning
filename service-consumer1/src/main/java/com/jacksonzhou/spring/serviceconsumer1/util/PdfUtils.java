package com.jacksonzhou.spring.serviceconsumer1.util;

import com.itextpdf.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PdfUtils {

    public static void FTL2PDF(String srcPath, String destPath , Map<String,Object> map) {

        try {
            // 将生成的内容写入html文件中
            Configuration conf = new Configuration(Configuration.VERSION_2_3_23);
            conf.setDirectoryForTemplateLoading(new File(srcPath));
            conf.setEncoding(Locale.getDefault(), "UTF-8");
            conf.setDateFormat("yyyy-MM-dd HH:mm:ss");
            Template template = conf.getTemplate("html.ftl");
            StringWriter stringWriter = new StringWriter();
            BufferedWriter writer = new BufferedWriter(stringWriter);
            template.process(map, writer);
            String htmlStr = stringWriter.toString();
            System.out.println("转换html成功！");

            // 将生成的内容写入html转换成pdf
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(htmlStr.getBytes("UTF-8")));
            ITextRenderer renderer = new ITextRenderer();
            // 解决中文支持问题
            ITextFontResolver fontResolver = renderer.getFontResolver();

            // 设置pdf中文字体为宋体
            if (isOsWindow()) {
                fontResolver.addFont("C:/Windows/Fonts/SimSun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            } else {
                fontResolver.addFont("/usr/share/fonts/ttc/SimSun.ttf",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            }
            renderer.setDocument(doc, null);
            renderer.layout();
            OutputStream out = new FileOutputStream(new File(destPath));
            renderer.createPDF(out);

            System.out.println("转换pdf成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static boolean isOsWindow() {
        String osName = System.getProperties().getProperty("os.name");
        if(osName.toLowerCase().indexOf("win")!=-1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String srcPath = "F:/project2018/";
        String destPath = "F:/project2018/456.pdf";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("number", "1565615178");
        map.put("years", "2017");
        map.put("month", "11");
        map.put("day", "05");
        FTL2PDF(srcPath, destPath, map);

    }

}
