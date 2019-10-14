# CCS
新高考走班排课系统

目录结构说明：
com.goclass-parent
  -com.goclass-mapper   #orm映射文件
  -com.goclass-pojo     #实体
  -com.goclass-web      #WebService
    -com.web
      -GoClassApp.java  #App启动类
    -com.web.common     #公共类
      -config             #配置
      -utils              #工具
    -com.web.model      #WebService模块
      -rpc                #rpc远程调用
      -business           #业务
        -user               #用户管理
        -timer              #上课时间时段管理
        -course_table       #课表管理
        -classroom          #课室管理
        -cg                 #分班业务
        -ccs                #排课业务
      -security           #安全访问
        -authentication     #自定义认证服务
        -config             #配置
        -filter             #token过滤器
