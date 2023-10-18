package ai;

import ai.math.*;
import ai.math.Error;

public class NeuralNetwork {

    private final int[] layers;

    private Neuron[][] neurons;

    private double[] expectedResult;

    private final int epochs;

    private final double learningRate;

    private final double momentum;

    public NeuralNetwork(int[] layers, int epochs, double learningRate, double momentum) {
        this.layers = layers;
        if (layers != null) {
            this.neurons = new Neuron[layers.length][];
            this.expectedResult = new double[layers[layers.length - 1]];
        }
        this.epochs = epochs;
        this.learningRate = learningRate;
        this.momentum = momentum;
    }

    public void run() {
        if (layers == null || layers.length < 1) {
            System.out.println("Incorrect layer architecture");
            System.exit(1);
        }
        neuronsInitialization();

        for (int i = 0; i < epochs; i++) {
            System.out.println("Epoch " + i + ", error = " + calculateError() + "%");
            runBackpropagation();
            calculateGradient();
            correctSynapsesWeights();
            runNewIteration();
        }
    }

    public void neuronsInitialization() {
        for (int i = 0; i < layers.length; i++) {
            neurons[i] = new Neuron[layers[i]];
        }
        initializingTheInputLayer();
        initializingHiddenAndOutputLayers();
    }

    private void initializingTheInputLayer() {
//      HARDCODE
        double[] outputSynapsesWeights = null;
        if (neurons.length > 1) {
            outputSynapsesWeights = new double[neurons[1].length];
            for (int i = 0; i < neurons[1].length; i++) {
                outputSynapsesWeights[i] = Math.random();
            }
        }
        Neuron neuron1 = new Neuron(0, outputSynapsesWeights);
        neuron1.setOutputData(Math.random());
        neurons[0][0] = neuron1;
        Neuron neuron2 = new Neuron(0, outputSynapsesWeights);
        neuron2.setOutputData(Math.random());
        neurons[0][1] = neuron2;
        Neuron neuron3 = new Neuron(0, outputSynapsesWeights);
        neuron3.setOutputData(Math.random() * -1);
        neurons[0][2] = neuron3;
        expectedResult[0] = 0;
    }

    private void initializingHiddenAndOutputLayers() {
        for (int i = 1; i < neurons.length; i++) {
            for (int j = 0; j < neurons[i].length; j++) {

                Neuron[] previousLayer = neurons[i - 1];

                double weightedOutputData = 0;

                for (Neuron neuron : previousLayer) {
                    weightedOutputData +=
                            (neuron.getOutputData() * neuron.getOutputSynapsesWeights()[j]);
                }

                double[] outputSynapsesWeights = null;
                if (i < layers.length - 1) {
                    outputSynapsesWeights = new double[neurons[i + 1].length];

                    for (int k = 0; k < outputSynapsesWeights.length; k++) {
                        double weight = Math.random() * 5;
                        if (weight % 2 == 0) {
                            weight *= -1;
                        }
                        outputSynapsesWeights[k] = weight;
                    }
                }
                neurons[i][j] = new Neuron(weightedOutputData, outputSynapsesWeights);
            }
        }
    }

    private int calculateError() {
        double error = Error.find(neurons[neurons.length - 1], expectedResult);
        return (int) (error * 100);
    }

    private void runBackpropagation() {
        calculateOutputNeuronsBackpropagation();
        calculateBackpropagation();
    }

    private void calculateOutputNeuronsBackpropagation() {
        Backpropagation.setOutputNeuronsDeltaWithHyperbolicTangent(neurons[neurons.length - 1], expectedResult);
    }

    private void calculateBackpropagation() {
        for (int i = neurons.length - 2; i >= 0; i--) {
            Backpropagation.setDeltaWithHyperbolicTangent(neurons[i], neurons[i + 1]);
        }
    }

    private void calculateGradient() {
        for (int i = neurons.length - 2; i >= 0; i--) {
            Gradient.find(neurons[i], neurons[i + 1]);
        }
    }

    private void correctSynapsesWeights() {
        for (int i = neurons.length - 2; i >= 0; i--) {
            SynapseWeight.correct(neurons[i], neurons[i + 1], learningRate, momentum);
        }
    }

    private void runNewIteration() {
        for (int i = 1; i < neurons.length; i++) {
            Iteration.run(neurons[i - 1], neurons[i]);
        }
    }
}