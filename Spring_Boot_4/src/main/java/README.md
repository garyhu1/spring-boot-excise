# 关于spring boot的配置

###server.undertow.* 包含了undertow 相关配置，较为重要的配置如下：
1、打开undertow 日志，默认为false
server.undertow.accesslog.enabled=false
2、访问日志所在目录
server.undertow.accesslog.dir=logs
3、创建工作线程的I/O 线程，默认为2 或者CPU 的个数
server.undertow.io-threads=
4、工作线程个数，默认为I/O 线程个数的8 倍
server.undertow.worker-threads
5、 HTTP POST 内容最大长度，默认不限制
server.undertow.max-http-post-size=O

### server.tty.* 包含了J巳tty 相关配置，较为重要的配置如下：
1、 打开Jetty 日志， 默认为false
server.jetty.accesslog.enabled=false
2、访问日志所在目录
server.jetty.accesslog.dir=logs
3、 acceptors 线程个数，用来接受访问请求，相当于工作线程
server.jetty.acceptors=
4、 selectors 线程个数，和CPU 个数相关，默认是可用（ CPU+l) /2 ，用于分配请求给工作线程
server.jetty.selectors=

###