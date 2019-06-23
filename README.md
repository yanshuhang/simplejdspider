# simplejdspider
准备做个ssm练习项目，需要一些数据
写个简单的爬虫，使用selenium实现，爬取商品名称、价格、图片地址，可以修改页数爬取多页
基于springboot，mysql、mybatis配置更容易
数据库需要自己创建，启动springboot 爬虫即可启动

selenium需要下载chrome浏览器和chromeDriver驱动，
selenium 详细介绍 https://blog.csdn.net/qq_22003641/article/details/79137327，
驱动下载地址：https://npm.taobao.org/mirrors/chromedriver，
驱动默认放到文件夹d:/seleniumdriver/chromedriver.exe可以更换，在util/SeleniumDriver.java中修改
