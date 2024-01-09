import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


class Demo {
    
    public static MemberChat[] chats = new MemberChat[0];
    public static void main(String[] args) {
        
        new MainFrame();
         

    }
    public static void growChatArr(String chatName) {
        System.out.println("\n\n" + chats.length + "\n\n");
        MemberChat[] temp = new MemberChat[chats.length + 1];
        for (int i = 0; i < chats.length; i++) {
            temp[i] = chats[i];
        }
        temp[chats.length] = new MemberChat(chatName, temp);
        chats = temp;

    
    }

    

}
class MainFrame extends JFrame {
    int x=0;
    JLabel titleLabel = new JLabel("Whatsapp Chat Creator", SwingConstants.CENTER);
    static JTextField chatNameTextField = new JTextField("Enter the name of the chat", 30);

    MainFrame() {
        initializeFrame();
        addComponents();
    }
    private void initializeFrame() {
        this.setVisible(true);
        this.setSize(800, 500);
        this.setTitle("Whatsapp");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(46, 46, 46));
        this.setLayout(new BorderLayout());
    }
    private void addComponents() {
        configureLabel(titleLabel, 16, new Color(46, 194, 89));
        configureTextField(chatNameTextField, 16);
        configureButtonPanel();

        JPanel labelPanel = new JPanel(new BorderLayout());
        labelPanel.add(titleLabel, BorderLayout.CENTER);
        labelPanel.setBackground(new Color(0, 0, 20));
        labelPanel.setPreferredSize(new Dimension(800, 80));
        this.add(labelPanel, BorderLayout.NORTH);

        JPanel textFieldPanel = new JPanel(null);
        textFieldPanel.setBackground(new Color(0, 0, 20));
        textFieldPanel.setPreferredSize(new Dimension(800, 400));
        textFieldPanel.add(chatNameTextField);
        this.add(textFieldPanel, BorderLayout.CENTER);
    }
    private void configureButtonPanel() {
        JButton button1 = createButton("Create Chat", 200, 40);
        JButton button2 = createButton("Close", 200, 40);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(0, 0, 20));
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        this.add(buttonPanel, BorderLayout.SOUTH);
    }
     JButton createButton(String text, int width, int height) {
        JButton button = new JButton(text);
        button.setFont(new Font("Times New Roman", Font.BOLD, 16));
        button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(width, height));
        button.setBackground(new Color(46, 194, 89));
        button.setForeground(Color.BLACK);
        button.setSize(new Dimension(150, 50));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
            private void buttonActionPerformed(ActionEvent evt) {
                String chatName = chatNameTextField.getText();
                if(button.getText().equals("Close")){
                    System.exit(0);
                }else{
                    if (chatName.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please enter the name of the chat");
                    } else {
                        // growChatArr(chatName);
                        // Demo.growChatArr(chatName);

                        Demo.growChatArr(chatName);
                        // new MemberChat(chatName, Demo.chats);

                    }
                }
            }
            
            
        });
        return button;
    }
    private void configureLabel(JLabel label, int fontSize, Color backgroundColor) {
        label.setOpaque(true);
        label.setFont(new Font("Times New Roman", Font.BOLD, fontSize));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(backgroundColor);
    }
    static void configureTextField(JTextField textField, int fontSize) {
        textField.setFont(new Font("Times New Roman", Font.BOLD, fontSize));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textField.setPreferredSize(new Dimension(500, 60));
        textField.setBounds(75, 100, 650, 60);
        textField.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField.setText("");
            }
        });
    }
}
////////////////////////////////////////////////////////////////////////////////
//////////////////////////////// MemberChat ////////////////////////////////////

class MemberChat extends JFrame {
    ImageIcon imageIcon = new ImageIcon("/home/shen/Documents/myProject/chatFrame/img/f2Icon.png");
    ImageIcon callIcon = new ImageIcon("/home/shen/Documents/myProject/chatFrame/img/callIcon.png");
    ImageIcon videoCallIcon = new ImageIcon("/home/shen/Documents/myProject/chatFrame/img/videoCallIcon.png");

    Image originalImage = imageIcon.getImage();
    Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

    // Create a new ImageIcon with the resized image
    ImageIcon resizedIcon = new ImageIcon(resizedImage);

    Image originalImage2 = callIcon.getImage();
    Image resizedImage2 = originalImage2.getScaledInstance(30, 20, Image.SCALE_SMOOTH);

    // Create a new ImageIcon with the resized image
    ImageIcon callReIcon = new ImageIcon(resizedImage2);

    JButton callButton = new JButton(callReIcon);
    JButton videoCallButton = new JButton(videoCallIcon);

    MemberChat[] chats;

    public MemberChat(String chatName, MemberChat[] chats) {
        this.chats = chats;
        initializeChatFrame(chatName);
    }

    private void initializeChatFrame(String chatName) {
        this.setVisible(true);
        this.setSize(450, 570);
        if (chatName.equals("me")) {
            this.setTitle("My Chat");
        } else {
            this.setTitle(chatName + "'s Chat");
        }
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addComponents();
    }

    private void addComponents() {
        JLabel titleLabel = new JLabel("SE Friends", resizedIcon, SwingConstants.LEFT);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(175,236,184));
        titleLabel.setPreferredSize(new Dimension(300, 50));
    
        JPanel buttonPanel = new JPanel();
        callButton.setPreferredSize(new Dimension(40, 30));
        videoCallButton.setPreferredSize(new Dimension(30, 20));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(callButton);
        buttonPanel.add(videoCallButton);

        callButton.setBackground(new Color(0, 0, 0, 0));
        videoCallButton.setBackground(new Color(0, 0, 0, 0));

        buttonPanel.setBackground(new Color(175,236,184));

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.add(titleLabel, BorderLayout.WEST);
        titlePanel.add(buttonPanel, BorderLayout.EAST);
        titlePanel.setPreferredSize(new Dimension(400, 50));
        titlePanel.setBackground(new Color(175,236,184));

        this.add(titlePanel, BorderLayout.NORTH);

        configureTextArea();
        configureInputField();
    }

    JTextArea textArea = new JTextArea();
    private void configureTextArea() {
        textArea.setBackground(new Color(175,236, 228));
        textArea.setEditable(false);

         JScrollPane scrollPane = new JScrollPane(textArea);
         scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(textArea, BorderLayout.CENTER);
    }

    JTextField inputField = new JTextField();
    private  void configureInputField() {
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputField.setBackground(new Color(175,236,184));
        inputPanel.setPreferredSize(new Dimension(450, 50));
        inputField.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                     handleUserInput();
                }
            }
        );

        this.add(inputPanel, BorderLayout.SOUTH);
    }
    //
     private void handleUserInput() {
        String text = inputField.getText().trim();
        if (!text.isEmpty()) {
            appendMessage("Me", text);
            broadcastMessage(text); // Send the message to all open chat frames
            inputField.setText("");
        }
    }

    private void appendMessage(String sender, String message) {
        
        textArea.append(sender + ": " + message + "\n");
    }

    //formattedMessage = "<div style='text-align:right;'><b>" + sender + ":</b> " + message + "</div>";
    

    private void broadcastMessage(String message) {
        // Iterate over all open frames and append the message
        Frame[] frames = JFrame.getFrames();
        for (Frame frame : frames) {
            if (frame instanceof MemberChat && frame != this) {
                
                    ((MemberChat) frame).appendMessage("Friend",message);
                
            }
           
        for (int i = 0; i < frames.length; i++) {
            
        }
    }
    
}

}



