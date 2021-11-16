package com.axue.code.generate;

import com.axue.core.base.BaseEntity;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 生成代码
 *
 * @author axue
 */
public class MyBatisPlusGenerate {

    /**
     * 数据库URL
     */
    private final static String URL = "jdbc:mysql://172.16.150.135:3306/saas_solution_stock?useUnicode=true" +
            "&characterEncoding=UTF-8&serverTimezone=GMT%2B8&nullCatalogMeansCurrent=true";

    /**
     * 项目路径
     */
    private final static String PROJECT_PATH  = "/saas-solution/saas-solution-stock";

    /**
     * 包路径
     */
    private final static String PARENT = "com.axue.solution.stock";

    /**
     * mysql驱动
     */
    private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    /**
     * 账户
     */
    private final static String USER_NAME = "root";

    /**
     * 密码
     */
    private final static String PASSWORD = "root";

    /**
     * 作者，需要更改
     */
    public final static String AUTHOR = "axue";

    /**
     * 代码生成器 - 主方法
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        String projectPath = globalConfig(mpg);
        dataSourceConfig(mpg);
        getPackageConfig(mpg);
        InjectionConfig cfg = getInjectionConfig();
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        focListAddOutputFile(projectPath, templatePath, focList);
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        templateConfig(mpg);
        strategyConfig(mpg);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * 自定义配置会被优先输出
     *
     * @param projectPath  projectPath
     * @param templatePath templatePath
     * @param focList      focList
     */
    private static void focListAddOutputFile(String projectPath, String templatePath, List<FileOutConfig> focList) {
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + PROJECT_PATH + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
    }

    /**
     * 自定义配置
     */
    private static InjectionConfig getInjectionConfig() {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
    }

    /**
     * 配置模板
     *
     * @param mpg mpg
     */
    private static void templateConfig(AutoGenerator mpg) {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
    }

    /**
     * 策略配置
     *
     * @param mpg mpg
     */
    private static void strategyConfig(AutoGenerator mpg) {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 是否开启lombok注解
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类控制器,没有就不用设置!
        // strategy.setSuperControllerClass("BaseController");
        // 写于父类中的公共字段
        strategy.setSuperEntityClass(BaseEntity.class);
        strategy.setSuperEntityColumns("id", "version", "create_time",
                "create_by", "update_time", "update_by", "logic_del");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        // 是否生成表字段映射的常量,在entity里面生成数据库映射字段常量
//        strategy.setEntityColumnConstant(true);
        // 数据库表前缀
        strategy.setTablePrefix("t_");
        mpg.setStrategy(strategy);
    }

    /**
     * 包配置
     *
     * @param mpg mpg
     */
    private static void getPackageConfig(AutoGenerator mpg) {
        PackageConfig pc = new PackageConfig();
        pc.setParent(PARENT);
        pc.setController("controller");
        pc.setMapper("mapper");
        pc.setEntity("entity.po");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);
    }

    /**
     * 数据源配置
     *
     * @param mpg mpg
     */
    private static void dataSourceConfig(AutoGenerator mpg) {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUsername(USER_NAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);
    }

    /**
     * 全局配置
     *
     * @param mpg mpg
     * @return String
     */
    private static String globalConfig(AutoGenerator mpg) {
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //生成文件的输出目录
        gc.setOutputDir(projectPath + PROJECT_PATH + "/src/main/java");
        //作者名称
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        //实体属性 Swagger2 注解
        gc.setSwagger2(true);
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);
        return projectPath;
    }

    /**
     * 读取控制台内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            return scanner.next();
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

}
