package digitalatm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DigitalATM {
    //Universal declaration of GUI variables.
    static JFrame atmFrame;
    static JTable adminMenuTable;
    static JPanel containerPanel, introPanel, introScreen, mainMenuPanel, mainMenuScreen, createAccountPanel, createAccountScreen, loginAccountPanel, loginAccountScreen, actionMenuPanel, actionMenuScreen, depositMenuPanel, depositMenuScreen, numpadPanel, withdrawMenuPanel, withdrawMenuScreen, adminMenuPanel, adminMenuScreen;
    static JLabel logo, titleLabel, welcomeLabel, atmNoteLabel, mainMenuLabel, createAccountLabel, nameCreateLabel, pinCreateLabel, initialDepositCreateLabel, phoneNumCreateLabel,loginAccountLabel, phoneNumLabel, pinLoginLabel, actionMenuWelcomeLabel, currentBalanceLabel, depositMenuLabel, depositAmountLabel, withdrawMenuLabel, withdrawAmountLabel, adminMenuLabel;
    static JButton enterButton, createAccountButton, loginAccountButton, submitCreateButton, createToMenuButton, submitLoginButton, loginToMenuButton, depositButton, withdrawButton, actionToMenuButton, depositToMenuButton, withdrawToMenuButton, adminToMenuButton, deleteButton;
    static JTextField nameCreateTextField, pinCreateTextField, initialDepositCreateTextField, phoneNumLoginTextField, phoneNumCreateTextField, currentBalanceTextField, depositAmountTextField, withdrawAmountTextField;
    static JPasswordField pinLoginPasswordField;
    static JPanel[] sideButtons = new JPanel[8];
    static JButton[] numPadButtons = new JButton[12];
    
    //Universal declaration of functionality variables.
    static InputVerifier inputVerify = new InputVerifier();
    static AccountNode accNode = new AccountNode();
    static AccountNode loginNode = new AccountNode();
    static AccountNode head = new AccountNode();
    static boolean phoneNumStatus, nameStatus, pinStatus, initialDepositStatus, depositAmountStatus, withdrawAmountStatus;
    static String name, pin, balanceStr, phoneNum, accountCreateDialogBox = "", denominationDialogBox = "", phoneNumLogin, pinLogin, depositAmountStr, withdrawAmountStr;
    static int balance, depositAmount, withdrawAmount;
    static int denomination;
    static String adminUsername = "admin", adminPassword = "adminPass", denominationType;
    static int[] denominationsValue = {1000, 500, 100, 50, 20, 10, 1};
    
    //Main Method
    public static void main(String[] args) {
        //Running the GUI
        atmFrameGui();
    }
    
    //------------------------------------------------------------------Methods for GUI.---------------------------------------------------------------------------------------------------------------
    //atmFrameGui Method.
    public static void atmFrameGui() {
        //Create JFrame object and set its layout.
        atmFrame = new JFrame();
        atmFrame.setTitle("DigiVault");
        atmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        atmFrame.setResizable(false);
        atmFrame.setSize(916, 689);
        atmFrame.setLocationRelativeTo(null);
        atmFrame.setLayout(null);
        atmFrameComponents();
        atmFrame.setVisible(true);
    }
    
    //atmFrameComponents Method.
    public static void atmFrameComponents() {
        //Declaration of atmFrame Components
        containerPanel = new JPanel();

        //Setting the component's layout.
        containerPanel.setSize(900, 650);
        containerPanel.setLayout(new CardLayout());

        //Adding the menus.
        introMenu();
        mainMenu();
        loginAccountMenu();
        createAccountMenu();
        actionMenu();
        depositMenu();
        withdrawMenu();
        adminMenuPanel();
        atmFrame.add(containerPanel);
    }
    
    //introMenu Method.
    public static void introMenu() {
        //Declaration of introMenu components.
        welcomeLabel = new JLabel();
        atmNoteLabel = new JLabel();
        introPanel = new JPanel();
        introScreen = new JPanel();
        enterButton = new JButton();

        //Setting introMenu component layout.
        welcomeLabel.setFont(new Font("Rockwell", 0, 48));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setForeground(new Color(253, 253, 253));
        welcomeLabel.setText("Welcome to DigiVault!");
        welcomeLabel.setBounds(109, 160, 531, 57);

        atmNoteLabel.setFont(new Font("Rockwell", 0, 24));
        atmNoteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        atmNoteLabel.setForeground(new Color(173, 173, 172));
        atmNoteLabel.setText("DigiVault does not support centavos.");
        atmNoteLabel.setBounds(109, 215, 531, 57);

        introPanel.setBackground(new Color(0x3B3E44));
        introPanel.setSize(900, 650);
        introPanel.setLayout(null);

        introScreen.setBorder(BorderFactory.createLineBorder(new Color(52, 50, 50), 3));
        introScreen.setBackground(new Color(0x3C465C));
        introScreen.setBounds(80, 80, 740, 490);
        introScreen.setLayout(null);

        enterButton.setBackground(new Color(253, 253, 253));
        enterButton.setFont(new java.awt.Font("Rockwell", 0, 20));
        enterButton.setForeground(new java.awt.Color(0, 153, 51));
        enterButton.setText("Enter");
        enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        enterButton.setFocusable(false);
        enterButton.setBounds(320, 280, 100, 30);

        //Add action listener to the buttons.
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                introPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
            }
        });

        //Adding the component to their corresponding parent component.
        introScreen.add(enterButton);
        introScreen.add(welcomeLabel);
        introScreen.add(atmNoteLabel);
        panelDesigns(introPanel);
        introPanel.add(titleLabel);
        introPanel.add(introScreen);
        containerPanel.add(introPanel);
    }
    
    //Main Menu Method.
    public static void mainMenu() {
        //Declaration of mainMenu components.
        mainMenuLabel = new JLabel();
        mainMenuPanel = new JPanel();
        mainMenuScreen = new JPanel();
        createAccountButton = new JButton();
        loginAccountButton = new JButton();

        //Setting mainMenu component layout.
        mainMenuLabel.setFont(new java.awt.Font("Rockwell", 0, 48));
        mainMenuLabel.setForeground(new Color(253, 253, 253));
        mainMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainMenuLabel.setText("Main Menu");
        mainMenuLabel.setBounds(109, 120, 531, 57);

        mainMenuPanel.setBackground(new Color(0x3B3E44));
        mainMenuPanel.setSize(900, 650);
        mainMenuPanel.setLayout(null);

        mainMenuScreen.setBorder(BorderFactory.createLineBorder(new Color(52, 50, 50), 3));
        mainMenuScreen.setBackground(new Color(0x3C465C));
        mainMenuScreen.setBounds(80, 80, 740, 490);
        mainMenuScreen.setLayout(null);
        
        loginAccountButton.setBackground(new Color(253, 253, 253));
        loginAccountButton.setFont(new java.awt.Font("Rockwell", 0, 20));
        loginAccountButton.setForeground(new Color(60, 70, 92));
        loginAccountButton.setText("Login");
        loginAccountButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginAccountButton.setFocusable(false);
        loginAccountButton.setBounds(249, 200, 250, 30);
        
        createAccountButton.setBackground(new Color(253, 253, 253));
        createAccountButton.setFont(new java.awt.Font("Rockwell", 0, 20));
        createAccountButton.setForeground(new Color(60, 70, 92));
        createAccountButton.setText("Sign Up");
        createAccountButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createAccountButton.setFocusable(false);
        createAccountButton.setBounds(249, 260, 250, 30);

        

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenuPanel.setVisible(false);
                createAccountPanel.setVisible(true);
            }
        });

        loginAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenuPanel.setVisible(false);
                loginAccountPanel.setVisible(true);
            }
        });

        //Adding the component to their corresponding parent component.
        mainMenuScreen.add(mainMenuLabel);
        mainMenuScreen.add(createAccountButton);
        mainMenuScreen.add(loginAccountButton);
        panelDesigns(mainMenuPanel);
        mainMenuPanel.add(mainMenuScreen);
        containerPanel.add(mainMenuPanel);
    }
    
    //Admin Menu Panel Method.
    public static void adminMenuPanel() {
        //Declaration of existingAccountMenu components.
        String[] columnNames = {"Phone Number", "Name", "PIN", "Balance"};
        Object[][] data = {};
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        adminMenuLabel = new JLabel();
        adminMenuTable = new JTable(tableModel);
        JScrollPane adminScrollPane = new JScrollPane(adminMenuTable);
        adminToMenuButton = new JButton();
        deleteButton = new JButton();
        adminMenuPanel = new JPanel();
        adminMenuScreen = new JPanel();

        //Setting existingAccountMenu components.
        adminMenuLabel.setFont(new java.awt.Font("Rockwell", 0, 48));
        adminMenuLabel.setForeground(new Color(253, 253, 253));
        adminMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        adminMenuLabel.setText("Admin Screen:");
        adminMenuLabel.setBounds(110, 50, 531, 57);

        adminMenuTable.setBackground(new Color(253, 253, 253));
        adminMenuTable.setFont(new Font("Rockwell", 0, 18));
        adminScrollPane.setBounds(70, 130, 600, 200);
        deleteButton.setBackground(new Color(253, 253, 253));
        deleteButton.setFont(new java.awt.Font("Rockwell", 0, 20));
        deleteButton.setForeground(new Color(0xE13527));
        deleteButton.setText("Delete User");
        deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteButton.setFocusable(false);
        deleteButton.setBounds(295, 360, 150, 30);

        adminToMenuButton.setBackground(new Color(253, 253, 253));
        adminToMenuButton.setFont(new java.awt.Font("Rockwell", 0, 20));
        adminToMenuButton.setForeground(new Color(60, 70, 92));
        adminToMenuButton.setText("Back to Main Menu");
        adminToMenuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminToMenuButton.setFocusable(false);
        adminToMenuButton.setBounds(245, 420, 250, 30);

        adminMenuPanel.setBackground(new Color(0x3B3E44));
        adminMenuPanel.setSize(900, 650);
        adminMenuPanel.setLayout(null);

        adminMenuScreen.setBorder(BorderFactory.createLineBorder(new Color(52, 50, 50), 3));
        adminMenuScreen.setBackground(new Color(0x3C465C));
        adminMenuScreen.setBounds(80, 80, 740, 490);
        adminMenuScreen.setLayout(null);

        //Add action listener to the buttons.
        adminToMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminMenuPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
            }
        });
        
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = adminMenuTable.getSelectedRow();
                int posDel = 0;
                if (selectedRow != -1) {
                    String phoneNumDel = (String) adminMenuTable.getValueAt(selectedRow, 0);
                    
                    AccountNode currNode = head;
                    while (currNode.next != null) {
                        if (phoneNumDel.equals(currNode.phoneNum)) {
                            break;
                        }
                        currNode = currNode.next;
                        posDel++;
                    }
                    
                    //Identify position and update its links.
                    if (posDel == 0) {
                        //If posDel is 0, set newSecondNode as the new head.
                        head = head.next;
                    }
                    else {
                        //Create a node that will serve as the node before the position and set it by default to head.
                        AccountNode beforeNode = head;

                        //Traveres linked list until it gets to the pos.
                        for (int i=1; i != posDel; i++) {
                            beforeNode = beforeNode.next;
                        }

                        //Create a node that will serve as the node after the position and set it as the node next to beforeNode.
                        AccountNode afterNode = beforeNode.next;

                        //Set the link of beforeNode to the node afte the afterNode.
                        beforeNode.next = afterNode.next;
                    }
                    tableModel.removeRow(selectedRow);
                }
            } 
        });
        
        //Adding the component to their corresponding parent component.
        adminMenuScreen.add(adminToMenuButton);
        adminMenuScreen.add(deleteButton);
        adminMenuScreen.add(adminMenuLabel);
        adminMenuScreen.add(adminScrollPane);
        panelDesigns(adminMenuPanel);
        adminMenuPanel.add(adminMenuScreen);
        containerPanel.add(adminMenuPanel);
    }
    
    //Login Account Menu Method.
    public static void loginAccountMenu() {
        //Declaration of loginAccountMenu components.
        loginAccountLabel = new JLabel();
        phoneNumLabel = new JLabel();
        pinLoginLabel = new JLabel();
        phoneNumLoginTextField = new JTextField();
        pinLoginPasswordField = new JPasswordField();
        submitLoginButton = new JButton();
        loginToMenuButton = new JButton();
        loginAccountPanel = new JPanel();
        loginAccountScreen = new JPanel();

        //Setting loginAccountMenu components.
        loginAccountLabel.setFont(new Font("Rockwell", 0, 48));
        loginAccountLabel.setForeground(new Color(253, 253, 253));
        loginAccountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginAccountLabel.setText("Login Account:");
        loginAccountLabel.setBounds(109, 100, 531, 57);

        phoneNumLabel.setFont(new Font("Rockwell", 0, 18));
        phoneNumLabel.setForeground(new Color(253, 253, 253));
        phoneNumLabel.setText("Phone Number:");
        phoneNumLabel.setBounds(220, 190, 200, 22);

        pinLoginLabel.setFont(new Font("Rockwell", 0, 18));
        pinLoginLabel.setForeground(new Color(253, 253, 253));
        pinLoginLabel.setText("PIN:");
        pinLoginLabel.setBounds(220, 250, 200, 22);

        phoneNumLoginTextField.setBackground(new Color(253, 253, 253));
        phoneNumLoginTextField.setFont(new Font("Rockwell", 0, 14));
        phoneNumLoginTextField.setForeground(new Color(60, 70, 92));
        phoneNumLoginTextField.setHorizontalAlignment(JTextField.CENTER);
        phoneNumLoginTextField.setBounds(370, 185, 155, 30);

        pinLoginPasswordField.setBackground(new Color(253, 253, 253));
        pinLoginPasswordField.setFont(new Font("Rockwell", 0, 14));
        pinLoginPasswordField.setForeground(new Color(60, 70, 92));
        pinLoginPasswordField.setHorizontalAlignment(JTextField.CENTER);
        pinLoginPasswordField.setBounds(370, 245, 155, 30);

        submitLoginButton.setBackground(new java.awt.Color(253, 253, 253));
        submitLoginButton.setFont(new java.awt.Font("Rockwell", 0, 20));
        submitLoginButton.setForeground(new java.awt.Color(60, 70, 92));
        submitLoginButton.setText("Submit");
        submitLoginButton.setFocusable(false);
        submitLoginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitLoginButton.setBounds(320, 300, 100, 31);

        loginToMenuButton.setBackground(new Color(253, 253, 253));
        loginToMenuButton.setFont(new java.awt.Font("Rockwell", 0, 20));
        loginToMenuButton.setForeground(new Color(60, 70, 92));
        loginToMenuButton.setText("Back to Main Menu");
        loginToMenuButton.setFocusable(false);
        loginToMenuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginToMenuButton.setBounds(245, 420, 250, 30);

        loginAccountPanel.setBackground(new Color(0x3B3E44));
        loginAccountPanel.setSize(900, 650);
        loginAccountPanel.setLayout(null);

        loginAccountScreen.setBorder(BorderFactory.createLineBorder(new Color(52, 50, 50), 3));
        loginAccountScreen.setBackground(new Color(0x3C465C));
        loginAccountScreen.setBounds(80, 80, 740, 490);
        loginAccountScreen.setLayout(null);

        //Add action listener to the buttons.
        submitLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scanLoginInput();
            }
        });

        loginToMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                phoneNumLoginTextField.setText("");
                pinLoginPasswordField.setText("");
                loginAccountPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
            }
        });
        //Adding the component to their corresponding parent component.
        loginAccountScreen.add(loginAccountLabel);
        loginAccountScreen.add(phoneNumLabel);
        loginAccountScreen.add(pinLoginLabel);
        loginAccountScreen.add(phoneNumLoginTextField);
        loginAccountScreen.add(pinLoginPasswordField);
        loginAccountScreen.add(submitLoginButton);
        loginAccountScreen.add(loginToMenuButton);
        panelDesigns(loginAccountPanel);
        loginAccountPanel.add(loginAccountScreen);
        containerPanel.add(loginAccountPanel);
    }
    
    //Create Account Menu Method.
    public static void createAccountMenu() {
        //Declaration of createAccountMenu components.
        createAccountLabel = new JLabel();
        phoneNumCreateLabel = new JLabel();
        nameCreateLabel = new JLabel();
        pinCreateLabel = new JLabel();
        initialDepositCreateLabel = new JLabel();
        nameCreateTextField = new JTextField();
        phoneNumCreateTextField = new JTextField();
        pinCreateTextField = new JTextField();
        initialDepositCreateTextField = new JTextField();
        createAccountPanel = new JPanel();
        createAccountScreen = new JPanel();
        submitCreateButton = new JButton();
        createToMenuButton = new JButton();

        //Setting createAccountMenu components.       
        createAccountLabel.setFont(new Font("Rockwell", 0, 48));
        createAccountLabel.setForeground(new Color(253, 253, 253));
        createAccountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        createAccountLabel.setText("Sign-Up:");
        createAccountLabel.setBounds(109, 60, 531, 57);
        
        phoneNumCreateLabel.setFont(new Font("Rockwell", 0, 18));
        phoneNumCreateLabel.setForeground(new Color(253, 253, 253));
        phoneNumCreateLabel.setText("Phone Number:");
        phoneNumCreateLabel.setBounds(220, 140, 200, 22);
        
        nameCreateLabel.setFont(new Font("Rockwell", 0, 18));
        nameCreateLabel.setForeground(new Color(253, 253, 253));
        nameCreateLabel.setText("Username:");
        nameCreateLabel.setBounds(220, 200, 200, 22);

        pinCreateLabel.setFont(new Font("Rockwell", 0, 18));
        pinCreateLabel.setForeground(new Color(253, 253, 253));
        pinCreateLabel.setText("PIN:");
        pinCreateLabel.setBounds(220, 260, 200, 22);

        initialDepositCreateLabel.setFont(new Font("Rockwell", 0, 18));
        initialDepositCreateLabel.setForeground(new Color(253, 253, 253));
        initialDepositCreateLabel.setText("Initial Deposit:");
        initialDepositCreateLabel.setBounds(220, 320, 200, 22);
        
        phoneNumCreateTextField.setBackground(new Color(253, 253, 253));
        phoneNumCreateTextField.setFont(new Font("Rockwell", 0, 14));
        phoneNumCreateTextField.setForeground(new Color(60, 70, 92));
        phoneNumCreateTextField.setHorizontalAlignment(JTextField.CENTER);
        phoneNumCreateTextField.setBounds(370, 135, 155, 30);
        
        nameCreateTextField.setBackground(new Color(253, 253, 253));
        nameCreateTextField.setFont(new Font("Rockwell", 0, 14));
        nameCreateTextField.setForeground(new Color(60, 70, 92));
        nameCreateTextField.setHorizontalAlignment(JTextField.CENTER);
        nameCreateTextField.setBounds(370, 195, 155, 30);

        pinCreateTextField.setBackground(new Color(253, 253, 253));
        pinCreateTextField.setFont(new Font("Rockwell", 0, 14));
        pinCreateTextField.setForeground(new Color(60, 70, 92));
        pinCreateTextField.setHorizontalAlignment(JTextField.CENTER);
        pinCreateTextField.setBounds(370, 255, 155, 30);

        initialDepositCreateTextField.setBackground(new Color(253, 253, 253));
        initialDepositCreateTextField.setFont(new Font("Rockwell", 0, 14));
        initialDepositCreateTextField.setForeground(new Color(60, 70, 92));
        initialDepositCreateTextField.setHorizontalAlignment(JTextField.CENTER);
        initialDepositCreateTextField.setBounds(370, 310, 155, 30);

        submitCreateButton.setBackground(new java.awt.Color(253, 253, 253));
        submitCreateButton.setFont(new java.awt.Font("Rockwell", 0, 20));
        submitCreateButton.setForeground(new java.awt.Color(60, 70, 92));
        submitCreateButton.setText("Submit");
        submitCreateButton.setFocusable(false);
        submitCreateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitCreateButton.setBounds(320, 370, 100, 31);

        createToMenuButton.setBackground(new Color(253, 253, 253));
        createToMenuButton.setFont(new java.awt.Font("Rockwell", 0, 20));
        createToMenuButton.setForeground(new Color(60, 70, 92));
        createToMenuButton.setText("Back to Main Menu");
        createToMenuButton.setFocusable(false);
        createToMenuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createToMenuButton.setBounds(245, 430, 250, 30);

        createAccountPanel.setBackground(new Color(0x3B3E44));
        createAccountPanel.setSize(900, 650);
        createAccountPanel.setLayout(null);

        createAccountScreen.setBorder(BorderFactory.createLineBorder(new Color(52, 50, 50), 3));
        createAccountScreen.setBackground(new Color(0x3C465C));
        createAccountScreen.setBounds(80, 80, 740, 490);
        createAccountScreen.setLayout(null);

        //Add action listener to the buttons.
        submitCreateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scanAccountCreateInput();
            }
        });

        createToMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameCreateTextField.setText("");
                pinCreateTextField.setText("");
                initialDepositCreateTextField.setText("");
                createAccountPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
            }
        });

        //Adding the component to their corresponding parent component.
        createAccountScreen.add(createToMenuButton);
        createAccountScreen.add(submitCreateButton);
        createAccountScreen.add(phoneNumCreateTextField);
        createAccountScreen.add(nameCreateTextField);
        createAccountScreen.add(pinCreateTextField);
        createAccountScreen.add(initialDepositCreateTextField);
        createAccountScreen.add(phoneNumCreateLabel);
        createAccountScreen.add(nameCreateLabel);
        createAccountScreen.add(pinCreateLabel);
        createAccountScreen.add(initialDepositCreateLabel);
        createAccountScreen.add(createAccountLabel);
        panelDesigns(createAccountPanel);
        createAccountPanel.add(createAccountScreen);
        containerPanel.add(createAccountPanel);
    }
    
    //Action Menu Method.
    public static void actionMenu() {
        //Declaration of actionMenu components.
        actionMenuWelcomeLabel = new JLabel();
        currentBalanceLabel = new JLabel();
        currentBalanceTextField = new JTextField();
        actionMenuPanel = new JPanel();
        actionToMenuButton = new JButton();
        depositButton = new JButton();
        withdrawButton = new JButton();
        actionMenuScreen = new JPanel();

        //Setting actionMenu components.
        actionMenuWelcomeLabel.setFont(new Font("Rockwell", 0, 48));
        actionMenuWelcomeLabel.setForeground(new Color(253, 253, 253));
        actionMenuWelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        actionMenuWelcomeLabel.setBounds(0, 145, 740, 57);

        currentBalanceLabel.setFont(new Font("Rockwell", 0, 18));
        currentBalanceLabel.setForeground(new Color(253, 253, 253));
        currentBalanceLabel.setText("Balance:");
        currentBalanceLabel.setBounds(225, 230, 200, 22);

        currentBalanceTextField.setBackground(new Color(253, 253, 253));
        currentBalanceTextField.setFont(new Font("Rockwell", 0, 14));
        currentBalanceTextField.setForeground(new Color(60, 70, 92));
        currentBalanceTextField.setHorizontalAlignment(JTextField.CENTER);
        currentBalanceTextField.setEditable(false);
        currentBalanceTextField.setBounds(375, 225, 140, 30);

        depositButton.setBackground(new java.awt.Color(253, 253, 253));
        depositButton.setFont(new java.awt.Font("Rockwell", 0, 20));
        depositButton.setForeground(new java.awt.Color(60, 70, 92));
        depositButton.setText("Deposit");
        depositButton.setFocusable(false);
        depositButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        depositButton.setBounds(225, 270, 140, 31);

        withdrawButton.setBackground(new java.awt.Color(253, 253, 253));
        withdrawButton.setFont(new java.awt.Font("Rockwell", 0, 20));
        withdrawButton.setForeground(new java.awt.Color(60, 70, 92));
        withdrawButton.setText("Withdraw");
        withdrawButton.setFocusable(false);
        withdrawButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        withdrawButton.setBounds(375, 270, 140, 31);

        actionToMenuButton.setBackground(new Color(253, 253, 253));
        actionToMenuButton.setFont(new java.awt.Font("Rockwell", 0, 20));
        actionToMenuButton.setForeground(new Color(60, 70, 92));
        actionToMenuButton.setText("Back to Main Menu");
        actionToMenuButton.setFocusable(false);
        actionToMenuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        actionToMenuButton.setBounds(245, 420, 250, 30);

        actionMenuPanel.setBackground(new Color(0x3B3E44));
        actionMenuPanel.setSize(900, 650);
        actionMenuPanel.setLayout(null);

        actionMenuScreen.setBorder(BorderFactory.createLineBorder(new Color(52, 50, 50), 3));
        actionMenuScreen.setBackground(new Color(0x3C465C));
        actionMenuScreen.setBounds(80, 80, 740, 490);
        actionMenuScreen.setLayout(null);

        //Add action listener to the buttons.
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionMenuPanel.setVisible(false);
                depositMenuPanel.setVisible(true);
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionMenuPanel.setVisible(false);
                withdrawMenuPanel.setVisible(true);
            }
        });

        actionToMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionMenuPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
            }
        });

        //Adding the component to their corresponding parent component.
        actionMenuScreen.add(depositButton);
        actionMenuScreen.add(withdrawButton);
        actionMenuScreen.add(currentBalanceLabel);
        actionMenuScreen.add(currentBalanceTextField);
        actionMenuScreen.add(actionToMenuButton);
        actionMenuScreen.add(actionMenuWelcomeLabel);
        panelDesigns(actionMenuPanel);
        actionMenuPanel.add(actionMenuScreen);
        containerPanel.add(actionMenuPanel);
    }
    
    //Deposit Menu Method.
    public static void depositMenu() {
        //Declaration of depositMenu components.
        depositMenuLabel = new JLabel();
        depositAmountLabel = new JLabel();
        depositAmountTextField = new JTextField();
        depositToMenuButton = new JButton();
        depositMenuPanel = new JPanel();
        depositMenuScreen = new JPanel();

        //Setting depositMenu components.
        depositMenuLabel.setFont(new Font("Rockwell", 0, 48));
        depositMenuLabel.setForeground(new Color(253, 253, 253));
        depositMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        depositMenuLabel.setText("Cash Deposit:");
        depositMenuLabel.setBounds(0, 50, 740, 57);

        depositAmountLabel.setFont(new Font("Rockwell", 0, 18));
        depositAmountLabel.setForeground(new Color(253, 253, 253));
        depositAmountLabel.setText("Amount:");
        depositAmountLabel.setBounds(225, 135, 200, 22);

        depositAmountTextField.setBackground(new Color(253, 253, 253));
        depositAmountTextField.setFont(new Font("Rockwell", 0, 14));
        depositAmountTextField.setForeground(new Color(60, 70, 92));
        depositAmountTextField.setHorizontalAlignment(JTextField.CENTER);
        depositAmountTextField.setEditable(false);
        depositAmountTextField.setBounds(375, 130, 140, 30);

        depositToMenuButton.setBackground(new Color(253, 253, 253));
        depositToMenuButton.setFont(new java.awt.Font("Rockwell", 0, 20));
        depositToMenuButton.setForeground(new Color(60, 70, 92));
        depositToMenuButton.setText("Back to Main Menu");
        depositToMenuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        depositToMenuButton.setFocusable(false);
        depositToMenuButton.setBounds(245, 443, 250, 30);

        depositMenuPanel.setBackground(new Color(0x3B3E44));
        depositMenuPanel.setSize(900, 650);
        depositMenuPanel.setLayout(null);

        depositMenuScreen.setBorder(BorderFactory.createLineBorder(new Color(52, 50, 50), 3));
        depositMenuScreen.setBackground(new Color(0x3C465C));
        depositMenuScreen.setBounds(80, 80, 740, 490);
        depositMenuScreen.setLayout(null);

        //Add action listener to the buttons.
        depositToMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                depositAmountTextField.setText("");
                depositMenuPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
            }
        });
        //Adding the component to their corresponding parent component.
        depositMenuScreen.add(depositToMenuButton);
        depositMenuScreen.add(depositMenuLabel);
        depositMenuScreen.add(depositAmountLabel);
        depositMenuScreen.add(depositAmountTextField);
        atmNumpadDesign(depositMenuScreen, depositAmountTextField);
        panelDesigns(depositMenuPanel);
        depositMenuPanel.add(depositMenuScreen);
        containerPanel.add(depositMenuPanel);
    }

    //withdraw Menu Method.
    public static void withdrawMenu() {
        //Declaration of createAccountMenu components.
        withdrawMenuLabel = new JLabel();
        withdrawAmountLabel = new JLabel();
        withdrawAmountTextField = new JTextField();
        withdrawToMenuButton = new JButton();
        withdrawMenuPanel = new JPanel();
        withdrawMenuScreen = new JPanel();

        //Setting createAccountMenu components.
        withdrawMenuLabel.setFont(new Font("Rockwell", 0, 48));
        withdrawMenuLabel.setForeground(new Color(253, 253, 253));
        withdrawMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        withdrawMenuLabel.setText("Cash Withdraw:");
        withdrawMenuLabel.setBounds(0, 50, 740, 57);

        withdrawAmountLabel.setFont(new Font("Rockwell", 0, 18));
        withdrawAmountLabel.setForeground(new Color(253, 253, 253));
        withdrawAmountLabel.setText("Amount:");
        withdrawAmountLabel.setBounds(225, 135, 200, 22);

        withdrawAmountTextField.setBackground(new Color(253, 253, 253));
        withdrawAmountTextField.setFont(new Font("Rockwell", 0, 14));
        withdrawAmountTextField.setForeground(new Color(60, 70, 92));
        withdrawAmountTextField.setHorizontalAlignment(JTextField.CENTER);
        withdrawAmountTextField.setEditable(false);
        withdrawAmountTextField.setBounds(375, 130, 140, 30);

        withdrawToMenuButton.setBackground(new Color(253, 253, 253));
        withdrawToMenuButton.setFont(new java.awt.Font("Rockwell", 0, 20));
        withdrawToMenuButton.setForeground(new Color(60, 70, 92));
        withdrawToMenuButton.setText("Back to Main Menu");
        withdrawToMenuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        withdrawToMenuButton.setFocusable(false);
        withdrawToMenuButton.setBounds(245, 443, 250, 30);

        withdrawMenuPanel.setBackground(new Color(0x3B3E44));
        withdrawMenuPanel.setSize(900, 650);
        withdrawMenuPanel.setLayout(null);

        withdrawMenuScreen.setBorder(BorderFactory.createLineBorder(new Color(52, 50, 50), 3));
        withdrawMenuScreen.setBackground(new Color(0x3C465C));
        withdrawMenuScreen.setBounds(80, 80, 740, 490);
        withdrawMenuScreen.setLayout(null);

        //Add action listener to the buttons.
        withdrawToMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                withdrawAmountTextField.setText("");
                withdrawMenuPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
            }
        });
        //Adding the component to their corresponding parent component.
        withdrawMenuScreen.add(withdrawToMenuButton);
        withdrawMenuScreen.add(withdrawMenuLabel);
        withdrawMenuScreen.add(withdrawAmountLabel);
        withdrawMenuScreen.add(withdrawAmountTextField);
        atmNumpadDesign(withdrawMenuScreen, withdrawAmountTextField);
        panelDesigns(withdrawMenuPanel);
        withdrawMenuPanel.add(withdrawMenuScreen);
        containerPanel.add(withdrawMenuPanel);
    }
    
    //Adding Decoration Method.
    public static void panelDesigns(JPanel panel) {
        //ATM Title.
        titleLabel = new JLabel();
        titleLabel.setFont(new Font("Rockwell Extra Bold", 3, 36));
        titleLabel.setForeground(new Color(173, 173, 172));
        titleLabel.setText("DigiVault");
        titleLabel.setBounds(80, 30, 3000, 40);

        //Left Side Button.
        for (int i = 0, j = 300; i < 4; i++, j += 70) {
            sideButtons[i] = new JPanel();
            sideButtons[i].setBackground(new Color(173, 173, 172));
            sideButtons[i].setBounds(11, j, 60, 45);
        }

        //Right Side Button.
        for (int i = 4, j = 300; i < 8; i++, j += 70) {
            sideButtons[i] = new JPanel();
            sideButtons[i].setBackground(new Color(173, 173, 172));
            sideButtons[i].setBounds(830, j, 60, 45);
        }
        
        //Logo.
        ImageIcon icon = new ImageIcon("D:\\PROGRAMMING KNOWLEDGE\\Netbeans\\DigiVault\\src\\digitalatm\\digiVaultLogo.png");
        Image originalImage = icon.getImage();

        // Resize the image while maintaining aspect ratio
        Image resizedImage = originalImage.getScaledInstance(70, -1, Image.SCALE_SMOOTH);
        
        logo = new JLabel();
        logo.setIcon(new ImageIcon(resizedImage));
        logo.setBounds(413, 575, 70, 70);


        //Add them to the given panel.
        panel.add(logo);
        panel.add(titleLabel);
        for (int i = 0; i < 8; i++) {
            panel.add(sideButtons[i]);
        }
    }
    
    //ATM Numpad Component.
    public static void atmNumpadDesign(JPanel panel, JTextField textField) {
        //Declaring numpad panel.
        numpadPanel = new JPanel(new GridLayout(4, 3));
        numpadPanel.setBounds(225, 180, 290, 250);

        //Declaring 1-9 numbers.
        for (int i = 0, k = 1; i < 9; i++, k++) {
            numPadButtons[i] = new JButton();
            numPadButtons[i].setBackground(new Color(253, 253, 253));
            numPadButtons[i].setFont(new java.awt.Font("Rockwell", 0, 20));
            numPadButtons[i].setForeground(new Color(60, 70, 92));
            numPadButtons[i].setText(Integer.toString(k));
            numPadButtons[i].setFocusable(false);
            numPadButtons[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        //Declaring 0 number.
        numPadButtons[9] = new JButton();
        numPadButtons[9].setBackground(new Color(253, 253, 253));
        numPadButtons[9].setFont(new java.awt.Font("Rockwell", 0, 20));
        numPadButtons[9].setForeground(new Color(60, 70, 92));
        numPadButtons[9].setText("0");
        numPadButtons[9].setFocusable(false);
        numPadButtons[9].setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Declaring clear button.
        numPadButtons[10] = new JButton();
        numPadButtons[10].setBackground(new Color(253, 253, 253));
        numPadButtons[10].setFont(new java.awt.Font("Rockwell", 0, 20));
        numPadButtons[10].setForeground(new Color(0xE13527));
        numPadButtons[10].setText("Clear");
        numPadButtons[10].setFocusable(false);
        numPadButtons[10].setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Declaring enter button.
        numPadButtons[11] = new JButton();
        numPadButtons[11].setBackground(new Color(253, 253, 253));
        numPadButtons[11].setFont(new java.awt.Font("Rockwell", 0, 20));
        numPadButtons[11].setForeground(new Color(0x1E8140));
        numPadButtons[11].setText("Enter");
        numPadButtons[11].setFocusable(false);
        numPadButtons[11].setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Declaring button listeners.
        for (int i = 0; i < 12; i++) {
            numPadButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String buttonPressed = e.getActionCommand();

                    switch (buttonPressed) {
                        case "Clear":
                            textField.setText("");
                            break;

                        case "Enter":
                            if (panel == depositMenuScreen) {
                                depositFunction();
                            } else if (panel == withdrawMenuScreen) {
                                withdrawFunction();
                            }
                            break;
                        default:
                            textField.setText(textField.getText() + buttonPressed);
                            break;
                    }
                }
            });
        }

        //Adding them numpadPanel.
        for (int i = 0; i < 12; i++) {
            numpadPanel.add(numPadButtons[i]);
        }

        //Adding them to the selected panel.
        panel.add(numpadPanel);
    }
    
    //------------------------------------------------------------------Methods for Functionality.------------------------------------------------------------------------------------------------
    
    //Scan the account creation input method.
    public static void scanAccountCreateInput() {
        //Get Textfield Input.
        phoneNum = phoneNumCreateTextField.getText();
        name = nameCreateTextField.getText();
        pin = pinCreateTextField.getText();
        balanceStr = initialDepositCreateTextField.getText();
        
        //Verify Inputs.
        phoneNumStatus = inputVerify.verifyPhoneNum(phoneNum) && phoneNumTaken();
        nameStatus = inputVerify.verifyName(name);
        pinStatus = inputVerify.verifyPin(pin);
        initialDepositStatus = inputVerify.verifyInitialDeposit(balanceStr);
        dialogBoxSetter();
    }
    
    //Scan login credential is right method.
    public static void scanLoginInput() {
            //Get TextField Input.
            phoneNumLogin = phoneNumLoginTextField.getText();
            pinLogin = pinLoginPasswordField.getText();
            
            //If login is admin, proceed to admin.
            if (phoneNumLogin.equals(adminUsername) && pinLogin.equals(adminPassword)) {
                DefaultTableModel model = (DefaultTableModel) adminMenuTable.getModel();
                model.setRowCount(0);
                
                AccountNode currNode = head;
                
                while (currNode.next != null) {
                    model.addRow(new String[]{currNode.phoneNum, currNode.userName, currNode.pin, "P" + currNode.balance});
                    currNode = currNode.next;
                }
                
                phoneNumLoginTextField.setText("");
                pinLoginPasswordField.setText("");
                loginAccountPanel.setVisible(false);
                adminMenuPanel.setVisible(true);
            }
            else {
                //Get the node that will match the authentication.
                if (loginSystem(phoneNumLogin, pinLogin) == true) {
                    phoneNumLoginTextField.setText("");
                    pinLoginPasswordField.setText("");
                    actionMenuWelcomeLabel.setText("Welcome " + loginNode.userName + "!");
                    currentBalanceTextField.setText("P" + loginNode.balance);
                    loginAccountPanel.setVisible(false);
                    actionMenuPanel.setVisible(true);
                }
                else {
                    phoneNumLoginTextField.setText("");
                    pinLoginPasswordField.setText("");
                    JOptionPane.showMessageDialog(null, "Invalid Login Credentials!"); 
                }
            }                
    }
    
    //Deposit Functionality Method. 
    public static void depositFunction() {
        depositAmountStr = depositAmountTextField.getText();
        depositAmountStatus = inputVerify.verifyDepositAmount(depositAmountStr);

        if (depositAmountStatus == true) {
            depositAmount = Integer.parseInt(depositAmountStr);
            loginNode.balance = loginNode.balance + depositAmount;

            JOptionPane.showMessageDialog(null, "Deposit Success!\nDeposit Amount: P" + depositAmount + "\nUpdated Balance: P" + loginNode.balance);
            depositAmountTextField.setText("");
            depositMenuPanel.setVisible(false);
            introPanel.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Amount!");
        }
    }
    
    //Withdraw Functionality Method.
    public static void withdrawFunction() {
            withdrawAmountStr = withdrawAmountTextField.getText();
            withdrawAmountStatus = inputVerify.verifyWithdrawAmount(withdrawAmountStr, loginNode.balance);

            if (withdrawAmountStatus == true) {
                withdrawAmount = Integer.parseInt(withdrawAmountStr);
                loginNode.balance = loginNode.balance - withdrawAmount;

                withdrawAmountTextField.setText("");
                withdrawDenominationDialog();
                withdrawMenuPanel.setVisible(false);
                introPanel.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Amount!");
            }
    }
    
    //Withdraw Denomination Function.
    public static void withdrawDenominationDialog() {
        DenominationStack denominationStack = new DenominationStack();
        denomination = withdrawAmount;

        for (int value : denominationsValue) {
            while (denomination >= value) {
              int count = denomination / value;
              denomination %= value;

              if (value == 1 || value == 10) {
                  denominationType = "coin";
              } else {
                  denominationType = "peso bill";
              }

              String denominationData = count + " piece(s) of " + value + " " + denominationType + ".\n";
              denominationStack.push(denominationData);
            }
        }
        
        while (!denominationStack.isEmpty()) {
            denominationDialogBox = denominationStack.pop() + denominationDialogBox;
        }

        JOptionPane.showMessageDialog(null, "Withdraw Success!\nYou will receive:\n" + denominationDialogBox + "Withdraw Amount: P" + withdrawAmount + "\nUpdated Balance: P" + loginNode.balance);
        denominationDialogBox = "";
    }
    
    //Bring up warning dialog depending on the invalid account creation input.
    public static void dialogBoxSetter() {
        if (nameStatus == true && pinStatus == true && initialDepositStatus == true && phoneNumStatus == true) {
            balance = Integer.parseInt(balanceStr);
            addAccNode(phoneNum, name, pin, balance);
            JOptionPane.showMessageDialog(null, "Account Created! Please remember these details!");
            phoneNumCreateTextField.setText("");
            nameCreateTextField.setText("");
            pinCreateTextField.setText("");
            initialDepositCreateTextField.setText("");
        } else {
            if(phoneNumStatus == false) {
                accountCreateDialogBox = accountCreateDialogBox.concat("Phone number must not be taken, numerical and 11-digits long!\n");
            }
            if (nameStatus == false) {
                accountCreateDialogBox = accountCreateDialogBox.concat("Name must not contain spaces and only contains alphabetical values!\n");
            }
            if (pinStatus == false) {
                accountCreateDialogBox = accountCreateDialogBox.concat("Pin must be numerical and 4-digits long!\n");
            }
            if (initialDepositStatus == false) {
                accountCreateDialogBox = accountCreateDialogBox.concat("Initial Deposit must be numerical, whole money and at least P500!\n");
            }
            JOptionPane.showMessageDialog(null, accountCreateDialogBox);
            accountCreateDialogBox = "";
        }
    }
    
    //Checks if phoneNum is already existing.
    public static boolean phoneNumTaken() {
        AccountNode currNode = head;
        while (currNode.next != null) {
            if (phoneNum.equals(currNode.phoneNum)) {
                return false;
            }
            currNode = currNode.next;
        }
        return true;
    }  
    
    //Authentication System.
    public static boolean loginSystem(String phoneNumLogin, String pin) {
        AccountNode currNode = head;
        while (currNode.next != null) {
            if (phoneNumLogin.equals(currNode.phoneNum) && pinLogin.equals(currNode.pin)) {
                loginNode = currNode;
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }  
    
    //Add account to LinkedList.
    public static void addAccNode(String phoneNum, String userName, String pin, int balance) {
        AccountNode newAccNode = new AccountNode(phoneNum, userName, pin, balance);
        newAccNode.next = head;
        head = newAccNode;
    } 
}

