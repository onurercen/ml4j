package nn;
import tensor.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Sequential extends Module {
   
    private List<Module> modules;
    
    public Sequential() {
        this.modules = new ArrayList<>();
    }

    public Sequential(Module... modules) {
        this.modules = Arrays.asList(modules);
    }

    public void add(Module module) {
        modules.add(module);
    }

    @Override
    public Tensor forward(Tensor input) {
        Tensor output = input;
        for (Module module : modules) {
            output = module.forward(output);
        }
        return output;
    }

    @Override
    public List<Tensor> parameters() {
        List<Tensor> params = new ArrayList<>();
        for (Module module : modules) {
            params.addAll(module.parameters());
        }
        return params;
    }
    
}
