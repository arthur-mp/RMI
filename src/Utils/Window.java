package Utils;

import Interface.Aplication;
import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Window  {

    /*
     * Variables
     * */
    JFrame jFrame = new JFrame();
    Font big = new Font("Serif", Font.BOLD, 30);
    Font small = new Font("Serif", Font.BOLD, 15);
    Font button = new Font("Tahoma", Font.BOLD, 90);

    String[][] table = new String[3][3];

    String idPlayer;
    String namePlayer;
    String move = "";

    // Type Aplication
    JRadioButton optionServer;
    JRadioButton optionClient;

    // Gamer

    JLabel gamer;
    JTextField nameGamer;

    // Connection
    JButton connectionAplication;

    // Table buttons
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;
    JButton btn6;
    JButton btn7;
    JButton btn8;
    JButton btn9;


    public Window() {
        initComponents();
    }

    private void initComponents() {
        setConfigsWindow();
        // Title
        JLabel header = new JLabel("Aplicação de conexão RMI");
        jFrame.add(header);
        header.setFont(big);
        header.setBounds(100, 10, 600, 50);

        // Connexion
        JLabel typeConnection = new JLabel("Tipo de Conexão:");
        jFrame.add(typeConnection);
        typeConnection.setFont(small);
        typeConnection.setBounds(100, 80, 150, 20);


        ButtonGroup groupTypeConnection = new ButtonGroup();

        optionServer = new JRadioButton("Servidor");
        jFrame.add(optionServer);
        optionServer.setBounds(100, 105, 150, 20);


        optionClient = new JRadioButton("Cliente");
        jFrame.add(optionClient);
        optionClient.setBounds(100, 125, 150, 20);


        groupTypeConnection.add(optionServer);
        groupTypeConnection.add(optionClient);

        // Gamer
        gamer = new JLabel("Jogador:");
        jFrame.add(gamer);
        gamer.setFont(small);
        gamer.setBounds(280, 80, 150, 20);

        nameGamer = new JTextField(30);
        jFrame.add(nameGamer);
        nameGamer.setBounds(280, 110, 150, 20);
        nameGamer.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        // Initialize Connexion
        connectionAplication = new JButton("Conectar");
        jFrame.add(connectionAplication);
        connectionAplication.setFont(small);
        connectionAplication.setBounds(500, 110, 140, 40);
        connectionAplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                initializeAplication();
            }
        });


        // Funcionality
        JLabel functionality = new JLabel("Funcionalidade:");
        jFrame.add(functionality);
        functionality.setFont(small);
        functionality.setBounds(100, 210, 150, 20);


        JLabel typeFunctionality = new JLabel("Jogo da Velha");
        jFrame.add(typeFunctionality);
        typeFunctionality.setFont(small);
        typeFunctionality.setBounds(350, 210, 150, 20);


        // Buttons

        btn1 = new javax.swing.JButton();
        jFrame.add(btn1);
        btn1.setFont(button);
        btn1.setBounds(200, 250, 140, 140);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn1ActionPerformed();
            }
        });


        btn2 = new javax.swing.JButton();
        jFrame.add(btn2);
        btn2.setFont(button);
        btn2.setBounds(350, 250, 140, 140);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn2ActionPerformed();
            }
        });


        btn3 = new javax.swing.JButton();
        jFrame.add(btn3);
        btn3.setFont(button);
        btn3.setBounds(500, 250, 140, 140);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn3ActionPerformed();
            }
        });


        btn4 = new javax.swing.JButton();
        jFrame.add(btn4);
        btn4.setFont(button);
        btn4.setBounds(200, 400, 140, 140);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn4ActionPerformed();
            }
        });


        btn5 = new javax.swing.JButton();
        jFrame.add(btn5);
        btn5.setFont(button);
        btn5.setBounds(350, 400, 140, 140);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn5ActionPerformed();
            }
        });


        btn6 = new javax.swing.JButton();
        jFrame.add(btn6);
        btn6.setFont(button);
        btn6.setBounds(500, 400, 140, 140);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn6ActionPerformed();
            }
        });


        btn7 = new javax.swing.JButton();
        jFrame.add(btn7);
        btn7.setFont(button);
        btn7.setBounds(200, 550, 140, 140);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn7ActionPerformed();
            }
        });


        btn8 = new javax.swing.JButton();
        jFrame.add(btn8);
        btn8.setFont(button);
        btn8.setBounds(350, 550, 140, 140);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn8ActionPerformed();
            }
        });


        btn9 = new javax.swing.JButton();
        jFrame.add(btn9);
        btn9.setFont(button);
        btn9.setBounds(500, 550, 140, 140);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn9ActionPerformed();
            }
        });


    }//

    private void setConfigsWindow() {
        jFrame.setTitle("Aplicação RMI");
        jFrame.setSize(800, 800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    private void btn1ActionPerformed() {

        if (Objects.equals(idPlayer, "1")) {
            btn1.setText("X");
            btn1.setEnabled(false);
            table[0][0] = "X";
            move = "00X";
            verifyWinner();
        } else {
            if (Objects.equals(idPlayer, "2")) {
                btn1.setText("O");
                btn1.setEnabled(false);
                table[0][0] = "O";
                move = "00O";
                verifyWinner();
            }
        }
    }

    private void btn2ActionPerformed() {

        if (Objects.equals(idPlayer, "1")) {
            btn2.setText("X");
            btn2.setEnabled(false);
            table[0][1] = "X";
            move = "01X";
            verifyWinner();
        } else {
            if (Objects.equals(idPlayer, "2")) {
                btn2.setText("O");
                btn2.setEnabled(false);
                table[0][1] = "O";
                move = "01O";
                verifyWinner();
            }
        }
    }

    private void btn3ActionPerformed() {

        if (Objects.equals(idPlayer, "1")) {
            btn3.setText("X");
            btn3.setEnabled(false);
            table[0][2] = "X";
            move = "02X";
            verifyWinner();
        } else {
            if (Objects.equals(idPlayer, "2")) {
                btn3.setText("O");
                btn3.setEnabled(false);
                table[0][2] = "O";
                move = "02O";
                verifyWinner();
            }
        }
    }

    private void btn4ActionPerformed() {

        if (Objects.equals(idPlayer, "1")) {
            btn4.setText("X");
            btn4.setEnabled(false);
            table[1][0] = "X";
            move = "10X";
            verifyWinner();
        } else {
            if (Objects.equals(idPlayer, "2")) {
                btn4.setText("O");
                btn4.setEnabled(false);
                table[1][0] = "O";
                move = "10O";
                verifyWinner();
            }
        }
    }

    private void btn5ActionPerformed() {

        if (Objects.equals(idPlayer, "1")) {
            btn5.setText("X");
            btn5.setEnabled(false);
            table[1][1] = "X";
            move = "11X";
            verifyWinner();
        } else {
            if (Objects.equals(idPlayer, "2")) {
                btn5.setText("O");
                btn5.setEnabled(false);
                table[1][1] = "O";
                move = "11O";
                verifyWinner();
            }
        }
    }

    private void btn6ActionPerformed() {

        if (Objects.equals(idPlayer, "1")) {
            btn6.setText("X");
            btn6.setEnabled(false);
            table[1][2] = "X";
            move = "12X";
            verifyWinner();
        } else {
            if (Objects.equals(idPlayer, "2")) {
                btn6.setText("O");
                btn6.setEnabled(false);
                table[1][2] = "O";
                move = "12O";
                verifyWinner();
            }
        }
    }

    private void btn7ActionPerformed() {

        if (Objects.equals(idPlayer, "1")) {
            btn7.setText("X");
            btn7.setEnabled(false);
            table[2][0] = "X";
            move = "20X";
            verifyWinner();
        } else {
            if (Objects.equals(idPlayer, "2")) {
                btn7.setText("O");
                btn7.setEnabled(false);
                table[2][0] = "O";
                move = "20O";
                verifyWinner();
            }
        }
    }

    private void btn8ActionPerformed() {

        if (Objects.equals(idPlayer, "1")) {
            btn8.setText("X");
            btn8.setEnabled(false);
            table[2][1] = "X";
            move = "21X";
            verifyWinner();
        } else {
            if (Objects.equals(idPlayer, "2")) {
                btn8.setText("O");
                btn8.setEnabled(false);
                table[2][1] = "O";
                move = "21O";
                verifyWinner();
            }
        }
    }

    private void btn9ActionPerformed() {

        if (Objects.equals(idPlayer, "1")) {
            btn9.setText("X");
            btn9.setEnabled(false);
            table[2][2] = "X";
            move = "22X";
            verifyWinner();
        } else {
            if (Objects.equals(idPlayer, "2")) {
                btn9.setText("O");
                btn9.setEnabled(false);
                table[2][2] = "O";
                move = "22O";
                verifyWinner();
            }
        }
    }

    private void initializeAplication() {
        if (getAplicationConnection() == null) {
            alertMessage("É preciso informar um tipo de Aplicação!");
        } else {
            if (Objects.equals(getAplicationConnection(), "Server")) {
                isServer();
                startAplication();
            } else {
                if (nameGamer.getText().isEmpty()) {
                    alertMessage("É preciso informar um nome!");
                } else {
                    namePlayer = nameGamer.getText();
                    startAplication();
                }
            }

        }
    }

    private void sendMove(){
        Aplication inOut = new Main();
        inOut.sendClient();
    }

    public String getNamePlayer(){
        return namePlayer;
    }

    private void startAplication() {
        connectionAplication.setEnabled(false);
        Aplication aplication = new Main();
        aplication.initialize();
    }

    private void verifyWinner() {
        //Check Lines
        for (int i = 0; i < 3; i++) {
            if (table[i][0] == "X" && table[i][1] == "X" && table[i][2] == "X") {
                JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
                endOfTheGame();
            }
            if (table[i][0] == "O" && table[i][1] == "O" && table[i][2] == "O") {
                JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
                endOfTheGame();
            }
        }

        //Check Columns
        for (int i = 0; i < 3; i++) {
            if (table[0][i] == "X" && table[1][i] == "X" && table[2][i] == "X") {
                JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
                endOfTheGame();
            }
            if (table[0][i] == "O" && table[1][i] == "O" && table[2][i] == "O") {
                JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
                endOfTheGame();
            }
        }

        //Check Main Diagonal
        if (table[0][0] == "X" && table[1][1] == "X" && table[2][2] == "X") {
            JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
            endOfTheGame();
        }
        if (table[0][0] == "O" && table[1][1] == "O" && table[2][2] == "O") {
            JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
            endOfTheGame();
        }

        //Check Secondary Diagonal
        if (table[0][2] == "X" && table[1][1] == "X" && table[2][0] == "X") {
            JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
            endOfTheGame();
        }
        if (table[0][2] == "O" && table[1][1] == "O" && table[2][0] == "O") {
            JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
            endOfTheGame();
        }

        verifyLoss();
    }

    private void verifyLoss() {
        if(!move.equals(Messages.FINISH.getValueString())){
            boolean loss = true;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (table[i][j] == null) {
                        loss = false;
                    }
                }
            }

            if (loss) {
                JOptionPane.showMessageDialog(null, "VELHA! :(");
                endOfTheGame();
            }
        }

        sendMove();
    }

    public void disabledTable() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }

    public void enableTable() {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
    }

    public void updateTable(String coordinates) {
        enableTable();
        String[] values = coordinates.split("");
        int x = Integer.parseInt(values[0]);
        int y = Integer.parseInt(values[1]);
        if (table[x][y] == null) {
            table[x][y] = values[2];
            updateTableButtons();
        }
    }
    private void updateTableButtons() {
        if (table[0][0] != null) {
            btn1.setText(table[0][0]);
            btn1.setEnabled(false);
        }
        if (table[0][1] != null) {
            btn2.setText(table[0][1]);
            btn2.setEnabled(false);
        }
        if (table[0][2] != null) {
            btn3.setText(table[0][2]);
            btn3.setEnabled(false);
        }
        if (table[1][0] != null) {
            btn4.setText(table[1][0]);
            btn4.setEnabled(false);
        }
        if (table[1][1] != null) {
            btn5.setText(table[1][1]);
            btn5.setEnabled(false);
        }
        if (table[1][2] != null) {
            btn6.setText(table[1][2]);
            btn6.setEnabled(false);
        }
        if (table[2][0] != null) {
            btn7.setText(table[2][0]);
            btn7.setEnabled(false);
        }
        if (table[2][1] != null) {
            btn8.setText(table[2][1]);
            btn8.setEnabled(false);
        }
        if (table[2][2] != null) {
            btn9.setText(table[2][2]);
            btn9.setEnabled(false);
        }

    }

    public void alertMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public String getAplicationConnection() {
        if (optionServer.isSelected()) {
            return "Server";
        }
        if (optionClient.isSelected()) {
            return "Client";
        }
        return null;
    }

    public void endOfTheGame(){
        move = Messages.FINISH.getValueString();
    }
    public String getMove(){
        return move;
    }


    public void isServer() {
        disabledTable();
        nameGamer.setText("Servidor");
        nameGamer.setEditable(false);
        disableOptionsConnections();
        alertMessage("Servidor Inicializado");
    }

    public void isClient(String idPlayer){
        disabledTable();
        nameGamer.setEditable(false);
        this.idPlayer = idPlayer;
        disableOptionsConnections();
    }
    private void disableOptionsConnections(){
        optionClient.setEnabled(false);
        optionServer.setEnabled(false);
    }

}