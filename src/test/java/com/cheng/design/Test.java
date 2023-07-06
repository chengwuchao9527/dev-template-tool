package com.cheng.design;

/**
 * @author chengwuchao
 * @date 2023/6/26
 */
 class Test {
    private boolean flag = false;

    @org.junit.jupiter.api.Test
    public void singletonTest(){
        Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("线程1执行了" + "flag = " + flag);
            // 如果 flag 变量为 true 就终止执行
            while (!flag) {
                System.out.println("线程1");
            }
            System.out.println("终止执行");
        }
    });
        t1.start();
        // 1s 之后将 flag 变量的值修改为 true
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2执行了");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("设置 flag 变量的值为 true！");
                flag = true;
            }
        });
        t2.start();
    }
}


