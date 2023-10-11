import ai.ArtificialIntelligence;

public class Main {

    public static void main(String[] args) {
        int[] layers = new int[]{3, 3, 1};      //layer architecture
        int epochs = 2000;                      //number of training cycles
        double learningRate = 0.03;             //weight correction factor
        double momentum = 0.3;              //local minimum avoidance factor

        ArtificialIntelligence AI = new ArtificialIntelligence(layers, epochs, learningRate, momentum);
        AI.run();
    }
}