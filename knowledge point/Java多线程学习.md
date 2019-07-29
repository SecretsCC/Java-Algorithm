# Java多线程

## 重要概念

	#### 同步(synchronization))和异步(synchronization)

​	同步和异步通常用来形容一次方法的调用。同步方法调用一旦开始,调用者必须等到方法调用返回后才能继续后续行为。异步方法调用更像一个消息传递,一旦开始,方法调用就会立即返回,调用者可以继续后续的操作



####并发(Concurrency)和并行(Parallelism)

​	并发偏重于多个任务交替执行, 而多个任务之间可能是串行的

​	并行是真正意义上的同时执行

​	多线程在单核CPU的话是顺序执行,也就是交替运行(并发)。多核CPU的话,因为每个CPU有自己的运算器,所以在多个CPU中可以同时运行(并行)



#### 高并发

​	通常指通过设计保证系统能够同时并行处理很多请求

​	高并发相关常用的一些指标有响应时间(Response Time), 吞吐量(Throu), 每秒查询率(Query Per Second),并发用户数等



#### 临界区(critical zone)

​	临界区用来表示一种公共资源或者说是共享数据，可以被多个线程使用。但是每一次，只能有一个线程使用它，一旦临界区资源被占用，其他线程要想使用这个资源，就必须等待。在并行程序中，临界区资源是保护的对象。



#### 阻塞和非阻塞

​	非阻塞指在不能立刻得到结果之前,该函数不会阻塞当前线程,而会立刻返回,而阻塞与之相反

## 使用多线程常见的三种方式

​	前两种很少用,一般线程池的方式多一点

	#### 1. 继承Thread类

```Java
public class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		System.out.println("MyThread");
	}
}

public class Run {

	public static void main(String[] args) {
		MyThread mythread = new MyThread();
		mythread.start();
		System.out.println("运行结束");
	}

}

```


#### 2. 实现Runnable接口

```java
public class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("MyRunnable");
	}
}
public class Run {

	public static void main(String[] args) {
		Runnable runnable=new MyRunnable();
		Thread thread=new Thread(runnable);
		thread.start();
		System.out.println("运行结束！");
	}

}
--------------------- 
作者：SnailClimb在csdn 
来源：CSDN 
原文：https://blog.csdn.net/qq_34337272/article/details/79640870 
```
#### 3. 使用线程池

​	线程资源通过线程池提供



## 实例变量和线程安全

	#### 不共享数据的情况

```java
public class MyThread extends Thread {

private int count = 5;

public MyThread(String name) {
	super();
	this.setName(name);
}

@Override
public void run() {
	super.run();
	while (count > 0) {
		count--;
		System.out.println("由 " + MyThread.currentThread().getName() + " 计算，count=" + count);
	}
}

public static void main(String[] args) {
	MyThread a = new MyThread("A");
	MyThread b = new MyThread("B");
	MyThread c = new MyThread("C");
	a.start();
	b.start();
	c.start();
}
    
 --------------------- 
作者：SnailClimb在csdn 
来源：CSDN 
原文：https://blog.csdn.net/qq_34337272/article/details/79640870 
```
#### 共享数据的情况

​	



```java
public class SharedVariableThread extends Thread {
	private int count = 5;
    @Override
    public void run() {
        super.run();
        count--;
        System.out.println("由 " + SharedVariableThread.currentThread().getName() + " 计算，count=" + count);
    }

    public static void main(String[] args) {

        SharedVariableThread mythread = new SharedVariableThread();
        // 下列线程都是通过mythread对象创建的
        Thread a = new Thread(mythread, "A");
        Thread b = new Thread(mythread, "B");
        Thread c = new Thread(mythread, "C");
        Thread d = new Thread(mythread, "D");
        Thread e = new Thread(mythread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
}
    
 结果:  4
     	0
     	1
     	2
     	2
```
通过synchronized关键字(保证任意时刻只有一个线程执行该方法),一种利用Atomiclnteger类(JUC中的Atomic原子类)



## 一些常用方法

 1. currentThread()

    返回当前正在执行的线程对象的引用

	2. getId()

    返回此线程的标识符

	3. getName()

    返回此线程的名称

	4. getPriority()

    返回此线程的优先级

	5. isAlive()

    测试这个线程是否处于活动状态

    活动状态就是线程已经启动且尚未终止。线程处于正在运行或者准备运行的状态

	6. Sleep(loing millis)

    使正在执行的线程以指定毫秒数休眠

	7. Interrupt()

    中断这个线程

	8. Interrupted()和isInterrupted()

    Interrupted():测试当前线程是否已经中断, 执行后具有将状态标志清除为false的功能

    isInterrupted(): 测试线程Thread对相关是否已经是终端状态, 但不清楚状态标志

	9. setName(String name)

    将此线程的名称更改为参数name

	10. isDaemon()

     测试这个线程是否是守护线程

	11. setDaemon(boolean on)

     将此线程标记为daemon线程或用户线程

	12. Join()

     等待该线程终止

     主线程需要等待子线程执行完成后再结束.这个时候要用到Join()方法了

	13. yield()

     放弃当前CPU资源,将它然给其他任务去占用CPU时间, 放弃的时间不确定,可能一会就会重新获得CPU时间片

	14. setPriority(int newPriority)

     更改此线程的优先级



## 如何停止一个线程

​	stop(),suspend(),resume()这些方法已弃用

	#### 1. 使用interrupt()方法

#### 2. 使用return停止线程



## 线程的优先级

​	每个线程都具有各自的优先级,线程的优先级可以在程序中表明该线程的重要性,如果有很多处线程处于就绪状态,系统会根据优先级来决定首先使哪个线程进入运行状态

​	线程优先级具有继承特性,比如A线程启动B线程,则B线程的优先级和A是一样的

​	线程优先级具有随机性也就是说线程优先级高的不一定每一次都先执行完

Thread类中包含的成员变量代表了线程的某些优先级。

如Thread.MIN_PRIORITY（常数1），Thread.NORM_PRIORITY（常数5）,

Thread.MAX_PRIORITY（常数10）。其中每个线程的优先级都在Thread.MIN_PRIORITY（常数1） 到Thread.MAX_PRIORITY（常数10） 之间，在默认情况下优先级都是Thread.NORM_PRIORITY（常数5）。



## 多线程分类

	用户线程：运行在前台，执行具体的任务，如程序的主线程、连接网络的子线程等都是用户线程

守护线程：运行在后台，为其他前台线程服务.也可以说守护线程是JVM中非守护线程的 “佣人”。

特点：一旦所有用户线程都结束运行，守护线程会随JVM一起结束工作

应用：数据库连接池中的检测线程，JVM虚拟机启动后的检测线程

最常见的守护线程: 垃圾回收线程



## Synchronized关键字

​	非线程安全问题存在于实例变量中,如果是方法内部的私有变量,则不存在非线程安全问题,所得结果也就是线程安全的了

​	如果两个线程同时操作对象中的实例变量,则会出现非线程安全,解决办法就是在方法前面加上synchronized关键字即可



#### 脏读

​	读取实例变量时,此值已经被其他线程更改过了



