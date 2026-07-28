package nn;

import java.util.List;
import java.util.Collections;
import tensor.Tensor;

public abstract class Module {

    public abstract Tensor forward(Tensor input);


    public List<Tensor> parameters() {
        return Collections.emptyList();
    }

}