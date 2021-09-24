import java.text.DecimalFormat;

public class Hospital {
    private static final double MAX_TEMPERATURE = 40.0;
    private static final double MIN_TEMPERATURE = 32.0;
    private static final double MAX_TEMPERATURE_HEALTHY_PATIENTS = 36.9;
    private static final double MIN_TEMPERATURE_HEALTHY_PATIENTS = 36.2;

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        float[] patientsTemperatures = new float[patientsCount];
        for (int i = 0; i < patientsTemperatures.length; i++) {
            float value = (float) (Math.random() * (MAX_TEMPERATURE - MIN_TEMPERATURE) + MIN_TEMPERATURE);
            patientsTemperatures[i] = value;
        }
        return patientsTemperatures;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */

        DecimalFormat formatter = new DecimalFormat("#0.00°C");
        StringBuilder temperaturePatients = new StringBuilder();
        float averageTemperature = 0;
        int countHealthyPatients = 0;
        for (int i = 0; i < temperatureData.length; i++) {
            averageTemperature += temperatureData[i];
            if (!(i == temperatureData.length - 1)) {
                temperaturePatients.append(formatter.format(temperatureData[i])).append(" ");
            } else temperaturePatients.append(formatter.format(temperatureData[i]));

            if (temperatureData[i] >= MIN_TEMPERATURE_HEALTHY_PATIENTS && temperatureData[i] <= MAX_TEMPERATURE_HEALTHY_PATIENTS) {
                countHealthyPatients++;
            }
        }

        averageTemperature = (float) Math.round(averageTemperature / temperatureData.length);

        return "Температуры пациентов: " + temperaturePatients +
                "\nСредняя температура: " + formatter.format(averageTemperature) +
                "\nКоличество здоровых: " + countHealthyPatients;
    }
}
