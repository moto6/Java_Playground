public class ex1 {
    
    private enum Animal {CAT, DOG, MONKEY}
    private enum Fruit {APPLE, PEAR, BANANA}

    public static void main(String[] args) {
        Animal animal = Animal.MONKEY;
        Fruit fruit = Fruit.BANANA;

        System.out.println(animal);
        System.out.println(fruit);

        if (animal.equals(fruit)) {
            System.out.println("Monkey is Banana!");
        } else {
            System.out.println("Monkey is not Banana!");
        }

    }

}
