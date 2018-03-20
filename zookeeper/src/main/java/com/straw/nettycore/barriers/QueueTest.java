package com.straw.nettycore.barriers;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class QueueTest {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        final Queue<Book> queue = new Queue<Book>("192.168.2.105:2181", "/queue");
        int n = 4;
        for (int i=0;i<n;i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"开始写书了");
                    queue.produce(new Book("红楼梦"+ finalI,1000,"曹雪芹",new Date()));
                    countDownLatch.countDown();
                }
            }).start();
        }
        for (int i=0;i<n+1;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Book consume = queue.consume(Book.class);
                    System.out.println(consume.name);
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                queue.produce(new Book("红楼梦终极版" ,1000,"曹雪芹",new Date()));
                countDownLatch.countDown();
            }
        }).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class Book{
        public Book() {
        }

        public Book(String name, Integer page, String author, Date createDate) {
            this.name = name;
            this.page = page;
            this.author = author;
            this.createDate = createDate;
        }

        String name;
        Integer page;
        String author;
        Date createDate;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Date getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Date createDate) {
            this.createDate = createDate;
        }
    }
}
