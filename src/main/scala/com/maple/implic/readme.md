## 隐式解析机制
> 即编译器是如何查找到缺失信息的，解析具有以下两种规则：

#### 1.首先会在当前代码作用域下查找`隐式实体`（隐式方法  隐式类 隐式对象）
 
#### 2.如果第一条规则查找隐式实体失败，会继续在隐式参数的类型的作用域里查找

类型的作用域是指与该类型相关联的全部伴生模块，一个隐式实体的类型`T`
它的查找范围如下：
- 如果T被定义为T with A with B with C,那么A,B,C都是T的部分，在T的隐式解析过程中，它们的伴生对象都会被搜索
- 如果T是参数化类型，那么类型参数和与类型参数相关联的部分都算作T的部分，比如List[String]的隐式搜索会搜索List的
伴生对象和String的伴生对象
- 如果T是一个单例类型p.T，即T是属于某个p对象内，那么这个p对象也会被搜索
- 如果T是个类型注入S#T，那么S和T都会被搜索

## 隐式转换的前提：
1.不存在二义性（如例1）
 
2.隐式操作不能嵌套使用（如 convert1(covert2(x))）+y
 
3.代码能够在不使用隐式转换的前提下能编译通过，就不会进行隐式转换
