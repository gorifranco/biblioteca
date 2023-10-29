import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class GUI extends JFrame {
    private Container panellContinguts;
    private JPanel panellLogin, areaLogin;


    private JTextField user, pass;
    private JButton submit;

    public GUI() {
        super("Biblioteca pepino");
        setDefaultCloseOperation(GUI.EXIT_ON_CLOSE);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800, 800));
        panellContinguts = getContentPane();
        panellContinguts.setLayout(new BorderLayout());

        creacionContenedoresYComponentes();
        pack();
    }

    // Método para cambiar la fuente a Arial para todos los componentes

    private void creacionContenedoresYComponentes() {

        panellContinguts.setLayout(new BorderLayout());
        areaLogin = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Rellena en ambas direcciones
        gbc.insets = new Insets(panellContinguts.getSize().height / 2 - 102, panellContinguts.getSize().width / 2 - 185, panellContinguts.getSize().height / 2 - 102, panellContinguts.getSize().width / 2 - 185); // Puedes ajustar los márgenes según sea necesario

        LoginPanel loginPanel = new LoginPanel();
        areaLogin.add(loginPanel, gbc);
        panellContinguts.add(areaLogin, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new GUI();
    }

}

class LoginPanel extends JPanel {
    private JButton submit;
    private Font mainFont, errorFont;
    private JLabel passLabel, userLabel, errorLabel;
    private JTextField pass, user;

    public LoginPanel() {
        super(null);
        init();
    }

    private void init() {
        mainFont = new Font("Arial", Font.BOLD, 15);
        errorFont = new Font("Arial", Font.PLAIN, 12);

        setVisible(true);
        setBackground(Color.LIGHT_GRAY);

        passLabel = new JLabel("PASSWORD", SwingConstants.CENTER);
        passLabel.setBounds(25, 65, 200, 35);
        passLabel.setFont(mainFont);
        add(passLabel);

        pass = new JTextField();
        pass.setToolTipText("PASSWORD");
        pass.setBounds(25, 30, 200, 35);
        pass.setFont(mainFont);
        add(pass);

        userLabel = new JLabel("USERNAME", SwingConstants.CENTER);
        userLabel.setBounds(25, 0, 200, 35);
        userLabel.setFont(mainFont);
        add(userLabel);

        user = new JTextField();
        user.setBounds(25, 95, 200, 35);
        user.setToolTipText("USERNAME");
        user.setFont(mainFont);
        add(user);

        submit = new JButton();
        submit.setBounds(65, 143, 120, 35);
        submit.setText("Login");
        submit.setFont(mainFont);
        add(submit);

        errorLabel = new JLabel("Login error", SwingConstants.CENTER);
        errorLabel.setVisible(true);
        errorLabel.setFont(errorFont);
errorLabel.setForeground(Color.RED);
errorLabel.setBounds(25, 173, 200, 35);
add(errorLabel);

    }
}

























