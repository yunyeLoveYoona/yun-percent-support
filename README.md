# yun-percent-support
根据百分比设置控件的宽高，margin，padding等属性


谷歌新推出了根据百分比设置控件宽高等属性的支持包，试着自己实现并增加一些新的特性，让我们可以像写html那样写布局文件，以及
尽量减少因屏幕适配带来的工作量。


可以同时根据父控件的高度或者宽度的百分比设置控件的width,height,margin,padding


通过重写Relativitylayout，Linearlayout以及Framelayout来实现此功能，可以嵌套使用，子控件的大小是根据父控件的大小的百分比来确定的


![image](https://github.com/yunyeLoveYoona/yun-percent-support/blob/master/app/src/main/res/drawable-mdpi/a.png)

 
