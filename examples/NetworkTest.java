package examples;

import nn.*;
import tensor.*;

public class NetworkTest {

    public static void main(String[] args) {

        Tensor input = Tensor.random(1, 784);

        Sequential model = new Sequential(
                new Linear(784, 128),
                new ReLU(),
                new Linear(128, 10)
        );

        Tensor output = model.forward(input);

        System.out.println(output);

    }

}