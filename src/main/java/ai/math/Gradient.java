package ai.math;

import ai.Neuron;

public class Gradient {

    public static void find(Neuron[] currentLayer, Neuron[] nextLayer) {
//     gradient = a * delta     where:     a - actual output data
//                                     delta - delta of next layer neuron
        for (int i = 0; i < currentLayer.length; i++) {
            for (int j = 0; j < nextLayer.length; j++) {
                currentLayer[i].getOutputSynapsesGradients()[j] =
                        currentLayer[i].getOutputData() * nextLayer[j].getDelta();
            }
        }
    }
}