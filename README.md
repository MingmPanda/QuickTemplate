### 集成Mybatis Plus步骤
1. 在pom.xml文件引入相关的jar包依赖
2. 实现XxxMapper接口。通过此接口来操作数据持久化
3. 对XxxDO实体进行注解的定义，如：数据库表名，字段的定义
4. 如需修改Plus默认配置，需实现MybatisPlusConfig类
5. 如需要自定义一个方法，需实现XxxMapper.xml，来定义自定义SQL

### 自动更新系统级字段
1. 公共元数据处理器
2. 为XxxDO配置注解

### 集成验证框架步骤
1. 在pom.xml引入相关的jar包支持
2. 在待验证的实体里面添加相应的注解
3. 在Controller中添加相应的注解
4. 做参数校验工具类，完成service层的参数校验

### 实现统一异常处理功能
1. 实现一个异常处理的类，并且用@ControllerAdvice修饰