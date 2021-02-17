package com.clinic.provider.template;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>
 * 代码生成器演示
 * </p>
 */
public class CodeGenerator {

  public static void main(String[] args) {
    generator();
  }

  /**
   * SQLServer 生成演示
   */
  public static void generator() {
	  AutoGenerator mpg = new AutoGenerator();
	    // 全局配置
	    GlobalConfig gc = new GlobalConfig();
	    gc.setOutputDir(
	        "D:\\LB20019\\内容管理\\trunk\\ly_nrfb\\longyou-dev-api\\src\\main\\java");
	    gc.setFileOverride(true);
	    gc.setActiveRecord(true);
	    gc.setEnableCache(false);// XML 二级缓存
	    gc.setBaseResultMap(true);// XML ResultMap
	    gc.setBaseColumnList(false);// XML columList
	    gc.setAuthor("majunjie");
	    // 自定义文件命名，注意 %s 会自动填充表实体属性！
	    gc.setMapperName("%sMapper");
	    gc.setXmlName("%sMapper");
	    gc.setEntityName("%sEntity");
	    mpg.setGlobalConfig(gc);
	    // 数据源配置
	    DataSourceConfig dsc = new DataSourceConfig();
	    dsc.setDbType(DbType.ORACLE);
	    dsc.setTypeConvert(new OracleTypeConvert());
	    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
	    dsc.setUsername("hd");
	    dsc.setPassword("F098058455ec50b3a");
	    dsc.setUrl("jdbc:mysql://rm-bp11dcihvkde73pm6ao.mysql.rds.aliyuncs.com/hd_lytapp?characterEncoding=utf-8&allowMultiQueries=true&serverTimezone=GMT%2B8");
//	    dsc.setSchemaName("MRHP");
	    mpg.setDataSource(dsc);

	 // 配置模板
//        TemplateConfig tc = new TemplateConfig();
//        // templates/entity.java 模板路径配置，默认在templates目录下，.vm 后缀不用加
//        tc.setEntity("templates/entity.java");//使用自定义模板生成实体类
//        tc.setXml("");
//        mpg.setTemplate(tc);
	    
	    // 包配置
	    PackageConfig pc = new PackageConfig();
	    pc.setParent("com.clinic");
	    // pc.setModuleName("test");
	    pc.setMapper("mapper");
	    pc.setController("controller");
	    pc.setEntity("domain.Entity");
	    pc.setService("service");
	    pc.setServiceImpl("service.impl");
	    mpg.setPackageInfo(pc);
	    StrategyConfig strategy = new StrategyConfig();
	    strategy.setInclude("new_template");
	    strategy.setCapitalMode(false);// 全局大写命名 ORACLE 注意
	    strategy.setTablePrefix("");// 此处可以修改为您的表前缀
	    strategy.setNaming(NamingStrategy.underline_to_camel);
	    strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
	    strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
	    mpg.setStrategy(strategy);
//			// 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
//			// 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
//			 TemplateConfig tc = new TemplateConfig();
//			 tc.setController("/template/tpl_controller.java.vm");
//			 tc.setEntity("/template/tpl_entity.java.vm");
//			 tc.setMapper("/template/tpl_mapper.java.vm");
//			 tc.setXml("/template/tpl_,apper.xml.vm");
//			 tc.setService("/template/tpl_service.java.vm");
//			 tc.setServiceImpl("/template/tpl_serviceImpl.java.vm");
//			 mpg.setTemplate(tc);
	    // 执行生成
	    mpg.execute();
  }

}
