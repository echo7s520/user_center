# **用户中心** 

通过一套完整的项目流程，体验企业做项目的过程，学习相关的开发技术

> **项目源码**
>
> **用户中心前端源码 ：** 
>
> **用户中心后端源码 ：**

# **1.1 企业做项目流程**

需求分析 -->  设计（概要设计、详细设计）--> 技术选型 --> 初始化 / 引入需要的技术 --> 写 Demo --> 写代码 （实现业务逻辑） --> 测试（单元测试）--> 代码提交 / 代码评审 --> 部署 --> 发布

# **1.2 需求分析**

* 1 登录 / 注册
* 2 用户管理（仅管理员可见） 对用户的查询或修改
* 3 用户校验

# **1.3 技术选型** 

* 前端 : 三件套 + React + 组件库 Ant Design + Umi + Ant Design Pro
* 后端 : 
  * java
  * Spring + SpringMVC + MyBatis
  * SpringBoot
  * junit 单元测试库
  * mysql 
* 部署 : 服务器 / 容器（平台）

# **1.4 计划**

1. 初始化项目
   1. 前端初始化
      1. 初始化项目  ✔
      2. 引入组件  ✔
      3. 框架瘦身  ✔
   2. 后端初始化
      1. 准备环境（Mysq）  ✔
      2. 初始化后端项目，引入框架  ✔
2. 数据库设计  ✔
3. 登录、注册、注销   ✔
   1. 后端
      1. 规整项目目录   ✔
      2. 实现数据库的操作   ✔
      3. 写注册逻辑  ✔
      4. 写登录逻辑  ✔
      4. 写注销逻辑  ✔
   2. 前端
      1. 删除多余代码  ✔
      2. 完成登录页面  ✔
      2. 完成注册页面  ✔
      2. 完成注销页面  ✔
4. 用户管理
   1. 后端  ✔
   2. 前端  ✔



# **二 初始化项目**

## **2.1 前端初始化**

### **2.1.1 下载并安装 node.js**

### **2.1.2 初始化 Ant Design Pro 脚手架**

（ 1 ）初始化前端项目

> ```bash
> # 使用 npm
> npm i @ant-design/pro-cli -g
> pro create myapp
> ```
>
> ```shell
> ? 🐂 使用 umi@4 还是 umi@3 ? (Use arrow keys)
> ❯ umi@4
>   umi@3
> ```
>
> ```shell
> ? 🚀 要全量的还是一个简单的脚手架? (Use arrow keys)
> ❯ simple
>   complete
> ```
>
> ```shell
> $ cd myapp && tyarn
> // 或
> $ cd myapp && npm install
> ```

 （ 2 ）安装项目所需依赖包

> yarn

（ 3 ） 安装 Umi UI （可以帮我们自动生成代码）

> `yarn add @umijs/preset-ui -D `

（ 4 ）项目瘦身

* 1 删除国际化
  * 执行 `i18n-remove` 脚本
  * 删除项目路径下 src / locales 文件夹
* 2 删除项目路径下 src / e2e 文件夹
  * e2e 文件夹里面定义的是一系列测试流程
* 3 删除项目路径下 src / services / swagger 文件夹
  * swagger 文件夹里面定义了一系列后台接口程序
* 4 删除项目路径下 config / oneapi.json 文件
  * oneapi.json 定义了整个项目用到的接口
* 5 删除项目路径下tests 文件夹
  * tests 文件夹注意和测试相关的
* 6 删除项目路径下 jest . config.js  文件
  * jest . config.js 测试相关的配置文件
* 7 删除项目路径下 playwright . config.ts 文件
  * platwright . config.ts 自动化测试工具，不需要打开浏览器进行测试

## **2.2 后端初始化**

### **2.2.1 mysql 安装**

> 下载安装  [MySQL5.7 安装链接](https://dev.mysql.com/downloads/mysql/5.7.html)

### **2.2.2 SpringBoot 初始化**

> 引入  [MyBatis-Plus](https://baomidou.com/) 
>
> 当使用Junit5包中的@Test单元测试中
>
>  添加注解 @Runwith(springRunner.class) 



# **三 数据库设计**

## **3.1 用户表设计**

* **普通字段**

| 字段         | 说明                                 | 类型          |
| ------------ | ------------------------------------ | ------------- |
| id           | 主键，唯一标识                       | bigint        |
| username     | 昵称                                 | varchar(256)  |
| userAccount  | 账号                                 | varchar(256)  |
| avatarUrl    | 头像                                 | varchar(1024) |
| gender       | 性别                                 | tinyint       |
| userPassword | 密码                                 | varchar(256)  |
| phone        | 电话                                 | varchar(256)  |
| email        | 邮箱                                 | varchar(256)  |
| userStatus   | 用户状态。0-> 正常                   | int           |
| userRole     | 用户权限。0 -> 普通用户，1 -> 管理员 | int           |
|              |                                      |               |

* **必备字段**

| 字段       | 说明                     | 类型     |
| ---------- | ------------------------ | -------- |
| createTime | 创建时间（数据插入时间） | datetime |
| updateTime | 更新时间（数据更新时间） | datetime |
| isDelete   | 是否删除                 | tinyint  |

> 使用 sql 语句方式
>
> ```sql
> create table user
> (
>     id           bigint auto_increment comment 'id' primary key,
>     username     varchar(256)                       null comment '用户昵称',
>     userAccount  varchar(256)                       null comment '登录账号',
>     avatarUrl    varchar(1024)                      null comment '头像',
>     gender       tinyint                            null comment '性别',
>     userPassword varchar(512)                       not null comment '密码',
>     phone        varchar(128)                       null comment '电话',
>     email        varchar(512)                       null comment '邮箱',
>     userStatus   int      default 0                 not null comment '用户状态，0：正常',
>     createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
>     updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
>     isDelete     tinyint  default 0                 null comment '是否删除'
> )
>     comment '用户';
> ```



# **四 登录 / 注册功能**

## **4.1 规整项目目录**

![](d:\Users\i\Desktop\xx\笔记\userimg\捕获.PNG)

## **4.2 通过 MyBatisX 插件自动生成相关类**

* domain 实体对象
* mapper 操作数据库对象
* mapper . xml 定义mapper 对象和数据库关联操作
* service 业务逻辑实现接口
* serviceimpl 具体实现接口方法

## **4.3 注册功能实现--后端**

1. 用户在前端输入账户，密码以及校验码
2. 检验用户的账户，密码是否符合要求
   1. 非空
   2. 账户长度 **不小于** 4 位
   3. 密码长度 **不小于** 8 位
   4. 账户不能重复
   5. 账户不能包含特殊字符
   6. 密码和校验密码相同
3. 对密码进行加密
4. 向数据库中插入用户数据
5. 进行单元测试

# **五 用户管理**

## **5.1 后端-登录**

### **5.1.1 登录接口**

* 接收参数 :  用户账号、密码

* 请求类型 : POST

* 请求体 : JSON 格式数据

  > 请求参数很长时不建议用 GET

* 返回值 : 用户信息 （ 脱敏 ）

### **5.1.2 登录逻辑**

1. 校验用户账户和密码是否合法
   1. 非空
   2. 账户长度 不小于 4 位
   3. 密码长度 不小于 8 位
   4. 账户不包含特殊字符
2. 校验密码是否输入正确，要和数据库中的密文密码进行对比
3. 用户信息脱敏，隐藏敏感信息，防止数据库字段泄露
4. 记录用户的登录态（session），将其存在服务器上，后端记录 cookie
5. 返回脱敏后的用户信息

> isDelete 逻辑删除 MyBatis-Plus 内置，需要手动设置逻辑删除字段属性，添加注解 @TableLogic
>
> ```yaml
> mybatis-plus:
> global-config:
> db-config:
> logic-delete-field: isDelete # 全局逻辑删除的实体字段名(since
> 3.3.0,配置后可以忽略不配置步骤2)
> logic-delete-value: 1 # 逻辑已删除值(默认为 1)
> logic-not-delete-value: 0 # 逻辑未删除值(默认为 0)
> ```

### **5.1.3 判断用户是否登录**

1. 连接服务器端后，得到一个 session 状态（匿名会话），返回给前端
2. 登录成功后，得到了登录成功的 session ，并且给该 session 设置一些值，返回给前端一个设置 cookie 的命令
3. 前端接收到后端的命令后，设置 cookie，保存到浏览器内
4. 前端再次请求后端时，请求头带上 cookie 去请求
5. 后端拿到前端传来的 cookie ，找到对应的 session
6. 后端从 session 中可以取出基于该 session 存储的变量

### **5.1.4 Controller 层封装请求**

​		（ 1 ） application . yml 指定接口全局 api

```yaml
servlet: 
	context-path: /api
```

​		（ 2 ） 注册接口

> http://localhost:8080/api/user/register

​		（ 3 ） 登录接口

> http://localhost:8080/api/user/login

​		（ 4 ） 扩展

> 1. @RestController 适用编写 Restful 风格的 api ，返回值默认位 json 类型
> 2. controller 层校验 和 service 层校验的区别
>    1. controller 层倾向于对请求参数本省的校验，不涉及到逻辑本身
>    2. service 层对业务逻辑的校验（有可能被 controller 之外的类调用）

## **5.2 后端-用户管理**

接口设计关键 : 必须鉴权！！

​	1 查询用户 （允许根据用户名查询）

​	2 删除用户

## **5.3 前端-登录**

 （ 1 ）先对项目代码进行精简 - > 将用户登录界面修改

 （ 2 ） 实现前后端交互

* tips : 跨域问题可以在后端解决，但这样不安全

* 解决方法 : 正向代理

* 修改 config / proxy . ts 下的文件

  当发起 http://localhost:8000/api/user/login 时，正向代理到 http://localhost:8080/api/user/login 从而解决跨域问题  
  
* **前后端交互**

  * 前端向后端发生请求回去数据 / 执行操作

* **实现代理**

  * Nginx 服务器
  * Node . js 服务器

## **5.4 前端-用户管理**

  对接后端接口，设置权限，限制访问人员

## **5.5 后端-注销**

### **5.5.1 注销逻辑**

 查询登录态 , 将其设置为空

## **5.6 前端-注销**

对接后端接口，

# **六 优化**

## **6.1 后端-优化**

### **6.1.1通用返回对象**

​		目的 : 给对象补充信息，告诉前端这个请求在业务层面上是否成功

200、403、404、500、502、503 ...

* 自定义错误码
* 返回类支持返回正常和错误

### **6.1.2 封装全局异常处理**

1. 定义业务异常类

   1. 相对于 Java 的异常类，支持更多字段
   2. 自定义构造函数，更灵活

2. 编写全局异常处理器

   1. 捕获代码中所有的异常，内部消化，让前端得到更详细的业务报错 / 信息
   2. 同时屏蔽掉项目框架本身的异常（不暴露服务器内部状态）

   > 实现：
   >
   > ​    Spring AOP ：在调用方法前后进行额外处理 （切面操作）

3. 全局请求日志和登录校验

## **6.2 前端-优化**

>  对接后端的返回值， 前端适配接收的数据

### **6.2.1 全局响应处理**

* 应用场景 :  需要对接口的 **通用响应** 进行统一处理
* 优势 :  不用在每个请求接口中都去写相同逻辑
* 实现 :  参考封装工具的 官方文档





