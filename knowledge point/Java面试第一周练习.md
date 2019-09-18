# Java面试第一周练习

#### Java中只有值传递

​	**按值调用(call by value)表示方法接收的是调用者提供的值，而按引用调用（call by reference)表示方法接收的是调用者提供的变量地址。一个方法可以修改传递引用所对应的变量值，而不能修改传递值调用所对应的变量值。** 它用来描述各种程序设计语言（不只是Java)中方法参数传递方式。

**Java程序设计语言总是采用按值调用。也就是说，方法得到的是所有参数值的一个拷贝，也就是说，方法不能修改传递给它的任何参数变量的内容。**



#### ArrayList和LinkedList区别

​	ArrayList是基于动态数组的数据结构,LinkedList是基于链表的数据结构

​	对于随机访问get和set,ArrayList优于LinkedList,因为Linkedlist要移动指针

​	对于新增和删除add和remove,LinkedList占优

​	__源码分析__:

​		ArrayList:

​		ArrayList是线程不安全的,适合用于对元素的查找,一般是改变位置和操作元素,所以多线程环境下不能保证原子性		

```java
/**
 * 默认初始化容量
 */
private static final int DEFAULT_CAPACITY = 10;

/**
 * 如果自定义容量为0，则会默认用它来初始化ArrayList。或者用于空数组替换。
 */
private static final Object[] EMPTY_ELEMENTDATA = {};

/**
 * 如果没有自定义容量，则会使用它来初始化ArrayList。或者用于空数组比对。
 */
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

/**
 * 这就是ArrayList底层用到的数组

 * 非私有，以简化嵌套类访问
 * transient 在已经实现序列化的类中，不允许某变量序列化
 */
transient Object[] elementData;

/**
 * 实际ArrayList集合大小
 */
private int size;

/**
 * 可分配的最大容量
 */
private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

/**
* 构造方法,带参数版本
*/
public ArrayList(int initialCapacity){
    if(initialCapacity > 0){
        this.elementData = new Object[initialCapacity];
    }else if(initialCapacity == 0){
        this.elementData = EMPTY_ELEMENTDATA;
    }else{
        throw new IllegalArgumentException("Illegal Capacity:" + initialCapacity);
    }
}

/**
*不带参数的构造方法,默认容量为10
*/
public ArrayList(){
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}

/**
*	通过集合做参数的形式初始化
*/
public ArrayList(Collection<? extends E> c){
    elementData = c.toArray();
    if((size = elementData.length) != 0){
        if(elementData.getClass() != object[].class)
            elementData = Arrays.copyOf(elementData,size,Object[].class);
    }else{
        this.elementData = EMPTY_ELEMENTDATA;
    }
}

//主干方法
/**
* 最小化实例存储
*/
public void trimTosize(){
    modCount++;
    if(size < elementData.length){
        elementData = (size == 0) ? EMPTY_ELEMENTDATA : Arrays.copyof(elementData,size);
    }
}

/**
* clone方法()
*/
public Object clone(){
    try{
        ArrayList<?> v = (ArrayList<?> super.clone());
        v.elementData = Arrays.copyOf(elementData,size);
        v.modCount = 0;
        return v;
    }catch (CloneNotSupportedException e){
        throw the InternalError(e);
    }
}
//通过调用Object的clone方法来得到一个新的ArrayList对象,然后将elementData复制给该对象并返回

/**
*  add(E e) 方法
*/
public boolean add(E e){
    ensureCapacityIntern(size + 1);
    elementData[size++] = e;
    return true;
}
//调用了ensureCapacityIntern, size + 1 !!!!! 
private void ensureCapacityInternal(int minCapacity){
    ensureExplicitCapacity(calculateCapacity(elementData,minCapacity));
}

//这个方法里又调用了两个方法,计算容量和确保容量
private static int calculateCapacity(Object[] elementData, int minCapacity){
    if(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
        return Math.max(DEFAULT_CAPACITY,minCapacity);
    }
    return minCapacity;
}
// 如果size + 1 > elementData.length 证明数组已经放满,则增加容量,调用grow()
private static int ensureExplicitCapacity(Object[] elementData, int minCapacity){
    modCount++;
    if(minCapacity - elementData.length > 0){
        grow(minCapacity);
    }
}
/**
* 默认1.5倍扩容,
*/
private void grow(int minCapacity){
	int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if(newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if(newCapacity - MAX_ARRAY_SIZE > 0)
   		newCapacity = hugeCapacity(minCapacity);
    elementData = Arrays.copyOf(elementData, newCapacity);
}
//size + 1 的问题
size + 1 代表的含义是:
	1. 如果集合添加元素成功后,集合中的实际元素个数
	2. 为了确保扩容不会出现错误
	加入不加以处理, 如果默认size是0,则0+0>>1还是0

/**
* add(int index, E element)
*/
public void add(int index, E element){
	rangeCheckForAdd(index);
	
	ensureCapacityInternal(size + 1);
	System.arraycopy(elementData, index, elementData, index + 1, size - index);
	elementData[index] = element;
	size++;
}

private void rangeCheckForAdd(int index) {
    if (index > size || index < 0)
        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
}

public E set(int index, E element) {
    rangeCheck(index);

    E oldValue = elementData(index);
    elementData[index] = element;
    return oldValue;
}

E elementData(int index) {
    return (E) elementData[index];
}

public int indexOf(Object o) {
    if (o == null) {
        for (int i = 0; i < size; i++)
            if (elementData[i]==null)
                return i;
    } else {
        for (int i = 0; i < size; i++)
            if (o.equals(elementData[i]))
                return i;
    }
    return -1;
}

public E get(int index) {
    rangeCheck(index);

    return elementData(index);
}

public E remove(int index) {
    // 检测index是否合法
    rangeCheck(index);
    // 数据结构修改次数
    modCount++;
    E oldValue = elementData(index);

    // 记住这个算法
    int numMoved = size - index - 1;
    if (numMoved > 0)
        System.arraycopy(elementData, index+1, elementData, index,
                         numMoved);
    elementData[--size] = null; // clear to let GC do its work

    return oldValue;
}
```

transient 关键字:

​	作用是让某些成员属性不被序列化



LinkList源码

``` java
/**
 * 集合元素数量
 **/
transient int size = 0;

/**
 * 指向第一个节点的指针
 * Invariant: (first == null && last == null) ||
 *            (first.prev == null && first.item != null)
 */
transient Node<E> first;

/**
 * 指向最后一个节点的指针
 * Invariant: (first == null && last == null) ||
 *            (last.next == null && last.item != null)
 */
transient Node<E> last;

//构造方法
public LinkedList(){
    
}

//将集合c所有元素插入链表中
public LinkedList(Collection<? extends E> c){
    this();
    addAll(c);
}

private static class Node(E){
    E item;
    Node<E> next;
    Node<E> prev;
    Node(Node<E> prev,E element, Node<E> next){
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}

//添加元素
public boolean addAll(Collection<? extends E> c){
    return addAll(size,c);
}

public boolean addAll(int index, Collection<? extends E> c){
    checkPositionIndex(index);
    Object[] a = c.toArray();
    
    int numNew = a.length;
    if(numNew == 0){
        return false;
    }
}
```





####  ConcurrentModificationException异常出现原因

```java
public class Test {
    public static void main(String[] args)  {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                list.remove(integer);
        }
    }
}
```

上段代码会抛出ConcurrentModificationException异常

因为调用list.remove()方法导致modCount和expectedmodCount的值不一样

解决: 在迭代器中删除元素的话,需要调用iterator的remove方法



#### HashMap, HashTable, ConcurrentHashMap区别

​	相同点:

  1. HashMap和Hashtable都实现了Map接口

		2. 都可以存储key-value数据

     不同点:

     1. HashMap可以把null作为key或value，HashTable不可以
     2. HashMap线程不安全，效率高。HashTable线程安全，效率低。
     3. HashMap的迭代器(Iterator)是fail-fast迭代器，而Hashtable的enumerator迭代器不是fail-fast的。

     > 什么是fail-fast?
     > 就是最快的时间能把错误抛出而不是让程序执行。

Java5 提供了ConcurrentHashMap,是HashTable的替代, 比HashTable扩展性更好

__让HashMap同步__:

​		Map m = Collections.synchronizedMap(hashMap);





#### 线程创建的方式

​	方法1: 继承Thread类,作为线程对象存在

``` java
public class CreatThreadDemo1 extends Thread{
    /**
     * 构造方法： 继承父类方法的Thread(String name)；方法
     * @param name
     */
    public CreatThreadDemo1(String name){
        super(name);
    }

    @Override
    public void run() {
        while (!interrupted()){
            System.out.println(getName()+"线程执行了...");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CreatThreadDemo1 d1 = new CreatThreadDemo1("first");
        CreatThreadDemo1 d2 = new CreatThreadDemo1("second");

        d1.start();
        d2.start();

        d1.interrupt();  //中断第一个线程
    }
}
```

方法二: 实现runnable接口,作为线程任务存在

``` java
public class CreatThreadDemo2 implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println("线程执行了...");
        }
    }

    public static void main(String[] args) {
        //将线程任务传给线程对象
        Thread thread = new Thread(new CreatThreadDemo2());
        //启动线程
        thread.start();
    }
}
```

runnable知识修饰线程所执行的任务,不是一个线程对象,想要启动runnable对象,必须将它放到一个线程对象里





#### java线程池

Executors提供了四种方法来创建线程池

 	1. newFixedThreadPool(): 创建固定大小的线程池
 	2. newCachedThreadPool(): 创建无限大小的线程池, 线程池中线程数量不固定,可根据需求自动更改
 	3. newSingleThreadPool(): 创建单个线程池, 线程池中只有一个线程
 	4. newScheduledThreadPool(): 创建固定大小的线程池,可以延迟或定时执行的任务

线程池作用: 

​	限制线程个数,避免线程过多导致系统运行缓慢或崩溃

​	不需要频繁的创建和销毁,节约资源,响应更快



#### Math.round(-2.5) 等于多少

口诀: +0.5后向下取整, 结果是-2

Math.round(-2.6) 结果是-3



#### 面向对象6大原则

​	

1. 单一职责原则——SRP

> 让每个类只专心处理自己的方法。

2. 开闭原则——OCP

> 软件中的对象(类，模块，函数等)应该对于扩展是开放的，但是对于修改是关闭的。

3. 里式替换原则——LSP

> 子类可以去扩展父类，但是不能改变父类原有的功能。

4. 依赖倒置原则——DIP

> 应该通过调用接口或抽象类(比较高层)，而不是调用实现类(细节)。

5. 接口隔离原则——ISP

> 把接口分成满足依赖关系的最小接口，实现类中不能有不需要的方法。

6. 迪米特原则——LOD

> 高内聚,低耦合。



#### static和final的区别

​	![Image text](<https://github.com/SecretsCC/Java-Algorithm/blob/master/knowledge%20point/images/static%20final.png>)



#### String s = "hello"和String s = new String("hello");区别

`String s = new String("hello");`可能创建两个对象也可能创建一个对象。如果常量池中有`hello`字符串常量的话，则仅仅在堆中创建一个对象。如果常量池中没有`hello`对象，则堆上和常量池都需要创建。

`String s = "hello"`这样创建的对象，JVM会直接检查字符串常量池是否已有"hello"字符串对象，如没有，就分配一个内存存放"hello"，如有了，则直接将字符串常量池中的地址返回给栈。(没有new，没有堆的操作)



#### Java中的switch选择结构可以使用数据类型的数据

​	

1. char
2. byte
3. short
4. int
5. Character
6. Byte
7. Short
8. Integer
9. String
10. enum

更好的记忆方法:

基本类型中，没有`boolean`和`浮点类型`+`长类型long`.相应的包装类型也没有。

外加`String`和`enum`。



#### JVM垃圾清理算法

###### 标记-清除算法（老年代）

该算法分为“标记”和“清除”两个阶段: 首先标记出所有需要回收的对象(可达性分析), 在标记完成后统一清理掉所有被标记的对象.

![img](https://mmbiz.qpic.cn/mmbiz_png/eQPyBffYbuf0rZDLWoicAbX7cP1O2y357BLr4l5LR2pXFGmn8Iu5vM16icGwMpTUbuNdiaF6lvxyOzMjWAGXoNUibg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

该算法会有两个问题：

1. 效率问题，标记和清除效率不高。
2. 空间问题: 标记清除后会产生大量不连续的内存碎片, 空间碎片太多可能会导致在运行过程中需要分配较大对象时无法找到足够的连续内存而不得不提前触发另一次垃圾收集。

所以它一般用于"垃圾不太多的区域，比如老年代"。

###### 复制算法（新生代）

该算法的核心是将可用内存按容量划分为大小相等的两块, 每次只用其中一块, 当这一块的内存用完, 就将还存活的对象（非垃圾）复制到另外一块上面, 然后把已使用过的内存空间一次清理掉。

优点：不用考虑碎片问题，方法简单高效。

缺点：内存浪费严重。

现代商用VM的新生代均采用复制算法，但由于新生代中的98%的对象都是生存周期极短的，因此并不需完全按照1∶1的比例划分新生代空间，而是将新生代划分为一块较大的Eden区和两块较小的Survivor区(HotSpot默认Eden和Survivor的大小比例为8∶1), 每次只用Eden和其中一块Survivor。

当发生MinorGC时，将Eden和Survivor中还存活着的对象一次性地拷贝到另外一块Survivor上， 最后清理掉Eden和刚才用过的Survivor的空间。当Survivor空间不够用(不足以保存尚存活的对象)时，需要依赖老年代进行空间分配担保机制，这部分内存直接进入老年代。

![img](https://mmbiz.qpic.cn/mmbiz_png/eQPyBffYbuf0rZDLWoicAbX7cP1O2y357uybqCKaiaXyDJ8wvpxf4ftLEeibTdMcV5ParGstkAZSKOETXXfdMcC5g/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

**复制算法的空间分配担保：**
在执行Minor GC前, VM会首先检查老年代是否有足够的空间存放新生代尚存活对象, 由于新生代使用复制收集算法, 为了提升内存利用率, 只使用了其中一个Survivor作为轮换备份, 因此当出现大量对象在Minor GC后仍然存活的情况时, 就需要老年代进行分配担保, 让Survivor无法容纳的对象直接进入老年代, 但前提是老年代需要有足够的空间容纳这些存活对象. 

但存活对象的大小在实际完成GC前是无法明确知道的, 因此Minor GC前, VM会先首先检查老年代连续空间是否大于新生代对象总大小或历次晋升的平均大小, 如果条件成立, 则进行Minor GC, 否则进行Full GC(让老年代腾出更多空间).

然而取历次晋升的对象的平均大小也是有一定风险的, 如果某次Minor GC存活后的对象突增,远远高于平均值的话,依然可能导致担保失败(Handle Promotion Failure, 老年代也无法存放这些对象了), 此时就只好在失败后重新发起一次Full GC(让老年代腾出更多空间).

------

###### 标记-整理算法（老年代）

标记清除算法会产生内存碎片问题, 而复制算法需要有额外的内存担保空间, 于是针对老年代的特点, 又有了标记整理算法. 标记整理算法的标记过程与标记清除算法相同, 但后续步骤不再对可回收对象直接清理, 而是让所有存活的对象都向一端移动,然后清理掉端边界以外的内存.



#### 新生代,老年代,持久带都存储哪些东西

​	新生代:

​		方法中new一个对象,就会先进入新生代

​	老年代:

​		新生代中经历N此垃圾回收仍然存活的对象就会被放到老年代中

​		大对象一般直接放入老年代

​		当Survivor空间不足, 需要老年代担保一些空间,也会将对象放入老年代

​	永久带:

​		指的是方法区



#### Java对象存活分析

​	引用计数法&可达性分析

​	