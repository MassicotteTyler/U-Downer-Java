package com.mlg420blazeit;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class GUI extends JPanel {


    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JLabel url;
    private JTextField field;
    private JRadioButton audio, video;
    private ButtonGroup group;
    private String format = "-x ";
    private String  link;
    private JButton download, reset;
    private UDowner udowner;

    public GUI() {

        udowner = new UDowner();

        audio = new JRadioButton("Audio");
        video = new JRadioButton("Video");
        url = new JLabel("URL");
        download = new JButton("Download");
        reset = new JButton("Reset");
        field = new JTextField(20);
        field.addMouseListener(new FieldAction());
        Listener listener = new Listener();
        audio.addItemListener(listener);
        video.addItemListener(listener);
        download.addActionListener(new ButtonAction());
        reset.addActionListener(new ResetAction());
        url.addMouseListener(new MouseAction());

        reset.setSize(new Dimension(5,1));
        audio.setSelected(true);

        group = new ButtonGroup();
        group.add(audio);
        group.add(video);


        setPreferredSize(new Dimension(400,100));
        add(url);
        add(field);
        add(audio);
        add(video);
        add(download);
        add(reset);
    }
    public void errorMsg(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private class Listener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (audio.isSelected()) {
                format = "-x ";
            }
            if (video.isSelected()) {
                format = "";
            }


        }

    }

    private class ButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            link = field.getText();
            if (link.equals("")) {
                errorMsg("URL is empty");
                return;
            }
            if (link.contains("playlist") && link.contains("youtube"))
            {
                link = "\"" + link +"\"";
                if (format.equals("-x")) {
                    format = "-x -i ";
                }
                else 
                    format = "-i ";
            }
            if (link.contains("soundcloud.com"))
                format = "";
            if (url == null)
                errorMsg("No text");
            udowner.download("youtube-dl " + format + link);
        }

    }

    private class ResetAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            field.setText("");
            // TODO Auto-generated method stub

        }

    }

    private class MouseAction implements MouseListener {
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable t = c.getContents(this);
        @Override
        public void mouseClicked(MouseEvent e) {
            c = Toolkit.getDefaultToolkit().getSystemClipboard();
            t = c.getContents(this);
            if (t != null) {
                try {
                    field.setText((String) t.getTransferData(DataFlavor.stringFlavor));
                } catch (Exception d){
                    d.printStackTrace();
                }
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

    }

    private class FieldAction implements MouseListener {

        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable t = c.getContents(this);
        @Override
        public void mouseClicked(MouseEvent arg0) {
            if (SwingUtilities.isRightMouseButton(arg0)) {
                c = Toolkit.getDefaultToolkit().getSystemClipboard();
                t = c.getContents(this);
                if (t != null) {
                    try {
                        field.setText((String) t.getTransferData(DataFlavor.stringFlavor));
                    } catch (Exception d){
                        d.printStackTrace();
                    }
                }
            }


            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

        }


    }
