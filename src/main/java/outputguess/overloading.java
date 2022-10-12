package outputguess;

        public class overloading {
            public static void main(String[] args) {
                System.out.println(1.0/0.0);
                someMethod(null);
                int i = 1111;
                 i = i-- - --i;
                System.out.println(i);
            }
            public static void someMethod(Object o) {
                System.out.println("Object method Invoked");
            }
//            public static void someMethod(String s) {
//                System.out.println("String method Invoked");
//            }
            public static void someMethod(Double s) {
                System.out.println("doubel method Invoked");
            }
        }

