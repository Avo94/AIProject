package ai.math;

import ai.Neuron;

public class Iteration {

    public static void run(Neuron[] previousLayer, Neuron[] currentLayer) {
        double output;
        for (int i = 0; i < currentLayer.length; i++) {
            output = 0;
            for (int j = 0; j < previousLayer.length; j++) {
                output += previousLayer[j].getOutputData() * previousLayer[j].getOutputSynapsesWeights()[i];
            }
            currentLayer[i].setOutputData(NeuronActivationFunction.findHyperbolicTangent(output));
        }
    }
}