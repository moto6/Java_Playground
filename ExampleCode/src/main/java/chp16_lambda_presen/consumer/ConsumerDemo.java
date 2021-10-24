package chp16_lambda_presen.consumer;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void printAppleInfo(List<Apple> inventory, Consumer<Apple> consumer){
        for (Apple apple : inventory) {
            consumer.accept(apple);
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(150,"green"));
        inventory.add(new Apple(200,"green"));
        inventory.add(new Apple(200,"red"));
        inventory.add(new Apple(150,"red"));

        //1. using anonymous inner class



        //2. lambda expression



        //3. Method Reference

    }

    @Setter
    public static class Apple {
        private Integer weight = 0;
        private String color = "";

        public Apple(Integer weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
