##本产品由NJUNONAMES团队开发

#本产品为物流信息系统服务器端1.0.0

#本产品需要提前安装jre1.7或以上版本以及mysql数据库进行支持

##install 在产品安装时，请在安装好mysql数据库以后打开安装包中的sql初始化脚本并运行
#运行方式：进入CMD模式运行“ mysql -h localhost -u 服务器名 -密码 < F:\LS-Server\sql初始化脚本.sql  ”
                                                                                   #最后填安装地址

##初始化后即可运行服务器端

##请在src/main/resources/config.xml中配置服务器数据库端口号以及用户名密码以及服务器ip地址和对外端口号
##请在src/main/resources/DistanceChart.txt中修改距离常量信息或者进入系统之后进入总经理管理自主进行初始化操作
##请在src/main/resources/PriceChart.txt中修改价格常量信息或者进入系统中自行初始化操作

##如若登录后有乱码操作，请将PriceChart.txt中的编码格式修改为ANSI

##在初始化所有工作后，本产品中初始信息有admin账号，密码为admin,另外还有账号topmanager即总经理，密码topmanager
##请登录后进行一系列初始化操作。

##本产品为1.0.0试用版，如有任何使用疑问，请联系我们##