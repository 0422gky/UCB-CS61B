public class HorribleSteve {
    public static void main(String[] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                //这里判断相等应该使用.equals()方法
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }

    /*
     * Java 中的 Integer 并没有上限为 128 的限制。Integer 是一个包装类，其值范围与基本数据类型 int 相同，即 -2³¹ 到
     * 2³¹-1（-2,147,483,648 到 2,147,483,647）。
     * 
     * 但是，你可能遇到的问题与 Integer 的缓存机制 有关。
     * 
     * Integer 缓存机制
     * Java 对 Integer 对象进行了缓存优化，默认情况下，Integer 对象的值在 -128 到 127 范围内会被缓存。
     * 
     * 具体表现
     * 如果两个 Integer 对象的值在 -128 到 127 范围内，并且通过自动装箱（Integer.valueOf()）创建，它们会引用同一个对象。
     * 如果超出这个范围，则会创建新的对象。
     * 示例
     * Integer a = 127;
     * Integer b = 127;
     * System.out.println(a == b); // true，因为引用的是同一个缓存对象
     * 
     * Integer c = 128;
     * Integer d = 128;
     * System.out.println(c == d); // false，因为超出缓存范围，创建了新的对象
     * 为什么会出现问题
     * 在你的代码中，Flik.isSameNumber 方法使用了 == 比较两个 Integer 对象：
     * 
     * public static boolean isSameNumber(Integer a, Integer b) {
     * return a == b;
     * }
     * 
     * == 比较的是两个对象的引用，而不是值。
     * 当 a 和 b 的值在 -128 到 127 范围内时，它们引用的是同一个缓存对象，因此 a == b 为 true。
     * 当值超出这个范围时，a 和 b 是不同的对象，即使它们的值相等，a == b 也会返回 false。
     * 
     * == 比较的是两个对象的引用，而不是值。
     * 当 a 和 b 的值在 -128 到 127 范围内时，它们引用的是同一个缓存对象，因此 a == b 为 true。
     * 当值超出这个范围时，a 和 b 是不同的对象，即使它们的值相等，a == b 也会返回 false。
     * 
     */
}
