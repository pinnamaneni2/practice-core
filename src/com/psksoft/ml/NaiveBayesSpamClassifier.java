package com.psksoft.ml;

import java.util.*;



public class NaiveBayesSpamClassifier {
        private List<Email> trainingData;

        public NaiveBayesSpamClassifier(List<Email> trainingData) {
            this.trainingData = trainingData;
        }

        private double[] getClassProbabilities() {
            return new double[] {
                    trainingData.stream().filter(e -> e.label.equals("Spam")).count() / (double) trainingData.size(),
                    trainingData.stream().filter(e -> e.label.equals("Non-Spam")).count() / (double) trainingData.size()
            };
        }

        private double[][] getFeatureProbabilities() {
            int numFeatures = trainingData.get(0).features.length;
            double[][] probabilities = new double[2][numFeatures];

            for (int i = 0; i < 2; i++) {
                String label = i == 0 ? "Spam" : "Non-Spam";
                long classCount = trainingData.stream().filter(e -> e.label.equals(label)).count();

                for (int j = 0; j < numFeatures; j++) {
                    int finalJ = j;
                    long featureCount = trainingData.stream()
                                                    .filter(e -> e.label.equals(label))
                                                    .mapToInt(e -> e.features[finalJ])
                                                    .sum();

                    probabilities[i][j] = (featureCount + 1) / (double) (classCount + 2);
                }
            }

            return probabilities;
        }

        public String predict(int[] features) {
            double[] classProbabilities = getClassProbabilities();
            double[][] featureProbabilities = getFeatureProbabilities();

            double[] probabilities = new double[2];

            for (int i = 0; i < 2; i++) {
                probabilities[i] = classProbabilities[i];

                for (int j = 0; j < features.length; j++) {
                    probabilities[i] *= Math.pow(featureProbabilities[i][j], features[j]) * Math.pow(1 - featureProbabilities[i][j], 1 - features[j]);
                }
            }

            return probabilities[0] > probabilities[1] ? "Spam" : "Non-Spam";
        }

        public static void main(String[] args) {
            List<Email> trainingData = Arrays.asList(
                    new Email(new int[]{1, 1, 0}, "Spam"),
                    new Email(new int[]{0, 1, 1}, "Spam"),
                    new Email(new int[]{0, 0, 0}, "Non-Spam"),
                    new Email(new int[]{1, 1, 0}, "Spam"),
                    new Email(new int[]{0, 0, 1}, "Non-Spam")
            );

            NaiveBayesSpamClassifier classifier = new NaiveBayesSpamClassifier(trainingData);

            System.out.println(classifier.predict(new int[]{1, 1, 0}));  // Spam
            System.out.println(classifier.predict(new int[]{0, 0, 1}));  // Non-Spam
        }
    }


    class  Email {
        int[] features;
        String label;

        public Email(int[] features, String label) {
            this.features = features;
            this.label = label;
        }

}