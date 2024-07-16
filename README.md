
**完整代码收费可以加微信FY-yuanma咨询接毕业设计论文**

**作者QQ：3042127848 微信：FY-yuanma (支持修改、部署调试、支持代做毕设)**

**接网站建设、小程序、H5、APP、各种系统等**

**选题+开题报告+任务书+程序定制+安装调试+论文+答辩ppt都可以做**

**毕业设计所有选题地址： https://github.com/Good-Night-Unicorn?tab=repositories**

## 基于springboot+Vue的大学生党务学习平台小程序+LW(源码+数据库)

## 一、系统介绍
大学生党务学习平台管理系统按照操作主体分为管理员和用户。
管理员的功能包括档案管理、党课管理、党课收藏管理、党课评价管理、党课报名管理、字典管理、试卷管理、试卷选题管理、试题表管理、
考试记录表管理、答题详情表管理、错题表管理、公告信息管理、党务工作者管理、签到信息管理、谈心谈话管理、入党申请管理、提醒管理、
在线学习管理、在线学习收藏管理、在线学习留言管理、用户管理、作业管理、作业提交管理、管理员管理。用户的功能等。
该系统采用了Mysql数据库，Java语言，Spring Boot框架等技术进行编程实现。
## 二、所用技术

后端技术栈：

- SpringMvc
- mybatis
- mysql
- shiro


前端技术栈：
- Vue
- layui
- axios
- bootstrap
- uniapp
- 小程序

## 三、环境介绍

基础环境 :IDEA/eclipse, JDK 1.8, Mysql5.7及以上, Maven3.6, HBuilder

所有项目以及源代码本人均调试运行无问题 可支持远程调试运行

## 四、页面演示
![图片](https://github.com/user-attachments/assets/f1030a6b-ced1-416e-b416-a0d12fb1f16b)
![图片](https://github.com/user-attachments/assets/a1ed92a5-0d41-4c5b-9fb7-382bc1503df8)
![图片](https://github.com/user-attachments/assets/cf71696b-80ca-4fde-b9b4-087f2ef8d9a5)
![图片](https://github.com/user-attachments/assets/a816845f-f308-40d4-bcfa-dd433fc42103)
![图片](https://github.com/user-attachments/assets/1baca642-45d3-4300-b1d7-11e3716f26f5)


## 五、浏览地址

后台访问地址：http://localhost:8097
- 管理员账号/密码：sysadmin/123456
- 超级管理员账号/密码：admin/admin123

app端用户名密码：
lilong/123456

## 六、部署教程

1. 使用Navicat或者其它工具，在mysql中创建对应名称的数据库，并执行项目的sql文件；
2. 使用IDEA/Eclipse导入Hospital-register项目，若为maven项目请选择maven，等待依赖下载完成；
3. 进入src/main/resources修改application.yml里面的profile文件路径配置和application-druid.yml的数据库配置
4. 启动项目后端项目
5. hbuilder打开Hospital-register-wx项目，修改manifest.json的微信小程序配置，点击运行到小程序模拟器
6. 执行运行后会跳转到微信小程序开发工具
