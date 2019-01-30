# Android:具体内容看有道云笔记Android of Accenture
Some example of Android

Homework完成的内容：
Day 01 Learning guide
1.	Java
基础语法(重点掌握 -> 定义、基础使用)
运算符
数组
方法 e.g. 重写 重载
条件控制 e.g. if...else  for  switch
常量&变量 
static & final 修饰符

集合(会用)
Map e.g. HashMap
Set e.g. HashSet
List e.g. ArrayList
泛型(理解)
http://www.runoob.com/java/java-collections.html

String(熟练掌握 -> 会使用常用的方法、会查文档)
http://www.runoob.com/java/java-string.html

面向对象(理解)
接口 Interface
类 Class
访问修饰符 e.g. private public
继承
多态
封装
2.	JSON
基础定义
{} 对象
[ ] 数组

Gson(熟练使用)
https://github.com/google/gson
Android Studio中使用插件生成Model
3.	Android Studio
安装指南
https://developer.android.google.cn/studio/

创建你的第一个Android App
https://developer.android.google.cn/training/basics/firstapp/creating-project
4.	Homework
概要说明:
在MainActivity中调用SearchHandler的searchFlight()方法，把返回值flight data size：4显示在界面上，在console里用JSON格式输出 flight list data
注意尽可能运用上学习目标上提及到的Java知识点
定义说明:
FlightModel:
包含以下成员变量
departure
arrival
flightNo

SearchHandler:
包含initData()、searchFlight()和printAllFlight方法
initData()
初始化Flight Data列表集合
printAllFlightInfo()
重写FlightModel中的toString()方法, return该类中的所有成员变量
用for循环配合Log.d()调用toString()输出所有fligt info
searchFlight()
用Log.d()输出flight list data(Json格式)
调用printAllFlight()方法
返回flight data size info 

Flight list Json data:
[
  {
    "arrival": "PEK",
    "departure": "HKG",
    "flightNo": "CX888"
  },
  {
    "arrival": "JFK",
    "departure": "HKG",
    "flightNo": "CX777"
  },
  {
    "arrival": "SIN",
    "departure": "HKG",
    "flightNo": "CX666"
  },
  {
    "arrival": "CUU",
    "departure": "HKG",
    "flightNo": "CX555"
  }
]

console output info:

FlightModel{departure='HKG', arrival='PEK', flightNo='CX888'}
FlightModel{departure='HKG', arrival='JFK', flightNo='CX777'}
FlightModel{departure='HKG', arrival='SIN', flightNo='CX666'}
FlightModel{departure='HKG', arrival='CUU', flightNo='CX555'}
评分标准(10分满 6分及格)：
能按照描述要求定义FlightModel类与SearchHandler类(1分)
能正确定义initData()、searchFlight()和printAllFlight方法  (1分)
能正确重写toString(1分)
能正确使用Gson处理json(1分)
正确在界面上输出“flight data size：4”(3分)
正确在console上输出 flight的 json list data(3分)

DayTwo:
Day 02 Learning guide
1. 入门部分
Android系统概貌​​
Android项目结构(掌握)
-	Android Project
	-	app()
    		-	build()
        	-	libs()
        	-	src()
            		-	androidTest()
           		-	main()
          			-	AndroidManifest.xml()
            			-	java()
               			-	res()
                			-	layout()
                        		-	values()
                        		-	drawable()
                        		-	drawable-x()
                        		-	mipmap-x()
                	-	test()
                	-	build.gradle()
        -	build.gradle()
build.gradle(会看会改)
compileSdkVersion
minSdkVersion
targetSdkVersion
dependencies
AndroidManifest(掌握)
会看会改，了解里面大致能配置什么当用到的时候知道在哪里可以查询：
https://developer.android.google.cn/guide/topics/manifest/manifest-intro?hl=zh-cn
调试日志输出(掌握)
Log
Toast
2. 系统主要组件
Application(掌握)
简介
Application的自动创建：每一个应用程序在运行时，系统都会自动帮你创建一个application类的对象，并且只会创建一个它是个单例，一般会用它来做一些全局初始化, 譬如常用到的第三方数据库、图片加载器、日志系统等等。
生命周期
初始化第三方lib一般放在什么方法？
定义static变量放在Application作为全局变量使用会有什么危险？
四大组件
Activity(重中之重)
如何创建
如何使用
生命周期(超级重点)
正常情况下的生命周期
​​
异常情况下的生命周期
​​

启动模式
standard
singleTop
singleTask
singleInstance
Service(掌握)
生命周期
基本使用(开启，关闭)
bindService & startService开启的区别
什么是远程服务什么是本地服务
线程与Service有什么区别？
Broadcast Receiver(了解会用)
生命周期
动态广播与静态广播是什么？有什么区别？
有序广播无序广播是什么?有什么区别
Content Provider(了解会用)
共同特点
都需要Intent启动
都需要在AndroidManifest.xml中配置
Intent(熟练掌握)
显式Intent
隐式Intent
IntentFilter
如何传输数据
数据传输会有大小限制吗？
3. UI(重中之重)
View
一切UI组件都是View，布局也是View
​​
Xml
Xml是界面结构的描述文件, Xml在实际运行中会将内容解析成View 显示在Activity中
可以把界面XML想象成一个没有气的气球，在实际使用的时候相当于给它充了气，然他充满活力
布局
FrameLayout
LinearLayout
RelativeLayout
布局原则
在实现界面时布局选择的优先级
Framlayout > Learlayout > RelativeLayout
为保绘制效率，应该用尽可能少的布局嵌套去完成界面的布局实现
单位
什么是dp 什么是sp
常用UI控件(不完整)
TextView
EditText
Button
RadioButton
RadioGroup
4. Homework
概述
1.	 进入app后首先会启动一个Service，该Service在开启5秒后在后台会打印一行“run: MyService done”的log并且立刻结束该Service，在Service结束后会在后台打印一行“onDestroy”的log，如下图
​​
2.	按手机主菜单键返回桌面, 然后再次启动程序，这时后台会打印一行“reShow”的log，如下图
​​
3.	输入arrival后点击按钮“Go to Summary”，来到Summary界面在界面中显示上一个界面带过来的arrival信息。
4.	当点击“go to home page”后，界面会跳转到第一个界面，这时按返回键应用程序会退出到桌面(如果不会回到桌面,证明结果不对)
MainActivity
​​
SummaryActivity
​​

DetailActivity

​​

MainActivity UI 标注
​​
评分标准(10分满 6分及格)：
基础UI的使用 (1分)
灵活运用布局进行界面排版 (2分)
Activity和Service的基础使用 (1分)
Activity的启动模式 (2分)
Activity的生命周期 (2分)
Intent的基础使用 (1分)
Log日志工具的使用 (1分)


UiTrainingDemos-master>TabLayoutDemo
Day 03 Learning guide
1.	 UI(重中之重)
Fragment
如何创建？
什么是FragmentMannerger?
什么是事务
replace() 与 add()绑定Activity的区别?
Fragment与Activity之间怎么传递参数？
生命周期
​​
与Activity的生命周期相比较
​​
常用UI控件
ImageView(掌握)
了解scaleType
要知道不可以在内存中加载大图 e.g. 大于3M图片
ProgressBar(了解)
了解如何使用条形进度条与圆形进度条
CheckBox(了解)
ScrollView(了解)
要知道如何解决嵌套RecyclerView带来的事件冲突 (NestedScrollView)
对话框(掌握)
Popupwindow
Dialog
Popupwindow 与 Dialog之间的区别。
复杂UI控件
RecycleView(重点掌握)
理解Item元素的复用机制，理解Holder
会写Adapter，并理解Adapter的含义
如何更新列表？
LayoutManager是什么？
多类型Item的情况要如何实现？
为什么说RecycleView性能很高？
ViewPager(重点掌握)
理解Item元素的复用机制，理解Holder
会写Adapter，并理解Adapter的含义
如何与Tablayout实现联动效果
SwipeRefreshLayout(下拉刷新)
会基本使用
会配置样式
知道如何实现下拉刷新函数
DrawerLayout(抽屉式菜单)
Tablayout
2. Handler(掌握)
什么是Handler？运行原理是怎么样的？
​​
什么是ANR？ 发生ANR的原因什么是？
如何使用Handler? 如何配合更新UI？
3. Homework
概述
该App只有一个Activity
该Activity有两个标签栏, 一个是下载页界面,另一个是列表界面
下载页界面(参考下图)
原始状态下的下载页界面只会显示 download 与reset两个button和一个progressbar， 图片不会显示，但是会占据一部分空间。
当点击download时模拟下载图片的场景，每一秒增加10进度并且同时更新进度文字，当进度达到100时,进度条会停止增加，并且图片会显示出来
当点击reset时，一切会恢复最开始的状态(图片不显示,进度条为0)
列表界面(参考下图)
列表界面有两种item类型, 一种是header，另种是content。
mock一些data (item x) 进行列表的展示
列表界面具有下拉刷新功能。需要自定义一个dialog 作为 loading dialog
当下拉时弹出loading dialog，延迟4秒,模拟网络请求的效果。然后隐藏loading dialog 并且用随机数更新列表内容。
下载界面
初始状态(下载)
​​
完成状态(下载)
图片可以随便网上下载一张放在本地项目
​​
列表界面
初始状态(列表)
​​
模拟等待刷新(列表)
​​
刷新完毕(列表)
​​

评分标准(10分满 6分及格)：
下载页界面(1分)
原始状态下的下载页界面只会显示 download 与reset两个button和一个progressbar， 图片不会显示，但是会占据一部分空间。(1分)
当点击download时模拟下载图片的场景，每一秒增加10进度并且同时更新进度文字，当进度达到100时,进度条会停止增加，并且图片会显示出来(1分)
当点击reset时，一切会恢复最开始的状态(图片不显示,进度条为0)(1分)
列表界面(1分)
列表界面有两种item类型, 一种是header，另种是content。(1分)
mock一些data (item x) 进行列表的展示(1分)
列表界面具有下拉刷新功能。需要自定义一个dialog 作为 loading dialog(1分)
当下拉时弹出loading dialog，延迟4秒,模拟网络请求的效果。然后隐藏loading dialog 并且用随机数更新列表内容。(2分)
