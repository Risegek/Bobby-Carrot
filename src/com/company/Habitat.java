package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.*;

public class Habitat {
    int h, w;
    JFrame window = null;
    File saveFile = null;
    Client client = null;

    boolean isLevel1Complite = false;
    boolean isLevel2Complite = false;
    boolean isLevel3Complite = false;
    boolean isLevel4Complite = false;
    boolean isLevel5Complite = false;
    boolean isLevel6Complite = false;
    boolean isLevel7Complite = false;

    JLabel complite_1 = null;
    JLabel complite_2 = null;
    JLabel complite_3 = null;
    JLabel complite_4 = null;
    JLabel complite_5 = null;
    JLabel complite_6 = null;
    JLabel complite_7 = null;

    int rabbitSkin = 1;

    JTextArea usersArea = new JTextArea();
    JTextArea logArea = new JTextArea();


    Habitat() {
        try {
            client = new Client(this);
        } catch (IOException e) {
            client = null;
        }
        w = 600;
        h = 800;
    }

    public void init() {
        window = new JFrame("Bobby Carrot");
        window.setIconImage(new ImageIcon("src/image/Other/icon.png").getImage());

        JButton lvl_1_Button = new JButton("Level 1");
        JButton lvl_2_Button = new JButton("Level 2");
        JButton lvl_3_Button = new JButton("Level 3");
        JButton lvl_4_Button = new JButton("Level 4");
        JButton lvl_5_Button = new JButton("Level 5");
        JButton lvl_6_Button = new JButton("Level 6");
        JButton lvl_7_Button = new JButton("Level 7");

        usersArea.setBounds(w, 25, 250, h / 2 - 75);
        usersArea.setFont(new Font("Arial", Font.ITALIC, 15));
        usersArea.setEditable(false);

        logArea.setBounds(w, h / 2, 250, h / 2 - 100);
        logArea.setFont(new Font("Arial", Font.ITALIC, 16));
        logArea.setEditable(false);

        JButton changeSkin = new JButton("Change Skin");

        JMenuBar menuBar = new JMenuBar();

        JMenu mGame = new JMenu("Game");
        JMenu mSelectLvl = new JMenu("Select level");

        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem cb_level_1 = new JRadioButtonMenuItem("Level 1", true);
        group.add(cb_level_1);
        JRadioButtonMenuItem cb_level_2 = new JRadioButtonMenuItem("Level 2", false);
        group.add(cb_level_2);
        JRadioButtonMenuItem cb_level_3 = new JRadioButtonMenuItem("Level 3", false);
        group.add(cb_level_3);
        JRadioButtonMenuItem cb_level_4 = new JRadioButtonMenuItem("Level 4", false);
        group.add(cb_level_4);
        JRadioButtonMenuItem cb_level_5 = new JRadioButtonMenuItem("Level 5", false);
        group.add(cb_level_5);

        mSelectLvl.add(cb_level_1);
        mSelectLvl.add(cb_level_2);
        mSelectLvl.add(cb_level_3);
        mSelectLvl.add(cb_level_4);
        mSelectLvl.add(cb_level_5);

        JMenuItem mStart = new JMenuItem("Start");
        mStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cb_level_1.isSelected()) {
                    Level level = new Level(getInstance());
                    level.setSelectedLvl(1);
                    level.startGame();
                    window.setVisible(false);

                } else if (cb_level_2.isSelected()) {
                    if (isLevel1Complite) {
                        Level level = new Level(getInstance());
                        level.setSelectedLvl(2);
                        level.startGame();
                        window.setVisible(false);
                    }

                } else if (cb_level_3.isSelected()) {
                    if (isLevel2Complite) {
                        Level level = new Level(getInstance());
                        level.setSelectedLvl(3);
                        level.startGame();
                        window.setVisible(false);
                    }
                } else if (cb_level_4.isSelected()) {
                    if (isLevel3Complite) {
                        Level level = new Level(getInstance());
                        level.setSelectedLvl(4);
                        level.startGame();
                        window.setVisible(false);
                    }
                } else if (cb_level_5.isSelected()) {
                    if (isLevel5Complite) {
                        Level level = new Level(getInstance());
                        level.setSelectedLvl(5);
                        level.startGame();
                        window.setVisible(false);
                    }
                }
            }
        });

        JMenuItem mSave = new JMenuItem("Save");
        JMenuItem mSave_1 = new JMenuItem("Save as...");

        JMenuItem mLoad_1 = new JMenuItem("Load as...");

        mSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGame();
            }
        });

        mSave_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGame();
            }
        });

        mLoad_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadGame();
            }
        });

        mGame.add(mStart);
        mGame.add(mSave);
        mGame.add(mSave_1);
        mGame.add(mLoad_1);

        menuBar.add(mGame);
        menuBar.add(mSelectLvl);
        window.setJMenuBar(menuBar);

        if (client == null)
            window.setBounds(200, 50, w, h);
        else {
            window.setBounds(200, 50, w + 280, h);
        }

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);

        lvl_1_Button.setBounds(50, 100, 150, 50);
        lvl_1_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Level level = new Level(getInstance());
                level.setSelectedLvl(1);
                level.startGame();
                window.setVisible(false);
            }
        });

        lvl_2_Button.setBounds(50, 200, 150, 50);
        lvl_2_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isLevel1Complite) {
                    Level level = new Level(getInstance());
                    level.setSelectedLvl(2);
                    level.startGame();
                    window.setVisible(false);
                }
            }
        });
        lvl_3_Button.setBounds(50, 300, 150, 50);
        lvl_3_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isLevel2Complite) {
                    Level level = new Level(getInstance());
                    level.setSelectedLvl(3);
                    level.startGame();
                    window.setVisible(false);
                }
            }
        });

        lvl_4_Button.setBounds(50, 400, 150, 50);
        lvl_4_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isLevel3Complite) {
                    Level level = new Level(getInstance());
                    level.setSelectedLvl(4);
                    level.startGame();
                    window.setVisible(false);
                }
            }
        });

        lvl_5_Button.setBounds(50, 500, 150, 50);
        lvl_5_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isLevel4Complite) {
                    Level level = new Level(getInstance());
                    level.setSelectedLvl(5);
                    level.startGame();
                    window.setVisible(false);
                }
            }
        });
        lvl_6_Button.setBounds(300, 100, 150, 50);
        lvl_6_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isLevel5Complite) {
                    Level level = new Level(getInstance());
                    level.setSelectedLvl(6);
                    level.startGame();
                    window.setVisible(false);
                }
            }
        });
        lvl_7_Button.setBounds(300, 200, 150, 50);
        lvl_7_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isLevel5Complite) {
                    Level level = new Level(getInstance());
                    level.setSelectedLvl(7);
                    level.startGame();
                    window.setVisible(false);
                }
            }
        });

        changeSkin.setBounds(w - 200, h - 150, 150, 50);
        changeSkin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSkin.setEnabled(false);
                JDialog dialog = new JDialog(window, "Skins");
                JButton skin1 = new JButton("Skin 1");
                JButton skin2 = new JButton("Skin 2");
                JButton skin3 = new JButton("Skin 3");
                JButton skin4 = new JButton("Skin 4");
                JButton skin5 = new JButton("Skin 5");
                JButton skin6 = new JButton("Skin 6");

                dialog.setBounds(200, 200, w, h);
                dialog.setLayout(null);

                BufferedImage scale = new BufferedImage(150, 200, BufferedImage.TYPE_INT_ARGB);
                scale.getGraphics().drawImage(Rabbit.SKIN_1, 0, 0, 150, 200, null);


                skin1.setBounds(70, 30, 150, 200);
                skin1.setIcon(new ImageIcon(scale));
                skin1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rabbitSkin = 1;
                        dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));

                    }
                });

                BufferedImage scale1 = new BufferedImage(150, 200, BufferedImage.TYPE_INT_ARGB);
                scale1.getGraphics().drawImage(Rabbit.SKIN_2, 0, 0, 150, 200, null);

                skin2.setBounds(70, 280, 150, 200);
                skin2.setIcon(new ImageIcon(scale1));
                skin2.setMinimumSize(new Dimension(60, 80));
                skin2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rabbitSkin = 2;
                        dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
                    }
                });

                BufferedImage scale2 = new BufferedImage(150, 200, BufferedImage.TYPE_INT_ARGB);
                scale2.getGraphics().drawImage(Rabbit.SKIN_3, 0, 0, 150, 200, null);

                skin3.setBounds(70, 530, 150, 200);
                skin3.setIcon(new ImageIcon(scale2));
                skin3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rabbitSkin = 3;
                        dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
                    }
                });

                BufferedImage scale3 = new BufferedImage(150, 200, BufferedImage.TYPE_INT_ARGB);
                scale3.getGraphics().drawImage(Rabbit.SKIN_4, 0, 0, 150, 200, null);

                skin4.setBounds(300, 30, 150, 200);
                skin4.setIcon(new ImageIcon(scale3));
                skin4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rabbitSkin = 4;
                        dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
                    }
                });

                BufferedImage scale4 = new BufferedImage(150, 200, BufferedImage.TYPE_INT_ARGB);
                scale4.getGraphics().drawImage(Rabbit.SKIN_5, 0, 0, 150, 200, null);

                skin5.setBounds(300, 280, 150, 200);
                skin5.setIcon(new ImageIcon(scale4));
                skin5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rabbitSkin = 5;
                        dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
                    }
                });

                BufferedImage scale5 = new BufferedImage(150, 200, BufferedImage.TYPE_INT_ARGB);
                scale5.getGraphics().drawImage(Rabbit.SKIN_6, 0, 0, 150, 200, null);

                skin6.setBounds(300, 530, 150, 200);
                skin6.setIcon(new ImageIcon(scale5));
                skin6.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rabbitSkin = 6;
                        dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
                    }
                });

                dialog.add(skin1);
                dialog.add(skin2);
                dialog.add(skin3);
                dialog.add(skin4);
                dialog.add(skin5);
                dialog.add(skin6);
                dialog.setVisible(true);
                dialog.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        changeSkin.setEnabled(true);
                    }
                });
            }
        });

        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                if (client != null) client.exit();
            }
        });

        window.add(changeSkin);
        window.add(lvl_1_Button);
        window.add(lvl_2_Button);
        window.add(lvl_3_Button);
        window.add(lvl_4_Button);
        window.add(lvl_5_Button);
        window.add(lvl_6_Button);
        window.add(lvl_7_Button);

        if (client != null) window.add(usersArea);
        if (client != null) window.add(logArea);

        window.setVisible(true);

    }


    private Habitat getInstance() {
        return this;
    }

    private void saveGame() {
        if (saveFile == null) {
            try {
                JFileChooser fileChooser = new JFileChooser(new File("src/save"));
                fileChooser.setDialogTitle("Choose your file");
                fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
                File saveFile = null;
                int result = fileChooser.showSaveDialog(window);
                if (result == JFileChooser.APPROVE_OPTION) {
                    saveFile = fileChooser.getSelectedFile();
                } else throw (new Exception());

                FileOutputStream outputStream = new FileOutputStream(saveFile);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(new boolean[]{isLevel1Complite, isLevel2Complite, isLevel3Complite, isLevel4Complite, isLevel5Complite, isLevel6Complite, isLevel7Complite});
                objectOutputStream.close();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(saveFile);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(new boolean[]{isLevel1Complite, isLevel2Complite, isLevel3Complite, isLevel4Complite, isLevel5Complite, isLevel6Complite, isLevel7Complite});
                objectOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadGame() {
        try {
            JFileChooser fileChooser = new JFileChooser(new File("src/save"));
            fileChooser.setDialogTitle("Choose your file");
            fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
            File loadFile = null;
            int result = fileChooser.showOpenDialog(window);
            if (result == JFileChooser.APPROVE_OPTION) {
                loadFile = fileChooser.getSelectedFile();
            } else throw (new Exception());

            FileInputStream fileInputStream = null;
            fileInputStream = new FileInputStream(loadFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            boolean[] mas = (boolean[]) objectInputStream.readObject();
            isLevel1Complite = mas[0];
            isLevel2Complite = mas[1];
            isLevel3Complite = mas[2];
            isLevel4Complite = mas[3];
            isLevel5Complite = mas[4];
            isLevel6Complite = mas[5];
            isLevel7Complite = mas[6];

            System.out.println(isLevel1Complite);
            if (isLevel1Complite == true) complete_levels(1);
            else if (complite_1 != null) window.remove(complite_1);
            if (isLevel2Complite == true) complete_levels(2);
            else if (complite_2 != null) window.remove(complite_2);
            if (isLevel3Complite == true) complete_levels(3);
            else if (complite_3 != null) window.remove(complite_3);
            if (isLevel4Complite == true) complete_levels(4);
            else if (complite_4 != null) window.remove(complite_4);
            if (isLevel5Complite == true) complete_levels(5);
            else if (complite_5 != null) window.remove(complite_5);
            if (isLevel6Complite == true) complete_levels(6);
            else if (complite_6 != null) window.remove(complite_6);
            if (isLevel7Complite == true) complete_levels(7);
            else if (complite_7 != null) window.remove(complite_7);

            window.setVisible(false);
            window.setVisible(true);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void complete_levels(int level) {
        switch (level) {
            case 1: {
                complite_1 = new JLabel(" - Complete!");
                complite_1.setFont(new Font("Arial", Font.BOLD, 17));
                complite_1.setBounds(200, 125, 150, 20);
                window.add(complite_1);
                break;
            }
            case 2: {
                complite_2 = new JLabel(" - Complete!");
                complite_2.setFont(new Font("Arial", Font.BOLD, 17));
                complite_2.setBounds(200, 225, 150, 20);
                window.add(complite_2);
                break;
            }
            case 3: {
                complite_3 = new JLabel(" - Complete!");
                complite_3.setFont(new Font("Arial", Font.BOLD, 17));
                complite_3.setBounds(200, 325, 150, 20);
                window.add(complite_3);
                break;
            }
            case 4: {
                complite_4 = new JLabel(" - Complete!");
                complite_4.setFont(new Font("Arial", Font.BOLD, 17));
                complite_4.setBounds(200, 425, 150, 20);
                window.add(complite_4);
                break;
            }
            case 5: {
                complite_5 = new JLabel(" - Complete!");
                complite_5.setFont(new Font("Arial", Font.BOLD, 17));
                complite_5.setBounds(200, 525, 150, 20);
                window.add(complite_5);
                break;
            }
            case 6: {
                complite_6 = new JLabel(" - Complete!");
                complite_6.setFont(new Font("Arial", Font.BOLD, 17));
                complite_6.setBounds(450, 125, 150, 20);
                window.add(complite_6);
                break;
            }  case 7: {
                complite_7 = new JLabel(" - Complete!");
                complite_7.setFont(new Font("Arial", Font.BOLD, 17));
                complite_7.setBounds(450, 225, 150, 20);
                window.add(complite_7);
                break;
            }
        }
    }

}
