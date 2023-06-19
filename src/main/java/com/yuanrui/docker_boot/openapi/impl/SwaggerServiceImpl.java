package com.yuanrui.docker_boot.openapi.impl;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import javafx.scene.chart.ScatterChart;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/6/14-20:01
 */
@Slf4j
public class SwaggerServiceImpl {


    public static void main(String[] args) throws Exception {
/*
        SwaggerParseResult swaggerParseResult = new OpenAPIParserrser().readLocation("", null, null);
*/
        String content = FileUtils.readFileToString(
                new File("src/main/resources/swagger测试1-8.json"), StandardCharsets.UTF_8);

        SwaggerParseResult swaggerParseResult = new OpenAPIParser().readContents(content, null, null);
        OpenAPI openAPI = swaggerParseResult.getOpenAPI();

        try(FileOutputStream     fileOutputStream = new FileOutputStream(new File("openAPI_output.txt"));
            ByteArrayInputStream inputStream = new ByteArrayInputStream(openAPI.toString().getBytes(StandardCharsets.UTF_8));
        ){
            IOUtils.copy(new ByteArrayInputStream(openAPI.toString().getBytes(StandardCharsets.UTF_8)), fileOutputStream);
        }catch (Exception e){
            e.printStackTrace();
            log.error("粗大事啦！");
        }
    }
}
