package com.geek.swagger_geek.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author geek
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerConfig.class);

    // G:/lyfGeek/maven_repository/io/springfox/springfox-swagger-ui/2.9.2/springfox-swagger-ui-2.9.2.jar!/META-INF/resources/swagger-ui.html

    /**
     * 合作开发。一个 Bean 代表不同程序员的开发。
     *
     * @return
     */
    @Bean
    public Docket docket1() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2).groupName("A");
        LOGGER.info(" ~ SwaggerConfig ~ docket1; ~ docket ~ {}",
                docket);
        return docket;
    }

    /**
     * 合作开发。一个 Bean 代表不同程序员的开发。
     *
     * @return
     */
    @Bean
    public Docket docket2() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2).groupName("B");
        LOGGER.info(" ~ SwaggerConfig ~ docket2; ~ docket ~ {}",
                docket);
        return docket;
    }

    @Bean
    public Docket docket3() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2).groupName("C");
        LOGGER.info(" ~ SwaggerConfig ~ docket3; ~ docket ~ {}",
                docket);
        return docket;
    }

    /**
     * 配置 Swagger 的 Bean 实例 Docket。
     *
     * @param environment
     * @return
     */
    @Bean
    public Docket docket(Environment environment) {

        // 动态配置当项目处于 test、dev 环境时显示 swagger，处于 prod 时不显示。

        // 获取项目环境。
        // 设置要显示的 swagger 环境。
        Profiles profiles = Profiles.of("dev", "test");
        // 通过 environment.acceptsProfiles(profiles); 判断是否处在自己设定的环境当中。
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println("flag = " + flag);
        // Unable to infer base url. This is common when using dynamic servlet registration or when the API is behind an API Gateway. The base url is the root of where all the swagger resources are served. For e.g. if the api is available at http://example.org/api/v2/api-docs then the base url is http://example.org/api/. Please enter the location manually:

        // 注意端口。
//        spring.profiles.active=pro

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())

                // 是否启动 Swagger。默认 true。
                .enable(true)
                // 😱 Could not render e, see the console.

                // Select a spec
                .groupName("geek")

                // select - build。
                .select()
                // RequestHandlerSelectors。配置要扫描接口的方式。
                // basePackage。指定要扫描的包。
                .apis(RequestHandlerSelectors.basePackage("com.geek.swagger_geek.controller"))
                // 过滤 ... 请求路径。指定的会显示。
                .paths(PathSelectors.ant("/kuang/**"))
//                .apis(RequestHandlerSelectors.any())
//                .apis(RequestHandlerSelectors.none())
                // 扫描类上的注解。
//                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                // 扫描方法上的注解。
//                .apis(RequestHandlerSelectors.withClassAnnotation(GetMapping.class))
                // build 工厂。
                .build();

        //Basic Error Controller
        //Hello Controller
        // 就不在了。
    }

    /**
     * 配置 Swagger 信息 ——> apiInfo。
     *
     * @return
     */
    private ApiInfo apiInfo() {

        // 作者信息。
        Contact contact = new Contact("Geek", "https://me.csdn.net/lyfGeek", "YifanLiGeek@gmail.com");

        // 覆盖默认。
        return new ApiInfo("geek 的 Swagger API 文档。",
                "即使再小的帆也能远航",
                "1.0",
                "https://me.csdn.net/lyfGeek",
//                DEFAULT_CONTACT,
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
//        return new ApiInfo("Api Documentation",
//                "Api Documentation",
//                "1.0",
//                "urn:tos",
//                DEFAULT_CONTACT,
//                "Apache 2.0",
//                "http://www.apache.org/licenses/LICENSE-2.0",
//                new ArrayList());
    }

}
