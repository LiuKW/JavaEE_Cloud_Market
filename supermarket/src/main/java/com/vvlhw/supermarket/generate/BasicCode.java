package com.vvlhw.supermarket.generate;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * 【利用mybatisPlus的基础代码生成】
 * 【已经弄好了，不要运行了（注释了execute），不然又多文件】
 * 【乱改了密码】以免上传被人看到
 *
 * @author VVlhw
 * @date 2020/7/5 - 22:22
 */
public class BasicCode {
    public static void main(String[] args) {
        // 需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();
        // 配置策略
        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("梁汉伟");
        gc.setOpen(false);
        // 是否覆盖
        gc.setFileOverride(false);
        // 去Service的I前缀
        gc.setServiceName("%sService");
        gc.setIdType(IdType.AUTO);
        // ONLY_DATE：util包下Date，导入了mybatis-typehandlers-jsr310 会不会是java8的时间类【不行】
        // TIME_PACK：说是Java8，不知道会不会 【可以】
        gc.setDateType(DateType.TIME_PACK);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://www.vvlhw.com:3308/supermarket?useSSL=true&useUnicode=true&&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("xxx");
        dsc.setPassword("xxx");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //3、包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("supermarket");
        pc.setParent("com.vvlhw");
        pc.setEntity("entity");
        pc.setMapper("dao");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        //【改】设置要映射的表名
        strategy.setInclude("userOrder");
        // 下划线转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自动lombok
        strategy.setEntityLombokModel(true);
        //【改】
        strategy.setLogicDeleteFieldName("loginDelete");
        //【改】自动填充配置
        TableFill gmtCreate = new TableFill("order_time", FieldFill.INSERT);
//        TableFill gmtModified = new TableFill("updateTime", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
//        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);
        //【改】乐观锁
//        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        //localhost:8080/hello_id_2
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        //执行
//        mpg.execute();
    }
}
