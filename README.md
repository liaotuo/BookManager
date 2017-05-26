# BookManager
JPA+EJB+JSF2.0 实现增删查改 做的一个简单的图书管理系统

全部文件：
  studb.sql 测试的数据库备份
  三个Project (EJB EAR WEB)

如何使用：1. 配置好自己的glassfish 并还原数据库studb.sql <br>
         2.使用eclipse导入3个项目 <br>
         3.修改BookEJB\ejbModule\META-INF下的persistence.xml <br>
           将<jta-data-source>lt_pool</jta-data-source>中 数据库连接池的名字改为你自己的连接池名即可
