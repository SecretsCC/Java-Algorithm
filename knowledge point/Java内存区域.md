# Java内存区域

# 常见面试题

### 基本问题

 - 介绍下Java内存区域(运行时数据区)
 - Java对象创建过程(五步)
 - 对象的访问定位的两种方式(句柄和直接指针)

### 拓展问题

- String类和常量池
- 8中基本类型的包装类和常量池



## 1. Java内存区域

​	Java程序员把内存的控制权利交给Java虚拟机

​		![Image text](<https://github.com/SecretsCC/Java-Algorithm/blob/master/knowledge%20point/images/Java%20memory%20area.png>)

​			![Image text](<https://github.com/SecretsCC/Java-Algorithm/blob/master/knowledge%20point/images/Java%20memory%20area2.png>)

__线程私有__:										 __线程共享__:

​	程序计数器	program counter Register			堆		    Heap

​	虚拟机栈	    VM stack						      方法区	    Method Area

​	本地方法栈	 Native Method Stack				直接内存	Direct Memory

***

1. __程序计数器__

   ​	程序计数器是一块较小的内存空间, 看做当前线程所执行的字节码的行号指示器.

   ​	__字节码解释器工作时通过改变这个计数器的值来选取下一条需要执行的字节码指令__,分支,循环,跳转,异常处理,线程恢复等功能都需要依赖这个计数器来完成.

   ​	为了线程切换后能恢复到正确的执行位置,每条线程都需要有一个独立的程序计数器,各线程之间计数器互不影响,独立存储,我们称这类内存区域为"线程私有"的内存__(记录当前线程执行的位置, 从而当线程切换回来的时候能够知道该线程上次运行到哪)__

   __注意: 程序计数器是唯一一个不会出现OutOfMemoryError的内存区域, 它的生命周期随着线程的创建而创建, 随着线程的结束而死亡__

2. __Java虚拟机__

   ​	Java虚拟机也是线程私有的,生命周期和线程相同,描述的是Java方法执行的内存模型,每次方法调用的数据通过栈传递

   ​	Java内存粗糙的分为堆内存(Heap)和栈内存(Stack), 栈就是虚拟机栈, 或者说虚拟机栈局部变量表.

   ​	局部变量表主要存放了编译器可知的各种__数据类型(boolean, byte, char,short,int,float,long,double), 对象引用__(reference类型, 不同于对象本身, 可能是一个指向对象起始地址的引用指针, 也可能是指向一个代表对象的句柄或其他与此对象相关的位置)

   ​	Java虚拟机栈会出现__两种异常__: 

   ​		__StackOverFlowError__: 若Java虚拟机栈内存大小不允许动态拓展, 当线程请求栈的深度超过当前虚拟机栈最大深度抛出异常

   ​		__OutOfMemoryError__: 若Java虚拟机栈的内存大小允许动态拓展, 且当线程请求栈内存用完, 无法再动态扩展,抛出异常

   ​	

   ​	Java栈可用类比数据结构的栈, Java栈中保存的主要内容是栈帧, 每一次函数调用都会有一个对象的栈帧压入栈, 调用结束后弹出. __两种返回方式__: 1. return语句 2.抛出异常

3. __本地方法栈__

   ​	和虚拟机栈所发挥的作用非常相似, 区别是: 虚拟机栈为虚拟机执行Java方法(字节码)服务, 本地方法栈则为虚拟机使用到的Native方法服务

   ​	本地方法被执行的时候, 本地方法栈也会创建一个栈帧, 用于存放局部变量,操作数栈,动态链接,出口信息

4. __堆__

   ​	Java虚拟机所管理内存中最大的一块, 堆是所有线程共享的一块内存区域,在虚拟机启动时创建. __此内存区域的唯一目的就是存放对象实例,几乎所有的对象实例以及数组都在这里分配内存__

   ​	堆是垃圾收集管理的主要区域,也被称为GC堆(__Garbage Collected Heap__), 分代垃圾收集算法, 所以还可以细分为: 新生代和老年代 __进一步划分的目的是更好的回收内存, 或者更快的分配内存__ 

   ​	eden | s0 | s1 | tentired 

   ​	eden,s0,s1属于新生代, tentired属于老年代.

5. __方法区__

   ​	和堆一样, 是线程共享区域, 用于存储已被虚拟机加载的类信息,常量,静态变量,即时编译器编译后的代码等数据. 虽然Java虚拟机规范把方法区描述为堆的一个逻辑部分,但它有个别名叫Non-Heap

6. __运行时常量池__

   ​	运行时常量池是方法区的一部分. Class文件中除了有类的版本、字段、方法、接口等描述信息外,还有常量池信息(用于存放编译期生成的各种字面量和符号的引用)

   ​	既然是方法区的一部分,自然受到方法区的限制,当无法申请到内存时抛出OutOfMemoryError异常

   ​	__JDK1.7之后版本的 JVM已经将运行时常量池从方法区中移了出来, 在Java堆中开辟了一块区域存放运行时常量池

7. __直接内存__

   ​	**直接内存并不是虚拟机运行时数据区的一部分，也不是虚拟机规范中定义的内存区域，但是这部分内存也被频繁地使用。而且也可能导致 OutOfMemoryError 异常出现。**



## HotSpot虚拟机对象探秘

###    1. 对象的创建

​			![Image text](<https://github.com/SecretsCC/Java-Algorithm/blob/master/knowledge%20point/images/object%20creat%20process.png>)

	##### 	Step1: 类加载检查	

​		虚拟机遇到一条 new 指令时，首先将去检查这个指令的参数是否能在常量池中定位到这个类的符号引用，并且检查这个符号引用代表的类是否已被加载过、解析和初始化过。如果没有，那必须先执行相应的类加载过程。

#####  	Step2: 分配内存

​		类加载通过后, 为新生对象分配内存, 所需内存大小在类加载后便可确定. __分配方式__: __指针碰撞__,__空闲列表__. 		选择哪种方式由Java堆是否规整决定, 而Java堆是否规整又由所采用的垃圾收集器是否有压缩整理功能决定.

​	![Image text](<https://github.com/SecretsCC/Java-Algorithm/blob/master/knowledge%20point/images/memory%20allocation.png>)



##### 	Step3: 初始化零值 

​		保证了对象的实例字段在Java代码中可以不赋初始值直接使用

	##### 	Step4: 设置对象头

​		虚拟机对对象必要的设置, 例如这个对象是哪个类的实例, 如何才能找到类的元数据信息, 对象的哈希吗, 对象的GC分代年龄等信息.这些信息都保存在对象头中.

##### 	Step5: 执行Init方法

​		执行new指令之后执行init方法,把对象按照程序员的意愿进行初始化,一个真正的对象才算完全产出来



### 2.对象的内存布局

​	对象在内存中分为3块区域: __对象头,实例数据,对齐填充__

​	对象头包含两部分信息, 第一部分用于存储对象自身的自身运行时数据, 另一部分是类型指针, 虚拟机通过这个指针来确定这个对象是哪个类的实例

​	实例数据部分是对象那个真正存储的有效信息

​	对齐填充部分不是必然存在,仅仅起占位作用,8字节的倍数

### 3.对象的访问定位

​	Java程序通过栈上的reference数据来操作堆上的具体对象. 对象的访问由虚拟机实现而定, 主流访问方式__使用句柄__ 和__直接指针__ 

​	![Image text](<https://github.com/SecretsCC/Java-Algorithm/blob/master/knowledge%20point/images/handle%20access.png>)

![Image text](<https://github.com/SecretsCC/Java-Algorithm/blob/master/knowledge%20point/images/director%20pointer.png>)

​	**这两种对象访问方式各有优势。使用句柄来访问的最大好处是 reference 中存储的是稳定的句柄地址，在对象被移动时只会改变句柄中的实例数据指针，而 reference 本身不需要修改。使用直接指针访问方式最大的好处就是速度快，它节省了一次指针定位的时间开销。**



# 重点补充

### 1. String类和常量池

​	Stirng对象两种创建方式:

```Java
	String str1 = "abcd";	//先检查字符串常量池中有没有"abcd",如果没有,则创建一个，然后 str1 指向字符串常量池中的对象，如果有，则直接将 str1 指向"abcd"
	String str2 = new String("abcd"); //堆中创建一个新的对象
	String str3 = new String("abcd"); //堆中创建一个新的对象
	System.out.println(str1 == str2) //false
    System..outprintln(str2 == str3) //false
    //只要使用new, 便需要创建新的对象
```



![Image text](<https://github.com/SecretsCC/Java-Algorithm/blob/master/knowledge%20point/images/data%20storage.png>)

 - 直接使用双引号声明出来的String对象存储在常量池中

 - 如果不是用双引号声明, 可以使用String 提供的intern方法, String.intern()是一个Native方法, 作用是:如果常量池中已经包含一个等于此String对象内容的字符串, 则返回常量池中的引用, 如果没有, 在常量池中创建与此String内容相同的字符串,并返回常量池中创建的字符串的引用

 - ```Java
   	      String s1 = new String("计算机");
   	      String s2 = s1.intern();
   	      String s3 = "计算机";
   	      System.out.println(s2);//计算机
   	      System.out.println(s1 == s2); //false，因为一个是堆内存中的 String 对象一个是常量池中的 String 对象，
   	      System.out.println(s3 == s2);//true，因为两个都是常量池中的 String 对象
   ```

```java
		  String str1 = "str";
		  String str2 = "ing";
		 
		  String str3 = "str" + "ing";//常量池中的对象
		  String str4 = str1 + str2; //在堆上创建的新的对象	  
		  String str5 = "string";//常量池中的对象
		  System.out.println(str3 == str4);//false
		  System.out.println(str3 == str5);//true
		  System.out.println(str4 == str5);//false
```

__String s1 = new String("abc");这句话创建了几个字符串对象？__

​	**将创建 1 或 2 个字符串。如果池中已存在字符串文字“abc”，则池中只会创建一个字符串“s1”。如果池中没有字符串文字“abc”，那么它将首先在池中创建，然后在堆空间中创建，因此将创建总共 2 个字符串对象。**



### 2.8种基本类型的包装类和常量池

​	Byte, Short,Integer,Long,Character,Boolean 这五种包装类实现了常量池技术,默认创建了数值[-128,127]

​	Float,Double并没有实现常量池技术

```Java
		Integer i1 = 33;
		Integer i2 = 33;
		System.out.println(i1 == i2);// 输出 true
		Integer i11 = 333;
		Integer i22 = 333;
		System.out.println(i11 == i22);// 输出 false
		Double i3 = 1.2;
		Double i4 = 1.2;
		System.out.println(i3 == i4);// 输出 false
```