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



## volatile关键字

	如在C语言中，volatile关键字可以用来提醒编译器它后面所定义的变量随时有可能改变，因此编译后的程序每次需要存储或读取这个变量的时候，都会直接从变量地址中读取数。如果没有volatile关键字，则编译器可能优化读取和存储，可能暂时使用寄存器中的值，如果这个变量由别的程序更新了的话，将出现不一致的现象。
​	Java的内存模型实现总是从主存（即共享内存）读取变量，是不需要进行特别的注意的。而在当前的 Java 内存模型下，线程可以把变量保存本地内存（比如机器的寄存器）中，而不是直接在主存中进行读写。这就可能造成一个线程在主存中修改了一个变量的值，而另外一个线程还继续使用它在寄存器中的变量值的拷贝，造成数据的不一致。 

要解决这个问题，就需要把变量声明为 volatile，这就指示 JVM，这个变量是不稳定的，每次使用它都到主存中进行读取。 



#### volatile关键字的可见性

​	volatile修饰的成员变量在每次被线程访问时,都强迫从主存(共享内存)中重读该成员变量的值。而且,当成员变量发生变化时,强迫线程将变化值回写到主存(共享内存),这样在任何时刻,两个不同的线程总是看到某个成员变量的同一个值

假如你把while循环代码里加上任意一个输出语句或者sleep方法你会发现死循环也会停止，不管isRunning变量是否被加上了上volatile关键字。

加上输出语句：

```java
while (isRunning == true) {
        int a=2;
        int b=3;
        int c=a+b;
        m=c;
        System.out.println(m);
    }
加上sleep方法：
```
```java
    while (isRunning == true) {
        int a=2;
        int b=3;
        int c=a+b;
        m=c;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
```


因为：JVM会尽力保证内存的可见性，即便这个变量没有加同步关键字。换句话说，只要CPU有时间，JVM会尽力去保证变量值的更新。这种与volatile关键字的不同在于，volatile关键字会强制的保证线程的可见性。而不加这个关键字，JVM也会尽力去保证可见性，但是如果CPU一直有其他的事情在处理，它也没办法。最开始的代码，一直处于死循环中，CPU处于一直占用的状态，这个时候CPU没有时间，JVM也不能强制要求CPU分点时间去取最新的变量值。而加了输出或者sleep语句之后，CPU就有可能有时间去保证内存的可见性，于是while循环可以被终止。



## synchronized关键字和volatile关键字比较



volatile关键字是线程同步的轻量级实现，所以volatile性能肯定比synchronized关键字要好。但是volatile关键字只能用于变量而synchronized关键字可以修饰方法以及代码块。synchronized关键字在JavaSE1.6之后进行了主要包括为了减少获得锁和释放锁带来的性能消耗而引入的偏向锁和轻量级锁以及其它各种优化之后执行效率有了显著提升，实际开发中使用synchronized关键字还是更多一些。

多线程访问volatile关键字不会发生阻塞，而synchronized关键字可能会发生阻塞

volatile关键字能保证数据的可见性，但不能保证数据的原子性。synchronized关键字两者都能保证。

volatile关键字用于解决变量在多个线程之间的可见性，而ynchronized关键字解决的是多个线程之间访问资源的同步性。



## 等待/通知机制

	#### 不使用等待/通知机制

​	当两个线程之间存在生产和消费者关系，也就是说第一个线程（生产者）做相应的操作然后第二个线程（消费者）感知到了变化又进行相应的操作。比如像下面的whie语句一样，假设这个value值就是第一个线程操作的结果，doSomething()是第二个线程要做的事，当满足条件value=desire后才执行doSomething()。

​	但是这里有个问题就是：第二个语句不停过通过轮询机制来检测判断条件是否成立。如果轮询时间的间隔太小会浪费CPU资源，轮询时间的间隔太大，就可能取不到自己想要的数据。所以这里就需要我们今天讲到的等待/通知（wait/notify）机制来解决这两个矛盾。

```java
    while(value=desire){
        doSomething();
    }
```
#### 等待通知机制

​	是指一个线程A调用了对象O的wait()方法进入等待状态，而另一个线程B调用了对象O的notify()/notifyAll()方法，线程A收到通知后退出等待队列，进入可运行状态，进而执行后续操作。上诉两个线程通过对象O来完成交互，而对象上的wait()方法和notify()/notifyAll()方法的关系就如同开关信号一样，用来完成等待方和通知方之间的交互工作。

**notify():**	随机唤醒等待队列中等待同一共享资源的 “一个线程”，并使该线程退出等待队列，进入可运行状态，也就是notify()方法仅通知“一个线程”

**notifyAll():**	使所有正在等待队列中等待同一共享资源的 “全部线程” 退出等待队列，进入可运行状态。此时，优先级最高的那个线程最先执行，但也有可能是随机执行，这取决于JVM虚拟机的实现
**wait():**	使调用该方法的线程释放共享资源锁，然后从运行状态退出，进入等待队列，直到被再次唤醒
**wait(long):**	超时等待一段时间，这里的参数时间是毫秒，也就是等待长达n毫秒，如果没有通知就超时返回
**wait(long，int):**	对于超时时间更细力度的控制，可以达到纳秒



#### 线程基本状态

​	**1.新建(new):** 新创建了一个线程对象

​	**2.可运行(runnable):** 线程对象创建后,其他线程(比如main线程)调用了该对象的start()方法,该状态的线程位于可运行线程池中,等待被线程调度选中,获得CPU使用权

​	**3.运行(running):** 可运行状态的线程获得了CPU时间片,执行代码

​	**4. 阻塞(block):** 阻塞状态指线程因为某种原因放弃了CPU使用权,也即让出了CPU timeslice,暂时停止运行。直到线程进入可运行状态,才有机会再次获得时间片

​		阻塞状态分三种:

​			**1. 等待阻塞:** 运行的线程执行wait()方法,JVM会把线程放入等待队列(waitting queue)

​			**2. 同步阻塞:** 运行的线程在获取对象同步锁时,若该同步锁被别的线程占用,JVM会把该线程放入锁池(lock pool)中

​			**3. 其他阻塞:** 运行的线程执行sleep 或join()方法,或者发出了IO请求,JVM会把该线程置为阻塞状态。当sleep状态超时join()等待线程终止或者超时,或者IO处理完毕,线程重新进入运行状态

​	**5. 死亡(dead): ** 线程run(),main()方法执行结束,或因异常退出了run(),则该线程结束生命周期,死亡线程不可再次浮生



**当方法wait()被执行后，锁自动被释放，但执行完notify()方法后，锁不会自动释放。必须执行完notify()方法所在的synchronized代码块后才释放。**



## 线程池与Executor框架

​	线程池提供了一种限制和管理资源, 每个线程池还维护一些基本信息,例如已完成任务的数量

​	好处:

  - **降低资源消耗: ** 通过重复利用已创建的线程降低线程创建和销毁造成的消耗

  - **提高响应速度: ** 当任务到达时候, 任务可以不需要的等到线程创建就能立即执行

  - **提高线程的可管理性: ** 线程是稀缺资源,如果无限制的创建,不仅会消耗系统资源,还会降低系统的稳定性,使用线程池可以进行统一分配,调优和监控

    