package aasdntool;

/**
*
* @author ateethkumar
*/

import aasdntool.AASDNTool;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Login {

	private JFrame frame;
	private JTextField txtPath, txtPath1, txtPath3, txtPath2;
	private JLabel hostLabel, usernameLabel, keyLabel, remoteLabel, port;
	private String loginIPAddress, portNumber;
	public static String terminalCommand;

	@SuppressWarnings("deprecation")
	public void initialize(String v) {

		frame = new JFrame();
		frame.setBounds(100, 100, 650, 250);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		remoteLabel = new JLabel("Remote Login for Switch:" + v);
		remoteLabel.setFont(new Font("Courier New", Font.ITALIC, 15));
		remoteLabel.setBounds(50, 20, 600, 20);
		frame.getContentPane().add(remoteLabel);

		port = new JLabel("Port");
		port.setBounds(380, 60, 100, 20);
		frame.getContentPane().add(port);

		hostLabel = new JLabel("Host IP/URL");
		hostLabel.setBounds(10, 60, 100, 20);
		frame.getContentPane().add(hostLabel);

		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(10, 90, 100, 20);
		frame.getContentPane().add(usernameLabel);

		keyLabel = new JLabel("Keyfile");
		keyLabel.setBounds(10, 120, 100, 20);
		frame.getContentPane().add(keyLabel);

		try {
			StringBuffer response = new StringBuffer();
			URL obj = new URL("http://" + AASDNTool.controllerIP + ":8080/wm/core/controller/switches/json");
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			// optional default is GET
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + "http://" + AASDNTool.controllerIP
					+ ":8080/wm/core/controller/switches/json");
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			ObjectMapper mapper = new ObjectMapper();
			List<Switches> switchList = mapper.readValue(response.toString(),
					mapper.getTypeFactory().constructCollectionType(List.class, Switches.class));
			for (Switches sw : switchList) {
				if (sw.getDpid().toString().equals(v)) {
					loginIPAddress = (sw.getInetAddress().split("/")[1]).split(":")[0];
					portNumber = (sw.getInetAddress().split("/")[1]).split(":")[1];
				}
			}
		} catch (Exception e) {
			System.out.println("Exception Occured:" + e);
		}

		txtPath = new JTextField();
		txtPath.setBounds(140, 60, 214, 30);
		frame.getContentPane().add(txtPath);
		txtPath.setColumns(10);
		txtPath.setText(loginIPAddress);

		txtPath3 = new JTextField();
		txtPath3.setBounds(450, 60, 70, 30);
		frame.getContentPane().add(txtPath3);
		txtPath3.setColumns(10);
		txtPath3.setText(portNumber);

		txtPath1 = new JTextField();
		txtPath1.setBounds(140, 90, 414, 30);
		frame.getContentPane().add(txtPath1);
		txtPath1.setColumns(10);

		txtPath2 = new JTextField();
		txtPath2.setBounds(140, 120, 414, 30);
		frame.getContentPane().add(txtPath2);
		txtPath2.setColumns(10);

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(560, 120, 87, 30);
		frame.getContentPane().add(btnBrowse);

		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();

				// For Directory
				// fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				// For File
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

				fileChooser.setAcceptAllFileFilterUsed(false);

				int rVal = fileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					txtPath2.setText(fileChooser.getSelectedFile().toString());
				}
			}
		});

		JButton login = new JButton("Login");
		login.setBounds(250, 150, 87, 30);
		frame.getContentPane().add(login);

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String host = txtPath.getText();
				String user = txtPath1.getText();
				BasicConfigurator.configure();
				Logger.getRootLogger().setLevel(Level.INFO);
				if (txtPath3.getText() != null && !txtPath3.getText().trim().equals("")) {
					if (txtPath2.getText() != null && !txtPath2.getText().trim().equals("")) {
						terminalCommand = "ssh " + "-i " + txtPath2.getText() + " " + user + "@" + host + " -p "
								+ txtPath3.getText();
					} else {
						terminalCommand = "ssh " + user + "@" + host + " -p " + txtPath3.getText();
					}
				} else {
					if (txtPath2.getText() != null && !txtPath2.getText().trim().equals("")) {
						terminalCommand = "ssh " + "-i " + txtPath2.getText() + " " + user + "@" + host;
					} else {
						terminalCommand = "ssh " + user + "@" + host;
					}
				}
				new TerminalPty();
				
			}
		});
	}


}
