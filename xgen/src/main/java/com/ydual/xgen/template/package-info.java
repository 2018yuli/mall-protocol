/**
 * 模板管理
 * 享元，访问者
 * 
 * 负责获取相应模板数据
 * 详细功能
 * 		能够获取指定模板文件的内容
 * 		能够缓存模板文件内容
 * 		能够按语法规则和配置数据对模板文件进行处理，比如进行变量值的替换
 * 		向外提供处理好的模板内容
 * 功能边界
 * 		不关心模板内容
 * 		不关心需要替换的内容数据的来源
 * 		不关心具体要执行什么方法，以获得某部分需要的内容
 * 		不关心具体如何处理原始的模板内容，以及处理流程
 * 		不关心具体处理后得到的内容，谁来使用，如何使用，只是把这些功能提供出去而已
 * 对外接口
 * 内部实现
 * 		UML类图
 * 与其他模块的交互
 */
/**
 * @author l8989
 *
 */
package com.ydual.xgen.template;