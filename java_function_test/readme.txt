ava8所有的新特性基本基于函数式编程的思想，函数式编程的带来，给Java注入了新鲜的活力。

下面来近距离观察一下函数式编程的几个特点：

函数可以作为变量、参数、返回值和数据类型。
基于表达式来替代方法的调用
函数无状态，可以并发和独立使用
函数无副作用，不会修改外部的变量
函数结果确定性；同样的输入，必然会有同样的结果。



1、Function
    将参数T传递给一个函数，返回R

2、Predicate
    Predicate是一个谓词函数，主要作为一个谓词演算推导真假值存在，返回布尔值的函数。Predicate等价于一个Function的boolean型返回值的子集。

3、Consumer
    Consumer是从T到void的一元函数，接受一个入参但不返回任何结果的操作。
    Consumer最常用的肯定是   default void forEach(Consumer<? super T> action) {}
    这是一段forEach循环的代码，传入实现的方法，并不返回任何值。只是循环。

4、Supplier
    接口仅包含一个无参的方法： T get() 。用来获取一个泛型参数指定类型的对象数据


5、Function接口: apply，andThen，compose
    apply：执行逻辑
    compose：先执行compose，再执行 apply
    andThen：先执行apply，再执行 andThen
6、


