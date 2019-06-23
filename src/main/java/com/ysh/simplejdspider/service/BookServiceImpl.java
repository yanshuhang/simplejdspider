package com.ysh.simplejdspider.service;

import com.ysh.simplejdspider.dao.BookDao;
import com.ysh.simplejdspider.entity.Book;
import com.ysh.simplejdspider.util.SeleniumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void getInfo() {
        // 京东搜索书籍，第一页的url
        String url = "https://search.jd.com/Search?keyword=%E4%B9%A6&enc=utf-8&wq=shu&pvid" +
                "=9413d34bff68481e9a7e3815d8af67ce";
        // chrome驱动
        WebDriver driver = SeleniumDriver.chromeDriver();
        driver.get(url);
        //book实体列表 存储获取到的信息
        ArrayList<Book> books = new ArrayList<>();
        // 当前页数
        int pageNum = 1;
        while (pageNum < 5) {
            //滚动到页尾
            log.info("正在获取第 " + pageNum + " 页的数据...");
            long start = System.currentTimeMillis();
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,30000);");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<WebElement> listElements = driver.findElements(By.className("gl-item"));
            for (WebElement element : listElements) {
                String name = element.findElement(By.className("p-name")).findElement(By.tagName("em")).getText();
                String price = element.findElement(By.className("p-price")).findElement(By.tagName("i")).getText();
                //图片地址有多种结构，需要处理一下
                String pictureUrl =
                        element.findElement(By.className("p-img")).findElement(By.tagName("img")).getAttribute("src");
                if (pictureUrl == null) {
                    pictureUrl =
                            element.findElement(By.className("p-img")).findElement(By.tagName("img")).getAttribute(
                                    "data-lazy-img");
                    pictureUrl = "https:" + pictureUrl;
                }
                Book book = new Book();
                book.setName(name);
                book.setPrice(new BigDecimal(price));
                book.setPictureUrl(pictureUrl);
                books.add(book);
            }
            long end = System.currentTimeMillis();
            log.info("第 " + pageNum + " 页获取完成，获得 " + listElements.size() + " 条数据，用时 " + (end - start) + "ms");
            driver.findElement(By.className("pn-next")).click();
            pageNum++;
        }
        driver.close();
        log.info("获取了" + (pageNum - 1) + "页,共" + books.size() + "条数据");
        log.info("存入数据库...");
        // dao接口存储数据
        bookDao.addBooks(books);
        log.info("存储成功");
    }
}
