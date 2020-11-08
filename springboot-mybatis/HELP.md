# 1.2.2 springboot整合mybatis

* mybatis可以实现零配置
  * 首先，删除掉mybatis-config.xml并注释掉application.properties中对应配置项，运行正常
  * 其次，删除掉UsersMapper.xml并注释掉application.properties中对应的配置项，此时UsersDao中前两个方法不可用，但第三个方法运行正常
  * 最后，删除掉application.properties中的mybatis别名配置，不影响正常使用