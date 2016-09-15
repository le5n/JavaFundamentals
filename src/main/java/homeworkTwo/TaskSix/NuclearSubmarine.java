package homeworkTwo.TaskSix;

class NuclearSubmarine {
    private String name;
    //Существует 3 типа атомных лодок
    private Countries country;
    //Существует 4 поколения атомных лодок
    private byte generation;

    void setName(String name) {
        this.name = name;
    }

    void setCountry(Countries country) {
        this.country = country;
    }

    void setGeneration(byte generation) {
        if (generation <= 4) {
            this.generation = generation;
        }
    }

    @Override
    public String toString() {
        return "NuclearSubmarine: \n" +
                "name: '" + name + '\'' +
                "\ncountry: " + country +
                "\ngeneration: " + generation;
    }

    static class Engine {
        private static boolean working = false;

        static boolean turnOn() {
            working = true;
            return true;
        }

        public static boolean turnOf() {
            working = false;
            return false;
        }
    }


}
