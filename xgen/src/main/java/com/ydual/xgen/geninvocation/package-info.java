/**
 * 具体调用模块
 * 状态，模板方法，工厂方法，装饰者，观察者
 * 
 * 按照一定规则与theme模板结合，得到需要的生成结果
 * 调用模块和输出模块的解耦
 * 
 * 具体调用模块只是负责具体的generate调用过程
 * 不关心generate数据从何而来
 * 不关心实际如何generate
 * 不关心按照什么流程顺序generate
 * 不关心每个步骤需要完成些什么功能
 */
/**
 * @author l8989
 *
 */
package com.ydual.xgen.geninvocation;