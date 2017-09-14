# Mvn-Jdbc-Sql
用 maven 添加 jdbc 驱动访问本地数据库
### 在以前都是直接 copy jar 包到项目然后使用,现在用 maven 只需在pom.xml文件中添加几句就可以方便快捷
数据库是简单的表
![](https://ws3.sinaimg.cn/large/006tNc79gy1fjjfu5agfcj30im09wwfm.jpg)
### 添加到 pom 文件中的代码
      
        <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.39</version>
        </dependency>
