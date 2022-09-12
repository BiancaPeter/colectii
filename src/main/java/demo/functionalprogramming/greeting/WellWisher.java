package demo.functionalprogramming.greeting;

public class WellWisher {
    public static void main(String[] args) {
        Greeting indianGreeting = new IndianGreeting();
        wish(indianGreeting);

        Greeting englishGreeting = new EnglishGreeting();
        wish(englishGreeting);

//        wish(new Greeting() {
//            @Override
//            public void sayHello(){
//                System.out.println("Ciao");
//            }
//        });

        wish(() -> {
            System.out.println("Nihao");
        });

    }

    public static void wish(Greeting greeting) {
        greeting.sayHello();
    }
}
