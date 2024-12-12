import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CalculadoraNotas {
    private static double resultadoMA = 0; // Variável global para Resultado_MA
    private static double resultadoMF = 0; // Variável global para Resultado_MF

    public static void main(String[] args) {
        // Criando a janela principal
        JFrame frame = new JFrame("Calculadora de Notas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel principal com GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margem interna
        frame.add(panel);

        // Configurações gerais do GridBagConstraints
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campos de entrada
        JTextField cnp1Field = new JTextField("Nota do NP1");
        adicionarPlaceholder(cnp1Field, "Nota do NP1");

        JTextField cnp2Field = new JTextField("Nota do NP2");
        adicionarPlaceholder(cnp2Field, "Nota do NP2");

        JTextField ctexField = new JTextField("Nota do Exame");
        adicionarPlaceholder(ctexField, "Nota do Exame");

        // Adicionando campos ao painel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // O campo ocupa duas colunas
        panel.add(cnp1Field, gbc);

        gbc.gridy = 1;
        panel.add(cnp2Field, gbc);

        gbc.gridy = 2;
        panel.add(ctexField, gbc);

        // Botões
        JButton btnMA = new JButton("Calcular Media Semestral");
        JButton btnMF = new JButton("Calcular Media Final");
        JButton btnNovo = new JButton("Novo");

        // Adicionando botões ao painel
        gbc.gridy = 3;
        gbc.gridwidth = 1; // Cada botão ocupa uma coluna
        gbc.gridx = 0;
        panel.add(btnMA, gbc);

        gbc.gridx = 1;
        panel.add(btnMF, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2; // O botão Novo ocupa duas colunas
        panel.add(btnNovo, gbc);

        // Labels para resultados e status
        JLabel lbResultadoMA = new JLabel("Resultado Media Semestral: ");
        JLabel lbResultadoMF = new JLabel("Resultado Media Final: ");
        JLabel lbStatusMA = new JLabel("Status Media Semestral: ");
        JLabel lbStatusMF = new JLabel("Status Media Final: ");

        // Adicionando labels ao painel
        gbc.gridy = 5;
        panel.add(lbResultadoMA, gbc);

        gbc.gridy = 6;
        panel.add(lbResultadoMF, gbc);

        gbc.gridy = 7;
        panel.add(lbStatusMA, gbc);

        gbc.gridy = 8;
        panel.add(lbStatusMF, gbc);

        // Ação do botão para calcular Resultado_MA
        btnMA.addActionListener(e -> {
            try {
                double cnp1 = Double.parseDouble(cnp1Field.getText());
                double cnp2 = Double.parseDouble(cnp2Field.getText());
                resultadoMA = (cnp1 + cnp2) / 2;

                lbResultadoMA.setText("Resultado Media Semestral: " + resultadoMA);
                if (resultadoMA >= 7) {
                    lbStatusMA.setText("Status Media Semestral: O aluno esta aprovado!!!");
                } else {
                    lbStatusMA.setText("Status Media Semestral: O aluno esta de exame!!!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira valores validos.");
            }
        });

        // Ação do botão para calcular Resultado_MF
        btnMF.addActionListener(e -> {
            try {
                double ctex = Double.parseDouble(ctexField.getText());
                resultadoMF = (ctex + resultadoMA) / 2;

                lbResultadoMF.setText("Resultado Media Final: " + resultadoMF);
                if (resultadoMF >= 5) {
                    lbStatusMF.setText("Status Media Final: O aluno esta aprovado!!!");
                } else {
                    lbStatusMF.setText("Status Media Final: O aluno esta reprovado!!!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira valores validos.");
            }
        });

        // Ação do botão para reiniciar
        btnNovo.addActionListener(e -> {
            cnp1Field.setText("Nota do NP1");
            cnp2Field.setText("Nota do NP2");
            ctexField.setText("Nota do Exame");
            lbResultadoMA.setText("Resultado Media Semestral: ");
            lbResultadoMF.setText("Resultado Media Final: ");
            lbStatusMA.setText("Status Media Semestral: ");
            lbStatusMF.setText("Status Media Final: ");
            resultadoMA = 0;
            resultadoMF = 0;
        });

        // Configurando a janela principal
        frame.setSize(500, 500); // Tamanho inicial
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela
        frame.setVisible(true);
    }

    // Método para adicionar placeholder ao JTextField
    private static void adicionarPlaceholder(JTextField field, String placeholder) {
        field.setForeground(Color.GRAY);
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(Color.GRAY);
                }
            }
        });
    }
}
