# JDK监控和故障处理工具总结

JDK(Java Development ToolKit Java开发工具包), 包括了Java 运行环境(Java runtime enviroment), Java工具(java/java/jdb) 和Java基础的类库(即Java API)



## JDK 命令行工具

这些命令在 JDK 安装目录下的 bin 目录下：

- **jps** (JVM Process Status）: 类似 UNIX 的 `ps` 命令。用户查看所有 Java 进程的启动类、传入参数和 Java 虚拟机参数等信息；
- **jstat**（ JVM Statistics Monitoring Tool）: 用于收集 HotSpot 虚拟机各方面的运行数据;
- **jinfo** (Configuration Info for Java) : Configuration Info forJava,显示虚拟机配置信息;
- **jmap** (Memory Map for Java) :生成堆转储快照;
- **jhat** (JVM Heap Dump Browser ) : 用于分析 heapdump 文件，它会建立一个 HTTP/HTML 服务器，让用户可以在浏览器上查看分析结果;
- **jstack** (Stack Trace for Java):生成虚拟机当前时刻的线程快照，线程快照就是当前虚拟机内每一条线程正在执行的方法堆栈的集合。



#### jps(JVM Process Status): 查看所有Java进程

​	jps:显示虚拟机执行主类名称以及这些进程的本地虚拟机唯一ID(local virtual machine Identifier, LVMD)

​	jps -q: 只输出进程的本地虚拟机唯一ID

​	jps -l: 输出主类的全名, 如果进程执行的是Jar包,输出Jar路径

​	jps -v: 输出虚拟机进程启动时JVM参数

​	jps -m: 输出传递给Java进程main()函数的参数

#### jstat: 监视虚拟机各种运行状态信息

​	jstat(JVM Statistics  Monitoring Tool) 使用于监视虚拟机各种运行状态信息的命令行工具. 它可以显示本地或者远程(需要远程主机提供RMI支持)虚拟机进程中的类信息、内存、垃圾收集、JIT编译等运行数据,在没有GUI.只提供了纯文本控制台环境的服务器上,它将是运行期间定位虚拟机性能问题的首选工具

​	**jstat 命令使用格式：**

```java
jstat -<option> [-t] [-h<lines>] <vmid> [<interval> [<count>]]
```

**常见的 option 如下：**

- `jstat -class vmid` ：显示 ClassLoader 的相关信息；
- `jstat -compiler vmid` ：显示 JIT 编译的相关信息；
- `jstat -gc vmid` ：显示与 GC 相关的堆信息；
- `jstat -gccapacity vmid` ：显示各个代的容量及使用情况；
- `jstat -gcnew vmid` ：显示新生代信息；
- `jstat -gcnewcapcacity vmid` ：显示新生代大小与使用情况；
- `jstat -gcold vmid` ：显示老年代和永久代的信息；
- `jstat -gcoldcapacity vmid` ：显示老年代的大小；
- `jstat -gcpermcapacity vmid` ：显示永久代大小；
- `jstat -gcutil vmid` ：显示垃圾收集信息；



#### jinfo: 实时查看和调整虚拟机各项参数

​	**jinfo vmid:** 输出当前jvm进程的全部参数和系统属性(第一部分是系统的属性,第二部分是JVM参数)

​	jinfo -flag name vmid: 输出对应名称的参数的具体指



#### jmap: 生成堆转储快照

#### jhat: 分析heapdump文件

#### jstack: 生成虚拟机当前时刻的线程快照

​	jstack(Stack Trace for Java) 用于生成虚拟机当前时刻的线程快照. 线程快照就是当前虚拟机内每一条线程正在执行的方法堆栈的集合

​	生成线程快照的目的主要是定位线程长时间出现停顿的原因,如线程间死锁,死循环,请求外部资源导致的长时间等待等都是导致线程长时间停顿的原因