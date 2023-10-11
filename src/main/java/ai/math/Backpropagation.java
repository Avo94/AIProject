package ai.math;

import ai.Neuron;

public class Backpropagation {

    public static void setOutputNeuronsDeltaWithSigmoid(Neuron[] outputLayer, int[] expectedResult) {
//      HARDCODE
        double outputData = outputLayer[0].getOutputData();
//      delta = (i - a) * ((1 - a) * a)
        outputLayer[0].setDelta((expectedResult[0] - outputData) * ((1 - outputData) * outputData));
    }

    public static void setOutputNeuronsDeltaWithHyperbolicTangent(Neuron[] outputLayer, int[] expectedResult) {
//      HARDCODE
        double outputData = outputLayer[0].getOutputData();
//      delta = (i - a) * (1 - a^2)
        outputLayer[0].setDelta((expectedResult[0] - outputData) * (1 - Math.pow(outputData, 2)));
    }

    public static double setDeltaWithSigmoid(Neuron[] outputLayer, int[] expectedResult) {
//      HARDCODE
        double outputData = outputLayer[0].getOutputData();
//      delta = (i - a) * ((1 - a) * a)
        return (expectedResult[0] - outputData) * ((1 - outputData) * outputData);
    }

    public static void setDeltaWithHyperbolicTangent(Neuron[] currentLayer, Neuron[] nextLayer) {
        double sigma;
//      delta = (1 - a^2) * sigma(w * delta)        where: sigma - sum of all outgoing synapses (w * delta)
//                                                         delta - delta of next layer neuron
        for (int i = 0; i < currentLayer.length; i++) {
            sigma = 0;
            for (int j = 0; j < nextLayer.length; j++) {
                sigma += currentLayer[i].getOutputSynapsesWeights()[j] * nextLayer[j].getDelta();
            }
            currentLayer[i].setDelta((1 - Math.pow(currentLayer[i].getOutputData(), 2)) * sigma);
        }
    }
}