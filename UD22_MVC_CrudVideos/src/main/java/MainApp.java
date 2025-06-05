import controller.ClienteController;
import controller.VideoController;
import view.ClienteView;
import view.VideoView;

import javax.swing.*;
import java.awt.*;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Videoclub CRUD");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            
            JTabbedPane tabs = new JTabbedPane();

            ClienteView clienteView = new ClienteView();
            ClienteController clienteController = new ClienteController(clienteView);
            tabs.add("Clientes", clienteView);

            VideoView videoView = new VideoView();
            VideoController videoController = new VideoController(videoView);
            tabs.add("Videos", videoView);

            frame.add(tabs, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}