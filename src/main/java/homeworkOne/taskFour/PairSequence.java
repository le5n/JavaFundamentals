package homeworkOne.taskFour;

class PairSequence {
    private int[] incomeArray;

    public PairSequence(int[] incomeArray) {
        this.incomeArray = incomeArray;

    }

    int searchMaxElement() {
        int[] sequence = makeSequence();
        int max = 0;
        for (int aSequence : sequence) {
            if (aSequence > max)
                max = aSequence;
        }
        return max;
    }

    private int[] makeSequence() {
        for (int i = 0; i < incomeArray.length - 1; i++) {
            incomeArray[i] = incomeArray[i] + incomeArray[i + 1];
        }
        return incomeArray;
    }
}
