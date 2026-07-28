error id: file:///C:/Users/ercen/OneDrive/Desktop/ml4j/examples/NetworkTest.java:nn/Sequential#
file:///C:/Users/ercen/OneDrive/Desktop/ml4j/examples/NetworkTest.java
empty definition using pc, found symbol in pc: nn/Sequential#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 223
uri: file:///C:/Users/ercen/OneDrive/Desktop/ml4j/examples/NetworkTest.java
text:
```scala
package examples;

import nn.*;
import tensor.*;

public class NetworkTest {

    public static void main(String[] args) {

        Tensor input = Tensor.random(1, 784);

        Sequential model = new Sequential@@(
                new Linear(784, 128),
                new ReLU(),
                new Linear(128, 10)
        );

        Tensor output = model.forward(input);

        System.out.println(output);

    }

}
```


#### Short summary: 

empty definition using pc, found symbol in pc: nn/Sequential#