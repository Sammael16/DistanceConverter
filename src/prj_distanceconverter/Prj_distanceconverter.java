
package prj_distanceconverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;




public class Prj_distanceconverter extends JFrame implements ActionListener {
    //out of method for change in a actionlistener//
    
JComboBox combo1=new JComboBox(); 
boolean check=false;
    
    public static void main(String[] args) {
       Prj_distanceconverter gui=new Prj_distanceconverter();
    }
    public  Prj_distanceconverter(){
        /////Gui part/////
        //Frame//
        
        JFrame ekran=new JFrame("Welcome to converter");
        ekran.setLayout(null);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ekran.setSize(400,200);
        
        //button//
        
        JButton btn1=new JButton("Convert");
        btn1.setSize(150,25);
        btn1.setLocation(0, 50);
        
        //menu creating//
        
        JMenuBar menubar=new JMenuBar();
        JMenu menu=new JMenu("General");
        JMenuItem m_item1=new JMenuItem("Information");
        JMenuItem m_item2=new JMenuItem("Change");
   
        //textfield//
        
        final JTextField txtin=new JTextField("Please enter the value");
        final JTextField txtan=new JTextField("Answer");
        txtin.setSize(150, 25);
        txtin.setLocation(0,25);
        txtan.setSize(150, 25);
        txtan.setLocation(200, 50);
        txtan.setEditable(false);
        
        //textbox(labels)//
        
        JLabel txt1=new JLabel("The answer is below");
        txt1.setSize(150, 25);
        txt1.setLocation(200, 25);
        
        //combobox//
        
       final String[] normal_lenght={"mile","yard","inch","foot","nau. mile"};
       final String[] ottoman_lenght={"merhale","fersah","berid","kulaç","arşın","endaze","rubu","hat"};
       combo1=new JComboBox(normal_lenght);
        combo1.setSize(150, 25);
        combo1.setLocation(0, 75);
        
        /////actionlisteners/////
        
        //btn1-ActionListener//
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean checker=true; // checker if code gets in exception it blocks to move on.
                double answer=0;
              String chosen=combo1.getSelectedItem().toString();
                String in = txtin.getText();
                
                //Error catching//
                
                 try{
                 int innum_catch=Integer.parseInt(in);
                }
                catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"Please enter a number.");
                    checker=false;
                }
                ///////////////////
                 
                if(checker==true){
                    int innum=Integer.parseInt(in);
                    if(innum>0){
                        //normal distances.
                    if(chosen.equals("mile"))
                    answer=con_mil(innum);
                    else if(chosen.equals("yard"))
                    answer=con_yard(innum);
                    else if(chosen.equals("inch"))
                    answer=con_inch(innum);
                    else if(chosen.equals("foot"))
                    answer=con_foot(innum);
                    else if(chosen.equals("nau. mile"))
                    answer=con_naumile(innum);
                    //ottoman distances.
                    else if(chosen.equals("merhale"))
                        answer=con_merhale(innum);
                    else if(chosen.equals("fersah"))
                        answer=con_fersah(innum);
                    else if(chosen.equals("berid"))
                        answer=con_berid(innum);
                    else if(chosen.equals("kulaç"))
                        answer=con_kulaç(innum);
                    else if(chosen.equals("arşın"))
                        answer=con_arşın(innum);
                    else if(chosen.equals("endaze"))
                        answer=con_endaze(innum);
                    else if(chosen.equals("rubu"))
                        answer=con_rubu(innum);
                    else if(chosen.equals("hat"))
                        answer=con_hat(innum);
                    
                    
                String str_answer=Double.toString(answer);
                txtan.setText(str_answer+" meters");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Number must be bigger than 0");
                }}
            
        });
        
        //m_item1 ActionListener//
        
        m_item1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null,"-This applicaton converts some different distance units "
                        + "to meter which is common to use."+"\n-Change button changes units to ottoman distance units or normal distance units "+
                        "\n-Programmed by Muhammed Eroğlu");
            }
        });
        
        //m_item2 ActionListener//
        
        m_item2.addActionListener(new ActionListener() {

           //changes the normal distance units to ottoman distance units...
            
            public void actionPerformed(ActionEvent ae) {
               if(check==false){
                   DefaultComboBoxModel model = new DefaultComboBoxModel( ottoman_lenght );
combo1.setModel( model );
                   check=true;
               }
               else if(check==true){
                   DefaultComboBoxModel model = new DefaultComboBoxModel( normal_lenght );
combo1.setModel( model );
                   check=false;
               }
            }
        });
        
        //adding//
        
        ekran.setJMenuBar(menubar);
        menubar.add(menu); //menu adding to menubar
        menu.add(m_item1);menu.add(m_item2); //menu item adding to menu bar
        ekran.add(btn1);
        ekran.add(txtin);
        ekran.add(txt1);
        ekran.add(txtan);
        ekran.add(combo1);
        ekran.setVisible(true);
    }
    
    //over ride
    
    public void actionPerformed(ActionEvent e){
        
    }
    //convertion methods//
    
    //normal distance convert methods
    
    public double con_mil(double a){
        double answer=a*1609.344;
        return answer;
    }
    public double con_yard(double a){
        double answer=a*0.9144;
        return answer;
    }
    public double con_inch(double a){
        double answer=a*0.0254;
        return answer;
    }
    public double con_foot(double a){
        double answer=a*0.3048;
        return answer;
    }
    public double con_naumile(double a){
        double answer=a*1852;
        return answer;
    }
    //ottoman distance convert methods
    
    public double con_merhale(double a){
        double answer=a*45480;
        return answer;
    }
    public double con_fersah(double a){
        double answer=a*5685;
        return answer;
    }
     public double con_berid(double a){
        double answer=a*227;
        return answer;
    }
     public double con_kulaç(double a){
        double answer=a*1.89;
        return answer;
    }
     public double con_arşın(double a){
        double answer=a*0.68;
        return answer;
    }
     public double con_endaze(double a){
        double answer=a*0.65;
        return answer;
    }
     public double con_rubu(double a){
        double answer=a*0.085;
        return answer;
    }
     public double con_hat(double a){
        double answer=a*0.00263;
        return answer;
    }
}
