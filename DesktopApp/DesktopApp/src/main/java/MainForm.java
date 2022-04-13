import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {
    private JPanel mainPanel;
    private JButton collapseButton;
    private JTextField surname;
    private JTextField name;
    private JTextField patronymic;
    private JTextField result;
    private JLabel SN;
    private JLabel labelSurname;
    private JLabel labelPatronymic;
    private JLabel labelName;
    private boolean switch1 = true;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void createUIComponents() {
        result = new JTextField();
        result.setVisible(false);
        SN = new JLabel("Ф.И.О");
        SN.setVisible(false);
    }

    public MainForm() {
        collapseButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (switch1) {
                    String[] arrayName = name.getText().trim().split(" ");
                    String[] arraySurname = surname.getText().trim().split(" ");
                    String[] arrayPatronymic = patronymic.getText().trim().split(" ");
                    if (!arrayName[0].equals("") && !arraySurname[0].equals("") && arrayName.length == 1 && arraySurname.length == 1 && arrayPatronymic.length == 1) {
                        collapse();
                    } else error();
                } else {
                    expand();
                }
            }
        });
    }

    private void collapse() {
        collapseButton.setText("Expand");
        switchVisible(false);
        result.setText(surname.getText() + " " + name.getText() + " " + patronymic.getText());
    }

    private void expand() {
        String[] SNP = result.getText().trim().split(" ");
        if (SNP.length == 3 || SNP.length == 2) {
            switchVisible(true);
            collapseButton.setText("Collapse");
            surname.setText(SNP[0]);
            name.setText(SNP[1]);
            if (SNP.length == 2) {
                patronymic.setText("");
            } else patronymic.setText(SNP[2]);
        } else error();
    }

    private void switchVisible(boolean b) {
        switch1 = b;

        SN.setVisible(!b);
        result.setVisible(!b);

        surname.setVisible(b);
        name.setVisible(b);
        patronymic.setVisible(b);

        labelName.setVisible(b);
        labelPatronymic.setVisible(b);
        labelSurname.setVisible(b);
    }

    private void error() {
        JOptionPane.showMessageDialog(
                mainPanel,
                "Данные введены не корректно!",
                "Ошибка",
                JOptionPane.PLAIN_MESSAGE
        );
    }
}
