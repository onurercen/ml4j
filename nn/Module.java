package nn;
import java.util.List;

import tensor.Tensor;

public abstract class Module {
    public abstract Tensor forward(Tensor input);
    public abstract List<Tensor> parameters();
}
