import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor implements ActionListener {
    JFrame frame;
    JMenuBar menuBar;
    JMenu file,edit;
    JMenuItem newFile, openFile, saveFile;
    JMenuItem cut, copy, paste, selectAll, close;
    JTextArea textArea;
    TextEditor(){
        //initialize of a frame
        frame = new JFrame();

        //initialize menu bar
        menuBar = new JMenuBar();

        //initialize text are
        textArea = new JTextArea();

        //initialize menus
        file = new JMenu("File");
        edit = new JMenu("Edit");

        //initialize file menu items
        newFile = new JMenuItem("New Window");
        openFile = new JMenuItem("Open Window");
        saveFile = new JMenuItem("Save File");

        //add action listener
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        //add menu items to file menu
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);

        //initialize edit menu items
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        close = new JMenuItem("Close");

        //add action Listener
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);

        //add menu items to edit menu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        //add menus to menuBar
        menuBar.add(file);
        menuBar.add(edit);

        //set menuBar to frame
        frame.setJMenuBar(menuBar);
        //Create content pane
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.setLayout(new BorderLayout(0,0));
        //add textarea to the pannel
        panel.add(textArea,BorderLayout.CENTER);
        //create scroll pane
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //add scrollpane to panel
        panel.add(scrollPane);
        //add pannel to frame
        frame.add(panel);
        //setting dimensions
        frame.setBounds(0,0, 400,400);
        frame.setTitle("Dinosaur Pad");
        frame.setVisible(true);
        frame.setLayout(null);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource()==cut){//perform cut
            textArea.cut();
        }
        if(actionEvent.getSource()==copy){//perform copy
            textArea.copy();
        }
        if(actionEvent.getSource()==paste){//perform paste
            textArea.paste();
        }
        if(actionEvent.getSource()==selectAll){//perform selectAll
            textArea.selectAll();
        }
        if(actionEvent.getSource()==close){//perform close
            System.exit(0);
        }
        if (actionEvent.getSource()==openFile){
            //open file chooser
            JFileChooser fileChooser = new JFileChooser("C:");
            int chooseOption = fileChooser.showOpenDialog(null);
            //if we have clicked on open button
            if (chooseOption == JFileChooser.APPROVE_OPTION){
                //getting selected file
                File file  = fileChooser.getSelectedFile();
                //get path of selected file
                String filePath = file.getPath();
                try{
                    //initialize file reader
                    FileReader fileReader = new FileReader(filePath);
                    //initializing buffered reader
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String intermediate ="", output = "";
                    //Read content of file line by line
                    while((intermediate = bufferedReader.readLine())!=null){
                        output+= intermediate+"\n";
                    }
                    //set output string to text area
                    textArea.setText(output);
                }catch (FileNotFoundException fileNotFoundException){
                    fileNotFoundException.printStackTrace();
                }
                catch (IOException ioException){
                    ioException.printStackTrace();
                }
            }
        }
        if(actionEvent.getSource()==saveFile){
            //initialize file picker
            JFileChooser fileChooser = new JFileChooser("C:");
            int chooseOption = fileChooser.showSaveDialog(null);
            //check if we clicked on save button
            if(chooseOption==JFileChooser.APPROVE_OPTION){
                //create a new file with chosen directory path and file name
                File file =  new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");
                try{
                    //initialize file writer
                    FileWriter fileWriter = new FileWriter(file);
                    //initialize buffered writer
                     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                     //write contents of text area to file
                    textArea.write(bufferedWriter);
                    bufferedWriter.close();
                }
                catch (IOException ioException){
                    ioException.printStackTrace();
                }
            }
        }
        if (actionEvent.getSource()==newFile){
            TextEditor newTextEditor = new TextEditor();
        }
    }
    public static void main(String[] args) {
        TextEditor texteditor = new TextEditor();
    }
}
