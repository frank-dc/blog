package org.frank.reference.special_class.StringBuffer.function;
/*
    添加功能：
        1. public synchronized StringBuffer append(String str): 往已有的数据后面追加数据
        2. public synchronized StringBuffer insert(int offset, String str)：往指定位置插入数据

    删除功能：
        1. public synchronized StringBuffer delete(int start, int end): 删除一段字符串
        2. public synchronized StringBuffer deleteCharAt(int index): 删除指定位置的字符

    替换功能：
        public synchronized StringBuffer replace(int start, int end, String str): 替换一段字符串

    反转功能：
        public synchronized StringBuffer reverse(): 将字符串反转

    切片功能：
         public synchronized String substring(int start): 从指定位置开始到末尾
         public synchronized String substring(int start, int end): 从指定位置开始到指定位置结束

 */
public class StringBufferDemo {
    public static void main(String[] args) {
        // 创建StringBuffer对象
        StringBuffer sb = new StringBuffer();

        // 添加功能
        StringBuffer sb2 = sb.append("hello");
        System.out.println(sb);
        System.out.println(sb2);
        System.out.println(sb == sb2);  // true

        sb.append("world");
        sb.append("java");
        System.out.println(sb); // helloworldjava

        sb.insert(5, "WORLD");
        System.out.println(sb);
//        sb.insert(5, new char[]{'W', 'O', 'R', 'L', 'D'});

        // 删除功能
        sb.delete(0, 5);
        System.out.println(sb);

        sb.deleteCharAt(5);
        System.out.println(sb);

        // 替换功能
        sb.replace(5, 9, "12345");
        System.out.println(sb);

        // 反转功能
        sb.reverse();
        System.out.println(sb);

        // 切片功能
        String substr = sb.substring(3);
        System.out.println(substr);
        String substr2 = sb.substring(3, 6);
        System.out.println(substr2);
    }
}
