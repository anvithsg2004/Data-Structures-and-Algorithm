class Test {
    void method(int... nums) {
        System.out.println("Int varargs");
    }

    void method(Integer... nums) {
        System.out.println("Integer varargs");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.method(new Integer[]{1, 2, 3});
    }
}
