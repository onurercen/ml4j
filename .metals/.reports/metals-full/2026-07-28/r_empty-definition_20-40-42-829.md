error id: file:///C:/Users/ercen/OneDrive/Desktop/ml4j/nn/Linear.java:tensor/Tensor#random().
file:///C:/Users/ercen/OneDrive/Desktop/ml4j/nn/Linear.java
empty definition using pc, found symbol in pc: tensor/Tensor#random().
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 444
uri: file:///C:/Users/ercen/OneDrive/Desktop/ml4j/nn/Linear.java
text:
```scala
package nn;
import java.util.List;

import tensor.Tensor;

public class Linear extends Module {
    // Calculate Y = XW + b
    private Tensor weight;
    /* Weight tensor */
    private Tensor bias;
    /* Bias tensor */
    public Tensor getWeight() {
        return weight;
    }

    public Tensor getBias() {
        return bias;
    }

    public Linear(int inFeatures, int outFeatures) {
        this.weight = Tensor.@@random(inFeatures, outFeatures);
        this.bias = Tensor.zeros(1, outFeatures);
    }

    @Override
    public Tensor forward(Tensor input) {
        return input.matmul(weight).add(bias);
    }

    @Override
    public List<Tensor> parameters() {
        return List.of(weight, bias);
    }   
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: tensor/Tensor#random().