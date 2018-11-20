# Jenkins 账号自定义字段

为Jenkins的账号系统添加自定义字段。

## 版本兼容性

- jenkins 2.X
- jdk7
- groovy 2.X

## 目录

- src/main/java/cn/devit/demo/jenkins 
    - InstantMessageProperty.java 给账号添加自定义字段类型
- src/main/resources
    - index.jelly 出现在插件管理页中的插件描述 
    - cn/devit/demo/jenkins
        - i18n/Messages.properties 字符串，翻译（maven会自动生成Messages.java供引用）
    - cn/devit/demo/jenkins/InstantMessageProperty/ 是对应的插件类的UI存储位置，必须和类的名字相同
        - config.jelly 出现在账号配置界面的UI
        - config.properties UI中引用的字符串          

## 插件用法

    def user =  Jenkins.instance.getUser('admin')
    def p = user.getProperty(cn.devit.demo.jenkins.InstantMessageProperty.class)
    println p.mobilePhone
    println p.qq   

    
## jenkins 插件开发参考

### 设置开发环境，调试

https://wiki.jenkins.io/display/JENKINS/Plugin+tutorial#Plugintutorial-SettingUpEnvironment

### 启动并调试

    mvn hpi:run
