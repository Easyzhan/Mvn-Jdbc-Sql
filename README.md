# Mvn-Jdbc-Sql
用 maven 添加 jdbc 驱动访问本地数据库
### 在以前都是直接 copy jar 包到项目然后使用,现在用 maven 只需在pom.xml文件中添加几句就可以方便快捷
数据库是简单的表
![](https://ws3.sinaimg.cn/large/006tNc79gy1fjjfu5agfcj30im09wwfm.jpg)
![](https://ws3.sinaimg.cn/large/006tNc79gy1fjjfxhosjlj30gk09iaaw.jpg)
### 添加到 pom 文件中的代码
      
        <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.39</version>
        </dependency>
  ### 注意事项:
  当用 maven 的时候再 pom 中出现错误的时候,说明 maven 没有把你需要的 jar 下载到本地或者你下载到本地的是个错的
  那么就需要你找到.m2/repository/mysql
  在其中找到你报错的那个 jar 然后删掉重新 build.
  
  #### 链接数据库通过 jdbc 获取数据的具体步骤请
  参考 demo 中的 utils, 使用数据库请参考 testClass
