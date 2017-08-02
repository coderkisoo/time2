# time2


---
## 简介

顾名思义，这是我做的app**时煎**的第二版。在第一版中，我不懂框架结构，设计模式，对于各种Api的使用也是一知半解，基本就是用基本空间堆砌起来的APP。所以，推出第二版，算是对第一版的改良，也算是重新将整个App完成一遍。

## 使用的框架
* 采取了M-V-VM架构，使用了google在2015年IO大会推出的dataBinding。使用了大半年的MVP模式，想尝试一种新模式，MVP在我心里始终需要改良。而M-V-VM提高了xml文件在整体app的地位，将data与view互相绑定，使用viewmodel对数据进行修改以达到修改UI的效果

* 使用了dagger2，将vm注入activity，再将binding与vm绑定，便于单元测试

* 依照Material Design-Google推行的材料设计，来对整个app的界面进行规范（design包）

* 使用了rxJava这类函数式编程框架

* 图片加载库使用了glide，没有fresco那么庞大

* lambda

* 主题更换使用bilibili的magicasakura

* 后台决定使用Bmob

* 持久化数据存储使用realm，号称远超sqlite的效率，实际使用并未发现，其数据绑定的思想与databinding的思想吻合
___

### 暂定以上

## 已知bug：
 * ~~点击mainFragment上面的imageView无反应~~

___

## 更新：

### 2016.12.21-15:24:

 * 自定义view，字体设置的展板（第一版），感兴趣的同学们可以将downloadView 这个model自行pull下来查阅。

### 2016.12.19-22:12:

 * 解决了Bmob和GalleryFinal的冲突问题。


### 2016.11.17-16:42:

 * 修改了~~点击mainFragment上面的imageView无反应~~的bug。
 * 新增了SettingVM


### 2016.11.17-0:54:

 * 设置界面的item彻底解耦，使用了三种不同的View，可以点击的，可以滑动的，以及空的。

 * bindingAdapter 使用Glide来加载imageView上的图片。

### 2016.11.10-17:58:

 * 将settingFragment和mainFragment与viewModel使用dagger2依赖注入

 * 修改了BaseViewModel以及BaseFragmentModule

### 2016.11.10-1:30：

 * 更新了左侧的menu色彩，及与fragment的映射
 
 * 更改了架构（暂定）
 
 * 重构了部分代码
