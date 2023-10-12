package ai.math;

import ai.Neuron;

public class SynapseWeight {

    public static void correct(Neuron[] currentLayer, Neuron[] nextLayer, double learningRate, double momentum) {
//      deltaW = E * gradientW + alpha * deltaW         where:     E - learningRate, W - synapse,
//                                                             alpha - momentum, delta - synapse weight correction
        for (int i = 0; i < currentLayer.length; i++) {
            for (int j = 0; j < nextLayer.length; j++) {
                currentLayer[i].setSynapseWeightCorrection(
                        learningRate * currentLayer[i].getOutputSynapsesGradients()[j]
                                + momentum * currentLayer[i].getSynapseWeightCorrection());
                currentLayer[i].getOutputSynapsesWeights()[j] += currentLayer[i].getSynapseWeightCorrection();
            }
        }
    }
}