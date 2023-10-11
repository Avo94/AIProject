package ai;

import ai.math.Backpropagation;

public class ArtificialIntelligence {

    private int[] layers;

    private final Neuron[][] neuralNetwork;

    private int[] expectedResult;

    private final int epochs;

    private final double learningRate;

    private final double momentum;

    public ArtificialIntelligence(int[] layers, int epochs, double learningRate, double momentum) {
        this.layers = layers;
        this.neuralNetwork = new Neuron[layers.length][];
        this.expectedResult = new int[layers[layers.length - 1]];
        this.epochs = epochs;
        this.learningRate = learningRate;
        this.momentum = momentum;
    }

    public void run() {
        if (layers == null || layers.length < 1) {
            System.out.println("Incorrect layer architecture");
            System.exit(1);
        }

        neuronsInit();
        System.out.println("Error = " + getError() + "%");
        backpropagate();
    }

    public void neuronsInit() {
        for (int i = 0; i < layers.length; i++) {
            neuralNetwork[i] = new Neuron[layers[i]];
        }
        initializingTheInputLayer();
        initializingHiddenAndOutputLayers();
    }

    private void initializingTheInputLayer() {
        double[] outputSynapsesWeights = null;
        if (neuralNetwork.length > 1) {
            outputSynapsesWeights = new double[neuralNetwork[1].length];
            for (int i = 0; i < neuralNetwork[1].length; i++) {
                outputSynapsesWeights[i] = Math.random();
            }
        }
        Neuron neuron1 = new Neuron(0, outputSynapsesWeights);
        neuron1.setOutputData(0.8);
        neuralNetwork[0][0] = neuron1;
        Neuron neuron2 = new Neuron(0, outputSynapsesWeights);
        neuron2.setOutputData(0.4);
        neuralNetwork[0][1] = neuron2;
        Neuron neuron3 = new Neuron(0, outputSynapsesWeights);
        neuron3.setOutputData(-0.9);
        neuralNetwork[0][2] = neuron3;
    }

    private void initializingHiddenAndOutputLayers() {
        for (int i = 1; i < neuralNetwork.length; i++) {
            for (int j = 0; j < neuralNetwork[i].length; j++) {

                Neuron[] previousLayer = neuralNetwork[i - 1];

                double weightedOutputData = 0;

                for (Neuron neuron : previousLayer) {
                    weightedOutputData +=
                            (neuron.getOutputData() * neuron.getOutputSynapsesWeights()[j]);
                }

                double[] outputSynapsesWeights = null;
                if (i < layers.length - 1) {
                    outputSynapsesWeights = new double[neuralNetwork[i + 1].length];

                    for (int k = 0; k < outputSynapsesWeights.length; k++) {
                        double weight = Math.random() * 5;
                        if (weight % 2 == 0) {
                            weight *= -1;
                        }
                        outputSynapsesWeights[k] = weight;
                    }
                }
                neuralNetwork[i][j] = new Neuron(weightedOutputData, outputSynapsesWeights);
            }
        }
    }

    private double[] getOutputNeuronsOutputData() {
        double[] outputData = new double[neuralNetwork[neuralNetwork.length - 1].length];
        for (int i = 0; i < outputData.length; i++) {
            outputData[i] = neuralNetwork[neuralNetwork.length - 1][i].getOutputData();
        }
        return outputData;
    }

    private int getError() {
        expectedResult[0] = 1;
        double error = Backpropagation.calculateError(neuralNetwork[neuralNetwork.length - 1], expectedResult);
        return (int) (error * 100);
    }

    private void backpropagate() {
        backpropagateOutpotNeuron();
    }

    private void backpropagateOutpotNeuron() {

    }
}