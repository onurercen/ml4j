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
        this.weight = Tensor.random(inFeatures, outFeatures);
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
