package com.lxl.eurekaserver.more;

/**
 * @author lxl lukas
 * @description maven使用说明
 * @create 2018/1/26
 */
public class MVNUtil {

    static {
        /**
         * 1. 创建Maven的普通java项目：
         mvn archetype:create
         -DgroupId=packageName
         -DartifactId=projectName
         2. 创建Maven的Web项目：
         mvn archetype:create
         -DgroupId=packageName
         -DartifactId=webappName
         -DarchetypeArtifactId=maven-archetype-webapp
         3. 编译源代码： mvn compile
         4. 编译测试代码：mvn test-compile
         5. 运行测试：mvn test
         6. 产生site：mvn site
         7. 打包：mvn package
         8. 在本地Repository中安装jar：mvn install
         9. 清除产生的项目：mvn clean
         10. 生成eclipse项目：mvn eclipse:eclipse
         11. 生成idea项目：mvn idea:idea
         12. 组合使用goal命令，如只打包不测试：mvn -Dtest package
         13. 编译测试的内容：mvn test-compile
         14. 只打jar包: mvn jar:jar
         15. 只测试而不编译，也不测试编译：mvn test -skipping compile -skipping test-compile
         ( -skipping 的灵活运用，当然也可以用于其他组合命令)
         16. 清除eclipse的一些系统设置:mvn eclipse:clean


         一般使用情况是这样，首先通过cvs或svn下载代码到本机，然后执行mvn eclipse:eclipse生成ecllipse项目文件，然后导入到eclipse就行了；修改代码后执行mvn compile或mvn test检验，也可以下载eclipse的maven插件。

         mvn -version/-v  显示版本信息
         mvn archetype:generate        创建mvn项目
         mvn archetype:create -DgroupId=com.oreilly -DartifactId=my-app   创建mvn项目

         mvn package            生成target目录，编译、测试代码，生成测试报告，生成jar/war文件
         mvn jetty:run            运行项目于jetty上,
         mvn compile                    编译
         mvn test                    编译并测试
         mvn clean                    清空生成的文件
         mvn site                    生成项目相关信息的网站
         mvn -Dwtpversion=1.0 eclipse:eclipse        生成Wtp插件的Web项目
         mvn -Dwtpversion=1.0 eclipse:clean        清除Eclipse项目的配置信息(Web项目)
         mvn eclipse:eclipse                将项目转化为Eclipse项目

         mvn -v 显示版本
         mvn help:describe -Dplugin=help 使用 help 插件的  describe 目标来输出 Maven Help 插件的信息。
         mvn help:describe -Dplugin=help -Dfull 使用Help 插件输出完整的带有参数的目标列
         mvn help:describe -Dplugin=compiler -Dmojo=compile -Dfull 获取单个目标的信息,设置  mojo 参数和  plugin 参数。此命令列出了Compiler 插件的compile 目标的所有信息
         mvn help:describe -Dplugin=exec -Dfull 列出所有 Maven Exec 插件可用的目标
         mvn help:effective-pom 看这个“有效的 (effective)”POM，它暴露了 Maven的默认设置

         mvn archetype:create -DgroupId=org.sonatype.mavenbook.ch03 -DartifactId=simple -DpackageName=org.sonatype.mavenbook 创建Maven的普通java项目，在命令行使用Maven Archetype 插件
         mvn exec:java -Dexec.mainClass=org.sonatype.mavenbook.weather.Main Exec 插件让我们能够在不往 classpath 载入适当的依赖的情况下，运行这个程序
         mvn dependency:resolve 打印出已解决依赖的列表
         mvn dependency:tree 打印整个依赖树

         mvn install -X 想要查看完整的依赖踪迹，包含那些因为冲突或者其它原因而被拒绝引入的构件，打开 Maven 的调试标记运行
         mvn install -Dmaven.test.skip=true 给任何目标添加maven.test.skip 属性就能跳过测试
         mvn install assembly:assembly 构建装配Maven Assembly 插件是一个用来创建你应用程序特有分发包的插件

         mvn jetty:run 调用 Jetty 插件的 Run 目标在 Jetty Servlet 容器中启动 web 应用
         mvn compile 编译你的项目
         mvn clean install 删除再编译

         mvn hibernate3:hbm2ddl 使用 Hibernate3 插件构造数据库</span>
         * mvn
         *  执行顺序：

         1、使用清理插件：maven-clean-plugin:2.5执行清理删除已有target目录（版本2.5）；

         2、使用资源插件：maven-resources-plugin:2.6执行资源文件的处理（版本2.6）；

         3、使用编译插件：maven-compiler-plugin:3.1编译所有源文件生成class文件至target\classes目录下（版本3.1）；

         4、使用资源插件：maven-resources-plugin:2.6执行测试资源文件的处理（版本2.6）；

         5、使用编译插件：maven-compiler-plugin:3.1编译测试目录下的所有源代码（版本3.1）；

         6、使用插件：maven-surefire-plugin:2.12运行测试用例（版本2.12）；

         7、使用插件：maven-jar-plugin:2.4对编译后生成的文件进行打包，包名称默认为：artifactId-version，比如本例生成的jar文件：rtp-front-1.0-SNAPSHOT，包文件保存在target目录下（这个生成的包不能在命令行中直接执行，因为我们还没有入口类配置到Manifest资源配置文件中去，后续会阐述）。

         备注：

         不管是compile、package还是install等前三个步骤都是必不可少的。

            执行mvn clean可将根目录(当前模块)下生成的target文件移除

            执行mvn compile将编译根目录/当前工程到target目录,包括资源文件/class文件
            执行 mvn install 将本地工程打包成jar包，放入到本地仓库中，再通过pom.xml配置依赖引入到当前工程。
         　 pom.xml中引入的坐标首先在本地maven仓库中查找，若没有则去maven的网上中央仓库查找，并放到本地仓库供项目使用。

            mvn package是把jar打到本项目的target下，而install时把target下的jar安装到本地仓库，供其他项目使用.
         **/
    }

}
