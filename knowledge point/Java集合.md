# Java集合

## List,Set,Map

- List(对付顺序的好帮手): List接口存储一组不唯一有序的对象
- Set(注重独一无二的性质): 不允许重复的集合。不会有多个元素引用相同的对象
- Map(用key来搜索的专家): 使用键值对 ,key不能重复



## ArrayList与LinkedList区别

1. **是否保证线程安全:**ArrayList和LinkedList都是不同步的,不保证线程安全

2. **底层数据结构:** ArrayList底层使用Object数组; LinkedList底层使用双向链表数据结构(JDK1.6之前为循环链表, JDK1..7取消循环)
3. **插入和删除是否受元素位置的影响:** 
   1. ArrayList采用数组存储,所以插入和删除元素的时间复杂度受元素位置影响,如果添加在末尾复杂度O(1),如果插入在指定位置add(index,element),时间复杂度O(n - i), 插入位置后的元素 都要后移
   2. LinkedList采用链表存储,所以插入删除不受位置影响都是O(1)
4. **是否支持快速随机访问:** LinkedList不支持高效的随机访问,而ArrayList支持。
5. **内存空间占用:** ArrayList的空间浪费主要体现在list列表结尾会预留一定的容量空间,LinkedList的空间花费体现在每一个元素都要消耗比ArrayList更多的空间(因为要存放直接后继和前驱以及数据)



## ArrayList与Vector的区别

Vector类的所有方法都是同步的,可以由两个线程安全地访问一个Vector对象,但是一个线程访问Vector的话要在同步操作上耗费大量时间

ArrayList不是同步的



## HashMap 和Hashtable区别

 	1. **线程是否安全:** HashMap是非线程安全的,HashTable是线程安全的
 	2. **效率:** 因为线程安全的问题, HashMap要比HashTable效率高一点, 另外HashTable基本被淘汰
 	3. **对Null的支持:** HashMap中null可以作为键, 这样的键只有一个, 值可以有多个
 	4. **底层数据结构:** Java1.8后链表长度大于8时,转为红黑树

## HashMap 和HashSet

|             HashMap              |                           HashSet                            |
| :------------------------------: | :----------------------------------------------------------: |
|          实现了Map接口           |                         实现Set接口                          |
|            存储键值对            |                          仅存储对象                          |
|  调用 `put（）`向map中添加元素   |              调用 `add（）`方法向Set中添加元素               |
| HashMap使用键（Key）计算Hashcode | HashSet使用成员对象来计算hashcode值，对于两个对象来说hashcode可能相同，所以equals()方法用来判断对象的相等性， |



#### HashSet 如何检查重复

当你把对象加入`HashSet`时，HashSet会先计算对象的`hashcode`值来判断对象加入的位置，同时也会与其他加入的对象的hashcode值作比较，如果没有相符的hashcode，HashSet会假设对象没有重复出现。但是如果发现有相同hashcode值的对象，这时会调用`equals（）`方法来检查hashcode相等的对象是否真的相同。如果两者相同，HashSet就不会让加入操作成功。（摘自我的Java启蒙书《Head fist java》第二版）

**hashCode（）与equals（）的相关规定：**

1. 如果两个对象相等，则hashcode一定也是相同的
2. 两个对象相等,对两个equals方法返回true
3. 两个对象有相同的hashcode值，它们也不一定是相等的
4. 综上，equals方法被覆盖过，则hashCode方法也必须被覆盖
5. hashCode()的默认行为是对堆上的对象产生独特值。如果没有重写hashCode()，则该class的两个对象无论如何都不会相等（即使这两个对象指向相同的数据）。

**==与equals的区别**

1. ==是判断两个变量或实例是不是指向同一个内存空间 equals是判断两个变量或实例所指向的内存空间的值是不是相同
2. ==是指对内存地址进行比较 equals()是对字符串的内容进行比较
3. ==指引用是否相同 equals()指的是值是否相同



JDK1.8后 HashMap由数据+链表+红黑树组成



## comparable和Comparator的区别

