1.下载 http://maven.apache.org/download.cgi
![img.png](p1download.png)

2.解压
tar -zxvf apache-maven-3.x.x-bin.tar.gz

3.环境变量
vim /etc/profile

在打开的文件最后面添加以下信息(以在root/workSpace/maven 文件夹下为例):
export MAVEN_HOME=/root/workSpace/maven/apache-maven-3.8.4/
export PATH=$PATH:$MAVEN_HOME/bin

让配置生效
source /etc/profile

4.验证是否安装完成
mvn -version



----------------

修改本地仓库位置
在 Maven 的使用过程中，会自动将项目依赖的 jar 包从中央仓库下载到本地仓库，默认本地仓库路径是${user.home}/.m2/repository，这样的话，会占用较多的 C 盘空间，因此，我们可以自定义该路径。


