public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        float[] patientsTemperatures = new float[patientsCount];
        for (int i = 0; i < patientsTemperatures.length; i++) {
            float value = (float) Math.round(10 * (Math.random() * 8 + 32)) / 10;
            patientsTemperatures[i] = value;
        }
        return patientsTemperatures;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */


        StringBuilder temperaturePatients = new StringBuilder();
        float averageTemperature = 0;
        int countHealthyPatients = 0;
        for (int i = 0; i < temperatureData.length; i++) {
            averageTemperature += temperatureData[i];
            if (!(i == temperatureData.length - 1)) {
                temperaturePatients.append(temperatureData[i]).append(" ");
            } else temperaturePatients.append(temperatureData[i]);

            if (temperatureData[i] >= 36.2f && temperatureData[i] <= 36.9f) {
                countHealthyPatients++;
            }
        }
        averageTemperature = (float) Math.round(averageTemperature / temperatureData.length * 100) / 100;

        String report =
                "Температуры пациентов: " + temperaturePatients +
                        "\nСредняя температура: " + averageTemperature +
                        "\nКоличество здоровых: " + countHealthyPatients;

        return report;
    }
}
