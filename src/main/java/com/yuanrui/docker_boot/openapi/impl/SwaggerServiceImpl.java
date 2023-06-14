package com.yuanrui.docker_boot.openapi.impl;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/6/14-20:01
 */
public class SwaggerServiceImpl {


    public static void main(String[] args) throws IOException {
/*
        SwaggerParseResult swaggerParseResult = new OpenAPIParserrser().readLocation("", null, null);
*/
        String content = FileUtils.readFileToString(
                new File("src/main/resources/APIMarket.swagger.json"), StandardCharsets.UTF_8);

        SwaggerParseResult swaggerParseResult = new OpenAPIParser().readContents(content, null, null);

        OpenAPI openAPI = swaggerParseResult.getOpenAPI();

        System.out.println(content);
    }
}
